package com.example.sonaraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.sonaraapp.commonclasses.SharedData;

public class AdminProfile extends AppCompatActivity {
Button addengineer, addcustomer,logout,showengineer,sold,complaints,allcomplaints;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminprofile);
        addcustomer = findViewById(R.id.btn_admin_add_new_customer);
        addengineer = findViewById(R.id.btn_admin_add_new_enginner);
        complaints = findViewById(R.id.btn_admin_complaints);
        sold = findViewById(R.id.btn_sold);
        allcomplaints = findViewById(R.id.btn_admin_show_all_pending);
        showengineer = findViewById(R.id.btn_admin_show_all_engineer);
        logout = findViewById(R.id.btn_logout);
        SharedData sharedData = new SharedData(AdminProfile.this);
        allcomplaints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(AdminProfile.this,all_complaints_panel.class);
                startActivity(in);

            }
        });
        sold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(AdminProfile.this,sold_activity.class);
                startActivity(in);
            }
        });
        if(!sharedData.GetSharedPrefernce()){
            Intent in = new Intent(AdminProfile.this,login.class);
            startActivity(in);
        }

complaints.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent in = new Intent(AdminProfile.this,Complaints.class);
        startActivity(in);

    }
});
    addcustomer.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent in = new Intent(AdminProfile.this,addcustomer.class);
            startActivity(in);
        }
    });
    addengineer.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent in = new Intent(AdminProfile.this,AddEnginner.class);
            startActivity(in);
        }
    });
    logout.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            SharedData sd = new SharedData(AdminProfile.this);
            sd.clearSharedPreferences();
            startActivity(new Intent(AdminProfile.this,login.class));
        }
    });
    showengineer.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent in = new Intent(AdminProfile.this,EmployeeList.class);
            startActivity(in);
        }
    });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Toast.makeText(AdminProfile.this,"There is no back action",Toast.LENGTH_LONG).show();
        return;
    }


}