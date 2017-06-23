package com.jiyoun.teampleboard_kjy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class FindId extends AppCompatActivity {

    Button bt_findPw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_id);

        bt_findPw = (Button)findViewById(R.id.bt_findPw);
        bt_findPw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),FindPw.class);
                startActivity(intent);
            }
        });
    }
}
