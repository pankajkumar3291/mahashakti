package com.mahashakti.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mahashakti.R;
import com.sdsmdg.tastytoast.TastyToast;
import com.vanniktech.emoji.EmojiEditText;
import com.vanniktech.emoji.EmojiManager;
import com.vanniktech.emoji.EmojiPopup;
import com.vanniktech.emoji.one.EmojiOneProvider;

import java.io.IOException;

import butterknife.BindView;
import butterknife.OnClick;
import hani.momanii.supernova_emoji_library.Helper.EmojiconEditText;

public class ChatActivity extends AppCompatActivity implements View.OnClickListener {


//    @BindView(R.id.chatRecyclerview)
//    RecyclerView chatRecyclerview;

//    @BindView(R.id.edChat)
//    EmojiconEditText edChat;

//    @BindView(R.id.emoji_btn_chat)
//    ImageView emojiBtnChat;

//    @BindView(R.id.imageAttachmentChat)
//    ImageView imageAttachmentChat;

//    @BindView(R.id.relativeSendChatChat)
//    RelativeLayout relativeSendChatChat;

//    @BindView(R.id.imageBackarrowChat)
//    ImageView imageBackarrowChat;

//    @BindView(R.id.toolbar_title_chat)
//    TextView toolbarTitleChat;


//    @BindView(R.id.linearBottomChat)
//    LinearLayout linearBottomChat;

//    @BindView(R.id.toolbarChat)
//    Toolbar toolbarChat;

    private RecyclerView chatRecyclerview;
    private EditText edChat;
    private ImageView emojiBtnChat, imageAttachmentChat, imageBackarrowChat;
    private RelativeLayout relativeSendChatChat;
    private LinearLayout linearBottomChat;
    private TextView toolbarTitleChat;
    private Toolbar toolbarChat;

    private ViewGroup viewGroup;

    private Context context;
    private View v;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        findindIdsHere();
        clickListener();

        context = this;
//        final EmojiPopup emojiPopup = EmojiPopup.Builder.fromRootView(viewGroup).build((EmojiEditText) edChat);
//        emojiPopup.toggle(); // Toggles visibility of the Popup.
//        emojiPopup.dismiss(); // Dismisses the Popup.
//        emojiPopup.isShowing(); // Returns true when Popup is showing.

//        setSupportActionBar(toolbarChat);  Shahzeb commented this code


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

    }


//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//
//        getMenuInflater().inflate(R.menu.menu_search, menu);
//
//        MenuItem search = menu.findItem(R.id.search);
//        SearchView searchView = (SearchView) MenuItemCompat.getActionView(search);
//        search(searchView);
//        return true;
//    }
//
//    private void search(SearchView searchView) {
//
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//
//                if ( != null) mAdapter.getFilter().filter(newText);
//                return true;
//            }
//        });
//    }

//    @OnClick({R.id.imageBackarrowChat, R.id.emoji_btn_chat, R.id.imageAttachmentChat, R.id.relativeSendChatChat})
//    public void onViewClicked(View view) {
//        switch (view.getId()) {
//
//            case R.id.emoji_btn_chat:
//                break;
//            case R.id.imageAttachmentChat:
//                break;
//            case R.id.relativeSendChatChat:
//                break;
//
//            case R.id.imageBackarrowChat:
//
//                finish();
//                break;
//
//
//        }
//    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();


        finish();

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

                TastyToast.makeText(getApplicationContext(), "Sending The Thoughts", TastyToast.LENGTH_SHORT, TastyToast.SUCCESS).show();
                break;

            case R.id.imageBackarrowChat:
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
