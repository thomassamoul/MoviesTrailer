package com.thomas.moviestrailer.ui.favourite.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.thomas.moviestrailer.API.model.MovieDetail;
import com.thomas.moviestrailer.R;

import java.util.List;

import static com.thomas.moviestrailer.constant.Constant.IMAGE_URL;

public class FavouriteAdapter extends RecyclerView.Adapter<FavouriteAdapter.ViewHolder> {

    private List<MovieDetail> list;
    private Context context;

    public FavouriteAdapter(List<MovieDetail> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        MovieDetail items = list.get(position);

        holder.textView.setText(items.getTitle());
        Glide.with(context).load(IMAGE_URL + items.getPosterPath()).into(holder.imageView);

        holder.itemView.setOnClickListener(v -> onItemClickListener.onItemClick(items));
    }


    public void changeData(List<MovieDetail> notes) {
        this.list = notes;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (list == null && list.size() == 0) {
            return 0;
        }
        return list.size();
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(MovieDetail FavouriteMovies);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.movie_item_title);
            imageView = itemView.findViewById(R.id.movie_item_img);
        }
    }
}
