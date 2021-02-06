package com.thomas.moviestrailer.ui.movies.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.thomas.moviestrailer.API.model.MoviesItem;
import com.thomas.moviestrailer.R;

import static com.thomas.moviestrailer.constant.Constant.IMAGE_URL;

public class MoviesAdapter extends PagedListAdapter<MoviesItem, MoviesAdapter.ViewHolder> {

    private Context mContext;

    public MoviesAdapter(Context context) {
        super(MoviesItem.CALLBACK);
        this.mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_movie, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        MoviesItem items = getItem(position);
        holder.textView.setText(items.getTitle());
        Glide.with(mContext).load(IMAGE_URL + items.getPosterPath()).into(holder.imageView);

        holder.itemView.setOnClickListener(v -> onItemClickListener.onItemClick(items));
    }

    OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(MoviesItem MoviesItem);
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
