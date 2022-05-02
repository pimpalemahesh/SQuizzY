package com.myinnovation.squizzy.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.myinnovation.squizzy.Models.CategoryModel;
import com.myinnovation.squizzy.R;
import com.myinnovation.squizzy.databinding.SingleItemCategoryLayoutBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    ArrayList<CategoryModel> list;
    Context context;

    public CategoryAdapter(ArrayList<CategoryModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CategoryViewHolder(LayoutInflater.from(context).inflate(R.layout.single_item_category_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        CategoryModel model = list.get(position);
        holder.binding.itemName.setText(model.getCategory_name());
        Picasso.get()
                .load(model.getCategory_image())
                .placeholder(R.drawable.ic_question)
                .into(holder.binding.itemImage);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder{
        SingleItemCategoryLayoutBinding binding;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = SingleItemCategoryLayoutBinding.bind(itemView);
        }
    }
}
