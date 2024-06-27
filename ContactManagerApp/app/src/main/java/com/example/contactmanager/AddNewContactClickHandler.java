package com.example.contactmanager;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

public class AddNewContactClickHandler {

    Contacts contacts;
    Context context;
    MyViewModel myViewModel;

    public AddNewContactClickHandler(Contacts contacts,
                                     Context context,
                                     MyViewModel myViewModel) {
        this.contacts = contacts;
        this.context = context;
        this.myViewModel = myViewModel;
    }

    public void onSubmitBtnClickd(View view){
        if (contacts.getName() == null || contacts.getEmail() == null){
            Toast.makeText(context, "Fields Can not be empty", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent i = new Intent(context,MainActivity.class);
//            i.putExtra("Name",contacts.getName());
//            i.putExtra("Email",contacts.getEmail());

            Contacts c = new Contacts(
                    contacts.getName(),
                    contacts.getEmail()
            );

            myViewModel.addNewContact(c);


            context.startActivity(i);
        }
    }
}
