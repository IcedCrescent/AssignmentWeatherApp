package com.example.trungspc.simpleweatherapp.parser;

import java.util.ArrayList;
import java.util.List;

public class WeatherResponse {
    String cod;
    float message;
    int cnt;

    public WeatherResponse(String cod, float message, int cnt) {
        this.cod = cod;
        this.message = message;
        this.cnt = cnt;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public float getMessage() {
        return message;
    }

    public void setMessage(float message) {
        this.message = message;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    @Override
    public String toString() {
        return "WeatherResponse{" +
                "cod='" + cod + '\'' +
                ", message=" + message +
                ", cnt=" + cnt +
                '}';
    }
}

