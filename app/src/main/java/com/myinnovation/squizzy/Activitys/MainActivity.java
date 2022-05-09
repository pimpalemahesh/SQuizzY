package com.myinnovation.squizzy.Activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.myinnovation.squizzy.Fragments.HomeFragment;
import com.myinnovation.squizzy.Fragments.ProfileFragment;
import com.myinnovation.squizzy.Fragments.RankFragment;
import com.myinnovation.squizzy.Fragments.MyActivityFragment;
import com.myinnovation.squizzy.Fragments.WalletFragment;
import com.myinnovation.squizzy.R;
import com.myinnovation.squizzy.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.toolbar.setVisibility(View.VISIBLE);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, new HomeFragment());
        binding.bottomNavbar.setSelectedItemId(R.id.home);
        transaction.commit();

        binding.bottomNavbar.setOnItemSelectedListener(item -> {
            FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
            switch (item.getItemId()){

                case R.id.profile:
                    transaction1.replace(R.id.fragment_container, new ProfileFragment());
                    binding.toolbar.setVisibility(View.GONE);
                    break;

                case R.id.rank:
                    transaction1.replace(R.id.fragment_container, new RankFragment());
                    binding.toolbar.setVisibility(View.GONE);
                    break;

                case R.id.wallet:
                    transaction1.replace(R.id.fragment_container, new WalletFragment());
                    binding.toolbar.setVisibility(View.GONE);
                    break;

                case R.id.myActivity:
                    transaction1.replace(R.id.fragment_container, new MyActivityFragment());
                    binding.toolbar.setVisibility(View.GONE);
                    break;

                default:
                    binding.toolbar.setVisibility(View.VISIBLE);
                    transaction1.replace(R.id.fragment_container, new HomeFragment());
                    break;
            }
            transaction1.commit();
            return true;
        });
    }
}