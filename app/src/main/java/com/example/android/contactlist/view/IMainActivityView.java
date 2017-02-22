package com.example.android.contactlist.view;

import com.example.android.contactlist.model.Contact;

import java.util.List;

/**
 * Created by User on 2/22/2017.
 */

public interface IMainActivityView {

    void setContacts(List<Contact> contactsList);
}
