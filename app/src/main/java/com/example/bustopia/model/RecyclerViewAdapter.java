package com.example.bustopia.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.bustopia.R;

public class RecyclerViewAdapter extends RecyclerView.Adapter < RecyclerViewAdapter.ViewHolder > {
    private User[] mydata;
    // RecyclerView recyclerView;
    public RecyclerViewAdapter(User[] mydata) {
        this.mydata = mydata;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.recycler_resource, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final User MyData = mydata[position];
        holder.Username.setText(mydata[position].getUsername());
        holder.Password.setText(mydata[position].getPassword());
        holder.age.setText(mydata[position].getAge());
        holder.Gender.setText(mydata[position].getGender());
        holder.ID.setText(Integer.toString(mydata[position].getId()));

    }
    @Override
    public int getItemCount() {
        return mydata.length;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView Username;
        public TextView Password;
        public TextView age;
        public TextView Gender;
        public TextView ID;
        public ViewHolder(View itemView) {
            super(itemView);
            this.Username = (TextView) itemView.findViewById(R.id.name);
            this.Password = (TextView) itemView.findViewById(R.id.password);
            this.age = (TextView) itemView.findViewById(R.id.ageData);
            this.Gender = (TextView) itemView.findViewById(R.id.genderData);
            this.ID = (TextView) itemView.findViewById(R.id.uid);
        }
    }
}
