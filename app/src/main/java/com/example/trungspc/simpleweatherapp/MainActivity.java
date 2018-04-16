package com.example.trungspc.simpleweatherapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

import com.example.trungspc.simpleweatherapp.models.City;
import com.example.trungspc.simpleweatherapp.parser.IWeather;
import com.example.trungspc.simpleweatherapp.parser.RetrofitInstance;
import com.example.trungspc.simpleweatherapp.parser.WeatherResponse;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    List<City> cities;
    HashMap<String, Integer> citiesMap;
    @BindView(R.id.bt_check)
    Button btCheck;
    @BindView(R.id.tv_weather)
    TextView tvWeather;
    @BindView(R.id.actvCity)
    AutoCompleteTextView actvCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Gson gson = new Gson();
        try {
            cities = gson.fromJson(new InputStreamReader(getAssets().open("city.list.json")), new TypeToken<List<City>>() {
            }.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] cityNames = new String[cities.size()];
        citiesMap = new HashMap<>();
        for (int i = 0; i < cities.size(); i++) {
            cityNames[i] = cities.get(i).getName();
            citiesMap.put(cities.get(i).getName(), cities.get(i).getId());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, cityNames);
        actvCity.setAdapter(adapter);
    }

    @OnClick(R.id.bt_check)
    public void onViewClicked() {
        String inputCity = actvCity.getText().toString().trim();
        Integer cityID = citiesMap.get(inputCity);
        if (cityID == null) {
            actvCity.setError("This is city doesn't exist!");
            return;
        }
        Log.d(TAG, "onViewClicked: City id - " + cityID);

        IWeather weather = RetrofitInstance.getRetrofitInstance().create(IWeather.class);
        weather.getWeather(cityID, "metric", "vi", "1a51acf5bdfba80ac910961e2435f68a").enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                Log.d(TAG, "onResponse: " + (response.body() == null));
//                String result = response.body().getList().toString();
//                tvWeather.setText(result);
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {

            }
        });

    }
}
