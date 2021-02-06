package com.thomas.moviestrailer.ui.movieDetail.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.thomas.moviestrailer.API.model.CrewItem;
import com.thomas.moviestrailer.R;

import java.util.List;

import static com.thomas.moviestrailer.constant.Constant.IMAGE_URL;

public class MovieCrewAdapter extends RecyclerView.Adapter<MovieCrewAdapter.ViewHolder> {

    private Context mContext;
    private List<CrewItem> list;

    public MovieCrewAdapter(Context mContext, List<CrewItem> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_cast, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        CrewItem items = list.get(position);
        holder.textView.setText(items.getName());
        holder.title.setText(items.getJob());

        Glide.with(mContext).load(IMAGE_URL + items.getProfilePath()).into(holder.imageView);
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
        void onItemClick(CrewItem CrewItem);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView, title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.cast_item_img);
            textView = itemView.findViewById(R.id.cast_item_name);
            title = itemView.findViewById(R.id.cast_item_title);

        }
    }
}
