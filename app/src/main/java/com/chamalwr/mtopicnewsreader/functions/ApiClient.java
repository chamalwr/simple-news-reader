package com.chamalwr.mtopicnewsreader.functions;

import android.util.Log;

import com.chamalwr.mtopicnewsreader.models.News;
import com.chamalwr.mtopicnewsreader.models.NewsResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit retrofit = null;
    List<News> list = new ArrayList<>();
    Map<String, String> newsList;

    public Map<String, String> getNewsList() {
        return newsList;
    }

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
                    list = response.body().getNewsArticles();
                    newsList = getNewsArticals(list);

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


    public Map<String, String> getNewsArticals(List<News> newsList){

        Map<String, String> articals = new HashMap<>();
        for (News news : newsList){
            articals.put("source_id", news.getSource().getId());
            articals.put("source_name", news.getSource().getName());
            articals.put("author", news.getAuthor());
            articals.put("title", news.getTitle());
            articals.put("description", news.getDescription());
            articals.put("url", news.getUrl());
            articals.put("urlToImage", news.getUrlImage());
            articals.put("published_at", news.getPublishedAt());
            articals.put("content", news.getContent());
        }
        return articals;
    }
}
