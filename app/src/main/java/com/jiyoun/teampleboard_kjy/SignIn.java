package com.jiyoun.teampleboard_kjy;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.jiyoun.teampleboard_kjy.MainActivity.members;

public class SignIn extends AppCompatActivity {

    InputMethodManager imm;
    EditText editText1;
    EditText editText2;
    EditText editText3;
    EditText editText4;
    EditText editText5;
    Button clear;
    Button signIn;
    Button bt_id;
    Member member;
    boolean doubleCheck;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        editText1 = (EditText)findViewById(R.id.text1);
        editText2 = (EditText)findViewById(R.id.text2);
        editText3 = (EditText)findViewById(R.id.text3);
        editText4 = (EditText)findViewById(R.id.text4);
        editText5 = (EditText)findViewById(R.id.text5);
        doubleCheck= false;

        bt_id = (Button)findViewById(R.id.bt_id);
        bt_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = editText3.getText().toString();
                int index = -1;
                for(int i = 0; i<members.size(); i++) {
                    if(id.equals(members.get(i).id)) {
                        index = i;
                    }
                }
                if(index == -1){
                    showPositiveMessage();
                }
                else {
                    showNegativeMessage();
                }

            }
        });


        clear = (Button)findViewById(R.id.bt_reset);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText1.setText("");
                editText2.setText("");
                editText3.setText("");
                editText4.setText("");
                editText5.setText("");
            }
        });

        signIn = (Button)findViewById(R.id.bt_signIn);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText1.getText().toString();
                String idNumber = editText2.getText().toString();
                String id = editText3.getText().toString();
                String password = editText4.getText().toString();
                String chkpassword = editText5.getText().toString();

                if(name.length()==0||idNumber.length()==0||id.length()==0||password.length() == 0||chkpassword.length() == 0) {
                    Toast.makeText(SignIn.this,"빈칸을 모두 채우세요.", Toast.LENGTH_SHORT).show();
                }
                else if(doubleCheck == false) {
                    Toast.makeText(SignIn.this,"ID 중복체크를 해주세요. ", Toast.LENGTH_SHORT).show();
                }
                else {
                    if(password.equals(chkpassword)){
                        member = new Member(name, idNumber,id, password);
                        members.add(member);
                        Toast.makeText(SignIn.this,"회원가입이 완료되었습니다. ", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                    else {
                        Toast.makeText(SignIn.this,"비밀번호를 다시 확인해주세요.", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

    }
    private void showNegativeMessage() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("ID 중복확인");
        builder.setMessage("중복되는 ID가 있습니다.");
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                editText3.setText("");
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void showPositiveMessage() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("ID 중복확인");
        builder.setMessage("중복되는 ID가 없습니다. 회원가입을 진행하세요. ");
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                doubleCheck = true;
                bt_id.setVisibility(View.INVISIBLE);
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
