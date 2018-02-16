package com.mahashakti.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.mahashakti.fragments.FragmentUserInfo;
import com.mahashakti.fragments.FragmentPayment;
import com.mahashakti.fragments.FragmentSuccess;
import com.mahashakti.R;


/**
 * Created by dharamveer on 12/1/18.
 */

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public SimpleFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    // This determines the fragment for each tab
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new FragmentUserInfo();
        } else if (position == 1){
            return new FragmentPayment();
        } else{
            return new FragmentSuccess();
        }
    }

    // This determines the number of tabs
    @Override
    public int getCount() {
        return 3;
    }

    // This determines the title for each tab
    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        switch (position) {
            case 0:
                return mContext.getString(R.string.userinfo);
            case 1:
                return mContext.getString(R.string.payment);
            case 2:
                return mContext.getString(R.string.success);
            default:
                return null;
        }
    }

}
