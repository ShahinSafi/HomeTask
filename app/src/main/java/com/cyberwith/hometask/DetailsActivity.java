package com.cyberwith.hometask;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

public class DetailsActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView title, productID, price;
    private String imageUrl, productTitle, id, productPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        imageUrl = getIntent().getStringExtra("imageURL");
        productTitle = getIntent().getStringExtra("title");
        id = getIntent().getStringExtra("productID");
        productPrice = getIntent().getStringExtra("price");

        imageView = findViewById(R.id.detailsImageID);
        title = findViewById(R.id.detailsTitleID);
        productID = findViewById(R.id.detailsProductID);
        price = findViewById(R.id.detailsPriceID);

        dataBind();
    }

    private void dataBind() {
        Glide.with(getApplicationContext()).load(imageUrl).into(imageView);
        title.setText("Title: "+productTitle);
        productID.setText("Product ID: "+id);
        price.setText("Price: "+productPrice+"tk");
    }
}