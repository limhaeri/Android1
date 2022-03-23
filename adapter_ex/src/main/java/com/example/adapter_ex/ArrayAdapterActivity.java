package com.example.adapter_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ArrayAdapterActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_adapter);
        listView = (ListView) findViewById(R.id.listView);
        String [] data = {"이명지", "김인보", "나잘란", "진달래", "황금복", "최전선",
                "마진가", "백김치", "오리온", "조이풀"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                data
        );
        listView.setAdapter(arrayAdapter);

    }
}