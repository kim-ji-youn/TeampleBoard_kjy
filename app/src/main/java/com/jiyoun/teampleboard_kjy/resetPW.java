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
import android.widget.RelativeLayout;
import android.widget.Toast;

public class resetPW extends AppCompatActivity {

    InputMethodManager imm;
    EditText pw;
    EditText chkPw;
    Button resetNewPw;
    RelativeLayout emptySpace;

    String newPw;
    String chkNewPw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_pw);

        imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        pw = (EditText) findViewById(R.id.newPw);
        chkPw = (EditText)findViewById(R.id.chkNewPw);
        resetNewPw = (Button)findViewById(R.id.bt_resetNewPw);
        emptySpace = (RelativeLayout)findViewById(R.id.emptySpace);

        newPw = pw.getText().toString();
        chkNewPw = chkPw.getText().toString();

        resetNewPw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(newPw.equals(chkNewPw)) {
                    showTrueMessage();
                }
                else if(newPw.length() == 0) {
                    Toast.makeText(getApplicationContext(), "비밀번호를 입력하세요.",Toast.LENGTH_SHORT).show();
                }
                else if(chkPw.length() == 0) {
                    Toast.makeText(getApplicationContext(), "비밀번호 재확인을 해주세요.", Toast.LENGTH_SHORT).show();
                }
                else {
                    showFalseMessage();
                }

            }
        });


    }

    private void showTrueMessage() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("비밀번호 재설정");
        builder.setMessage("새로운 비밀번호가 생성되었습니다.");
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private  void showFalseMessage() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("비밀번호 재설정");
        builder.setMessage("입력한 비밀번호가 일치하지 않습니다.");
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }


}
