package com.example.bie_daalt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import io.paperdb.Paper;

public class admin_category_actvity extends AppCompatActivity {
    private ImageView tshirts, sport_tshirts,dress,hat,watch,mobile,laptop,sweather,glasses,bag,shoes,headphones;
    private Button logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_category_actvity);

        tshirts = findViewById(R.id.t_shirt);
        sport_tshirts = findViewById(R.id.sport_tshirt);
        dress = findViewById(R.id.dress);
        hat = findViewById(R.id.hats_caps);
        watch = findViewById(R.id.watches);
        mobile = findViewById(R.id.phone);
        laptop = findViewById(R.id.laptop);
        sweather = findViewById(R.id.sweathers);
        glasses = findViewById(R.id.glasses);
        bag = findViewById(R.id.purses_bags);
        shoes = findViewById(R.id.shoes);
        headphones = findViewById(R.id.headphones);

        logout = findViewById(R.id.logout);
        logout.setOnClickListener(v -> logoutclick());

        tshirts.setOnClickListener(v -> zuragdarah(tshirts));
        sport_tshirts.setOnClickListener(v -> zuragdarah(sport_tshirts));
        dress.setOnClickListener(v -> zuragdarah(dress));
        hat.setOnClickListener(v -> zuragdarah(hat));
        watch.setOnClickListener(v -> zuragdarah(watch));
        mobile.setOnClickListener(v -> zuragdarah(mobile));
        laptop.setOnClickListener(v -> zuragdarah(laptop));
        sweather.setOnClickListener(v -> zuragdarah(sweather));
        glasses.setOnClickListener(v -> zuragdarah(glasses));
        bag.setOnClickListener(v -> zuragdarah(bag));
        shoes.setOnClickListener(v -> zuragdarah(shoes));
        headphones.setOnClickListener(v -> zuragdarah(headphones));
    }

    private void zuragdarah(ImageView img) {
        Intent intent = new Intent(admin_category_actvity.this, adminaddnewproductactivity.class);
        String buuz = img.getTag().toString();
        intent.putExtra("category",buuz);
        startActivity(intent);
    }

    private void logoutclick() {
        Paper.book().destroy();
        this.finish();
    }
}