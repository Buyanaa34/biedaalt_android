package com.example.bie_daalt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import io.paperdb.Paper;

public class HomeActivity extends AppCompatActivity {
    Button logout_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        logout_btn = (Button) findViewById(R.id.logout_button);
        logout_btn.setOnClickListener(v -> lel());
    }

    private void lel() {
        Paper.book().destroy();
        this.finish();
    }
}