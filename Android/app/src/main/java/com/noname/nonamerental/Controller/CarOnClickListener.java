package com.noname.nonamerental.Controller;

import android.content.Intent;
import android.view.View;

import com.noname.nonamerental.Views.CarView;
import com.noname.nonamerental.Views.Fragments.CarListFragment;

public class CarOnClickListener implements View.OnClickListener {
    private int uid;
    public CarOnClickListener(int uid){
        this.uid = uid;
    }

    @Override
    public void onClick(View v) {
        int itemPosition = CarListFragment.getCarRecyclerView().getChildAdapterPosition(v) + 1;
        Intent intent = new Intent(v.getContext(), CarView.class);
        intent.putExtra("carId", itemPosition);
        intent.putExtra("uid", uid);
        v.getContext().startActivity(intent);

    }
}
