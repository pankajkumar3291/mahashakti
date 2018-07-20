package com.mahashakti.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mahashakti.R;
import com.mahashakti.response.commentByBlog.PayLoad;

import java.util.ArrayList;
import java.util.List;

public class BlogDetailsAdapter extends RecyclerView.Adapter<BlogDetailsAdapter.BlogDetailsViewHolder> {


    private Context context;
    private BlogDetailsViewHolder blogDetailsViewHolder;


    ArrayList<PayLoad> payLoadArrayList = new ArrayList<>();

    public BlogDetailsAdapter(Context context, List<PayLoad> payLoad) {

        this.context = context;
        this.payLoadArrayList = (ArrayList<PayLoad>) payLoad;


    }


    @NonNull
    @Override
    public BlogDetailsAdapter.BlogDetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.blog_comment_details, parent, false);
        blogDetailsViewHolder = new BlogDetailsViewHolder(view);
        return blogDetailsViewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull BlogDetailsAdapter.BlogDetailsViewHolder holder, int position) {

        final PayLoad load = payLoadArrayList.get(position);

        holder.blogName.setText(load.message);
        holder.blogCreatername.setText(load.userName);


    }


    @Override
    public int getItemCount() {
        return payLoadArrayList.size();
    }


    public class BlogDetailsViewHolder extends RecyclerView.ViewHolder {

        private TextView blogName, blogCreatername;


        public BlogDetailsViewHolder(View itemView) {
            super(itemView);

            blogName = itemView.findViewById(R.id.blogName);
            blogCreatername = itemView.findViewById(R.id.blogCreatername);


        }
    }
}
