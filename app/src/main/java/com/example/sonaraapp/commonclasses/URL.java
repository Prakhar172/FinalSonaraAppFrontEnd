package com.example.sonaraapp.commonclasses;


public class URL {

    private static final String ROOT_URL = "http://192.168.43.145:5000";

    public static final String URL_REGISTER = ROOT_URL + "/employee";

    public static final String URL_COMPLAINTS = ROOT_URL + "/addcomplaint";

    public static final String URL_LOGIN = ROOT_URL + "/login";

    public static final String URL_ADDCUSTOMER = ROOT_URL + "/customer/customerdetails";

    public  static final String URL_SHOWALLCUSTOMER = ROOT_URL + "/customer/getalldetails";

    public static final String URL_REMARKS = ROOT_URL+"/customer/remarks/";

    public static final String URL_SHOWALLEMPLOYEES = ROOT_URL+"/employee/details";

    public static final  String URL_SHOWALLCOMPLAINTS = ROOT_URL+"/customer/showcomplaint";

    public static final  String URL_SHOWPENDINGCOMPLAINTS = ROOT_URL+"/customer/showcomplaint";

    public static final  String URL_SHOWPROCESSCOMPLAINTS = ROOT_URL+"/customer/showcomplaint";


}