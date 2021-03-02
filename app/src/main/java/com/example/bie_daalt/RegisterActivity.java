package com.example.bie_daalt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {
    private Button Create_accountbutton;
    private EditText inputname,inputphonenumber,inputpassword,inputconfirmpassword;
    private ProgressDialog loadingbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Create_accountbutton = (Button) findViewById(R.id.login_towch);
        inputname = (EditText) findViewById(R.id.register_name);
        inputphonenumber = (EditText) findViewById(R.id.register_phone_number_input);
        inputpassword = (EditText) findViewById(R.id.register_password_input);
        inputconfirmpassword = (EditText) findViewById(R.id.register_password_confirm_input);
        loadingbar = new ProgressDialog(this);
        Create_accountbutton.setOnClickListener(v -> Createaccount());

    }

    private void Createaccount(){
        if(inputpassword.getText().toString().equals(inputconfirmpassword.getText().toString())){
            String name = inputname.getText().toString();
            String phone = inputphonenumber.getText().toString();
            String password = inputpassword.getText().toString();
            if(TextUtils.isEmpty(name)){
                Toast.makeText(this, "Please enter your name...", Toast.LENGTH_SHORT).show();
            }
            else if(TextUtils.isEmpty(phone)){
                Toast.makeText(this, "Please enter your phone number...", Toast.LENGTH_SHORT).show();
            }
            else if(TextUtils.isEmpty(password)){
                Toast.makeText(this, "Please enter your password...", Toast.LENGTH_SHORT).show();
            }
            else{
                loadingbar.setTitle("Create account");
                loadingbar.setMessage("Please wait,while we are checking the credentials");
                loadingbar.setCanceledOnTouchOutside(false);
                loadingbar.show();

                ValidatephoneNumber(name,phone,password);
            }
        }
        else{
            Toast.makeText(this, "Password and confirmation passwords are different !", Toast.LENGTH_SHORT).show();
        }
    }

    private void ValidatephoneNumber(String name, String phone, String password) {
        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();

        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(!(snapshot.child("Users").child(phone).exists())){
                    HashMap<String, Object> userdatamap = new HashMap<>();
                    userdatamap.put("phone",phone);
                    userdatamap.put("password",password);
                    userdatamap.put("name",name);

                    RootRef.child("Users").child(phone).updateChildren(userdatamap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(RegisterActivity.this, "Congratulations, your account has been created", Toast.LENGTH_SHORT).show();
                                loadingbar.dismiss();

                                Intent intent = new Intent(RegisterActivity.this, LoginActivity2.class);
                                startActivity(intent);
                            }
                            else{
                                loadingbar.dismiss();
                                Toast.makeText(RegisterActivity.this, "Network Error: Please try again after some time...", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }
                else{
                    Toast.makeText(RegisterActivity.this, "This"+phone+ " already exists", Toast.LENGTH_SHORT).show();
                    loadingbar.dismiss();
                    Toast.makeText(RegisterActivity.this, "Please try again using another phone number", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}