package com.example.tbptbpart2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView taskName;
    private ImageView taskImage;

    private ImageView asistenImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        asistenImage = (ImageView) findViewById(R.id.asistenImage);
        taskImage = (ImageView) findViewById(R.id.taskImage);
        taskImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openTaskActivity();
            }
        });
        asistenImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openAssistenActivity();
            }
        });
    }
    public void openTaskActivity(){
        Intent intent = new Intent(this, Tasklist.class);
        startActivity(intent);
    }
    public void openAssistenActivity(){
        Intent intent = new Intent(this, ListAsistenActivity.class);
        startActivity(intent);
    }
}
