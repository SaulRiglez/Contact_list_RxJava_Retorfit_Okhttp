package com.example.android.contactlist.presenter;

import com.example.android.contactlist.model.Contact;
import com.example.android.contactlist.utilities.RetrofitAdapter;
import com.example.android.contactlist.view.IMainActivityView;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by User on 2/22/2017.
 */

public class PresenterMainActivityImp implements IPresenterMainActivity {


    IMainActivityView iMainActivityView;

    public PresenterMainActivityImp(IMainActivityView iMainActivityView) {
        this.iMainActivityView = iMainActivityView;
    }

    @Override
    public void getContatcsList() {



        Observable<List<Contact>> resultObservable = RetrofitAdapter.Factory.createObservable();

        Observer myObserver = new Observer<List<Contact>>() {

            @Override
            public void onCompleted() {
                //contactAdapter.notifyDataSetChanged();





            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onNext(List<Contact> contactList) {

                iMainActivityView.setContacts(contactList);


            }
        };
        resultObservable.subscribeOn(Schedulers.io())
                .observeOn(Schedulers.newThread())
                .subscribe(myObserver);



    }
}
