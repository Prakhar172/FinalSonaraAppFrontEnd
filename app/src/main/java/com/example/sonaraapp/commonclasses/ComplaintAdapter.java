package com.example.sonaraapp.commonclasses;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sonaraapp.R;

import java.util.List;

public class ComplaintAdapter extends RecyclerView.Adapter<ComplaintAdapter.ComplaintViewHolder> {

    private Context mCtx;
    private List<Complaint> ComplaintList;

    //getting the context and product list with constructor
    public ComplaintAdapter(Context mCtx, List<Complaint> ComplaintList) {
        this.mCtx = mCtx;
        this.ComplaintList = ComplaintList;
    }

    @Override
    public ComplaintAdapter.ComplaintViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.activity_complaintlist, null);
        return new ComplaintAdapter.ComplaintViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ComplaintAdapter.ComplaintViewHolder holder, int position) {
        final Complaint Complaint = ComplaintList.get(position);
        holder.name.setText(Complaint.getName());
        holder.mobno.setText(Complaint.getMobile());
        holder.modelno.setText(Complaint.getModelno());
        holder.problems.setText(Complaint.getProblem());
        holder.engineername.setText(Complaint.getEnginnername());
        holder.status.setText(Complaint.getStatus());
        holder.date.setText(Complaint.getDate());
        holder.estimate.setText(Complaint.getEstimate());
        holder.paid.setText(Complaint.getPaid());
        holder.Complaint_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String number = Complaint.getCallnumber();
//                PhoneCallListener phoneListener = new PhoneCallListener(mCtx,Complaint.getMobile());
//                TelephonyManager telephonyManager =     (TelephonyManager) mCtx.getSystemService(Context.TELEPHONY_SERVICE);
//                telephonyManager.listen(phoneListener, PhoneStateListener.LISTEN_CALL_STATE);
//
//                if (ActivityCompat.checkSelfPermission(mCtx, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
//                    Intent callIntent = new Intent(Intent.ACTION_CALL);
//                    callIntent.setData(Uri.parse("tel:"+Complaint.getCallnumber()));
////                    callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    mCtx.startActivity(callIntent);
//                }else{
//                    Toast.makeText(mCtx, "You don't assign permission.", Toast.LENGTH_SHORT).show();
//                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return ComplaintList.size();
    }

    class ComplaintViewHolder extends RecyclerView.ViewHolder {
        TextView name, mobno,status, Complaint_call, modelno,engineername,date, problems, estimate, paid, remarks;

        public ComplaintViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            mobno = itemView.findViewById(R.id.mobno);
            modelno = itemView.findViewById(R.id.modelno);
            problems = itemView.findViewById(R.id.problems);
            date = itemView.findViewById(R.id.date);
            engineername = itemView.findViewById(R.id.engineername);
            status = itemView.findViewById(R.id.status);
            estimate = itemView.findViewById(R.id.estimate);
            paid = itemView.findViewById(R.id.paid);
        }
    }
}
