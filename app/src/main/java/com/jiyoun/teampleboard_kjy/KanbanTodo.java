package com.jiyoun.teampleboard_kjy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class KanbanTodo extends AppCompatActivity {
    Button bt_todo;
    Button bt_doing;
    Button bt_done;
    Button bt_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kanban_todo);

        ListViewAdapter adapter;
        Intent intent = getIntent();
        String name = intent.getStringExtra("todo_name");
        String date = intent.getStringExtra("todo_date");
        date = date + " 까지";

        adapter = new ListViewAdapter();

        ListView listView = (ListView)findViewById(R.id.listView1);
        listView.setAdapter(adapter);
        adapter.addItem(name,date);




        bt_add = (Button)findViewById(R.id.bt_add);
        bt_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),NewTodo.class);
                startActivity(intent);
            }
        });

        bt_todo = (Button)findViewById(R.id.bt_todo);
        bt_todo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(KanbanTodo.this,"같은 페이지 입니다. ",Toast.LENGTH_SHORT);
            }
        });

        bt_doing = (Button)findViewById(R.id.bt_doing);
        bt_doing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),KanbanDoing.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        bt_done = (Button)findViewById(R.id.bt_done);
        bt_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),KanbanDone.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}
