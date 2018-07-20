package com.mahashakti.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.siyamed.shapeimageview.mask.PorterShapeImageView;
import com.mahashakti.R;
import com.mahashakti.VerticalMarqueeTextView;
import com.mahashakti.response.createParticularServiceInfo.PayLoad;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ParticularServiceInfoAdapter extends RecyclerView.Adapter<ParticularServiceInfoAdapter.ParticularServiceInfoViewHolder> {

    private Context context;
    private ParticularServiceInfoViewHolder infoViewHolder;

    ArrayList<PayLoad> createServicePayload = new ArrayList<>();


    public ParticularServiceInfoAdapter(Context context, ArrayList<PayLoad> createServicePayload) {


        this.context = context;
        this.createServicePayload = createServicePayload;

    }


    @NonNull
    @Override
    public ParticularServiceInfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_serviceinfoadapter, parent, false);
        infoViewHolder = new ParticularServiceInfoViewHolder(view);
        return infoViewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull ParticularServiceInfoViewHolder holder, int position) {


        final PayLoad finalPayload = createServicePayload.get(position);

        holder.tvHeader.setText(finalPayload.name);
        String plainText = Html.fromHtml(finalPayload.contents).toString();
        holder.tvContents.setText(plainText);
        Picasso.with(context).load("http://softwareering.com/mahashakti/storage/app/"+ finalPayload.imagePath).into(holder.imgBottom);

    }


    @Override
    public int getItemCount() {
        return createServicePayload.size();
    }


    public class ParticularServiceInfoViewHolder extends RecyclerView.ViewHolder {


        private TextView tvHeader;
        private VerticalMarqueeTextView tvContents;
//        private ImageView imgBottom;

        private PorterShapeImageView imgBottom;

        public ParticularServiceInfoViewHolder(View itemView) {

            super(itemView);

            tvHeader = itemView.findViewById(R.id.tvHeader);
            tvContents = itemView.findViewById(R.id.tvContents);
            imgBottom = itemView.findViewById(R.id.imgBottom);

        }


    }


}
