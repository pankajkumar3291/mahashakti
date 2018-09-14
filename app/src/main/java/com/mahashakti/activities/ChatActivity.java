package com.mahashakti.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.kaopiz.kprogresshud.KProgressHUD;
import com.mahashakti.Adapters.ChatAdapter;
import com.mahashakti.AppConstants;
import com.mahashakti.R;
import com.mahashakti.di.modules.SharedPrefsHelper;
import com.mahashakti.httpNet.HttpModule;
import com.mahashakti.response.displayingAdminApproveChat.DisplayingAdminChat;
import com.mahashakti.response.displayingUserChat.Payload;
import com.sdsmdg.tastytoast.TastyToast;
import com.vanniktech.emoji.EmojiEditText;
import com.vanniktech.emoji.EmojiPopup;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ChatActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView chatRecyclerview;
    private RecyclerView.LayoutManager mlayoutManager;
    private ChatAdapter chatAdapter;

    private EditText edChat;
    private ImageView emojiBtnChat, imageAttachmentChat, imageBackarrowChat;
    private RelativeLayout relativeSendChatChat, imageBackaroow;
    private LinearLayout linearBottomChat;
    private TextView toolbarTitleChat;
    private Toolbar toolbarChat;

    private ViewGroup viewGroup;

    private Context context;
    private View v;

    KProgressHUD hud;


    ArrayList<com.mahashakti.response.displayingAdminApproveChat.Payload> listDisplayingMessage = new ArrayList<>();
    SharedPrefsHelper sharedPrefsHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);


        if (getIntent() != null) {

            if (getIntent().hasExtra("DisplayingUserChat")) {
                listDisplayingMessage = (ArrayList<com.mahashakti.response.displayingAdminApproveChat.Payload>) getIntent().getSerializableExtra("DisplayingUserChat");
            }
        }


        findindIdsHere();
        clickListener();
        initializeAdapterHere();

        context = this;
        hud = new KProgressHUD(this);
        hud.dismiss();
    }

    private void initializeAdapterHere() {


        chatRecyclerview.setHasFixedSize(true);
        mlayoutManager = new LinearLayoutManager(this);
        chatRecyclerview.setLayoutManager(mlayoutManager);
        chatAdapter = new ChatAdapter(context, listDisplayingMessage);
        chatRecyclerview.setAdapter(chatAdapter);
//        chatAdapter.notifyDataSetChanged();


    }

    private void clickListener() {

        chatRecyclerview.setOnClickListener(this);
        edChat.setOnClickListener(this);
        emojiBtnChat.setOnClickListener(this);
        imageAttachmentChat.setOnClickListener(this);
        relativeSendChatChat.setOnClickListener(this);
        imageBackarrowChat.setOnClickListener(this);
        linearBottomChat.setOnClickListener(this);
        toolbarTitleChat.setOnClickListener(this);
        toolbarChat.setOnClickListener(this);
        imageBackaroow.setOnClickListener(this);

    }

    private void findindIdsHere() {
        chatRecyclerview = findViewById(R.id.chatRecyclerview);
        edChat = findViewById(R.id.edChat);
        emojiBtnChat = findViewById(R.id.emoji_btn_chat);
        imageAttachmentChat = findViewById(R.id.imageAttachmentChat);
        relativeSendChatChat = findViewById(R.id.relativeSendChatChat);
        imageBackarrowChat = findViewById(R.id.imageBackarrowChat);
        linearBottomChat = findViewById(R.id.linearBottomChat);
        toolbarTitleChat = findViewById(R.id.toolbar_title_chat);
        toolbarChat = findViewById(R.id.toolbarChat);
        viewGroup = findViewById(R.id.main_activity_root_view);
        imageBackaroow = findViewById(R.id.imageBackaroow);

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        hud.dismiss();
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.emoji_btn_chat:

                // Check if no view has focus:
//                v = this.getCurrentFocus();
//
//               if (v != null)
//                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

                System.out.println("ChatActivity.onClick Shahzeb Test ");
                final EmojiPopup emojiPopup = EmojiPopup.Builder.fromRootView(viewGroup).build((EmojiEditText) edChat);
                emojiPopup.toggle(); // Toggles visibility of the Popup.
                emojiPopup.dismiss(); // Dismisses the Popup.
                emojiPopup.isShowing(); // Returns true when Popup is showing.
                break;

            case R.id.imageAttachmentChat:

                imageAttachmentFromGallery();
                break;
            case R.id.relativeSendChatChat:


                HttpModule.provideRepositoryService().displayAdminChatMessages(Integer.valueOf(DashboardActivity.userid), edChat.getText().toString()).enqueue(new Callback<DisplayingAdminChat>() {
                    @Override
                    public void onResponse(Call<DisplayingAdminChat> call, Response<DisplayingAdminChat> response) {

                        if (response.body() != null) {
                            if (response.body().isSuccess) {


                                TastyToast.makeText(getApplicationContext(), response.body().message, TastyToast.LENGTH_SHORT, TastyToast.SUCCESS).show();

                                edChat.setText("");
                                listDisplayingMessage.add(response.body().payload);

                                chatAdapter.notifyDataSetChanged();


                            } else {
                                TastyToast.makeText(getApplicationContext(), "Ooops ! You are missing something", TastyToast.LENGTH_SHORT, TastyToast.SUCCESS).show();
                                edChat.setText("");
                            }
                        }

                    }

                    @Override
                    public void onFailure(Call<DisplayingAdminChat> call, Throwable t) {


                        System.out.println("ChatActivity.onFailure " + t);

                    }
                });


//                TastyToast.makeText(getApplicationContext(), "Sending The Thoughts", TastyToast.LENGTH_SHORT, TastyToast.SUCCESS).show();
                break;

            case R.id.imageBackaroow:
                finish();
                break;
        }
    }

    private void imageAttachmentFromGallery() {

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);//
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1);

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {

            if (resultCode == Activity.RESULT_OK) {

                if (data != null) {
                    try {

                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(getApplication().getContentResolver(), data.getData());

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            } else if (resultCode == Activity.RESULT_CANCELED) {

                Toast.makeText(getApplicationContext(), "Cancelled", Toast.LENGTH_SHORT).show();
            }
        }
    }


}
