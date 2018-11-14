package com.example.a300288081.auction_app.model;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.a300288081.auction_app.Login_Activity;

public class SharedPrefManager {
    //the constants
    private static final String SHARED_PREF_NAME = "auctionsharedpref";
    private static final String KEY_ID="keyid";
    private static final String KEY_USERNAME = "keyusername";
    private static final String KEY_FIRSTNAME = "keyfirstname";
    private static final String KEY_LASTNAME = "keylastname";
    private static final String KEY_ADDRESS = "keyaddress";
    private static final String KEY_PROVINCE="keyprovince";
    private static final String KEY_COUNTRY="keycountry";
    private static final String KEY_UserType ="00";
    private static final String KEY_PINCODE="keypincode";
    private static final String KEY_PHONENUMBER="keyphonenumber";


    //these fields for seller
    private static final String KEY_PAYEENAME="keypayeename";
    private static final String KEY_BANKNAME="keybankname";
    private static final String KEY_ISTERMSCHECKED="keyistermschecked";
    private static final String KEY_SELLERTYPE="keysellertype";
    private static final String KEY_SIN="keysin";
    private static final String KEY_COMPANYNAME="keycompanyname";
    private static final String KEY_COMPANYADDRESS="keycompanyaddress";


    private static SharedPrefManager mInstance;
    private static Context mCtx;

    private SharedPrefManager(Context context) {
        mCtx = context;
    }

    public static synchronized SharedPrefManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }


    public void logout() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        mCtx.startActivity(new Intent(mCtx, Login_Activity.class));
    }

    public void userLogin(User user) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_ID, user.getUserID());
        editor.putString(KEY_USERNAME, user.getUsername());
        editor.putString(KEY_FIRSTNAME, user.getFirstname());
        editor.putString(KEY_LASTNAME, user.getLastname());
        editor.putString(KEY_ADDRESS, user.getAddress());
        editor.putString(KEY_PROVINCE, user.getProvince());
        editor.putString(KEY_PINCODE, user.getPincode());
        editor.putString(KEY_PHONENUMBER, user.getPhonenumber());
        editor.putString(KEY_UserType, user.getUserType());
        editor.apply();
    }
    //method to let the user login
    //this method will store the user data in shared preferences
   /*

    //this method will checker whether user is already logged in or not
    public boolean isLoggedIn() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USERNAME, null) != null;
    }
    //this method will give the logged in user
    public User getUser() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new User(
                sharedPreferences.getInt(KEY_ID, -1),
                sharedPreferences.getString(KEY_USERNAME, null),
                sharedPreferences.getString(KEY_FIRSTNAME, null),
                sharedPreferences.getString(KEY_LASTNAME, null),
                sharedPreferences.getString(KEY_ADDRESS, null),
                sharedPreferences.getString(KEY_PROVINCE, null),
                sharedPreferences.getString(KEY_COUNTRY,null),
                sharedPreferences.getString(KEY_PINCODE, null),
                sharedPreferences.getString(KEY_PHONENUMBER,null)
        );
    }
    //this method will logout the user


    //this method will store the user data for buyer
    public void tempUserData(User user) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_USERNAME, user.getUsername());
        editor.putString(KEY_FIRSTNAME, user.getFirstname());
        editor.putString(KEY_LASTNAME, user.getLastname());
        editor.putString(KEY_ADDRESS, user.getAddress());
        editor.putString(KEY_PROVINCE, user.getProvince());
        editor.putString(KEY_PINCODE, user.getPincode());
        editor.putString(KEY_PHONENUMBER, user.getPhonenumber());
        editor.apply();
    }
    //this method will store the user Model data in shared preferences
    public void storeUserModel(User user) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
      //  editor.putInt(KEY_ID, user.getUserID());
        editor.putString(KEY_USERNAME, user.getUsername());
        editor.putString(KEY_FIRSTNAME, user.getFirstname());
        editor.putString(KEY_LASTNAME, user.getLastname());
        editor.putString(KEY_ADDRESS, user.getAddress());
        editor.putString(KEY_PROVINCE, user.getProvince());
        editor.putString(KEY_PINCODE, user.getPincode());
        editor.putString(KEY_PHONENUMBER, user.getPhonenumber());
        editor.putString(KEY_PHONENUMBER, user.getPhonenumber());
        editor.putString(KEY_PASSWORD, user.getPswrd());
        editor.apply();
    }

    //this method to get user Model data
    public User getUserModel() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return  User.GetUserModel(
                sharedPreferences.getString(KEY_USERNAME, null),
                sharedPreferences.getString(KEY_FIRSTNAME, null),
                sharedPreferences.getString(KEY_LASTNAME, null),
                sharedPreferences.getString(KEY_ADDRESS, null),
                sharedPreferences.getString(KEY_PROVINCE, null),
                sharedPreferences.getString(KEY_COUNTRY,null),
                sharedPreferences.getString(KEY_PINCODE, null),
                sharedPreferences.getString(KEY_PHONENUMBER,null),
                sharedPreferences.getString(KEY_PASSWORD,null)
        );
    }

    //this method for seller login

    public void userSellerLogin(User user) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_ID, user.getUserID());
        editor.putString(KEY_USERNAME, user.getUsername());
        editor.putString(KEY_FIRSTNAME, user.getFirstname());
        editor.putString(KEY_LASTNAME, user.getLastname());
        editor.putString(KEY_ADDRESS, user.getAddress());
        editor.putString(KEY_PROVINCE, user.getProvince());
        editor.putString(KEY_PINCODE, user.getPincode());
        editor.putString(KEY_PHONENUMBER, user.getPhonenumber());
        editor.putString(KEY_PAYEENAME, user.getPayeeName());
        editor.putString(KEY_BANKNAME, user.getBankName());
        editor.putString(KEY_SIN, user.getSinNumber());
        editor.putInt(KEY_ISTERMSCHECKED, user.isIstermsCheced());
        editor.putString(KEY_SELLERTYPE, user.getSellerType());
        editor.putString(KEY_COMPANYNAME, user.getCompanyName());
        editor.putString(KEY_COMPANYADDRESS, user.getCompanyAddress());
        editor.apply();
    }
*/
}
