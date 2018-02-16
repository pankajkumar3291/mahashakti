package com.mahashakti.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mahashakti.Models.NotificationModel;
import com.mahashakti.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by dharamveer on 12/1/18.
 */

public class AdapterNotifications extends RecyclerView.Adapter<AdapterNotifications.MyHolder> {

    Context context;
    View view;
    ArrayList<NotificationModel> notificationModelArrayList = new ArrayList<>();

    public AdapterNotifications(Context context, ArrayList<NotificationModel> notificationModelArrayList) {
        this.context = context;
        this.notificationModelArrayList = notificationModelArrayList;
    }


    @Override
    public AdapterNotifications.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_notifications, parent, false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterNotifications.MyHolder holder, int position) {

        NotificationModel notificationModel = notificationModelArrayList.get(position);


        holder.imageNotification.setImageResource(notificationModel.getImageNotification());

        holder.txtMessageName.setText(notificationModel.getNotificationName());
        holder.txtMessageDesc.setText(notificationModel.getNotificationDesc());


    }

    @Override
    public int getItemCount() {
        return notificationModelArrayList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {


        private CircleImageView imageNotification;
        private TextView txtMessageName,txtMessageDesc;

        public MyHolder(View itemView) {
            super(itemView);


            //Cirlce image view
            imageNotification = itemView.findViewById(R.id.imageNotification);

            //Text view
            txtMessageName = itemView.findViewById(R.id.txtMessageName);
            txtMessageDesc = itemView.findViewById(R.id.txtMessageDesc);
        }
    }
}
