package com.chamalwr.mtopicnewsreader.functions;

import com.chamalwr.mtopicnewsreader.models.News;
import com.chamalwr.mtopicnewsreader.models.NewsResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JsonPlaceHolder {

    @GET("top-headlines?country=us&category=business&apiKey=YOUR API KEY IN HERE")
    Call<NewsResponse> getPots ();

    @GET("everything")
    Call<NewsResponse> getSearchResults(@Query("q") String query,
                                        @Query("sortBy") String sortBy,
                                        @Query("language") String language,
                                        @Query("apiKey") String apiKey);

    @GET("top-headlines")
    Call<NewsResponse> getHeadlines(@Query("bbc") String sources,
                                    @Query("5410be6b3ca74a4eb6bd525b4f71d54b") String apiKey);

}
