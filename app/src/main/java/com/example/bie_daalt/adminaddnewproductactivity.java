package com.example.bie_daalt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import io.paperdb.Paper;

public class adminaddnewproductactivity extends AppCompatActivity {
    Button logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminaddnewproductactivity);
        logout = (Button) findViewById(R.id.logout);
        Toast.makeText(this, "Welcome Admin...", Toast.LENGTH_SHORT).show();
        logout.setOnClickListener(v -> logoutclick());

    }

    private void logoutclick() {
        Paper.book().destroy();
        this.finish();
    }
}