package com.jiyoun.teampleboard_kjy;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

import static com.jiyoun.teampleboard_kjy.MainActivity.members;

public class NewProject extends AppCompatActivity {

    Button bt_date;
    Button bt_add;
    Button bt_delete;
    Button bt_newProject;
    TextView date;
    String selectedDate;
    EditText editText;
    String name;
    int mYear, mMonth, mDay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_project);

        editText = (EditText)findViewById(R.id.new_project_name);


        bt_newProject = (Button)findViewById(R.id.bt_newProject);
        bt_newProject.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = editText.getText().toString();
                Intent intent = new Intent(NewProject.this,ProjectMain.class);
                intent.putExtra("name", name);
                intent.putExtra("date", selectedDate);
                startActivity(intent);
            }
        });

        bt_date = (Button)findViewById(R.id.bt_date);
        date = (TextView)findViewById(R.id.showDate);

        final ArrayList<String> items = new ArrayList<String>();
        final ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_single_choice, items);

        final ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);

        bt_add = (Button)findViewById(R.id.bt_add);
        bt_add.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count;
                count = adapter.getCount();

                editText = (EditText)findViewById(R.id.input_member_id);
                String memberId = editText.getText().toString();
                int index = -1;
                for(int i = 0; i<members.size(); i++) {
                    if(memberId.equals(members.get(i).id)) {
                        index = i;
                    }
                }

                if(index == -1) {
                    showMessage();
                }
                else {
                    items.add(memberId);
                    adapter.notifyDataSetChanged();
                    editText.setText("");
                }

            }
        });

        bt_delete = (Button)findViewById(R.id.bt_delete);
        bt_delete.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count,checked;
                count = adapter.getCount();

                if(count>0) {
                    checked = listView.getCheckedItemPosition();

                    if(checked > -1 && checked < count) {
                        items.remove(checked);
                        listView.clearChoices();
                        adapter.notifyDataSetChanged();
                    }
                }
            }
        });

        Date date = new Date();
        mYear = date.getYear()+1900 ;
        mMonth = date.getMonth();
        mDay = date.getDate();


        bt_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(NewProject.this,listener, mYear, mMonth, mDay).show();
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

    private  void showMessage() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("없는 ID 입니다. ");
        builder.setMessage("팀원의 ID를 다시 확인해주세요. ");
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                editText.setText("");
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

}
