package com.example.trogon.second;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.trogon.First.Model;
import com.example.trogon.MyApi;
import com.example.trogon.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Cast extends AppCompatActivity {

    private TextView txt1,txt2;
    private MyApi myApi;
   // private ArrayList<CastModel> castModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cast);

        txt1=findViewById(R.id.nmecastt);
        txt2=findViewById(R.id.datecst);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.tvmaze.com/shows/1/")
                .addConverterFactory(GsonConverterFactory.create()).build();



           MyApi api=retrofit.create(MyApi.class);

        Call<List<CastModel>>  call=api.getModel();

        call.enqueue(new Callback<List<CastModel>>() {
            @Override
            public void onResponse(Call<List<CastModel>> call, Response<List<CastModel>> response)
            {
                List<CastModel> data=response.body();

                for (int i=0;i<data.size();i++)
                {
                    txt1.setText(data.get(i).getName());
                    txt2.append(data.get(i).getBirthday());
                }

            }

            @Override
            public void onFailure(Call<List<CastModel>> call, Throwable t) {

                Toast.makeText(Cast.this, "failure", Toast.LENGTH_SHORT).show();

            }
        });

    }
}