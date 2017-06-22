package com.dell.blr.ezaccess;

import android.content.Intent;
import android.graphics.Color;
import android.provider.Settings;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    int dev = 0,stg,oth,sev3,sev2,sev4,ebi,nebi, stChck = 0, inChck = 0, kch=0;
    TextView tvDEV, tvSTG, tvOTHER, SEV2,SEV3,SEV4, tvEBI, tvNEBI,submit;
    String title,project,platform,cid,env,sev,dom, eta, employeeID, employeeName;
    EditText titleF,projF,platF,time;
    Integer requestTime;
    Intent toSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDEV = (TextView)findViewById(R.id.tvDEV);
        tvSTG = (TextView)findViewById(R.id.tvSTG);
        tvOTHER = (TextView)findViewById(R.id.tvOTH);
        SEV2 = (TextView)findViewById(R.id.tvSEV2);
        SEV3 = (TextView)findViewById(R.id.tvSEV3);
        SEV4 = (TextView)findViewById(R.id.tvSEV4);
        tvEBI = (TextView)findViewById(R.id.tvEBI);
        tvNEBI = (TextView)findViewById(R.id.tvNEBI);
        submit = (TextView)findViewById(R.id.tvSubmit);
        titleF = (EditText)findViewById(R.id.edTitle);
        projF = (EditText)findViewById(R.id.edProject);
        platF = (EditText)findViewById(R.id.edPlatform);
        time = (EditText)findViewById(R.id.edClarityID);

        tvDEV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dev = 1;
                stg = 0;
                oth = 0;
                tvDEV.setTextColor(Color.WHITE);
                tvDEV.setBackgroundResource(R.drawable.rdcrns);
                tvSTG.setTextColor(ContextCompat.getColor(getBaseContext(),R.color.secondaryText));
                tvSTG.setBackgroundColor(Color.TRANSPARENT);
                tvOTHER.setTextColor(ContextCompat.getColor(getBaseContext(),R.color.secondaryText));
                tvOTHER.setBackgroundColor(Color.TRANSPARENT);

            }
        });
        tvSTG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stg = 1;
                dev = 0;
                oth =0;
                tvSTG.setTextColor(Color.WHITE);
                tvSTG.setBackgroundResource(R.drawable.rdcrns);
                tvDEV.setTextColor(ContextCompat.getColor(getBaseContext(),R.color.secondaryText));
                tvDEV.setBackgroundColor(Color.TRANSPARENT);
                tvOTHER.setTextColor(ContextCompat.getColor(getBaseContext(),R.color.secondaryText));
                tvOTHER.setBackgroundColor(Color.TRANSPARENT);

            }
        });
        tvOTHER.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                oth = 1;
                dev = 0;
                stg = 0;
                tvOTHER.setTextColor(Color.WHITE);
                tvOTHER.setBackgroundResource(R.drawable.rdcrns);
                tvSTG.setTextColor(ContextCompat.getColor(getBaseContext(),R.color.secondaryText));
                tvSTG.setBackgroundColor(Color.TRANSPARENT);
                tvDEV.setTextColor(ContextCompat.getColor(getBaseContext(),R.color.secondaryText));
                tvDEV.setBackgroundColor(Color.TRANSPARENT);

            }
        });

        SEV2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sev2=1;sev3=0;sev4=0;
                SEV2.setTextColor(Color.WHITE);
                SEV2.setBackgroundResource(R.drawable.gsev);
                SEV3.setTextColor(ContextCompat.getColor(getBaseContext(),R.color.secondaryText));
                SEV3.setBackgroundColor(Color.TRANSPARENT);
                SEV4.setTextColor(ContextCompat.getColor(getBaseContext(),R.color.secondaryText));
                SEV4.setBackgroundColor(Color.TRANSPARENT);

            }
        });
        SEV3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sev2=0;sev3=1;sev4=0;
                SEV3.setTextColor(Color.WHITE);
                SEV3.setBackgroundResource(R.drawable.osev);
                SEV2.setTextColor(ContextCompat.getColor(getBaseContext(),R.color.secondaryText));
                SEV2.setBackgroundColor(Color.TRANSPARENT);
                SEV4.setTextColor(ContextCompat.getColor(getBaseContext(),R.color.secondaryText));
                SEV4.setBackgroundColor(Color.TRANSPARENT);

            }
        });
        SEV4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sev2=0;sev3=0;sev4=1;
                SEV4.setTextColor(Color.WHITE);
                SEV4.setBackgroundResource(R.drawable.rsev);
                SEV2.setTextColor(ContextCompat.getColor(getBaseContext(),R.color.secondaryText));
                SEV2.setBackgroundColor(Color.TRANSPARENT);
                SEV3.setTextColor(ContextCompat.getColor(getBaseContext(),R.color.secondaryText));
                SEV3.setBackgroundColor(Color.TRANSPARENT);

            }
        });

        tvEBI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ebi = 1;nebi = 0;
                tvEBI.setTextColor(Color.WHITE);
                tvEBI.setBackgroundResource(R.drawable.rdcrns);
                tvNEBI.setTextColor(ContextCompat.getColor(getBaseContext(),R.color.secondaryText));
                tvNEBI.setBackgroundColor(Color.TRANSPARENT);

            }
        });
        tvNEBI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Volley", "hereee");
                ebi = 0;nebi = 1;
                tvNEBI.setTextColor(Color.WHITE);
                tvNEBI.setBackgroundResource(R.drawable.rdcrns);
                tvEBI.setTextColor(ContextCompat.getColor(getBaseContext(),R.color.secondaryText));
                tvEBI.setBackgroundColor(Color.TRANSPARENT);

            }
        });

        toSplash =  new Intent(this,MiddleSplash.class);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Volley", "here1");
                title = titleF.getText().toString();
                project = projF.getText().toString();
                platform = platF.getText().toString();
                cid = time.getText().toString();

                // Volley
                String tag_json_obj = "json_obj_req";

                String url = "http://01d4ae37.ngrok.io/getResource";
                Log.d("Volley", "here");
                HashMap<String, String> params = new HashMap<String, String>();
                params.put("request_platform", platform);
                params.put("request_time", cid);
                JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                        url, new JSONObject(params),
                        new Response.Listener<JSONObject>() {

                            @Override
                            public void onResponse(JSONObject response) {
                                Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
                                Log.d("Volley", response.toString());
                                try {
                                    eta = response.get("eta").toString();
                                    employeeID = response.get("employeeID").toString();
                                    employeeName = response.get("employeeName").toString();
                                    Log.d("Volley", eta+employeeName+employeeID);
                                    kch=1;
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.d("Volley", "Error: " + error.getMessage());
                    }
                }) {

                    /*@Override
                    protected Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("request_platform", platform);
                        params.put("request_time", cid);

                        return params;
                    }*/
                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        HashMap<String, String> headers = new HashMap<String, String>();
                        headers.put("Content-Type", "application/json");
                        return headers;
                    }

                };

