package com.mahashakti.adapters;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.ceylonlabs.imageviewpopup.ImagePopup;
import com.like.LikeButton;
import com.mahashakti.R;
import com.mahashakti.response.GetThoughtsResponse.GetAllThoughtPayload;
import com.mahashakti.response.GetThoughtsResponse.PayLoad;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;


public class AdapterThought extends RecyclerView.Adapter<AdapterThought.MyHolder> {

    Context context;
    View view;
    Dialog dialog;

    ArrayList<PayLoad> getAllThoughtPayloadArrayList;

    public ImageClickListener imageClickListener;


//    public AdapterThought(Context context, ArrayList<GetAllThoughtPayload> getAllThoughtPayloads) {
//        this.context = context;
//        this.getAllThoughtPayloadArrayList = getAllThoughtPayloads;
//    }

    public AdapterThought(Context context, ArrayList<PayLoad> getAllThoughtPayloads) {
        this.context = context;
        this.getAllThoughtPayloadArrayList = getAllThoughtPayloads;
    }

    public interface ImageClickListener {

        void clickImage(View v, int pos, String attachmentPic);
    }

    public void setOnItemClickListener(ImageClickListener imageClickListener) {
        this.imageClickListener = imageClickListener;

    }


    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_thoughts, parent, false);


        return new MyHolder(view);

    }

    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {

        final PayLoad payload = getAllThoughtPayloadArrayList.get(position);

//        holder.txtPersonName.setText(payload.name);
        holder.txtChat.setText(payload.message);


//        if (payload.getLikecount() == 0) {
//            holder.txtLikeCounter.setText("No");
//        } else {
//            holder.txtLikeCounter.setText(String.valueOf(payload.getLikecount()));
//        }


//        Picasso.with(view.getContext())
//                .load("http://softwareering.com/mahashakti/public/api/api/" + payload.imagePath)   // .load("http://mahashaktiradiance.com/" + payload.imagePath)
//                .error(R.drawable.user)
//                .into(holder.imageThought);


        String apiImagePath = payload.imagePath;
        System.out.println("AdapterThought.onBindViewHolder" + apiImagePath);

        Picasso.with(view.getContext())
                .load("http://smartit.ventures/mahash/public/" + payload.imagePath)
                .error(R.drawable.user)
                .into(holder.imageThought);

        // before
//        http://softwareering.com/mahashakti/storage/app/


        // Shahzeb commented this code

//        Picasso.with(view.getContext())
//                .load("http://mahashaktiradiance.com/" + payload.getAttachment_pic())
//                .error(R.drawable.user)
//                .into(holder.imageEnlarge);


        // SHahzeb commented this code
//        String timeDate = payload.getUpdated_at();

//        String[] splited = timeDate.split("\\s+");


//        holder.tvDate.setText(splited[0]);
//        holder.tvTime.setText(splited[1]);


        final ImagePopup imagePopup = new ImagePopup(view.getContext());
        imagePopup.setWindowHeight(50); // Optional
        imagePopup.setWindowWidth(50); // Optional
        imagePopup.setBackgroundColor(Color.TRANSPARENT);
        imagePopup.setFullScreen(true);
        imagePopup.setHideCloseIcon(true);
        imagePopup.setImageOnClickClose(true);

        // shahzeb commented this

//        if (payload.getAttachment_pic() == null) {
//
//
//            imagePopup.initiatePopup(holder.imageEnlarge.getDrawable());
//        }

        // shahzeb commented this
//        imagePopup.initiatePopupWithPicasso("http://mahashaktiradiance.com/" + payload.getAttachment_pic());


        holder.imageEnlarge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // imageClickListener.clickImage(v,position,payload.getAttachment_pic());

                // shahzeb commented this
                // imagePopup.viewPopup();
//                showDialog(payload.getAttachment_pic());

            }
        });

    }


    private void showDialog(String attach) {
        // custom dialog
        dialog = new Dialog(view.getContext());
        dialog.setContentView(R.layout.dialog_image_enlarge);

        // set the custom dialog components - text, image and button
        ImageButton close = dialog.findViewById(R.id.btnClose);
        ImageView imageAttch = dialog.findViewById(R.id.imageAttach);

        if (attach == null) {

            imageAttch.setBackgroundResource(R.drawable.defaultimage);
        } else {

            Picasso.with(view.getContext())
                    .load("http://mahashaktiradiance.com/" + attach)
                    .error(R.drawable.user)
                    .into(imageAttch);
        }

        // Close Button
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });


        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        dialog.show();
    }


    @Override
    public int getItemCount() {

        System.out.println("AdapterThought.getItemCount - - -" + getAllThoughtPayloadArrayList.size());
        return getAllThoughtPayloadArrayList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        private CircleImageView imageThought, imageEnlarge;
        private TextView txtPersonName, txtChat, tvDate, tvTime, txtLikeCounter;
        private LikeButton button_favorite;

        public MyHolder(View itemView) {
            super(itemView);

            imageThought = itemView.findViewById(R.id.imageThought);
            imageEnlarge = itemView.findViewById(R.id.imageEnlarge);

            txtPersonName = itemView.findViewById(R.id.txtPersonName);
            txtChat = itemView.findViewById(R.id.txtChat);
            tvDate = itemView.findViewById(R.id.tvDate);
            tvTime = itemView.findViewById(R.id.tvTime);
            button_favorite = itemView.findViewById(R.id.button_favorite);
            txtLikeCounter = itemView.findViewById(R.id.txtLikeCounter);


        }
    }
}
