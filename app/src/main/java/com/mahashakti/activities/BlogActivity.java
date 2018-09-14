package com.mahashakti.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.kaopiz.kprogresshud.KProgressHUD;
import com.mahashakti.Adapters.BlogAdapter;
import com.mahashakti.R;
import com.mahashakti.httpNet.HttpModule;
import com.mahashakti.interfaces.ItemClickListenerForBlogDetails;
import com.mahashakti.response.commentByBlog.PayLoad;
import com.mahashakti.response.createBlog.CreateBlog;
import com.mahashakti.response.createBlog.Payload;
import com.sdsmdg.tastytoast.TastyToast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BlogActivity extends AppCompatActivity implements ItemClickListenerForBlogDetails {


    private RecyclerView rvBlog;
    private RecyclerView.LayoutManager layoutManager;
    private BlogAdapter blogAdapter;
    private Context context;
    private ImageView backArrow;


    ArrayList<Payload> list = new ArrayList<>();

    KProgressHUD hud;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        hidingStatusBar();

        setContentView(R.layout.activity_blog);


        context = this;
        hud = new KProgressHUD(this);
        hud.dismiss();

        findingIdsHere();
        gettingBlogsDadaHere();


    }

    private void hidingStatusBar() {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }

    private void recyclerviewInitializationHere(List<Payload> payload) {

        rvBlog.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        rvBlog.setLayoutManager(layoutManager);
        blogAdapter = new BlogAdapter(context, payload);
        rvBlog.setAdapter(blogAdapter);

        blogAdapter.setClickListener(this);


    }

    private void gettingBlogsDadaHere() {


        pleaseWaitDilaog();


        HttpModule.provideRepositoryService().creatingBlog().enqueue(new Callback<CreateBlog>() {
            @Override
            public void onResponse(Call<CreateBlog> call, Response<CreateBlog> response) {


                if (response.body() != null) {

                    if (response.body().isSuccess) {

                        hud.dismiss();

//                        TastyToast.makeText(getApplicationContext(), response.body().message, TastyToast.LENGTH_SHORT, TastyToast.SUCCESS).show();
                        recyclerviewInitializationHere(response.body().payload);


                        list = (ArrayList<Payload>) response.body().payload;


                    } else {
                        TastyToast.makeText(getApplicationContext(), "SOMETHING WENT WRONG", TastyToast.LENGTH_SHORT, TastyToast.SUCCESS).show();

                    }
                }

            }

            @Override
            public void onFailure(Call<CreateBlog> call, Throwable t) {

                hud.dismiss();
                System.out.println("BlogActivity.onFailure " + t);

            }
        });

    }

    private void pleaseWaitDilaog() {


        hud = KProgressHUD.create(BlogActivity.this)
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setLabel("Please wait")
                .setCancellable(false)
                .setAnimationSpeed(2)
                .setDimAmount(0.5f)
                .show();
    }


    private void findingIdsHere() {

        rvBlog = findViewById(R.id.rvBlog);

        backArrow = findViewById(R.id.backArrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });

    }

    @Override
    public void onClick(View view, int position) {

        Intent intent = new Intent(BlogActivity.this, BlogDetailsActivity.class);
        intent.putExtra("BlogDetails", list.get(position));
        startActivity(intent);

    }
}
