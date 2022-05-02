package com.myinnovation.squizzy.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myinnovation.squizzy.Adapters.CategoryAdapter;
import com.myinnovation.squizzy.Models.CategoryModel;
import com.myinnovation.squizzy.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    ArrayList<CategoryModel> list;
    CategoryAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentHomeBinding binding = FragmentHomeBinding.inflate(inflater);
        this.list = new ArrayList<>();
        this.list.add(new CategoryModel("1", "Mathematics", "https://media.istockphoto.com/vectors/mathematics-vector-id1044168372?k=20&m=1044168372&s=612x612&w=0&h=H1O1Q0kaszNSHW620rqy42V52I5K4kSduPXI6O16-vA="));
        this.list.add(new CategoryModel("2", "Science", "https://pbs.twimg.com/media/ElzPbWzWMAE0mKo.jpg"));
        this.list.add(new CategoryModel("3", "History", "https://thumbs.dreamstime.com/b/history-etched-old-paper-scroll-feather-quill-compass-30890377.jpg"));
        this.list.add(new CategoryModel("4", "Language", "https://cdn2.psychologytoday.com/assets/styles/manual_crop_1_91_1_1528x800/public/field_blog_entry_teaser_image/2020-01/language.jpg?itok=ejUIGXol"));
        this.list.add(new CategoryModel("5", "Practice Test", "https://schools.aglasem.com/wp-content/uploads/2019/12/Mock-Tests-min.jpg"));
        this.list.add(new CategoryModel("5", "Puzzle", "https://www.spbh.org/wp-content/uploads/2017/07/07_24_18-9.png"));

        adapter = new CategoryAdapter(this.list, getContext());
        binding.categoryRclv.setLayoutManager(new GridLayoutManager(getContext(), 2));
        binding.categoryRclv.setHasFixedSize(true);
        binding.categoryRclv.setAdapter(adapter);
        return binding.getRoot();
    }
}