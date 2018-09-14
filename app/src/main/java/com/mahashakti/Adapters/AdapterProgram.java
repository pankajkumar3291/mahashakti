package com.mahashakti.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

import com.mahashakti.R;
import com.mahashakti.response.EventResponse.EventPayload;
import com.mahashakti.response.EventResponse.PayLoad;
import com.squareup.picasso.Picasso;

/**
 * Created by dharamveer on 11/1/18.
 */

public class AdapterProgram extends RecyclerView.Adapter<AdapterProgram.MyHolder> {

    Context context;
    View view;
    ArrayList<PayLoad> eventPayloadArrayList = new ArrayList<>();
    public AdapterProgramListener adapterProgramListener;
    public EventListenerActivity eventListenerActivity;


    public AdapterProgram(Context context, ArrayList<PayLoad> eventPayloadArrayList) {
        this.context = context;
        this.eventPayloadArrayList = eventPayloadArrayList;
    }


    public interface EventListenerActivity {

        void onRowClick(View image, String title, String des, String startDate, String endDate, int seats, int perprice, String location);
    }

    public interface AdapterProgramListener {

        void onChatButtonClik(View view, int position);

        void onBookingButtonClicked(View view, int position);


        void onProgramClick(View view, int position);

    }

    public void setOnRowClickListener(EventListenerActivity eventListenerActivity) {

        this.eventListenerActivity = eventListenerActivity;

    }

    public void setOnItemClickListener(AdapterProgramListener adapterBookingClickListener) {
        this.adapterProgramListener = adapterBookingClickListener;

    }


    @Override
    public AdapterProgram.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_program, parent, false);

        return new AdapterProgram.MyHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdapterProgram.MyHolder holder, final int position) {

        final PayLoad eventPayload = eventPayloadArrayList.get(position);

        String plainText = Html.fromHtml(eventPayload.description).toString();
        holder.txtFestivalName.setText(eventPayload.name);
        holder.txtFestDescription.setMovementMethod(new ScrollingMovementMethod());
        holder.txtFestDescription.setText(plainText);
        holder.txtDate.setText(eventPayload.startDate);
        holder.txtTime.setText(eventPayload.endDate);
        holder.txtAddress.setText(eventPayload.location);


        holder.txtTimeStart.setText(eventPayload.startTime);
        holder.txtTimeEnd.setText(eventPayload.endTime);


        Picasso.with(view.getContext())
                .load("http://softwareering.com/mahashakti/storage/app/" + eventPayload.imagePath)
                .into(holder.imageProgram);


        holder.btnChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                adapterProgramListener.onChatButtonClik(holder.btnChat, position);
            }
        });

        holder.btnBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                adapterProgramListener.onBookingButtonClicked(holder.btnBooking, position);
            }
        });


        holder.card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                adapterProgramListener.onProgramClick(holder.card_view, position);

            }
        });


        holder.eventRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // shahzeb commented this

//                eventListenerActivity.onRowClick(holder.imageProgram, eventPayload.name,
//                        eventPayload.description,
//                        eventPayload.startDate, eventPayload.endDate,
//                        eventPayload.totalSeat,
//                        Integer.parseInt(eventPayload.price), eventPayload.location);


//                eventListenerActivity.onRowClick(holder.imageProgram, eventPayload.getEventname(),
//                        eventPayload.getEventdesc(),
//                        eventPayload.getEventstartdate(), eventPayload.getEventenddate(),
//                        eventPayload.getEventseats(),
//                        eventPayload.getEventpriceperperson(), eventPayload.getEventlocation());


            }
        });


    }

    @Override
    public int getItemCount() {
        return eventPayloadArrayList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        private CircleImageView imageProgram;
        private TextView txtFestivalName, txtFestDescription, txtDate, txtTime, txtAddress, txtTimeStart, txtTimeEnd;
        private Button btnBooking, btnChat;
        private RelativeLayout eventRow;
        private CardView card_view;


        public MyHolder(View itemView) {

            super(itemView);

            eventRow = itemView.findViewById(R.id.eventRow);

            //Image view
            imageProgram = itemView.findViewById(R.id.imageProgram);

            //Text Views
            txtFestivalName = itemView.findViewById(R.id.txtFestivalName);
            txtFestDescription = itemView.findViewById(R.id.txtFestDescription);
            txtDate = itemView.findViewById(R.id.txtDate);
            txtTime = itemView.findViewById(R.id.txtTime);
            txtAddress = itemView.findViewById(R.id.txtAddress);


            //Buttons
            btnBooking = itemView.findViewById(R.id.btnBooking);
            btnChat = itemView.findViewById(R.id.btnChat);
            card_view = itemView.findViewById(R.id.card_view);

            txtTimeStart = itemView.findViewById(R.id.txtTimeStart);
            txtTimeEnd = itemView.findViewById(R.id.txtTimeEnd);


        }
    }
}
