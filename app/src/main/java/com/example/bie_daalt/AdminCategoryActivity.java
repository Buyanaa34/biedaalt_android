package com.example.bie_daalt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
//aldaa baihku murtluu zuer ulaigaad bsn
public class AdminCategoryActivity extends AppCompatActivity {

    private ImageView tshirts,sports, dress, sweather, glasses, bag, hat, shoe, headphones, laptop, watches, phones;
    private Button LogoutBtn, CheckOrdersBtn,maintainProductsBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_category_actitvity);
        tshirts = findViewById(R.id.t_shirts);
        sports = findViewById(R.id.sports);
        dress = findViewById(R.id.dresses);
        sweather = findViewById(R.id.sweathers);
        glasses = findViewById(R.id.glasses);
        bag = findViewById(R.id.bag);
        hat = findViewById(R.id.hats);
        shoe = findViewById(R.id.shoe);
        maintainProductsBtn = findViewById(R.id.maintain_btn);
        headphones = findViewById(R.id.headphones);
        laptop = findViewById(R.id.laptop);
        watches = findViewById(R.id.watches);
        phones = findViewById(R.id.mobile_phones);
        LogoutBtn = findViewById(R.id.admin_logout_btn);
        CheckOrdersBtn = findViewById(R.id.check_orders_btn);

        tshirts.setOnClickListener(v -> zurag_click("T-shirt"));
        sports.setOnClickListener(v -> zurag_click("Sports"));
        dress.setOnClickListener(v -> zurag_click("Dress"));
        sweather.setOnClickListener(v -> zurag_click("Sweather"));
        glasses.setOnClickListener(v -> zurag_click("Glasses"));
        bag.setOnClickListener(v -> zurag_click("Bag"));
        hat.setOnClickListener(v -> zurag_click("Hat"));
        shoe.setOnClickListener(v -> zurag_click("Shoes"));
        headphones.setOnClickListener(v -> zurag_click("Headphones"));
        laptop.setOnClickListener(v -> zurag_click("Laptop"));
        watches.setOnClickListener(v -> zurag_click("Watches"));
        phones.setOnClickListener(v -> zurag_click("Mobile phones"));
        LogoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });
        maintainProductsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, HomeActivity.class);
                intent.putExtra("Admin", "Admin");
                startActivity(intent);
            }
        });

        CheckOrdersBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminNewOrdersActivity.class);
                startActivity(intent);
            }
        });

    }

    public void zurag_click(String v){
        Intent intent = new Intent(AdminCategoryActivity.this, adminaddnewproductactivity.class);
        intent.putExtra("category",v);
        startActivity(intent);
    }

}