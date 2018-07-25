package mahashakti.mahashakti.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mahashakti.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import mahashakti.mahashakti.Models.GalleryModel;




public class GalleryRecyclerViewAdapter extends RecyclerView.Adapter<GalleryRecyclerViewAdapter.MyViewHolder> {

    private ArrayList<GalleryModel> galleryModelArrayList;
    private Context context;

    public GalleryRecyclerViewAdapter(ArrayList<GalleryModel> galleryModelArrayList, Context context) {
        this.galleryModelArrayList = galleryModelArrayList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gallery_row, parent, false);
        return  new GalleryRecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Picasso.with(context).load(galleryModelArrayList.get(position).
                getAndroid_image_url()).into(holder.gallerImageView);

    }

    @Override
    public int getItemCount() {
        return galleryModelArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        private ImageView gallerImageView;

        public MyViewHolder(View itemView) {
            super(itemView);

            gallerImageView = itemView.findViewById(R.id.gallerImageView);


        }
    }
}
