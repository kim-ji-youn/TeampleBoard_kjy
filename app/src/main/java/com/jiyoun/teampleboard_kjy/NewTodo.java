package com.jiyoun.teampleboard_kjy;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;


public class NewTodo extends AppCompatActivity {

    Button bt_date;
    Button bt_newTodo;
    TextView date;
    String selectedDate;
    EditText editText;
    String name;
    int mYear, mMonth, mDay;
    Todo todo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_todo);


        editText = (EditText)findViewById(R.id.todo_name);


        bt_newTodo = (Button)findViewById(R.id.bt_newTodo);
        bt_newTodo.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = editText.getText().toString();
                Intent intent = new Intent(NewTodo.this,KanbanTodo.class);
                intent.putExtra("todo_name", name);
                intent.putExtra("todo_date", selectedDate);
                startActivity(intent);
            }
        });

        bt_date = (Button)findViewById(R.id.bt_date);
        date = (TextView)findViewById(R.id.showDate);



        Date date = new Date();
        mYear = date.getYear()+1900 ;
        mMonth = date.getMonth();
        mDay = date.getDate();


        bt_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(NewTodo.this,listener, mYear, mMonth, mDay).show();
            }
        });
    }

    private DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            mYear = year;
            mMonth = month;
            mDay = dayOfMonth;
            selectedDate = year + " - " + (month+1) + " - " + dayOfMonth;
            updateNow();
        }
    };

    void updateNow() {
        date.setText(selectedDate);
    }

}
