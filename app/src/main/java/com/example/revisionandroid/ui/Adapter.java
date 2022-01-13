package com.example.revisionandroid.ui;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.revisionandroid.R;
import com.example.revisionandroid.pogo.DataItem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.viewHolder>
{
    List<DataItem> items=new ArrayList<>();
    myInterface anInterface;
    Context  context;

    public Adapter(List<DataItem> items, myInterface anInterface,Context context) {
        this.items = items;
        this.anInterface = anInterface;
        this.context=context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.row_item,null,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
       holder.textView.setText(items.get(position).getName());
        Picasso.get().load(items.get(position).getImage()).placeholder(R.drawable.ic_launcher_background).into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                anInterface.sendData(items.get(position).getId()+"");
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class viewHolder extends RecyclerView.ViewHolder
    {
        TextView textView;
        ImageView imageView;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
         textView=itemView.findViewById(R.id.ProductName);
         imageView=itemView.findViewById(R.id.ProductImage);
        }
    }
}
interface myInterface
{
    void sendData(String name);
}