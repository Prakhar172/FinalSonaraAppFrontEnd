package com.example.sonaraapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.sonaraapp.commonclasses.Complaint;
import com.example.sonaraapp.commonclasses.ComplaintAdapter;
import com.example.sonaraapp.commonclasses.CustomerAdapter;
import com.example.sonaraapp.commonclasses.Employee;
import com.example.sonaraapp.commonclasses.SharedData;
import com.example.sonaraapp.commonclasses.URL;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class all_complaints_panel extends AppCompatActivity {
RecyclerView recyclerView;
List<Complaint>  complaintList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaintlist);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        complaintList = new ArrayList<>();
        ShowAllComplaints(complaintList);
        

    }

    private void ShowAllComplaints(final List<Complaint>  complaintList) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL.URL_SHOWALLCOMPLAINTS, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try{
                    JSONArray jsonArray = new JSONArray(response);

                    for(int i=0;i<jsonArray.length();i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        Toast.makeText(all_complaints_panel.this, ""+jsonObject.getString("name")+""+jsonObject.getString("mobile")+""+jsonObject.getString("modelno")+""+jsonObject.getString("problem")+""+jsonObject.getString("engineer_id")+""+jsonObject.getString("status")+""+jsonObject.getString("date")+""+jsonObject.getString("estimate")+""+jsonObject.getString("paid"), Toast.LENGTH_SHORT).show();
                        jsonObject.getString("name");
                        complaintList.add(new Complaint(jsonObject.getString("name"),jsonObject.getString("mobile"),jsonObject.getString("modelno"),jsonObject.getString("problem"),jsonObject.getString("engineer_id"),jsonObject.getString("status"),jsonObject.getString("date"),jsonObject.getString("estimate"),jsonObject.getString("paid")));
                    }
                    ComplaintAdapter adapter = new ComplaintAdapter(all_complaints_panel.this,complaintList);
                    recyclerView.setAdapter(adapter);

//                    Toast.makeText(all_complaints_panel.this, ""+response, Toast.LENGTH_SHORT).show();

                }
                catch (Exception e){}

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(all_complaints_panel.this, "error  "+error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                return  params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(all_complaints_panel.this);
        requestQueue.add(stringRequest);
    }

}
