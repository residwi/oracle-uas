package com.example.uasoracle.util.api;


public class UtilsApi {

    public static final String BASE_URL_API = "http://192.168.1.14:8888/apex/obe/";

    public static BaseApiService getAPIService(){
        return RetrofitClient.getClient(BASE_URL_API).create(BaseApiService.class);
    }
}
