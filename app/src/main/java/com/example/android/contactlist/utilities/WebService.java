package com.example.android.contactlist.utilities;

import com.example.android.contactlist.model.Contact;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;



public interface WebService {

    @GET("technical-challenge/Contacts.json")
    Observable<List<Contact>> getContacts();
}

