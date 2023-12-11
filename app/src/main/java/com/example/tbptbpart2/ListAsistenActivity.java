package com.example.tbptbpart2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ListAsistenActivity extends AppCompatActivity {
    FloatingActionButton fabAssisten;
    DatabaseReference databaseReference;
    ValueEventListener eventListener;
    RecyclerView recyclerView;
    List<DataClassAssisten> dataListAssisten;
    MyAssistenAdapter adapter;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_asisten);

        recyclerView = findViewById(R.id.recyclerView);
        fabAssisten = findViewById(R.id.fabAssisten);
        searchView = findViewById(R.id.search);
        searchView.clearFocus();

        GridLayoutManager gridLayoutManager = new GridLayoutManager(ListAsistenActivity.this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);

        AlertDialog.Builder builder = new AlertDialog.Builder(ListAsistenActivity.this);
        builder.setCancelable(false);
        builder.setView(R.layout.progress_layout);
        AlertDialog dialog = builder.create();
        dialog.show();

        dataListAssisten = new ArrayList<>();

        adapter = new MyAssistenAdapter(ListAsistenActivity.this, dataListAssisten);
        recyclerView.setAdapter(adapter);

        databaseReference = FirebaseDatabase.getInstance().getReference("Assisten");
        dialog.show();
        eventListener = databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                dataListAssisten.clear();
                for (DataSnapshot itemSnapshot: snapshot.getChildren()){
                    DataClassAssisten dataClassAssisten = itemSnapshot.getValue(DataClassAssisten.class);

                    dataClassAssisten.setKey(itemSnapshot.getKey());

                    dataListAssisten.add(dataClassAssisten);
                }
                adapter.notifyDataSetChanged();
                dialog.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                dialog.dismiss();
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchList(newText);
                return true;
            }
        });

        fabAssisten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListAsistenActivity.this, UploadAssistenActivity.class);
                startActivity(intent);
            }
        });

    }
    public void searchList(String text){
        ArrayList<DataClassAssisten> searchList = new ArrayList<>();
        for (DataClassAssisten dataClassAssisten: dataListAssisten){
            if (dataClassAssisten.getDataName().toLowerCase().contains(text.toLowerCase())){
                searchList.add(dataClassAssisten);
            }
        }
        adapter.searchDataList(searchList);
    }
}