package mahashakti.mahashakti.Adapters;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import co.ceryle.fitgridview.FitGridAdapter;
import com.mahashakti.R;

/**
 * Created by dharamveer on 22/1/18.
 */

public class FitAdapter extends FitGridAdapter {

    private int[] drawables = {
            R.drawable.male, R.drawable.face_1, R.drawable.male, R.drawable.face_1,
            R.drawable.male, R.drawable.male, R.drawable.face_1, R.drawable.male,
            R.drawable.male, R.drawable.face_1, R.drawable.male, R.drawable.face_1};

    private Context context;


    public FitAdapter(Context context) {
        super(context,R.layout.grid_item);
        this.context = context;

    }

    @Override
    public void onBindView(final int position, View view) {
        ImageView iv = (ImageView) view.findViewById(R.id.grid_item_iv);
        iv.setImageResource(drawables[position]);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Position: " + position, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
