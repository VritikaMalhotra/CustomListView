package com.example.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);

        listAdapter = new ListAdapter(getApplicationContext(),R.layout.row_layout);
        listView.setAdapter(listAdapter);

        for(int i=0;i<5;i++){
            DataProvider dataProvider = new DataProvider("23-11","dadaji","5000"," ");
            listAdapter.add(dataProvider);
        }
        for(int i=0;i<5;i++){
            DataProvider dataProvider = new DataProvider("23-11","dadaji"," ","2000");
            listAdapter.add(dataProvider);
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                view = listView.getChildAt(position);
                String date = ((TextView) view.findViewById(R.id.date)).getText().toString();
                String purpose = ((TextView) view.findViewById(R.id.purpose)).getText().toString();
                String income = ((TextView) view.findViewById(R.id.income)).getText().toString();
                String expenditure = ((TextView) view.findViewById(R.id.expenditure)).getText().toString();
                Toast.makeText(getApplicationContext(), date+" "+purpose+" "+income+" "+expenditure, Toast.LENGTH_SHORT).show();
            }
        });

    }
}