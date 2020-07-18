package com.example.meteovozduh;

import com.example.meteovozduh.models.CityResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ServiceInterface {


    @GET("map/bounds/")
    Call<AllPlacesDatas> getAqi(@Query("token") String token,@Query("latlng") String latlng); //@Query("api_key") то что в скобках после Query
        //https://api.waqi.info/         map/bounds/     ?latlng=39.379436,116.091230,40.235643,116.784382&token=afe87f3649bace84ce4c2bf2a1bfd111c99d6e48
           //   baze url                 путь к запросу    после ? это Query параметры
//


//
    @GET("/feed/{city}/")
    Call<CityResponse>getAqibyCity(@Query("token") String token, @Path("city")String city);
   }