package com.myinnovation.squizzy.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myinnovation.squizzy.databinding.FragmentWalletBinding;

public class WalletFragment extends Fragment {

    FragmentWalletBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentWalletBinding.inflate(inflater);

        if(Integer.parseInt(binding.currentCoins.getText().toString()) >= 50000){
            binding.canWithdraw.setVisibility(View.VISIBLE);
        } else{
            binding.cannotWithdraw.setVisibility(View.INVISIBLE);
        }
        return binding.getRoot();
    }
}