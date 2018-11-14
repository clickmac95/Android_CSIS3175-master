package com.example.a300288081.auction_app.model;


import android.content.Context;

public class User {
    private String username;
    private String token;
    private String firstname;
    private String lastname;
    private String address;
    private String province;
    private String country;
    private String pincode;
    private String phonenumber;

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    private String userType;
    private Integer UserID;



    //these key values for seller user
    private  String payeeName,bankName,companyName,companyAddress, sellerType, sinNumber;
    private Integer istermsCheced;
    private  String pswrd;

    public User()
    {

    }


    public User(Integer UserId, String username, String firstname, String lastname, String address, String province, String country, String pincode, String phonenumber,String userType) {
        this.UserID=UserId;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.province = province;
        this.country = country;
        this.pincode = pincode;
        this.phonenumber = phonenumber;
        this.userType = userType;
    }



   /* public static synchronized User GetUserModel(String username, String firstname, String lastname, String address, String province, String country, String pincode, String phonenumber, String password) {
      User user=new User();
        user.username = username;

        user.firstname = firstname;
        user.lastname = lastname;
        user.address = address;
        user.province = province;
        user.country = country;
        user.pincode = pincode;
        user.phonenumber = phonenumber;
        user.pswrd=password;
        return  user;
    }*/
/// this method is fo the seller
/*public static synchronized User GetSeller(Integer UserId, String username, String firstname, String lastname, String address,
                                          String province, String country, String pincode, String phonenumber, String payeeName,
                                          String bankName, String sellerType, String sinnumber, String companyName, String companyAddress,
                                          Integer isAccepted) {
    User user=new User();
    user.UserID=UserId;
    user.username = username;

    user.firstname = firstname;
    user.lastname = lastname;
    user.address = address;
    user.province = province;
    user.country = country;
    user.pincode = pincode;
    user.phonenumber = phonenumber;
    user.payeeName=payeeName;
    user.bankName=bankName;
    user.sellerType=sellerType;
    user.sinNumber=sinnumber;
    user.companyName=companyName;
    user.companyAddress=companyAddress;
    user.istermsCheced=isAccepted;
    return  user;
}*/
    public String getFirstname() {
        return firstname;
    }

    public Integer getUserID() {
        return UserID;
    }

    public String getUsername() {
        return username;
    }


    public String getToken() {
        return token;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAddress() {
        return address;
    }

    public String getProvince() {
        return province;
    }

    public String getCountry() {
        return country;
    }

    public String getPincode() {
        return pincode;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getPayeeName() {
        return payeeName;
    }

    public String getBankName() {
        return bankName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public String getSellerType() {
        return sellerType;
    }

    public String getSinNumber() {
        return sinNumber;
    }

    public Integer getIstermsCheced() {
        return istermsCheced;
    }

    public Integer isIstermsCheced() {
        return istermsCheced;
    }


}

