package com.jiyoun.teampleboard_kjy;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class SignIn extends AppCompatActivity {

    InputMethodManager imm;
    EditText editText1;
    EditText editText2;
    EditText editText3;
    EditText editText4;
    EditText editText5;
    Button clear;
    Button signIn;




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
        clear = (Button)findViewById(R.id.bt_reset);
        signIn = (Button)findViewById(R.id.bt_signIn);




    }
}
