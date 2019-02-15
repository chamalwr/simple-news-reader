package com.chamalwr.mtopicnewsreader;

import android.os.Bundle;
import android.view.View;

import com.chamalwr.mtopicnewsreader.functions.ApiClient;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName("About");
        SecondaryDrawerItem item2 = new SecondaryDrawerItem().withIdentifier(2).withName("Level 2");

        toolbar = findViewById(R.id.toolbarMain);
        Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .addDrawerItems(
                        item1,
                        new DividerDrawerItem()
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        return true;
                    }
                })
                .build();

        ApiClient apiClient = new ApiClient();
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        Retrofit retrofit = apiClient.getClient(okHttpClient);



    }

}
