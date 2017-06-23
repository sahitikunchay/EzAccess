package com.dell.blr.ezaccess;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class RequestAdapter extends RecyclerView.Adapter<RequestAdapter.ContactViewHolder> {
    private List<RequestInfo> requestList;

    public RequestAdapter(List<RequestInfo> pRequestList) {
        this.requestList = pRequestList;
    }


    @Override
    public int getItemCount() {
        return requestList.size();
    }

    @Override
    public void onBindViewHolder(ContactViewHolder contactViewHolder, int i) {
        RequestInfo ri = requestList.get(i);
        contactViewHolder.vRequestID.setText(ri.requestID);
        contactViewHolder.vDepartment.setText(ri.department);
        contactViewHolder.vAssignedTo.setText(ri.assignedTo);
        contactViewHolder.vTitle.setText("Request");
        contactViewHolder.vETA.setText(ri.eta);
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.card_layout, viewGroup, false);

        return new ContactViewHolder(itemView);
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder {

        protected TextView vRequestID;
        protected TextView vDepartment;
        protected TextView vAssignedTo;
        protected TextView vETA;
        protected TextView vTitle;


        public ContactViewHolder(View v) {
            super(v);
            vRequestID =  (TextView) v.findViewById(R.id.txtName);
            vDepartment = (TextView)  v.findViewById(R.id.txtSurname);
            vAssignedTo = (TextView)  v.findViewById(R.id.txtEmail);
            vETA = (TextView) v.findViewById(R.id.txtAdd);
            vTitle=(TextView) v.findViewById(R.id.title);
        }
    }
}
