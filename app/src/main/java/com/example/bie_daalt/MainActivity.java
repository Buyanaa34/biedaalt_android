 package com.example.bie_daalt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.widget.*;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button joinnowbutton = (Button) findViewById(R.id.main_join_now_btn);
        Button loginbutton = (Button) findViewById(R.id.main_login_now_btn);
        loginbutton.setOnClickListener(v -> login(loginbutton));
        joinnowbutton.setOnClickListener(v -> login(joinnowbutton));

    }
    public void login(Button btn){
        if(btn.getText().equals("Already have an Account ? Login")){
            Intent intent = new Intent(MainActivity.this, LoginActivity2.class);
            startActivity(intent);
        }
        if(btn.getText().equals("Don't have an Account ? Sign up")){
            Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(intent);
        }

    }
}