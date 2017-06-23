package com.dell.blr.ezaccess;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class DefaultView extends AppCompatActivity {
    String eta, employeeName,  platform;
    int requestId;
    List<RequestInfo> helloList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default_view);

        RecyclerView recList = (RecyclerView) findViewById(R.id.cardList);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);
        helloList = createList(2);
        RequestAdapter ca = new RequestAdapter(helloList);
        recList.setAdapter(ca);
        int size = ca.getItemCount();

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            eta = extras.getString("ETA");
            employeeName = extras.getString("ASSIGNED_TO");
            requestId = extras.getInt("REQUEST_ID");
            platform = extras.getString("PLATFORM");
            RequestInfo ci2 = new RequestInfo();
            ci2.requestID = RequestInfo.REQUEST_ID_PREFIX + requestId;
            ci2.department = RequestInfo.DEPARTMENT_PREFIX + platform;
            ci2.assignedTo = RequestInfo.ASSIGNED_TO_PREFIX + employeeName;
            ci2.eta = RequestInfo.ETA_PREFIX + eta;
            helloList.add(ci2);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        if(id == R.id.addItem){
            Intent newForm = new Intent(this,MainActivity.class);
            startActivity(newForm);
        }
        return super.onOptionsItemSelected(item);
    }



    private List<RequestInfo> createList(int size) {

        List<RequestInfo> result = new ArrayList<>();
        RequestInfo ci = new RequestInfo();
        ci.requestID = RequestInfo.REQUEST_ID_PREFIX + " 250472";
        ci.department = RequestInfo.DEPARTMENT_PREFIX + " DCS";
        ci.assignedTo = RequestInfo.ASSIGNED_TO_PREFIX + " Susobhit P";
        ci.eta = RequestInfo.ETA_PREFIX + "12";
        result.add(ci);
        RequestInfo ci2 = new RequestInfo();
        ci2.requestID = RequestInfo.REQUEST_ID_PREFIX + " 460426";
        ci2.department = RequestInfo.DEPARTMENT_PREFIX + " PERF";
        ci2.assignedTo = RequestInfo.ASSIGNED_TO_PREFIX + " Sushant B";
        ci2.eta = RequestInfo.ETA_PREFIX + "6";
        result.add(ci2);
        /*for (int i=1; i <= size; i++) {
            RequestInfo ci = new RequestInfo();
            if(i)
            ci.requestID = RequestInfo.REQUEST_ID_PREFIX + " 250472";
            ci.department = RequestInfo.DEPARTMENT_PREFIX + " DCS";
            ci.assignedTo = RequestInfo.ASSIGNED_TO_PREFIX + " Susobhit P";
            result.add(ci);

        }*/

        return result;
    }
}
