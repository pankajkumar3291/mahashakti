package mahashakti.mahashakti.Activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import am.appwise.components.ni.NoInternetDialog;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import co.ceryle.fitgridview.FitGridView;
import mahashakti.mahashakti.Adapters.FitAdapter;
import mahashakti.mahashakti.Adapters.GalleryRecyclerViewAdapter;
import mahashakti.mahashakti.Models.GalleryModel;
import com.mahashakti.R;

public class GalleryActivity extends AppCompatActivity {


   /* @BindView(R.id.recyclerviewGallery)
    RecyclerView recyclerviewGallery;*/

    public Toolbar topToolBar;
    @BindView(R.id.imageBackaroow)
    RelativeLayout imageBackaroow;


  /*  @BindView(R.id.fitgridView)
    FitGridView fitgridView;*/



    private TextView toolbar_title;

    private final String android_image_urls[] = {
            "http://api.learn2crack.com/android/images/donut.png",
            "http://api.learn2crack.com/android/images/eclair.png",
            "http://api.learn2crack.com/android/images/froyo.png",
            "http://api.learn2crack.com/android/images/ginger.png",
            "http://api.learn2crack.com/android/images/honey.png",
            "http://api.learn2crack.com/android/images/icecream.png",
            "http://api.learn2crack.com/android/images/jellybean.png",
            "http://api.learn2crack.com/android/images/kitkat.png",
            "http://api.learn2crack.com/android/images/lollipop.png",
            "http://api.learn2crack.com/android/images/marshmallow.png",
            "http://api.learn2crack.com/android/images/icecream.png",
            "http://api.learn2crack.com/android/images/jellybean.png",
            "http://api.learn2crack.com/android/images/kitkat.png",
            "http://api.learn2crack.com/android/images/lollipop.png",
            "http://api.learn2crack.com/android/images/marshmallow.png"
    };


    private Context context;
    NoInternetDialog noInternetDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        ButterKnife.bind(this);

        topToolBar = findViewById(R.id.toolbar);
        toolbar_title = findViewById(R.id.toolbar_title);

        context = this;

        noInternetDialog = new NoInternetDialog.Builder(context).build();


        setSupportActionBar(topToolBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        toolbar_title.setText("GALLERY");

/*

        fitgridView.setFitGridAdapter(new FitAdapter(context));*/

        /*   recyclerviewGallery.setHasFixedSize(true);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(GalleryActivity.this, 3);
        recyclerviewGallery.setLayoutManager(mLayoutManager);
        ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(GalleryActivity.this, R.dimen.item_offset);
        recyclerviewGallery.addItemDecoration(itemDecoration);

        ArrayList<GalleryModel> galleryModels = prepareData();
        GalleryRecyclerViewAdapter adapter = new GalleryRecyclerViewAdapter(galleryModels, getApplicationContext());
        recyclerviewGallery.setAdapter(adapter);*/


    }




    private ArrayList<GalleryModel> prepareData() {

        ArrayList<GalleryModel> galleryModelArrayList = new ArrayList<>();
        for (int i = 0; i < android_image_urls.length; i++) {
            GalleryModel galleryModel = new GalleryModel();
            galleryModel.setAndroid_image_url(android_image_urls[i]);
            galleryModelArrayList.add(galleryModel);
        }
        return galleryModelArrayList;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        noInternetDialog.onDestroy();
    }

    @OnClick(R.id.imageBackaroow)
    public void onViewClicked() {

        finish();
        overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();

        overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);

    }


}
