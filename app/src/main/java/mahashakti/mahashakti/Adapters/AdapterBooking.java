package mahashakti.mahashakti.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import mahashakti.mahashakti.Dialogs.BookingCancelDialog;
import mahashakti.mahashakti.Models.BookingModel;
import mahashakti.mahashakti.Models.ProgramModel;
import com.mahashakti.R;

/**
 * Created by dharamveer on 11/1/18.
 */

public class AdapterBooking extends RecyclerView.Adapter<AdapterBooking.MyHolder>{

    Context context;
    View view;
    ArrayList<BookingModel> bookingModelArrayList = new ArrayList<>();
    public AdapterBookingClickListener adapterBookingClickListener;


    public AdapterBooking(Context context, ArrayList<BookingModel> bookingModelArrayList) {
        this.context = context;
        this.bookingModelArrayList = bookingModelArrayList;
    }

    public interface AdapterBookingClickListener{

        void onCancelButtonClik(View view, int position);
        void onBookedButtonClicked(View view,int position);

    }
    public void setOnItemClickListener(AdapterBookingClickListener adapterBookingClickListener) {
        this.adapterBookingClickListener = adapterBookingClickListener;

    }


    @Override
    public AdapterBooking.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_booking, parent, false);

            return new AdapterBooking.MyHolder(view);
    }




    @Override
    public void onBindViewHolder(final AdapterBooking.MyHolder holder, final int position) {

        BookingModel bookingModel = bookingModelArrayList.get(position);


        holder.imageBooking.setImageResource(bookingModel.getImageProgramBooking());
        holder.txtFestivalNameBooking.setText(bookingModel.getFestivalNameBooking());
        holder.txtFestDescriptionBooking.setText(bookingModel.getFestDescriptionBooking());
        holder.txtDateBooking.setText(bookingModel.getDateBooking());
        holder.txtTimeBooking.setText(bookingModel.getTimeBooking());



        holder.btnCancelBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               adapterBookingClickListener.onCancelButtonClik(holder.btnCancelBooking,position);



            }
        });


        holder.btnBookingAc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                adapterBookingClickListener.onBookedButtonClicked(holder.btnBookingAc,position);

            }
        });
    }

    @Override
    public int getItemCount()
    {
        return bookingModelArrayList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        private CircleImageView imageBooking;
        private TextView txtFestivalNameBooking,txtFestDescriptionBooking,txtDateBooking,txtTimeBooking;
        private Button btnBookingAc,btnCancelBooking;


        public MyHolder(View itemView) {
            super(itemView);

            //Image view
            imageBooking = itemView.findViewById(R.id.imageBooking);

            //Text Views
            txtFestivalNameBooking = itemView.findViewById(R.id.txtFestivalNameBooking);
            txtFestDescriptionBooking = itemView.findViewById(R.id.txtFestDescriptionBooking);
            txtDateBooking = itemView.findViewById(R.id.txtDateBooking);
            txtTimeBooking = itemView.findViewById(R.id.txtTimeBooking);


            //Buttons
            btnBookingAc = itemView.findViewById(R.id.btnBookingAc);
            btnCancelBooking = itemView.findViewById(R.id.btnCancelBooking);


        }
    }
}
