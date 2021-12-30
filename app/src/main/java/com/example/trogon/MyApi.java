package com.example.trogon;

import com.example.trogon.First.Model;
import com.example.trogon.second.CastModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyApi {


    @GET("shows")
    Call<ArrayList<Model>>modelCall();


    @GET("cast")
    Call<List<CastModel>> getModel();


}