// Adding request to request queue
                AppController.getInstance().addToRequestQueue(jsonObjReq, tag_json_obj);

                if (dev == 1)
                    env = "DEV";
                else if (stg == 1)
                    env = "STG";
                else if (oth == 1)
                    env = "OTHER";
                else
                    env = "";

                if (sev2 == 1)
                    sev = "SEV2";
                else if (sev3 == 1)
                    sev = "SEV3";
                else if (sev4 == 1)
                    sev = "SEV4";
                else
                    sev = "";

                if (ebi == 1)
                    dom = "EBI";
                else if (nebi == 1)
                    dom = "NONEBI";
                else
                    dom = "";

                if (title.length() > 0 && project.length() > 0 && platform.length() > 0 && cid.length() > 0)
                    stChck = 1;
                else
                    stChck = 0;

                if (env.length() > 0 && sev.length() > 0 && dom.length() > 0)
                    inChck = 1;
                else
                    inChck = 0;

                if (inChck == 1 && stChck == 1 && kch==1) {
                    toSplash.putExtra("TITLE", title);
                    toSplash.putExtra("PROJECT", project);
                    toSplash.putExtra("PLATFORM", platform);
                    toSplash.putExtra("TIME", cid);
                    toSplash.putExtra("ENV", env);
                    toSplash.putExtra("SEV", sev);
                    toSplash.putExtra("DOM", dom);
                    toSplash.putExtra("ETA", eta);
                    toSplash.putExtra("EMPLOYEE_ID", employeeID);
                    toSplash.putExtra("EMPLOYEE_NAME", employeeName);
                    startActivity(toSplash);
                } else {
                    Toast.makeText(getBaseContext(), "Please fill the remaining fields", Toast.LENGTH_LONG).show();
                }
            }

        });

        /*submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Volley", "here1");
                title = titleF.getText().toString();
                project = projF.getText().toString();
                platform = platF.getText().toString();
                requestTime = Integer.parseInt(time.getText().toString());

                // Volley
                String tag_json_obj = "json_obj_req";

                String url = "http://01d4ae37.ngrok.io/getResource";
                Log.d("Volley", "here");
                JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                        url, null,
                        new Response.Listener<JSONObject>() {

                            @Override
                            public void onResponse(JSONObject response) {
                                Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
                                Log.d("Volley", response.toString());
                            }
                        }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.d("Volley", "Error: " + error.getMessage());
                    }
                }) {

                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("request_platform", platform);
                        params.put("request_time", requestTime.toString());

                        return params;
                    }
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        HashMap<String, String> headers = new HashMap<String, String>();
                        headers.put("Content-Type", "application/json");
                        return headers;
                    }

                };

// Adding request to request queue
                AppController.getInstance().addToRequestQueue(jsonObjReq, tag_json_obj);

                if(dev == 1)
                    env = "DEV";
                else if(stg == 1)
                    env = "STG";
                else if(oth ==1)
                    env = "OTHER";
                else
                    env="";

                if(sev2 == 1)
                    sev = "SEV2";
                else if(sev3 == 1)
                    sev = "SEV3";
                else if(sev4 == 1)
                    sev = "SEV4";
                else
                    sev = "";

                if(ebi == 1)
                    dom = "EBI";
                else if(nebi == 1)
                    dom = "NONEBI";
                else
                    dom="";

                if(title.length() > 0 && project.length()>0 && platform.length()>0 && cid.length()>0)
                    stChck = 1;
                else
                    stChck = 0;

                if(env.length() > 0 && sev.length() > 0 && dom.length() > 0)
                    inChck = 1;
                else
                    inChck = 0;

                *//*if(inChck == 1 && stChck == 1){
                    toSplash.putExtra("TITLE",title);
                    toSplash.putExtra("PROJECT",project);
                    toSplash.putExtra("PLATFORM",platform);
                    toSplash.putExtra("CLARITY_ID",cid);
                    toSplash.putExtra("ENV",env);
                    toSplash.putExtra("SEV",sev);
                    toSplash.putExtra("DOM",dom);
                    //startActivity(toSplash);
                }
                else{
                    Toast.makeText(getBaseContext(),"Please fill the remaining fields",Toast.LENGTH_LONG).show();
                }*//*




            }
        });*/
    }

    public void popDialog(View V){
        AlertDialog.Builder diBuild = new AlertDialog.Builder(this);
        diBuild.setTitle("Severity Levels");
        diBuild.setMessage("SEV 2:Server issues\n" +
                "SEV 3: migration issues, Monitoring issues,Users Req/Issues (like access, cache , migration,export,scheduling etc.)\n" +
                "SEV 4: Report Issues, Miscellaneous issues.\n");
        diBuild.show();
    }




}
