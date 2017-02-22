package com.example.android.contactlist.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.android.contactlist.R;
import com.example.android.contactlist.model.Contact;
import com.example.android.contactlist.model.DetailContact;
import com.example.android.contactlist.presenter.IPresenterMainActivity;
import com.example.android.contactlist.presenter.PresenterMainActivityImp;
import com.example.android.contactlist.utilities.ContactAdapter;
import com.example.android.contactlist.utilities.OnItemClickListener;
import com.example.android.contactlist.utilities.RetrofitAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements OnItemClickListener, IMainActivityView {
    private static final String TAG = "MainActivity";
    List<Contact> myContacts = new ArrayList<>();
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private ContactAdapter contactAdapter;
    IPresenterMainActivity iPresenterMainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        contactAdapter = new ContactAdapter(myContacts, this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(contactAdapter);
        contactAdapter.setClickListener(this);
///################################################## se queda tiene que ver con la vista

        iPresenterMainActivity = new PresenterMainActivityImp(this);
        iPresenterMainActivity.getContatcsList();

    }


    @Override
    public void onClick(View view, int position) {
        Contact contact = myContacts.get(position);
        DetailContact contactDetail = new DetailContact(myContacts.get(position).getName()
                , myContacts.get(position).getLargeImageURL()
                , myContacts.get(position).getPhone().getMobile()
                , myContacts.get(position).getCompany());
        Intent intent = new Intent(this, ContactcDetailActivity.class);
        intent.putExtra("contact_detail", contactDetail);
        startActivity(intent);
    }

    @Override
    public void setContacts(List<Contact> contactsList) {

        for (Contact c : contactsList) {
            myContacts.add(c);
        }
        contactAdapter.notifyDataSetChanged();

    }
}
