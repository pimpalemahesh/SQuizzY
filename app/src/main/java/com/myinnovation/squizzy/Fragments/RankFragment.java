package com.myinnovation.squizzy.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myinnovation.squizzy.Adapters.RankAdapter;
import com.myinnovation.squizzy.Models.RankModel;
import com.myinnovation.squizzy.R;
import com.myinnovation.squizzy.databinding.FragmentRankBinding;

import java.util.ArrayList;


public class RankFragment extends Fragment {

    RankAdapter adapter;
    ArrayList<RankModel> List;
    FragmentRankBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRankBinding.inflate(inflater);
        List = new ArrayList<>();
        List.add(new RankModel("1", "#1", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRDrXGrFlQMYQBMWjjHoxIlaspf3nOgyUZjUQ&usqp=CAU", "Samrat Jadhav", "1950"));
        List.add(new RankModel("2", "#2", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQCOEZ-BAYoC4qitE9f6eOa60BFEcYxMZF1mShogq5rYhFjrxw4AtfwSOrmzO_elFowGtU&usqp=CAU", "Prathamesh Raje", "1920"));
        List.add(new RankModel("3", "#3", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTIdJUhjc4AJ2-WTv1JUiSFUwplxzFxoHZmZ-kDY7OzO0QEDorzaP0dYyWZicjDkaB0Mcs&usqp=CAU", "Raj Dalvi", "1900"));
        List.add(new RankModel("4", "#4", "https://assets.gqindia.com/photos/60488eb68b93aa38a4ca91fe/master/w_1600%2Cc_limit/Sunil-Mittal.jpg", "Yashraj Patil", "1870"));
        List.add(new RankModel("5", "#5", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSSTYL5N1K6wbT_vqQGUS7cBYb24VdwnWm_gj9N2NOgVOLWFTFP2hDFsSAMa_qGwg44z4s&usqp=CAU", "Harshal Dawkhare", "1820"));
        List.add(new RankModel("6", "#6", "https://assets.gqindia.com/photos/60488e9940ec5beed75572ce/master/w_1600%2Cc_limit/Shiv-Nadar.jpg", "Nikhil Naitum", "1810"));
        List.add(new RankModel("7", "#7", "https://specials-images.forbesimg.com/imageserve/5c76bcaaa7ea43100043c836/416x416.jpg?background=000000&cropX1=227&cropX2=2022&cropY1=22&cropY2=1817", "Mahesh Pimpale", "1750"));
        List.add(new RankModel("8", "#8", "https://assets.gqindia.com/photos/60488eb68b93aa38a4ca91fe/master/w_1600%2Cc_limit/Sunil-Mittal.jpg", "Saurabh Kadasang", "1710"));
        List.add(new RankModel("9", "#9", "https://assets.gqindia.com/photos/60488eb68b93aa38a4ca91fe/master/w_1600%2Cc_limit/Sunil-Mittal.jpg", "Suraj Dhanorkar", "1650"));
        List.add(new RankModel("10", "#10", "https://assets.gqindia.com/photos/60488eb68b93aa38a4ca91fe/master/w_1600%2Cc_limit/Sunil-Mittal.jpg", "Vivek Rathod", "1630"));

        adapter = new RankAdapter(List, getContext());
        binding.rankRclv.setAdapter(adapter);
        binding.rankRclv.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rankRclv.setHasFixedSize(true);
        return binding.getRoot();
    }
}