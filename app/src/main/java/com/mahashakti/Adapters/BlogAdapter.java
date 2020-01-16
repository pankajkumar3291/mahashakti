package com.mahashakti.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.mahashakti.R;
import com.mahashakti.interfaces.ItemClickListenerForBlogDetails;
import com.mahashakti.response.createBlog.Payload;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class BlogAdapter extends RecyclerView.Adapter<BlogAdapter.BlogViewHolder> {


    Context context;
    BlogViewHolder blogViewHolder;

    ArrayList<Payload> payloads = new ArrayList<>();


    private ItemClickListenerForBlogDetails listenerForBlogDetails;


    public BlogAdapter(Context context, ArrayList<Payload> payloadArrayList) {

        this.context = context;
        this.payloads = payloadArrayList;

    }

    public BlogAdapter(Context context, List<Payload> payload) {

        this.context = context;
        this.payloads = (ArrayList<Payload>) payload;


    }


    @NonNull
    @Override
    public BlogAdapter.BlogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_blog_adapter, parent, false);
        blogViewHolder = new BlogViewHolder(view);
        return blogViewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull BlogAdapter.BlogViewHolder holder, int position) {


        final Payload createBlogpayload = payloads.get(position);

        holder.tvTitle.setText(createBlogpayload.title);
        Picasso.with(context).load("http://smartit.ventures/mahash/public/" + createBlogpayload.imagePath).into(holder.blogImage);
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.swing_up_left);
//        Animation animation = AnimationUtils.loadAnimation(context, R.anim.swing_up_right);
        holder.cardView.startAnimation(animation);

//        http://mahashaktiradiance.com/storage/app/


    }


    @Override
    public int getItemCount() {
        return payloads.size();
    }


    public void setClickListener(ItemClickListenerForBlogDetails itemClickListener) {
        this.listenerForBlogDetails = itemClickListener;
    }


    public class BlogViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        private CircleImageView blogImage;
        private TextView tvTitle;
        private CardView cardView;


        public BlogViewHolder(View itemView) {
            super(itemView);


            blogImage = itemView.findViewById(R.id.blogImage);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            cardView = itemView.findViewById(R.id.cardView);

            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View view) {

            if (listenerForBlogDetails != null)
                listenerForBlogDetails.onClick(view, getAdapterPosition());
        }
    }
}
