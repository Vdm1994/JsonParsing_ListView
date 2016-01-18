package com.example.tasol.jsonparsing;

import android.app.Activity;
import android.app.ListActivity;
import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tasol on 7/1/16.
 */
public class MainActivity extends Activity /*extends ListActivity*/{
    TextView mTextView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView=(TextView)findViewById(R.id.mTextView);
        // Tag used to cancel the request

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://www.mocky.io/v2/568cf9120f00009542cceec5";


        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                url, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        JSONObject obj=null;
                        JSONObject obj5=null;
                        JSONObject obj1=null;
                        JSONObject obj2=null;
                        JSONObject obj3=null;
                        JSONObject obj4=null;
                        JSONArray arr =null;
                        String data = "";
                        try {
                            obj = response.getJSONObject("glossary");
                            obj1 = obj.getJSONObject("GlossDiv");
                            obj3 = obj1.getJSONObject("GlossList");
                            obj4 = obj3.getJSONObject("GlossEntry");
                            obj5 = obj4.getJSONObject("GlossDef");
                            arr = obj5.getJSONArray("GlossSeeAlso");

                            String title = obj.optString("title").toString();
                            String title2 = obj1.optString("title").toString();
                            String id = obj4.optString("ID").toString();
                            String SortAs = obj4.optString("SortAs").toString();
                            String GlossTerm = obj4.optString("GlossTerm").toString();
                            String Acronym = obj4.optString("Acronym").toString();
                            String Abbrev = obj4.optString("Abbrev").toString();
                            String GlossSee = obj4.optString("GlossSee").toString();
                            String para = obj5.optString("para").toString();

     /*                       HashMap<String, String> all = new HashMap<String, String>();
                            all.put("title",title);
                            ListAdapter adapter = new SimpleAdapter(
                                    MainActivity.this,
                                    R.layout.list, new String[] { }, new int[] { R.id.textView});

                            setListAdapter(adapter);
         //                   final String[] str = new String[]{
         //                           "title:"+ title,"title:"+ title2,"Id:"+ id, "SortAs" + SortAs , "GlossTerm"+GlossTerm , "Acronym" +Acronym , "Abbrev"+Abbrev , "GlossSee" + GlossSee, " para:" + para };


                     */       data =  "glossary:"+ "\n title:"+ title+
                                    "\nGlossDiv:"+ "\n title:"+ title2+
                                    "\nGlossList"+
                                    "\n GlossEntry:"+
                                    "\n Id:"+ id +"\n SortAs" + SortAs + "\n GlossTerm"+GlossTerm + "\n Acronym" +Acronym + "\n Abbrev"+Abbrev + "\n GlossSee" + GlossSee +
                                    "\n GlossDef:" +
                                    "\n para:" + para +
                                    "\n GlossSeeAlso:" + arr.toString();





                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        mTextView.setText(data);




           //             ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list, str);
             //           setListAdapter(adapter);




                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("Error: " + error.getMessage());
                // hide the progress dialog

            }
        });

// Adding request to request queue
        queue.add(jsonObjReq);


    }
}


/*
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://www.mocky.io/v2/568cf9120f00009542cceec5";
        mTextView=(TextView)findViewById(R.id.mTextView);

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the  characters of the response string.
                        JSONObject  jsonRootObject = new JSONObject(response);
                        JSONObject jsonObject = jsonRootObject.getJSONObject("glossary");
                        mTextView.setText(jsonObject);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mTextView.setText("That didn't work!");
            }
        });
// Add the request to the RequestQueue.
        queue.add(stringRequest);

}
}*/

/*obj2 = obj.getJSONObject("GlossDiv");
        obj3 = obj2.getJSONObject("title");
        obj4 = obj2.getJSONObject("GlossList");
        obj5 = obj4.getJSONObject("GlossEntry");*/