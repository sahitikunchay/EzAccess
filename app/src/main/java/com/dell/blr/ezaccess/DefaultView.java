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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default_view);

        RecyclerView recList = (RecyclerView) findViewById(R.id.cardList);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);
        RequestAdapter ca = new RequestAdapter(createList(4));
        recList.setAdapter(ca);
        int size = ca.getItemCount();
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
        for (int i=1; i <= size; i++) {
            RequestInfo ci = new RequestInfo();
            ci.requestID = RequestInfo.REQUEST_ID_PREFIX + i;
            ci.department = RequestInfo.DEPARTMENT_PREFIX + i;
            ci.assignedTo = RequestInfo.ASSIGNED_TO_PREFIX + i;
            result.add(ci);

        }

        return result;
    }
}
