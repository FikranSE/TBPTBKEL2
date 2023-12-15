package com.example.tbptbpart2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MyUserAdapter extends RecyclerView.Adapter<MyViewHolderUser> {

    private Context context;
    private List<DataClassUser> dataListUser;

    public MyUserAdapter(Context context, List<DataClassUser> dataListUser) {
        this.context = context;
        this.dataListUser = dataListUser;
    }

    @NonNull
    @Override
    public MyViewHolderUser onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_user, parent, false);
        return new MyViewHolderUser(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderUser holder, int position) {
        Glide.with(context).load(dataListUser.get(position).getDataImage()).into(holder.recImageUser);
        holder.recNameUser.setText(dataListUser.get(position).getDataName());
        holder.recEmail.setText(dataListUser.get(position).getDataEmail());

        holder.recCardUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailUserActivity.class);
                intent.putExtra("Image", dataListUser.get(holder.getAdapterPosition()).getDataImage());
                intent.putExtra("Email", dataListUser.get(holder.getAdapterPosition()).getDataEmail());
                intent.putExtra("Name", dataListUser.get(holder.getAdapterPosition()).getDataName());
                intent.putExtra("Key",dataListUser.get(holder.getAdapterPosition()).getKey());
                context.startActivity(intent);
            

            }
        });
    }

    @Override
    public int getItemCount() {return dataListUser.size();}

    public void searchDataList(ArrayList<DataClassUser> searchList){
        dataListUser = searchList;
        notifyDataSetChanged();
    }
}

class MyViewHolderUser extends RecyclerView.ViewHolder{

    ImageView recImageUser;
    TextView recNameUser, recEmail;
    CardView recCardUser;


    public MyViewHolderUser(@NonNull View itemView) {
        super(itemView);

        recImageUser = itemView.findViewById(R.id.recImageUser);
        recNameUser = itemView.findViewById(R.id.recNameUser);
        recEmail = itemView.findViewById(R.id.recEmail);
        recCardUser = itemView.findViewById(R.id.recCardUser);
    }
}
