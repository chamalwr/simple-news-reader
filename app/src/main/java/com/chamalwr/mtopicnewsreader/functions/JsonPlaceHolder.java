package com.chamalwr.mtopicnewsreader.functions;

import com.chamalwr.mtopicnewsreader.models.NewsResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JsonPlaceHolder {

    @GET("everything?q=bitcoin&from=2019-01-11&sortBy=publishedAt&apiKey=5410be6b3ca74a4eb6bd525b4f71d54b")
    Call<List<NewsResponse>> getPots ();

}
