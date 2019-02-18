package com.chamalwr.mtopicnewsreader;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.chamalwr.mtopicnewsreader.functions.ApiClient;
import com.chamalwr.mtopicnewsreader.functions.ArticalsAdapter;
import com.chamalwr.mtopicnewsreader.functions.JsonPlaceHolder;
import com.chamalwr.mtopicnewsreader.models.News;
import com.chamalwr.mtopicnewsreader.models.NewsResponse;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.util.List;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private RecyclerView.ViewHolder viewHolder;
    private LinearLayoutManager linearLayoutManager;
    private List<News> list;
    private Map<String, String> newsList;
    private ApiClient apiClient = new ApiClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbarMain);
        recyclerView = findViewById(R.id.newsRecView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName("About");
        Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .addDrawerItems(
                        item1
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        return true;
                    }
                })
                .build();

        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        Retrofit retrofit = getClient(okHttpClient);
    }


    public Retrofit getClient(OkHttpClient.Builder httpClient) {
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
                    newsList = apiClient.getNewsArticals(list);
                    ArticalsAdapter articalsAdapter = new ArticalsAdapter(MainActivity.this, newsList);
                    recyclerView.setAdapter(articalsAdapter);
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
