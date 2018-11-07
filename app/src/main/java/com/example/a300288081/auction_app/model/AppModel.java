package com.example.a300288081.auction_app.model;

public class AppModel {


boolean emailValidation( String email)
{

    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    if (email.matches(emailPattern) && email.length() > 0)
    {
       return true;
    }
    else
    {
        return false;
    }
}



boolean phonevalidation(String phone)
{


    return false;
}


}
