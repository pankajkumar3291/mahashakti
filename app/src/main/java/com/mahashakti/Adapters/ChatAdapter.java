package com.mahashakti.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mahashakti.R;
import com.mahashakti.response.displayingUserChat.Payload;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private Context context;
    private RecyclerView.ViewHolder viewHolder;

    private static final int SENDER = 0;
    private static final int RECEIVER = 1;

    ArrayList<Payload> payload;


    public ChatAdapter(Context context, ArrayList<Payload> listDisplayingMessage) {

        this.context = context;
        this.payload = listDisplayingMessage;


    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        if (viewType == SENDER)
        {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_chat_adapter_right, parent, false);
            viewHolder = new ChatViewHolderSender(view);
            return viewHolder;

        } else {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_chat_adapter_left, parent, false);
            viewHolder = new ChatViewHolderReceiver(view);
            return viewHolder;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {


        final Payload payloadFinal = payload.get(position);
        if(holder instanceof ChatViewHolderSender)
        {

            ((ChatViewHolderSender) holder).tv_messageSender.setText(payloadFinal.message);

            ((ChatViewHolderSender) holder).tv_senderCreatedTime.setText(payloadFinal.createdAt);
        }

        else if(holder instanceof ChatViewHolderReceiver)
        {
            ((ChatViewHolderReceiver) holder).tv_ReceiverMessage.setText(payloadFinal.message);

            ((ChatViewHolderReceiver) holder).tv_ReceiverCreatedTime.setText(payloadFinal.createdAt);

        }






    }


    @Override
    public int getItemCount() {
        return payload.size();
    }


    @Override
    public int getItemViewType(int position) {

        if (payload.get(position).role.equalsIgnoreCase("user")) {
            return SENDER;
        } else {
            return RECEIVER;
        }
    }

    public class ChatViewHolderSender extends RecyclerView.ViewHolder {


        private TextView tv_messageSender, tv_senderCreatedTime, tv_ReceiverMessage, tv_ReceiverCreatedTime;


        public ChatViewHolderSender(View itemView) {
            super(itemView);

            tv_messageSender = itemView.findViewById(R.id.tv_messageSender);
            tv_senderCreatedTime = itemView.findViewById(R.id.tv_senderCreatedTime);


        }
    }






    public class ChatViewHolderReceiver extends RecyclerView.ViewHolder {


        private TextView tv_messageSender, tv_senderCreatedTime, tv_ReceiverMessage, tv_ReceiverCreatedTime;


        public ChatViewHolderReceiver(View itemView) {
            super(itemView);


            tv_ReceiverMessage = itemView.findViewById(R.id.tv_ReceiverMessage);
            tv_ReceiverCreatedTime = itemView.findViewById(R.id.tv_ReceiverCreatedTime);

        }
    }





}
