package com.example.recyclerview;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHOlder> {
    ArrayList<Model> arrayList = new ArrayList<>();

    public Adapter(ArrayList<Model> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHOlder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv,parent, false);
        return new Adapter.ViewHOlder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHOlder holder, final int position) {
        holder.textView.setText(arrayList.get(position).getName());
        holder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("position", String.valueOf(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHOlder extends RecyclerView.ViewHolder {
        TextView textView;
        LinearLayout ll;

        public ViewHOlder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text);
            ll = itemView.findViewById(R.id.ll);
        }
    }
}
