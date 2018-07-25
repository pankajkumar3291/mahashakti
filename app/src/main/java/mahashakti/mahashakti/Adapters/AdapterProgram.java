package mahashakti.mahashakti.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import com.mahashakti.R;
import com.mahashakti.Response.EventResponse.EventPayload;

/**
 * Created by dharamveer on 11/1/18.
 */

public class AdapterProgram extends RecyclerView.Adapter<AdapterProgram.MyHolder>{

    Context context;
    View view;
    ArrayList<EventPayload> eventPayloadArrayList = new ArrayList<>();
    public AdapterProgramListener adapterProgramListener;
    public EventListenerActivity eventListenerActivity;


    public AdapterProgram(Context context, ArrayList<EventPayload> eventPayloadArrayList) {
        this.context = context;
        this.eventPayloadArrayList = eventPayloadArrayList;
    }


    public interface EventListenerActivity{

        void onRowClick(String title, String des,String startDate,String endDate,int seats,int perprice,String location);
    }

    public interface AdapterProgramListener{

        void onChatButtonClik(View view, int position);
        void onBookingButtonClicked(View view,int position);

    }

    public void setOnRowClickListener(EventListenerActivity eventListenerActivity){

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

         final EventPayload eventPayload = eventPayloadArrayList.get(position);

        holder.txtFestivalName.setText(eventPayload.getEventname());
        holder.txtFestDescription.setText(eventPayload.getEventdesc());
        holder.txtDate.setText(eventPayload.getEventstartdate());
        holder.txtTime.setText(eventPayload.getCreated_at());



        holder.btnChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                adapterProgramListener.onChatButtonClik(holder.btnChat,position);
            }
        });

        holder.btnBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                adapterProgramListener.onBookingButtonClicked(holder.btnBooking,position);
            }
        });


        holder.eventRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                eventListenerActivity.onRowClick(eventPayload.getEventname(),
                        eventPayload.getEventdesc(),
                        eventPayload.getEventstartdate(),eventPayload.getEventenddate(),
                        eventPayload.getEventseats(),
                        eventPayload.getEventpriceperperson(),eventPayload.getEventlocation());



            }
        });


    }

    @Override
    public int getItemCount() {
        return eventPayloadArrayList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        private CircleImageView imageProgram;
        private TextView txtFestivalName,txtFestDescription,txtDate,txtTime;
        private Button btnBooking,btnChat;
        private RelativeLayout eventRow;


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


            //Buttons
            btnBooking = itemView.findViewById(R.id.btnBooking);
            btnChat = itemView.findViewById(R.id.btnChat);




        }
    }
}
