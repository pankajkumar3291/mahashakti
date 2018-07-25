package mahashakti.mahashakti.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import am.appwise.components.ni.NoInternetDialog;
import com.mahashakti.R;

/**
 * Created by dharamveer on 12/1/18.
 */

public class FragmentUserInfo extends Fragment {



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.frag_userinfo_layout, container, false);


        NoInternetDialog noInternetDialog = new NoInternetDialog.Builder(getContext()).build();

        return rootView;



    }
}
