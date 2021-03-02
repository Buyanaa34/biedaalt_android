package com.example.bie_daalt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bie_daalt.Model.Users;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity2 extends AppCompatActivity {

    private EditText inputphonenumber, inputpassword;
    private Button loginbutton;
    private ProgressDialog loadingbar;
    private String parentdbname="Users";
    private CheckBox rememberme;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        inputphonenumber = (EditText) findViewById(R.id.login_phone_number_input);
        inputpassword = (EditText) findViewById(R.id.login_password_input);
        loadingbar = new ProgressDialog(this);
        loginbutton = (Button) findViewById(R.id.login_towch);
        loginbutton.setOnClickListener(v ->loginuser() );
    }

    private void loginuser(){
        String phone = inputphonenumber.getText().toString();
        String password = inputpassword.getText().toString();
        if(TextUtils.isEmpty(phone)){
            Toast.makeText(this, "Please enter your phone number...", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(password)){
            Toast.makeText(this, "Please enter your password...", Toast.LENGTH_SHORT).show();
        }
        else{
            loadingbar.setTitle("Login account");
            loadingbar.setMessage("Please wait,while we are checking the credentials");
            loadingbar.setCanceledOnTouchOutside(false);
            loadingbar.show();

            Allow_access_to_account(phone,password);
        }
    }

    private void Allow_access_to_account(String phone, String password) {
        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();

        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.child(parentdbname).child(phone).exists()){
                    Users usersdata = dataSnapshot.child(parentdbname).child(phone).getValue(Users.class);
                    if(usersdata.getPhone().equals(phone)){
                        if(usersdata.getPassword().equals(password)){
                            Toast.makeText(LoginActivity2.this, "logged in Successfully...", Toast.LENGTH_SHORT).show();
                            loadingbar.dismiss();
                            Intent intent = new Intent(LoginActivity2.this,HomeActivity.class);
                            startActivity(intent);
                        }
                        else{
                            loadingbar.dismiss();
                            Toast.makeText(LoginActivity2.this, "Password is incorrect", Toast.LENGTH_SHORT).show();
                        }
                    }

                }
                else{
                    Toast.makeText(LoginActivity2.this, "Account with this "+phone+" number does not exist", Toast.LENGTH_SHORT).show();
                    loadingbar.dismiss();
                    Toast.makeText(LoginActivity2.this, "You need to create a new account", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}