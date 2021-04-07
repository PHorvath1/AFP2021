package com.noname.nonamerental.Controller;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.noname.nonamerental.Model.CarResponse;
import com.noname.nonamerental.R;

import java.io.File;
import java.util.List;

public class CarListAdapter extends RecyclerView.Adapter<CarListAdapter.CarListViewHolder> {
    private List<CarResponse> data;
    public CarListAdapter(List<CarResponse> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public CarListAdapter.CarListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.car_card, parent, false);
        return new CarListViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(final CarListAdapter.CarListViewHolder holder, int position) {
        String brand = data.get(position).getBrand();
        String type = data.get(position).getType();



        holder.carBrand.setText(brand);
        holder.carModel.setText(type);
        holder.carImage.setImageDrawable(holder.carImage.getContext().getDrawable(R.drawable.ic_launcher_foreground));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class CarListViewHolder extends RecyclerView.ViewHolder {
        ImageView carImage;
        TextView carBrand;
        TextView carModel;

        public CarListViewHolder(@NonNull View itemView) {
            super(itemView);
            carImage = (ImageView) itemView.findViewById(R.id.car_image);
            carBrand = (TextView) itemView.findViewById(R.id.car_brand);
            carModel = (TextView) itemView.findViewById(R.id.car_model);
        }
    }
}

