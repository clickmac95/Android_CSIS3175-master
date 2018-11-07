package com.example.a300288081.auction_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.a300288081.auction_app.bid_creator.Bid_Creator_Activity_page2;

public class Register_Activity_page1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register___buyer);

        Button btnSignUp = findViewById(R.id.btn_signup_buyer);


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Register_Activity_page1.this, Bid_Creator_Activity_page2.class);
                startActivity(i);
            }
        });

    }
}
