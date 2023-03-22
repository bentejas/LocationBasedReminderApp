package com.example.grocerybuddy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.grocerybuddy.databinding.ActivityUserMenuBinding;

public class UserMenu extends AppCompatActivity {

    ActivityUserMenuBinding binding;
    TextView welcomeMsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        replaceFragment(new MapFragment());
        binding = ActivityUserMenuBinding.inflate(getLayoutInflater());
        binding.bottomNavigationView.getMenu().findItem(R.id.map).setChecked(true);
        setContentView(binding.getRoot());

        //setContentView(R.layout.activity_user_menu);
        welcomeMsg = findViewById(R.id.welcomeMessage);

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()) {
                case R.id.discounts:
                    replaceFragment(new DiscountFragment());
                    break;
                case R.id.list:
                    replaceFragment(new ListFragment());
                    break;
                case R.id.map:
                    replaceFragment(new MapFragment());
                    break;
                case R.id.account:
                    replaceFragment(new AccountFragment());
                    break;
                case R.id.settings:
                    replaceFragment(new SettingsFragment());
                    break;


            }

            return true;
        });
    }
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}