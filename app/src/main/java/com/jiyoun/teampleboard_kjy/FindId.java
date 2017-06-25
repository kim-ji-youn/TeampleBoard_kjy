package com.jiyoun.teampleboard_kjy;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.jiyoun.teampleboard_kjy.MainActivity.members;

public class FindId extends AppCompatActivity {

    EditText name;
    EditText idNum;
    Button bt_findID;
    Button bt_findPw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_id);

        name = (EditText)findViewById(R.id.find_name);
        idNum = (EditText)findViewById(R.id.find_idnumber);

        bt_findID = (Button)findViewById(R.id.bt_findId);
        bt_findID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputName = name.getText().toString();
                String inputIdNumber = idNum.getText().toString();
                for(int i = 0; i<members.size(); i++) {
                    if(inputName.equals(members.get(i).name)&&inputIdNumber.equals(members.get(i).idNumber)) {
                        showId(i);
                    }
                    else{
                        showInfo();
                    }
                }

            }
        });

        bt_findPw = (Button)findViewById(R.id.bt_findPw);
        bt_findPw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),FindPw.class);
                startActivity(intent);
            }
        });
    }

    private void showId(int i) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("아이디");
        builder.setMessage("당신의 아이디는 " + members.get(i).id + "입니다. ");
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.setPositiveButton("메인으로", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setNegativeButton("비밀번호찾기", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(getApplicationContext(),FindPw.class);
                startActivity(intent);
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void showInfo() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("가입해주세요. ");
        builder.setMessage("가입되어 있지 않습니다. ");
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.setPositiveButton("메인으로", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setNegativeButton("가입하기", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(getApplicationContext(),SignIn.class);
                startActivity(intent);
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
