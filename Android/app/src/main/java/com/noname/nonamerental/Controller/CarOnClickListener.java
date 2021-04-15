package com.noname.nonamerental.Controller;

import android.content.Intent;
import android.view.View;

import com.noname.nonamerental.Model.CarResponse;
import com.noname.nonamerental.Views.CarList;
import com.noname.nonamerental.Views.CarView;
import com.noname.nonamerental.Views.Fragments.CarListFragment;

public class CarOnClickListener implements View.OnClickListener {
    @Override
    public void onClick(View v) {
        int itemPosition = CarListFragment.getCarRecyclerView().getChildLayoutPosition(v);
        CarResponse item = CarListFragment.getCar(itemPosition);
        Intent intent = new Intent(v.getContext(), CarView.class);
        v.getContext().startActivity(intent);

    }
}
