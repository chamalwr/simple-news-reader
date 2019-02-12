package com.chamalwr.mtopicnewsreader;

import android.os.Bundle;
import android.util.Log;

import com.chamalwr.mtopicnewsreader.functions.JsonPlaceHolder;
import com.chamalwr.mtopicnewsreader.models.NewsResponse;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        DownloadTask downloadTask = new DownloadTask();
//        downloadTask.execute("https://newsapi.org/v2/everything?q=bitcoin&from=2019-01-11&sortBy=publishedAt&apiKey=5410be6b3ca74a4eb6bd525b4f71d54b");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://newsapi.org/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        JsonPlaceHolder jsonPlaceHolder = retrofit.create(JsonPlaceHolder.class);
        Call<List<NewsResponse>> call = jsonPlaceHolder.getPots();
        call.enqueue(new Callback<List<NewsResponse>>() {
            @Override
            public void onResponse(Call<List<NewsResponse>> call, Response<List<NewsResponse>> response) {
                if(!response.isSuccessful()){
                    Log.i("JSONNEWS", "ERROR CODE : " + response.code());
                }else{
                    Log.i("JSONNEWS", response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<List<NewsResponse>> call, Throwable t) {
                Log.i("JSONNEWS", "ERROR  : " + t.getMessage());
            }
        });
    }
}
