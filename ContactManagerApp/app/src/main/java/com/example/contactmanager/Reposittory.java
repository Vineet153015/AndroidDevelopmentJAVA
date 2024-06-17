package com.example.contactmanager;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Reposittory {

//    he available data sources:
//       -ROOM Database

    private final contactDAO ContactDAO;
    ExecutorService executor;
    Handler handler;

    public Reposittory(Application application) {
        
        ContactDatabase contactDatabase= ContactDatabase.getInstance(application);
        this.ContactDAO = contactDatabase.getContactDAO();

        //        Used for Background Databsae Operation
        executor = Executors.newSingleThreadExecutor();

//        Used for updating UI
        handler = new Handler(Looper.getMainLooper());

    }

//    Methods in DAO being executed from Repository
    public void addContact(Contacts contacts){
//        Runnable :Execute Tasks on separate thread
        executor.execute(new Runnable() {
            @Override
            public void run() {
//                Execute this code asynchronously
//                on separate thread
                ContactDAO.insert(contacts);
            }
        });

    }

    public void delteContact(Contacts contacts){

        executor.execute(new Runnable() {
            @Override
            public void run() {
                ContactDAO.delete(contacts);
            }
        });

    }

    public LiveData<List<Contacts>> getAllContacts(){
        return ContactDAO.getAllContacts();
    }
}
