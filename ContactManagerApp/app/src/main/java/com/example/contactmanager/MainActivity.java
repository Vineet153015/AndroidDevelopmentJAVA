package com.example.contactmanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.contactmanager.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

//    Data Source
    private ContactDatabase contactDatabase;
    private ArrayList<Contacts> contactsArrayList  = new ArrayList<>();

//    Adapter
    private MyAdapter myAdapter;

//    Binding
    private ActivityMainBinding mainBinding;
    private MainActivityClickHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        handler = new MainActivityClickHandler(this);

        mainBinding.setClickhandler(handler);


//        RecyclerView

        RecyclerView recyclerView = mainBinding.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

//

//        Database
        contactDatabase = ContactDatabase.getInstance(this);

//        View Model
        MyViewModel viewModel = new ViewModelProvider(this).get(MyViewModel.class);

//        Loading th data from database
        viewModel.getAllContacts().observe(
                this,
                new Observer<List<Contacts>>() {
                    @Override
                    public void onChanged(List<Contacts> contacts) {

                        contactsArrayList.clear();

                        for (Contacts c : contacts){
                            contactsArrayList.add(c);
                        }

                        myAdapter.notifyDataSetChanged();
                    }
                }
        );

//        Adapter
                 myAdapter = new MyAdapter(contactsArrayList);

//Linkng the RecyclerView with Adapter
        recyclerView.setAdapter(myAdapter);

//        Swipe to delete Function
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
//                If you swipe to the left
                Contacts c = contactsArrayList.get(viewHolder.getAdapterPosition());
                viewModel.deleteContact(c);

            }
        }).attachToRecyclerView(recyclerView);
    }
}