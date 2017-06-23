package com.dell.blr.ezaccess;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MiddleSplash extends AppCompatActivity {

    String title,project,platform,cid,env,sev,dom, assignedTo, eta, employeeID, employeeName;
    Button goBack ;
    Intent home;
    TextView id,aT;
    int request_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_middle_splash);

        id = (TextView)findViewById(R.id.req_id);
        aT = (TextView)findViewById(R.id.assignedto);
        goBack = (Button)findViewById(R.id.goHome);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            title = extras.getString("TITLE");
            project = extras.getString("PROJECT");
            platform = extras.getString("PLATFORM");
            cid = extras.getString("CLARITY_ID");
            env = extras.getString("ENV");
            sev = extras.getString("SEV");
            dom = extras.getString("DOM");
            eta = extras.getString("ETA");
            employeeID = extras.getString("EMPLOYEE_ID");
            employeeName = extras.getString("EMPLOYEE_NAME");
        }


        assignedTo = employeeName+"\nID: "+ employeeID + "\nETA:" + eta +" Hrs";
        request_id = (new Random(34).nextInt())/99999+2017000;

        id.setText(String.valueOf(Math.abs(request_id)));
        aT.setText(assignedTo);

        home = new Intent(this,DefaultView.class);
        home.putExtra("TITLE",title);
        home.putExtra("PROJECT",project);
        home.putExtra("PLATFORM",platform);
        home.putExtra("CLARITY_ID",cid);
        home.putExtra("ENV",env);
        home.putExtra("SEV",sev);
        home.putExtra("DOM",dom);
        home.putExtra("ASSIGNED_TO",employeeName);
        home.putExtra("REQUEST_ID",request_id);
        home.putExtra("ETA",eta);


        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(home);
            }
        });

    }
}
