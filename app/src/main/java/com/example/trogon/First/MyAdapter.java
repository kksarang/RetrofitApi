package com.example.trogon.First;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trogon.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private ArrayList<Model> modelArrayList;
    private Context context;


    //cerate constructor

    public MyAdapter(ArrayList<Model> modelArrayList, Context context) {
        this.modelArrayList = modelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.firstrecclerview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //initalize main data

        Model model = modelArrayList.get(position);

//        Glide.with(context).load(model.getImage())
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .into(holder.img);
        holder.name.setText("Movie Name : " + model.getName());
        holder.type.setText("Type : "+model.getType());
        holder.language.setText("Language :"+model.getLanguage());

        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, SecondActivity.class);

                intent.putExtra("name1",model.getName());
                intent.putExtra("language1",model.getLanguage());
                intent.putExtra("type1",model.getType());

                context.startActivity(intent);



            }
        });

    }

    @Override
    public int getItemCount()
    {
        return modelArrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name, type, language;
        ImageView img;
        Button btn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.moviename);
            type = itemView.findViewById(R.id.type);
            language = itemView.findViewById(R.id.language);
//            img = itemView.findViewById(R.id.imgfor1st);
            btn = itemView.findViewById(R.id.nextpage);


        }
    }
}
