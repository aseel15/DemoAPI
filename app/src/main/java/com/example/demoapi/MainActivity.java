package com.example.demoapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recycler;
    ArrayList<String>imagesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycler=findViewById(R.id.room_recycler);

        imagesList=new ArrayList<>();


    }
    //read from api
    //add url into array
    //pass array to captionedImg

    public void btnDecorateOnClick(View view) {
        //call volly
        imagesList=new ArrayList<>();
        String url ="https://api.unsplash.com/search/photos?client_id=a343tF8cTQJPm3NR2LZhMbZf0QUOLZ-MlOAw0GI2njQ&page=1&per_page=30&query=wedding%20decorate";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url,
                        null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                           JSONArray jsonArray=response.getJSONArray("results");
                           int length=jsonArray.length();

                           for(int i=0;i<length;i++) {
                               JSONObject obj = jsonArray.getJSONObject(i);
                               String imageUrl = "";
                               JSONObject imgUrl =obj.getJSONObject("urls");
                               imageUrl = imgUrl.getString("small");
                               imagesList.add(imageUrl);
                           }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                       

                        recycler.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                        CationImage adapter = new CationImage(MainActivity.this, imagesList);

                        recycler.setAdapter(adapter);
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error


                    }
                });
       // MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(jsonObjectRequest);
    }

    public void btnCakeOnClick(View view) {
        imagesList=new ArrayList<>();
        String url ="https://api.unsplash.com/search/photos?client_id=a343tF8cTQJPm3NR2LZhMbZf0QUOLZ-MlOAw0GI2njQ&page=1&per_page=30&query=wedding%20cake";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url,
                        null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONArray jsonArray=response.getJSONArray("results");
                            int length=jsonArray.length();

                            for(int i=0;i<length;i++) {
                                JSONObject obj = jsonArray.getJSONObject(i);
                                String imageUrl = "";
                                JSONObject imgUrl =obj.getJSONObject("urls");
                                imageUrl = imgUrl.getString("small");
                                imagesList.add(imageUrl);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }



                        recycler.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                        CationImage adapter = new CationImage(MainActivity.this, imagesList);

                        recycler.setAdapter(adapter);
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error


                    }
                });
        // MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(jsonObjectRequest);
    }


    public void btnFoodOnClick(View view) {
        imagesList=new ArrayList<>();
        String url ="https://api.unsplash.com/search/photos?client_id=a343tF8cTQJPm3NR2LZhMbZf0QUOLZ-MlOAw0GI2njQ&page=1&per_page=60&query=wedding%20food";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url,
                        null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONArray jsonArray=response.getJSONArray("results");
                            int length=jsonArray.length();

                            for(int i=0;i<length;i++) {
                                JSONObject obj = jsonArray.getJSONObject(i);
                                String imageUrl = "";
                                JSONObject imgUrl =obj.getJSONObject("urls");
                                imageUrl = imgUrl.getString("small");
                                imagesList.add(imageUrl);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }



                        recycler.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                        CationImage adapter = new CationImage(MainActivity.this, imagesList);

                        recycler.setAdapter(adapter);
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error


                    }
                });
        // MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(jsonObjectRequest);
    }
}