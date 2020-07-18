package com.example.meteovozduh;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ServiceInterface interf = RetrofitClient.getInstanse().create(ServiceInterface.class);

        Call<AllPlacesDatas> call = interf.getAqi(Constants.API_KEY,"39.379436,116.091230,40.235643,116.784382");


        call.enqueue(new Callback<AllPlacesDatas>() {
            @Override
            public void onResponse(Call<AllPlacesDatas> call, Response<AllPlacesDatas> response) {
             AllPlacesDatas allPlaceResult = response.body();  // AllPlacesDatas заполняются данными из jsona, которые пришли из интернета
//                for (OnePlaceData data : allPlaceResult.getData()){
//                    Log.d("aqi : ",data.getAqi());
//                }

                    OurAdapter ourAdapter = new OurAdapter();
                    recyclerView.setAdapter(ourAdapter);
                   // ourAdapter.setItems(OnePlaceData.getAqi(allPlaceResult));
                    ourAdapter.setItems(allPlaceResult.getData());


            }

            @Override
            public void onFailure(Call<AllPlacesDatas> call, Throwable t) {

            }
        });
    }
}
