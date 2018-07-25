package mahashakti.mahashakti.Activities;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

import am.appwise.components.ni.NoInternetDialog;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hani.momanii.supernova_emoji_library.Helper.EmojiconEditText;
import com.mahashakti.R;

public class ChatActivity extends AppCompatActivity {


    @BindView(R.id.chatRecyclerview)
    RecyclerView chatRecyclerview;
    @BindView(R.id.edChat)
    EmojiconEditText edChat;
    @BindView(R.id.emoji_btn_chat)
    ImageView emojiBtnChat;
    @BindView(R.id.imageAttachmentChat)
    ImageView imageAttachmentChat;
    @BindView(R.id.relativeSendChatChat)
    RelativeLayout relativeSendChatChat;

    @BindView(R.id.imageBackarrowChat)
    ImageButton imageBackarrowChat;
    @BindView(R.id.toolbar_title_chat)
    TextView toolbarTitleChat;
  /*  @BindView(R.id.imageSearch)
    ImageButton imageSearch;*/


    @BindView(R.id.linearBottomChat)
    LinearLayout linearBottomChat;
    @BindView(R.id.toolbarChat)
    Toolbar toolbarChat;
  /*  @BindView(R.id.searchview)
    MaterialSearchView searchview;*/

    private Context context;
    NoInternetDialog noInternetDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        ButterKnife.bind(this);

        context = this;

         noInternetDialog = new NoInternetDialog.Builder(context).build();

        setSupportActionBar(toolbarChat);
        getSupportActionBar().setDisplayShowTitleEnabled(false);



    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        noInternetDialog.onDestroy();
    }






/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_search, menu);

        MenuItem search = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(search);
        search(searchView);
        return true;
    }

    private void search(SearchView searchView) {

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                if ( != null) mAdapter.getFilter().filter(newText);
                return true;
            }
        });
    }*/

    @OnClick({R.id.imageBackarrowChat, R.id.emoji_btn_chat, R.id.imageAttachmentChat, R.id.relativeSendChatChat})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.emoji_btn_chat:
                break;
            case R.id.imageAttachmentChat:
                break;
            case R.id.relativeSendChatChat:
                break;
            case R.id.imageBackarrowChat:

                System.out.println("ChatActivity.onViewClicked  backarrow ");
                finish();
                overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);
                break;


        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

      /*  if (searchview.isSearchOpen()) {
            searchview.closeSearch();
        } else {
            super.onBackPressed();
        }
*/
        overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);

    }


}
