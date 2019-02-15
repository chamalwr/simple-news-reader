package com.chamalwr.mtopicnewsreader.functions;

import android.util.Log;

import com.chamalwr.mtopicnewsreader.models.NewsResponse;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit retrofit = null;

    public Retrofit getClient(OkHttpClient.Builder httpClient){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://newsapi.org/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();


        JsonPlaceHolder jsonPlaceHolder = retrofit.create(JsonPlaceHolder.class);
        Call<NewsResponse> call = jsonPlaceHolder.getPots();
        call.enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                if(response.isSuccessful()){
                    Log.i("JSONNEWS", new GsonBuilder().setPrettyPrinting().create().toJson(response));
                    Log.i("JSONNEWS", "SUCCESS : " + String.valueOf(response.code()));

                }else{
                    Log.i("JSONNEWS", String.valueOf(response.code()));
                }
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                Log.i("JSONNEWS", "ERROR : " +t.getMessage());
            }
        });

        return retrofit;
    }
}
