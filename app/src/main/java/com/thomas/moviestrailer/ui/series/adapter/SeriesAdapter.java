package com.thomas.moviestrailer.ui.series.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.thomas.moviestrailer.API.model.SeriesItem;
import com.thomas.moviestrailer.R;

import java.util.List;

import static com.thomas.moviestrailer.constant.Constant.IMAGE_URL;

public class SeriesAdapter extends RecyclerView.Adapter<SeriesAdapter.ViewHolder> {

    private Context mContext;
    private List<SeriesItem> list;

    public SeriesAdapter(Context mContext, List<SeriesItem> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_movie, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        SeriesItem items = list.get(position);
        holder.textView.setText(items.getName());
        Glide.with(mContext).load(IMAGE_URL + items.getPosterPath()).into(holder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(items);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (list == null && list.size() == 0) {
            return 0;
        }
        return list.size();
    }

    OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(SeriesItem SeriesItem);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.movie_item_img);
            textView = itemView.findViewById(R.id.movie_item_title);

        }
    }
}
