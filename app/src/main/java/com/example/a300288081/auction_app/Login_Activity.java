package com.example.a300288081.auction_app;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import com.example.a300288081.auction_app.model.SharedPrefManager;
import com.example.a300288081.auction_app.model.RequestHandler;
import com.example.a300288081.auction_app.model.URLs;
import com.example.a300288081.auction_app.model.User;

/**guys we ll implement apis to work this login and signup module
  for now its all dummy model
 */

public class Login_Activity extends AppCompatActivity  {

    EditText editTextUsername, editTextPassword;

    int userType ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button btnLogin = findViewById(R.id.email_sign_in_button);
        TextView txt_signup = (findViewById(R.id.txt_signup));
      final  EditText userEmail = (findViewById(R.id.editTxt_email));
      final  EditText userPassword = (findViewById(R.id.edittxt_pass));
      final RadioGroup rg = (findViewById(R.id.pop_up_radioGroup));

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

                        userType = 0;
                        break;
                    case R.id.rad_btn_bid_creator:
                        // do operations specific to this selection

                        userType = 1;
                        break;

                }
            }
        });





        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


        userLogin();




            }
        });

        // signup_onclick listner

        txt_signup.setOnClickListener(new View.OnClickListener() {

            // implement code for custom dialog box to proceed as bidder or bic creator
            // @Override
            public void onClick(View v) {
                MyCustomAlertDialog();
            }
        });

        //showAlertDialog();


    }




    public void MyCustomAlertDialog()
    {
        Dialog MyDialog = new Dialog(Login_Activity.this);
        MyDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        MyDialog.setContentView(R.layout.popup);
        MyDialog.setTitle("My PopUp");

              Button  Submit = findViewById(R.id.pop_up_submit);
        final RadioGroup rg = (findViewById(R.id.pop_up_radioGroup));


        Log.i("radio_button_selected",String.valueOf(rg.getCheckedRadioButtonId()));

       /* View popupView = layoutInflater.inflate(R.layout.popup, null);
        final PopupWindow popupWindow = new PopupWindow(
                popupView,
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT);

        Button btnDismiss = (Button)popupView.findViewById(R.id.dismiss);
        btnDismiss.setOnClickListener(new Button.OnClickListener(){

       *//* Submit.setEnabled(true);*//*
        Submit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int selectedId = rg.getCheckedRadioButtonId();
                Intent intent = new Intent(Login_Activity.this,App_home_Nav_Activity.class);
                if(selectedId == R.id.pop_up_bidCreator)
                {



                    intent.putExtra("USER_Type", 0);
//starting the activity

                }
                else if(selectedId == R.id.pop_up_rad_btn_bidder)
                {
                    intent.putExtra("USER_Type", 1);
                }
                startActivity(intent);

            }
        });*/
        MyDialog.show();
    }

    private void userLogin() {
        //first getting the values
        final String username = editTextUsername.getText().toString();
        final String password = editTextPassword.getText().toString();

        //validating inputs
        if (TextUtils.isEmpty(username)) {
            editTextUsername.setError("Please enter your username");
            editTextUsername.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            editTextPassword.setError("Please enter your password");
            editTextPassword.requestFocus();
            return;
        }
        class UserLogin extends AsyncTask<Void, Void, String> {

            ProgressDialog pdLoading = new ProgressDialog(Login_Activity.this);


            @Override
            protected String doInBackground(Void... voids) {
                //creating request handler object
                RequestHandler requestHandler = new RequestHandler();

                //creating request parameters
                HashMap<String, String> params = new HashMap<>();
                params.put("username", username);
                params.put("password", password);
                params.put("user_type",String.valueOf(userType));


                //returing the response
                return requestHandler.sendPostRequest(URLs.URL_LOGIN, params);
            }

            @Override
            protected void onPreExecute() {
                super.onPreExecute();

                //this method will be running on UI thread
                pdLoading.setMessage("\tLoading...");
                pdLoading.setCancelable(false);
                pdLoading.show();
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                pdLoading.dismiss();


                try {
                    //converting response to json object
                    JSONObject obj = new JSONObject(s);
                    if (!obj.getBoolean("error")) {
                        //  Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();

                        //getting the user from the response
                        JSONObject userJson = obj.getJSONObject("user");

                        //creating a new user object
                        User user = new User(
                                userJson.getInt("Id"),
                                userJson.getString("Email"),
                                userJson.getString("FName"),
                                userJson.getString("LName"),
                                userJson.getString("Address"),
                                userJson.getString("Province"),
                                userJson.getString("Country"),
                                userJson.getString("Pincode"),
                                userJson.getString("Phone") ,
                                userJson.getString("usertType")

                        );
                        //storing the user in shared preferences
                       SharedPrefManager.getInstance(getApplicationContext()).userLogin(user);



                        //starting the profile activity
                        finish();
                      //startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                    } else {
                        Toast.makeText(getApplicationContext(), "Invalid username or password", Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

        }
        UserLogin ul=new UserLogin();
        ul.execute();

    }


}
