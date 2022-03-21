package com.example.adapter_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class SimpleAdapterActivity extends AppCompatActivity {
   ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_adapter);
        listView = (ListView) findViewById(R.id.listView2);
        String [] names = {"이명지", "김인보", "나잘란", "진달래", "황금복", "최전선",
                "마진가", "백김치", "오리온", "조이풀"};
        String [] ages = {"19", "20", "21", "22", "23", "24", "25", "20", "21", "23"};

        //데이터준비
        ArrayList<HashMap<String, String>> data = new ArrayList<>();
        for(int i=0; i<10; i++) {
            HashMap<String, String> map = new HashMap<>();
            map.put("name", names[i]);
            map.put("age", ages[i]);
            data.add(map);
        }

        //심플어댑터 준비
        SimpleAdapter simpleAdapter = new SimpleAdapter(
                this,
                data,
                android.R.layout.simple_list_item_2,
                new String[]{"name", "age"},
                new int[]{android.R.id.text1, android.R.id.text2});


        //어댑터에 리스트뷰 연동
        listView.setAdapter(simpleAdapter);
    }
}