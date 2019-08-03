package com.example.uasoracle.util.api;


import com.example.uasoracle.model.ResponseBarang;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface BaseApiService {

    @GET("barang")
    Call<ResponseBarang> getSemuaBarang();
}
