package com.example.android.contactlist.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.contactlist.R;
import com.example.android.contactlist.model.DetailContact;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ContactcDetailActivity extends AppCompatActivity {

    @BindView(R.id.tv_contact_name)
    TextView contactName;
    @BindView(R.id.tv_contact_phone)
    TextView contactPhone;
    @BindView(R.id.tv_contact_company)
    TextView contactCompany;

    @BindView(R.id.image_view_large)
    ImageView contactPictureLarge;

    @BindView(R.id.detail_activity_background)
    ImageView arrowLeft;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactc_detail);


        ButterKnife.bind(this);
        updateContactDetail();


    }

    private void updateContactDetail() {
        Intent intent = getIntent();
        DetailContact contact = intent.getParcelableExtra("contact_detail");
        contactName.setText(contact.getContactName());
        contactPhone.setText(contact.getContactPhonenumber());
        contactCompany.setText(contact.getContactCompany());


        Picasso.with(this).load(contact.getContactPictureLarge())
                .into(contactPictureLarge, new Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError() {

                    }
                });

    }
    @OnClick(R.id.detail_activity_background)
    void goBack(){

        //Intent intent = new Intent(this,MainActivity.class);
        //startActivity(intent);

    }

}
