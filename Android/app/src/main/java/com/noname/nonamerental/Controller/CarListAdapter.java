package com.noname.nonamerental.Controller;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.noname.nonamerental.Model.CarResponse;
import com.noname.nonamerental.R;

import java.util.List;

public class CarListAdapter extends RecyclerView.Adapter<CarListAdapter.CarListViewHolder> {
    private List<CarResponse> data;
    private int itemPosition;
    private Context context;
    private final View.OnClickListener carOnClickListener = new CarOnClickListener();
    public CarListAdapter(List<CarResponse> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public CarListAdapter.CarListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.car_card, parent, false);
        view.setOnClickListener(carOnClickListener);
        return new CarListViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(final CarListAdapter.CarListViewHolder holder, int position) {
        itemPosition = position;
        String brand = data.get(position).getBrand();
        String type = data.get(position).getType();
        int image = context.getResources().getIdentifier(data.get(position).getImage(),"mipmap", context.getPackageName());
        
        holder.carBrand.setText(brand);
        holder.carModel.setText(type);
        holder.carImage.setImageResource(image);
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

