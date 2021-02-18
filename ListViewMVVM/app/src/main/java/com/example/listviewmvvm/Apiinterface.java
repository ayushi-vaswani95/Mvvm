package com.example.listviewmvvm;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Apiinterface {

  @GET("PublicHolidays/2019/us")
    Call<List<Listmodel>> getlist();
}
