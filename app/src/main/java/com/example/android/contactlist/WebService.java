package com.example.android.contactlist;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;



public interface WebService {

    @GET("technical-challenge/Contacts.json")
    Observable<List<Contact>> getContacts();
}

