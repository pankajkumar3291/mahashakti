package mahashakti.mahashakti.Dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Window;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.mahashakti.R;

/**
 * Created by dharamveer on 17/1/18.
 */

public class ImageEnlargeDialog extends Dialog {





    public ImageEnlargeDialog(@NonNull Context context,String imageAttach) {
        super(context);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCanceledOnTouchOutside(false);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_image_enlarge);
        ButterKnife.bind(this);




    }


}
