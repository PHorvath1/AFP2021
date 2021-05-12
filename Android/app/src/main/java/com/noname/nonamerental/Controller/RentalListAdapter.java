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

import com.noname.nonamerental.Model.RentalResponse;
import com.noname.nonamerental.R;

import org.w3c.dom.Text;

import java.util.List;

public class RentalListAdapter extends RecyclerView.Adapter<RentalListAdapter.RentalListViewHolder>{
    private List<RentalResponse> data;
    private int itemPosition;
    private int uid;
    private Context context;
    private View.OnClickListener carOnClickListener;
    public RentalListAdapter(List<RentalResponse> data, Context context, int uid) {
        this.data = data;
        this.context = context;
        this.uid = uid;
        carOnClickListener = new CarOnClickListener(uid);
    }

    @NonNull
    @Override
    public RentalListAdapter.RentalListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.rental_card, parent, false);
        return new RentalListViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(final RentalListAdapter.RentalListViewHolder holder, int position) {
        itemPosition = position;
        String brand = String.valueOf(data.get(position).getBrand());
        String type = String.valueOf(data.get(position).getType());
        int image = context.getResources().getIdentifier(data.get(position).getImage(),"mipmap", context.getPackageName());
        String time = String.valueOf(data.get(position).getRental_time());
        String price = String.valueOf(data.get(position).getRental_price()) + "Ft";


        holder.carBrand.setText(brand);
        holder.carModel.setText(type);
        holder.carImage.setImageResource(image);
        holder.rentalTime.setText(time);
        holder.rentalPrice.setText(price);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class RentalListViewHolder extends RecyclerView.ViewHolder {
        ImageView carImage;
        TextView carBrand;
        TextView carModel;
        TextView rentalPrice;
        TextView rentalTime;

        public RentalListViewHolder(@NonNull View itemView) {
            super(itemView);
            carImage = (ImageView) itemView.findViewById(R.id.rented_car_image);
            carBrand = (TextView) itemView.findViewById(R.id.rented_car_brand);
            carModel = (TextView) itemView.findViewById(R.id.rented_car_model);
            rentalPrice = (TextView) itemView.findViewById(R.id.rental_price);
            rentalTime = (TextView) itemView.findViewById(R.id.rental_time);

        }
    }
}
