package com.jiyoun.teampleboard_kjy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class ProjectMain extends AppCompatActivity {

    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_main);


        ListViewAdapter adapter;
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String date = intent.getStringExtra("date");
        date = date + " 까지";

        adapter = new ListViewAdapter();

        ListView listView = (ListView)findViewById(R.id.projectListView);
        listView.setAdapter(adapter);
        adapter.addItem(name,date);

        //여기부터
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),KanbanTodo.class);
                startActivity(intent);
            }
        });
        //여기까지 아이템 클릭

        button = (Button)findViewById(R.id.newProject);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),NewProject.class);
                startActivity(intent);
            }
        });
    }
}
