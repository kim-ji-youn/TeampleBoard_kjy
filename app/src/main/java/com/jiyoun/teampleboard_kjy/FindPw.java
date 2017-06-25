package com.jiyoun.teampleboard_kjy;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.jiyoun.teampleboard_kjy.MainActivity.members;

public class FindPw extends AppCompatActivity {

    static int findPwMember;
    Button resetPW;
    EditText id,name,idNum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_pw);

        id = (EditText)findViewById(R.id.find_id);
        name = (EditText)findViewById(R.id.find_name2);
        idNum = (EditText)findViewById(R.id.find_idnumber2);

        resetPW = (Button)findViewById(R.id.bt_resetPw);
        resetPW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputId = id.getText().toString();
                String inputName = name.getText().toString();
                String inputIdNum = idNum.getText().toString();

                for(int i = 0; i<members.size(); i++) {
                    if(inputId.equals(members.get(i).id)&&inputName.equals(members.get(i).name)&&inputIdNum.equals(members.get(i).idNumber)) {
                        findPwMember = i;
                        Toast.makeText(FindPw.this,"비밀번호를 재설정하세요.", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),resetPW.class);
                        startActivity(intent);
                    }
                    else {
                        showMessage();
                    }
                }

            }
        });


    }
    private void showMessage() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("입력한 정보가 틀리거나 존재하지 않는 ID 입니다.");
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
