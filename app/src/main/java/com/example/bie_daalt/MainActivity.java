 package com.example.bie_daalt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.*;
import android.os.Bundle;

import com.example.bie_daalt.Model.Users;
import com.example.bie_daalt.Prevalent.Prevalent;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import io.paperdb.Paper;

 public class MainActivity extends AppCompatActivity {
    private ProgressDialog loadingbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button joinnowbutton = (Button) findViewById(R.id.main_join_now_btn);
        Button loginbutton = (Button) findViewById(R.id.main_login_now_btn);
        loginbutton.setOnClickListener(v -> login(loginbutton));
        joinnowbutton.setOnClickListener(v -> login(joinnowbutton));
        loadingbar = new ProgressDialog(this);
        Paper.init(this);
        String userphonekey = Paper.book().read(Prevalent.Userphonekey);
        String passswordkey = Paper.book().read(Prevalent.Userpasswordkey);
        if(userphonekey!="" && passswordkey != ""){
            if(!TextUtils.isEmpty(userphonekey)&& !TextUtils.isEmpty(passswordkey)){
                Allow_access(userphonekey,passswordkey);

                loadingbar.setTitle("Already logged in");
                loadingbar.setMessage("Please wait");
                loadingbar.setCanceledOnTouchOutside(false);
                loadingbar.show();
            }
        }

    }

     private void Allow_access(String phone, String password) {
         final DatabaseReference RootRef;
         RootRef = FirebaseDatabase.getInstance().getReference();

         RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
             @Override
             public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                 if(dataSnapshot.child("Users").child(phone).exists()){
                     Users usersdata = dataSnapshot.child("Users").child(phone).getValue(Users.class);
                     if(usersdata.getPhone().equals(phone)){
                         if(usersdata.getPassword().equals(password)){
                             Toast.makeText(MainActivity.this, "logged in Successfully...", Toast.LENGTH_SHORT).show();
                             loadingbar.dismiss();
                             Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                             startActivity(intent);
                         }
                         else{
                             loadingbar.dismiss();
                             Toast.makeText(MainActivity.this, "Password is incorrect", Toast.LENGTH_SHORT).show();
                         }
                     }

                 }
                 else{
                     Toast.makeText(MainActivity.this, "Account with this "+phone+" number does not exist", Toast.LENGTH_SHORT).show();
                     loadingbar.dismiss();
                     Toast.makeText(MainActivity.this, "You need to create a new account", Toast.LENGTH_SHORT).show();
                 }
             }

             @Override
             public void onCancelled(@NonNull DatabaseError error) {

             }
         });
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