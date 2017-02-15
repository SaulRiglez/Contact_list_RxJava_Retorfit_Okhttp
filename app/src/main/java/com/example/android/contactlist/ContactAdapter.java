package com.example.android.contactlist;

/**
 * Created by User on 2/8/2017.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

import static com.example.android.contactlist.R.id.progressBar;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.MyViewHolder> {
    private static final String TAG = "Adapter";
    private List<Contact> contactList;
    Context context;
    OnItemClickListener onItemClickListener;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvName;
        TextView tvPhonenumber;

        ImageView myImage;
        ProgressBar progressBar;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvTitle_Name);
            myImage = (ImageView) itemView.findViewById(R.id.myImageView);
            tvPhonenumber = (TextView) itemView.findViewById(R.id.tv_phoneNumber);
            progressBar = (ProgressBar) itemView.findViewById(R.id.progressBar);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            onItemClickListener.onClick(v, getAdapterPosition());
        }
    }

    public ContactAdapter(List<Contact> contactList, Context context) {
        this.context = context;
        this.contactList = contactList;


    }

    public ContactAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_row_data, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ContactAdapter.MyViewHolder holder, int position) {
        holder.progressBar.setVisibility(View.VISIBLE);
        Contact contact = contactList.get(position);
        holder.tvName.setText(contact.getName());
        holder.tvPhonenumber.setText(contact.getPhone().getMobile());


        Picasso.with(context).load(contact.getSmallImageURL())
                .into(holder.myImage, new Callback() {
                    @Override
                    public void onSuccess() {
                        holder.progressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError() {

                    }
                });



    }

    public void setClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }


}