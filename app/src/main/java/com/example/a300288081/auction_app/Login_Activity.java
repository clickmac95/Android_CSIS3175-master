package com.example.a300288081.auction_app;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;


/**guys we ll implement apis to work this login and signup module
  for now its all dummy model
 */

public class Login_Activity extends AppCompatActivity  {

    String txt_email_input,txt_pass_input;

    int userType ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button btnLogin = findViewById(R.id.email_sign_in_button);
        TextView txt_signup = (findViewById(R.id.txt_signup));
      final  EditText userEmail = (findViewById(R.id.editTxt_email));
      final  EditText userPassword = (findViewById(R.id.edittxt_pass));
      final RadioGroup rg = (findViewById(R.id.radioGroup));

        userEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        userPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.rad_btn_bidder:
                        // do operations specific to this selection
                        break;
                    case R.id.rad_btn_bid_creator:
                        // do operations specific to this selection
                        break;

                }
            }
        });





        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {






                Intent i = new Intent(Login_Activity.this, App_home_Nav_Activity.class);
                startActivity(i);
            }
        });

        txt_signup.setOnClickListener(new View.OnClickListener() {

            // implement code for custom dialog box to proceed as bidder or bic creator




            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login_Activity.this, Register_Activity_page1.class);
                startActivity(i);
            }
        });

        //showAlertDialog();


    }




}
