package com.lzy.logisticsinfotest;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import org.litepal.LitePal;
import org.litepal.tablemanager.Connector;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private static Spinner kd;
    private ListView history;
    static int kdNum;
    static String kdName;
     ListView hisLV;
    private List<kdbean> hisList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hisList=new ArrayList<>();
        LitePal.initialize(this);
        SQLiteDatabase db = Connector.getDatabase();

        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        history=findViewById(R.id.historyLV);
        hisLV = findViewById(R.id.historyLV);

        kd=findViewById(R.id.kd);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, LogisticsInfoActivity.class);
                kdbean k1 = new kdbean(editText.getText().toString(),getKdName());
                k1.save();
                String id = editText.getText().toString();
                intent.putExtra("id",id);

                hisList=LitePal.findAll(kdbean.class);
                HistoryAdapter historyAdapter=new HistoryAdapter(MainActivity.this,hisList);
                historyAdapter.notifyDataSetChanged();
                hisLV.setAdapter(historyAdapter);
                startActivity(intent);
            }

        });


        hisLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, LogisticsInfoActivity.class);
                editText.setText(hisList.get(position).getKdnum());
                String kd = editText.getText().toString();
                intent.putExtra("id",kd);
                startActivity(intent);
            }
        });


    }

    public  static String  getKdName(){
        kdNum = kd.getSelectedItemPosition();
        switch (kdNum){
            case 0:kdName="ZTO";
                break;
            case 1:kdName="STO";
                break;
            case 2:kdName="YTO";
                break;
        }
        return kdName;
    }
}