package com.example.android.contactlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContactcDetailActivity extends AppCompatActivity {

    @BindView(R.id.tv_contact_name)
    TextView contactName;

    @BindView(R.id.image_view_large)
    ImageView contactPictureLarge;

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

    }

}
