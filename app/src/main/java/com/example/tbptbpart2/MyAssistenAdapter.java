package com.example.tbptbpart2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class MyAssistenAdapter extends RecyclerView.Adapter<MyViewHolderAssisten> {

    private Context context;
    private List<DataClassAssisten> dataListAssisten;

    public MyAssistenAdapter(Context context, List<DataClassAssisten> dataList) {
        this.context = context;
        this.dataListAssisten = dataList;
    }

    @NonNull
    @Override
    public MyViewHolderAssisten onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_assisten, parent, false);
        return new MyViewHolderAssisten(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderAssisten holder, int position) {
        Glide.with(context).load(dataListAssisten.get(position).getDataImage()).into(holder.recImageAssisten);
        holder.recName.setText(dataListAssisten.get(position).getDataName());
        holder.recDesc.setText(dataListAssisten.get(position).getDataDesc());

        holder.recCardAssisten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("Image", dataListAssisten.get(holder.getAdapterPosition()).getDataImage());
                intent.putExtra("Description", dataListAssisten.get(holder.getAdapterPosition()).getDataDesc());
                intent.putExtra("Name", dataListAssisten.get(holder.getAdapterPosition()).getDataName());
                intent.putExtra("Key",dataListAssisten.get(holder.getAdapterPosition()).getKey());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataListAssisten.size();
    }

    public void searchDataList(ArrayList<DataClassAssisten> searchList){
        dataListAssisten = searchList;
        notifyDataSetChanged();
    }
}

class MyViewHolderAssisten extends RecyclerView.ViewHolder{

    ImageView recImageAssisten;
    TextView recName, recDesc, recDue;
    CardView recCardAssisten;

    public MyViewHolderAssisten(@NonNull View itemView) {
        super(itemView);

        recImageAssisten = itemView.findViewById(R.id.recImageAssisten);
        recCardAssisten = itemView.findViewById(R.id.recCardAssisten);
        recDesc = itemView.findViewById(R.id.recDesc);
        recName = itemView.findViewById(R.id.recName);
    }
}