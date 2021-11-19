package com.example.a19113013_st088_pamuts;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class ActivityDirectory extends AppCompatActivity {

    private static final String JSON_URL = "https://api.jsonbin.io/b/618dd6084a56fb3dee0da690";

    List<Movie> movieList;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.directory_movie);

        movieList = new ArrayList<>();
        recyclerView = findViewById(R.id.recycle_view);

        GetData getData = new GetData();
        getData.execute();
    }

    public class GetData extends AsyncTask<String, String, String>{

        @Override
        protected String doInBackground(String... strings) {
            String current="";

            try{
                URL url;
                HttpURLConnection urlConnection = null;

                try {
                    url= new URL(JSON_URL);
                    urlConnection = (HttpURLConnection) url.openConnection();

                    InputStream is = urlConnection.getInputStream();
                    InputStreamReader isr = new InputStreamReader(is);

                    int data = isr.read();
                    while(data != -1){
                        current += (char) data;
                        data = isr.read();
                    }
                    return current;

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (urlConnection != null){
                        urlConnection.disconnect();
                    }
                }
            } catch (Exception e){
                e.printStackTrace();
            }
            return current;
        }

        @Override
        protected void onPostExecute(String s){

            try {
                JSONObject jsonObject = new JSONObject(s);
                JSONArray jsonArray = jsonObject.getJSONArray("results");

                for (int i = 0; i<jsonArray.length(); i++){
                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);

                    Movie movie = new Movie();
                    movie.setTitle(jsonObject1.getString("title"));
                    movie.setDescription(jsonObject1.getString("overview"));
                    movie.setRelease(jsonObject1.getString("release_date"));
                    movie.setImage(jsonObject1.getString("poster_path"));

                    movieList.add(movie);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            PutDataIntoRecyclerView(movieList);
        }
    }


    //    public class getMovie extends AsyncTask<String, String, String> {
//        @Override
//        protected String doInBackground(String... strings){
//            String current = "";
//
//            try{
//                url = new URL(JSON_URL);
//                urlConnection = (HttpURLConnection) url.openConnection();
//                InputStream is = urlConnection.getInputStream();
//                InputStreamReader isr = new InputStreamReader(is);
//
//                int data = isr.read();
//                while(data != -1){
//                    current += (char) data;
//                    data = isr.read();
//                }
//                return current;
//            } catch (MalformedURLException e){
//                e.printStackTrace();
//            } catch (IOException e){
//                e.printStackTrace();
//            } finally {
//                if (urlConnection !=null){
//                    urlConnection.disconnect();
//                }
//            }
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//
//        return current;
//    }



    private void PutDataIntoRecyclerView(List<Movie> movieList) {
        Adapter adapter = new Adapter(this, movieList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }


}

