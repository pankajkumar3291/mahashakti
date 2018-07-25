package com.mahashakti.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.siyamed.shapeimageview.mask.PorterShapeImageView;
import com.hanks.htextview.rainbow.RainbowTextView;
import com.kaopiz.kprogresshud.KProgressHUD;
import com.mahashakti.Adapters.BlogDetailsAdapter;
import com.mahashakti.R;
import com.mahashakti.VerticalMarqueeTextView;
import com.mahashakti.httpNet.HttpModule;
import com.mahashakti.response.commentByBlog.CommentByBlog;
import com.mahashakti.response.commentByBlog.PayLoad;
import com.mahashakti.response.createBlog.Payload;
import com.mahashakti.response.createComment.CreateComment;
import com.sdsmdg.tastytoast.TastyToast;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BlogDetailsActivity extends AppCompatActivity implements View.OnClickListener {


    private Context context;

    private RecyclerView rvBlogDetails;
    private RecyclerView.LayoutManager mlayoutManager;
    private BlogDetailsAdapter blogDetailsAdapter;

    private TextView tvCommentsBlog, tvPrototypeBlog;
    private ImageView imgSendChatBlog;
    private VerticalMarqueeTextView tvDescriptionBlog;

    private EditText edChatBlog;

    private Payload listContets;


    private PorterShapeImageView imgBlog;
    private RainbowTextView tvTitleBlog;

    List<PayLoad> loadList = new ArrayList<>();



    KProgressHUD hud;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        hidingStatusBar();
        setContentView(R.layout.blog_details_activity);


        context = this;

        hud = new KProgressHUD(this);
        hud.dismiss();


        findingIdsHere();
        listenTheClickHere();


        if (getIntent() != null) {

            if (getIntent().hasExtra("BlogDetails") || getIntent().hasExtra("BlogComment")) {

                listContets = (Payload) getIntent().getSerializableExtra("BlogDetails");

                blogCommentAPICallingHere(listContets);

                tvTitleBlog.setText(listContets.title);
                tvDescriptionBlog.setText(listContets.description);
                Picasso.with(context).load("http://softwareering.com/mahashakti/storage/app/" + listContets.imagePath)
                        .into(imgBlog);
            }
        }


    }

    private void hidingStatusBar() {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


    }


    private void listenTheClickHere() {

        imgSendChatBlog.setOnClickListener(this);


    }

    private void blogCommentAPICallingHere(Payload commentBlog) {

//        pleaseWaitDilaog();

        HttpModule.provideRepositoryService().createBlogComment(commentBlog.id).enqueue(new Callback<CommentByBlog>() {
            @Override
            public void onResponse(Call<CommentByBlog> call, Response<CommentByBlog> response) {

                if (response.body() != null) {
                    if (response.body().isSuccess) {

//                        hud.dismiss();
                        initializeAdapterHere(response.body().payLoad);

//                        TastyToast.makeText(getApplicationContext(), "Success wala", TastyToast.LENGTH_SHORT, TastyToast.SUCCESS).show();

                    } else {
//                        TastyToast.makeText(getApplicationContext(), response.body().message, TastyToast.LENGTH_SHORT, TastyToast.SUCCESS).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<CommentByBlog> call, Throwable t) {
//                hud.dismiss();

                System.out.println("BlogDetailsActivity.onFailure " + t);

            }
        });


    }

    private void pleaseWaitDilaog() {

        hud = KProgressHUD.create(BlogDetailsActivity.this)
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setLabel("Please wait")
                .setCancellable(false)
                .setAnimationSpeed(2)
                .setDimAmount(0.5f)
                .show();




    }

    private void initializeAdapterHere(List<PayLoad> payLoad) {

        rvBlogDetails.setHasFixedSize(true);
        mlayoutManager = new LinearLayoutManager(this);
        rvBlogDetails.setLayoutManager(mlayoutManager);
        blogDetailsAdapter = new BlogDetailsAdapter(context, payLoad);
        rvBlogDetails.setAdapter(blogDetailsAdapter);
    }


    private void findingIdsHere() {

        rvBlogDetails = findViewById(R.id.rvBlogDetails);
        tvTitleBlog = findViewById(R.id.tvTitleBlog);

        tvDescriptionBlog = findViewById(R.id.tvDescriptionBlog);
        tvCommentsBlog = findViewById(R.id.tvCommentsBlog);

        imgBlog = findViewById(R.id.imgBlog);

        imgSendChatBlog = findViewById(R.id.imgSendChatBlog);
        edChatBlog = findViewById(R.id.edChatBlog);


    }

    @Override
    public void onClick(View view) {


        switch (view.getId()) {
            case R.id.imgSendChatBlog: {

                HttpModule.provideRepositoryService().createComment(listContets.id, listContets.userId, edChatBlog.getText().toString()).enqueue(new Callback<CreateComment>() {
                    @Override
                    public void onResponse(Call<CreateComment> call, Response<CreateComment> response) {


                        if (response.body() != null) {
                            if (response.body().isSuccess) {
                                TastyToast.makeText(getApplicationContext(), response.body().isMessage, TastyToast.LENGTH_SHORT, TastyToast.SUCCESS).show();

                                edChatBlog.setText("");

                            } else {
                                edChatBlog.setText("");
                                TastyToast.makeText(getApplicationContext(), "Ooops ! please write something", TastyToast.LENGTH_SHORT, TastyToast.SUCCESS).show();
                            }
                        }
                    }


                    @Override
                    public void onFailure(Call<CreateComment> call, Throwable t) {
                        edChatBlog.setText("");
                        System.out.println("BlogDetailsActivity.onFailure -" + t);

                    }
                });
                break;
            }
        }


    }
}
