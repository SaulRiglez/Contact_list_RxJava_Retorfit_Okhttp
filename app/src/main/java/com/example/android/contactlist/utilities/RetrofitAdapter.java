package com.example.android.contactlist.utilities;

import com.example.android.contactlist.model.Contact;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Created by User on 2/8/2017.
 */

public class RetrofitAdapter {


    private static final String TAG = "Retrofit";
    private static final String BASE_URL = "https://s3.amazonaws.com/";

    public static class Factory {
        public static Retrofit create(){
            return new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
                    .build();
        }
        public static Observable<List<Contact>> createObservable(){
            Retrofit retrofit = create();
            WebService webService = retrofit.create(WebService.class);
            return webService.getContacts();
        }
    }
}
