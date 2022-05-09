package com.myinnovation.squizzy.Adapters;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.myinnovation.squizzy.Models.RankModel;
import com.myinnovation.squizzy.R;
import com.myinnovation.squizzy.databinding.SingleRankLayoutBinding;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.ArrayList;

public class RankAdapter extends RecyclerView.Adapter<RankAdapter.RankViewHolder> {

    ArrayList<RankModel> List;
    Context context;

    public RankAdapter(ArrayList<RankModel> list, Context context) {
        List = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RankViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RankViewHolder(LayoutInflater.from(context).inflate(R.layout.single_rank_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RankViewHolder holder, int position) {
        RankModel model = List.get(position);
        holder.binding.rank.setText(model.getUser_rank());
        holder.binding.userName.setText(model.getUser_name());
        Picasso.get()
                .load(model.getUser_image())
                .into(holder.binding.userImage);
        holder.binding.userScore.setText(model.getUser_score());
    }

    @Override
    public int getItemCount() {
        return List.size();
    }

    public class RankViewHolder extends RecyclerView.ViewHolder{

        SingleRankLayoutBinding binding;
        public RankViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = SingleRankLayoutBinding.bind(itemView);
        }
    }
}
