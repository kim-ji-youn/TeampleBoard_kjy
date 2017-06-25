package com.jiyoun.teampleboard_kjy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    static ArrayList<Member> members = new ArrayList<Member>();


    InputMethodManager imm;
    EditText idInput;
    EditText passwordInput;
    Button loginButton;
    Button signinButton;
    Button searchButton;
    RelativeLayout emptySpace;

    String idInputString;
    String passwordInputString;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        idInput = (EditText)findViewById(R.id.idInput);
        passwordInput = (EditText)findViewById(R.id.passwordInput);
        loginButton = (Button)findViewById(R.id.loginButton);
        signinButton = (Button)findViewById(R.id.signinButton);
        searchButton = (Button)findViewById(R.id.searchButton);
        emptySpace = (RelativeLayout)findViewById(R.id.emptySpace);


        emptySpace.setOnClickListener(myClickListener);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                idInputString = idInput.getText().toString();
                passwordInputString = passwordInput.getText().toString();
                if(members.size() == 0) {
                    Toast.makeText(MainActivity.this,"회원가입을 하세요.", Toast.LENGTH_SHORT).show();
                }
                else {
                    for (int i = 0; i < members.size(); i++) {
                        if (idInputString.equals(members.get(i).id)) {
                            if (passwordInputString.equals(members.get(i).password)) {
                                Toast.makeText(MainActivity.this, "로그인에 성공하였습니다. ", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), ProjectMain.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(MainActivity.this, "비밀번호를 다시 입력하세요. ", Toast.LENGTH_SHORT).show();
                                passwordInput.setText("");
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "회원가입을 하세요.", Toast.LENGTH_SHORT).show();
                        }
                    }
                }


            }
        });

        signinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SignIn.class);
                startActivity(intent);
            }
        });

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),FindId.class);
                startActivity(intent);
            }
        });


    }




    View.OnClickListener myClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            hideKeyboard();
        }
    };

    private void hideKeyboard() {
        imm.hideSoftInputFromWindow(idInput.getWindowToken(),0);
        imm.hideSoftInputFromWindow(passwordInput.getWindowToken(),0);
    }


}
