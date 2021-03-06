package com.example.sonaraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.sonaraapp.commonclasses.SharedData;
import com.example.sonaraapp.commonclasses.URL;

import java.util.HashMap;
import java.util.Map;

public class AddEnginner extends AppCompatActivity {

    EditText et_signup_username,et_signup_mobile,et_signup_email,et_signup_pass,et_signup_re_pass;
    Button btn_add_engineer;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_enginner);
        et_signup_username = findViewById(R.id.et_signup_username);
        et_signup_mobile = findViewById(R.id.et_signup_mobile);
        et_signup_email = findViewById(R.id.et_signup_email);
        et_signup_pass = findViewById(R.id.et_signup_pass);
        et_signup_re_pass =  findViewById(R.id.et_signup_re_pass);
        btn_add_engineer = findViewById(R.id.btn_add_enginner);
        btn_add_engineer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(et_signup_username.getText().toString().isEmpty()){
                    et_signup_username.setError("Username is can't be blank");
                }
                else if(et_signup_mobile.getText().toString().isEmpty()){
                    et_signup_mobile.setError("Mobile Number can't be blank");
                }
                else if(et_signup_mobile.getText().toString().length() !=10){
                    et_signup_mobile.setError("Mobile Number is Invalid!");
                }
                else if(et_signup_email.getText().toString().isEmpty()){
                    et_signup_email.setError("Email can't be blank");
                }
                else if(et_signup_pass.getText().toString().isEmpty()){
                    et_signup_pass.setError("Password can't be blank");
                }
                else if(et_signup_re_pass.getText().toString().isEmpty()){
                    et_signup_re_pass.setError("Repassword can't be blank");
                }
                else if(!(et_signup_pass.getText().toString().equalsIgnoreCase(et_signup_re_pass.getText().toString()))){
                    et_signup_re_pass.setError("Password and Repassword Mismatch");
                }
                else {
                    AddNewEnginner(et_signup_username.getText().toString(), et_signup_mobile.getText().toString(), et_signup_email.getText().toString(), et_signup_pass.getText().toString());
                }
            }
        });

    }
    private void AddNewEnginner(final String username, final String mobile, final String email, final String pass) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL.URL_REGISTER, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                String name = response;
                if(Integer.parseInt(response)>0){
                    Intent in = new Intent(AddEnginner.this,AdminProfile.class);
                    startActivity(in);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(AddEnginner.this, "error  "+error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                //{name:req.body.name,mobile:req.body.mobile,modelno:req.body.modelno,serialno:req.body.serialno,problem:req.body.problem,workdone:req.body.workdone,estimate:req.body.estimate,paid:req.body.paid,remarks:req.body.remarks}
                params.put("name",username);
                params.put("email",email);
                params.put("mobile",mobile);
                params.put("pass",pass);
//                Toast.makeText(signup.this, "--"+mobile, Toast.LENGTH_SHORT).show();
                return params; // {email: 'shivnag@gmail.com',pass:'124'}
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(AddEnginner.this);
        requestQueue.add(stringRequest);
    }
}