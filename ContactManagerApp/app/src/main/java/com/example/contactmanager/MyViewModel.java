package com.example.contactmanager;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MyViewModel extends AndroidViewModel {

//    if you need to use context inside your ViewModel
//    you should use AndroidViewModel (AVM),
//    because it contains the application context.
    private Reposittory myRepository;

    private LiveData<List<Contacts>> allContacts;

    public MyViewModel(@NonNull Application application) {
        super(application);
        this.myRepository = new Reposittory(application);
    }

    public LiveData<List<Contacts>> getAllContacts(){
        allContacts = myRepository.getAllContacts();
        return allContacts;
}

public void addNewContact(Contacts contacts){
        myRepository.addContact(contacts);
}

public void deleteContact(Contacts contacts){
        myRepository.delteContact(contacts);
}

//AndroidViewModel class is a subclass of ViewModel and similiar to them ,
// they are designed to store and manage UI-related data are responsible to prepare and provide data
//for UI and automatically allow data to survive configuration change.
}
