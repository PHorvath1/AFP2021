package com.noname.nonamerental.Views.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;
import com.noname.nonamerental.Model.Car;
import com.noname.nonamerental.R;

public class HomeFragment extends Fragment  {

    CardView homeCard;
    CardView myProfileCard;
    CardView myRentalCard;
    CardView carListCard;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_home,container,false);

        //Data from MainActivity
        final int userId = getArguments().getInt("UserId");

        //Card declaration
        myRentalCard = rootView.findViewById(R.id.home_my_rentals_card);
        myProfileCard = rootView.findViewById(R.id.home_my_profile_card);
        carListCard = rootView.findViewById(R.id.home_car_list_card);


        //Click Listeners


        carListCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, new CarListFragment(), "NewFragmentTag").commit();
                }catch (Exception e){
                    System.out.println(e);
                }
            }
        });

        myRentalCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, new MyRentalsFragment(), "NewFragmentTag").commit();
                }catch (Exception e){
                    System.out.println(e);
                }
            }
        });

        myProfileCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, new MyProfileFragment(), "NewFragmentTag").commit();
                }catch (Exception e){
                    System.out.println(e);
                }
            }
        });

        return rootView;
    }

}
