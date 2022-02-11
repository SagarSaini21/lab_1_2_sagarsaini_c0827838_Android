package com.example.lab_1_2_sagarsaini_c0827838_android;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.MyViewHolder> {
    Context context;
    ArrayList<String> id,name,desc,price;

    RVAdapter(Context context,ArrayList id,ArrayList name,ArrayList desc, ArrayList price){
    this.context=context;
    this.id=id;
    this.name=name;
    this.desc=desc;
    this.price=price;

    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.my_row,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.idtxt.setText(String.valueOf(id.get(position)));
        holder.nametxt.setText(String.valueOf(name.get(position)));
        holder.desctxt.setText(String.valueOf(desc.get(position)));
        holder.pricetxt.setText(String.valueOf(price.get(position)));
        holder.mainlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("id",String.valueOf(id.get(position)));
                intent.putExtra("name",String.valueOf(name.get(position)));
                intent.putExtra("desc",String.valueOf(desc.get(position)));
                intent.putExtra("price",String.valueOf(price.get(position)));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView idtxt,nametxt,desctxt,pricetxt;
        LinearLayout mainlayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            idtxt= itemView.findViewById(R.id.displayid);
            nametxt= itemView.findViewById(R.id.displayname);
            desctxt= itemView.findViewById(R.id.displaydesc);
            pricetxt= itemView.findViewById(R.id.displayPrice);
            mainlayout=itemView.findViewById(R.id.mainlayout);
        }
    }
}
