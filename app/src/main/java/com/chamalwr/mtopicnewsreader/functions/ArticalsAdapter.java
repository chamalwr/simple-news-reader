package com.chamalwr.mtopicnewsreader.functions;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chamalwr.mtopicnewsreader.R;
import com.squareup.picasso.Picasso;

import java.util.Map;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ArticalsAdapter extends RecyclerView.Adapter<ArticalsAdapter.ViewHolder> {


    private Context context;
    private Map<String, String> newsList;

    public ArticalsAdapter(Context context, Map<String, String> newsList){
        this.context = context;
        this.newsList = newsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.rv_articals, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ImageView titleImage = holder.newsTitleImage;
        TextView title = holder.txt_title;
        TextView author = holder.txt_author;
        TextView description = holder.txt_description;

        Picasso.get().load(newsList.get("urlToImage")).into(titleImage);
        title.setText(newsList.get("title"));
        author.setText(newsList.get("author"));
        description.setText(newsList.get("description"));
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView newsTitleImage;
        TextView txt_title, txt_author, txt_description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            newsTitleImage = itemView.findViewById(R.id.imgTitle);
            txt_title = itemView.findViewById(R.id.txtTitle);
            txt_author = itemView.findViewById(R.id.txtAuthor);
            txt_description = itemView.findViewById(R.id.txtDescription);


        }
    }


}

