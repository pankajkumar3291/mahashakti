package com.mahashakti.Adapters;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.siyamed.shapeimageview.mask.PorterImageView;
import com.mahashakti.R;
import com.mahashakti.activities.ServiceActivity;
import com.mahashakti.interfaces.ItemClickListener;
import com.mahashakti.response.createServices.PayLoad;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.ServiceViewHolder> {


    ArrayList<PayLoad> payLoadsServiceAdapter = new ArrayList<>();
    private Context context;

    private ItemClickListener clickListener;


    public ServiceAdapter(Context context, ArrayList<PayLoad> eventSuccessArrayList) {
        this.context = context;
        this.payLoadsServiceAdapter = eventSuccessArrayList;
    }

    @NonNull
    @Override
    public ServiceAdapter.ServiceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_service, parent, false);

        ServiceViewHolder serviceViewHolder = new ServiceViewHolder(view);
        return serviceViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ServiceAdapter.ServiceViewHolder holder, int position) {

        final PayLoad payLoad = payLoadsServiceAdapter.get(position);
        holder.first_texview.setText(payLoad.name);
//        Animation myAnimation = AnimationUtils.loadAnimation(context, R.anim.tv_animation);
//        holder.first_texview.startAnimation(myAnimation);


        Picasso.with(context).load("http://smartit.ventures/mahash/public/" + payLoad.icon).resize(400, 300).into(holder.first_ImageView);
        Integer serviceId = payLoad.id;

    }

    @Override
    public int getItemCount() {
        return payLoadsServiceAdapter.size();
    }


    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }


    public class ServiceViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView second_ImageView, third_ImageView;
        private TextView first_texview, second_texview, third_texview;
        //        private PorterImageView first_ImageView;
        private ImageView first_ImageView;


        public ServiceViewHolder(View itemView) {
            super(itemView);

            first_ImageView = itemView.findViewById(R.id.first_ImageView);
            first_texview = itemView.findViewById(R.id.first_texview);

            itemView.setOnClickListener(this);


        }


        @Override
        public void onClick(View view) {
            if (clickListener != null) clickListener.onClick(view, getAdapterPosition());
        }

    }
}
