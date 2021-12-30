package com.example.trogon.First;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.trogon.MyApi;
import com.example.trogon.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView1, recyclerView2;
    private MyApi myApi;
    private ArrayList<Model> modelArrayList;
    private String BaseUrl = "https://api.tvmaze.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//assign variable
        recyclerView1 = findViewById(R.id.first_recyclerview);

        modelArrayList = new ArrayList<>();


        viewJsonData();

    }

    private void viewJsonData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create()).build();

        myApi = retrofit.create(MyApi.class);

        Call<ArrayList<Model>> arrayListCall = myApi.modelCall();

        arrayListCall.enqueue(new Callback<ArrayList<Model>>() {
            @Override
            public void onResponse(Call<ArrayList<Model>> call, Response<ArrayList<Model>> response) {
                modelArrayList = response.body();

                int i = 0;

                for (i = 0; i < modelArrayList.size(); i++) {
                    MyAdapter myAdapter = new MyAdapter(modelArrayList, MainActivity.this);

                    LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this,
                            RecyclerView.VERTICAL, false);

                    recyclerView1.setLayoutManager(manager);

                    recyclerView1.setAdapter(myAdapter);

                    recyclerView1.setHasFixedSize(true);
                    recyclerView1.setLayoutManager(new LinearLayoutManager(MainActivity.this));


                }
            }

            @Override
            public void onFailure(Call<ArrayList<Model>> call, Throwable t) {

            }
        });

    }

}