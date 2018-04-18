package com.example.trungspc.simpleweatherapp.parser;

import java.nio.file.WatchEvent;
import java.util.ArrayList;
import java.util.List;

public class WeatherResponse {
    String cod;
    float message;
    int cnt;
    List<JSON> list;

    public WeatherResponse(String cod, float message, int cnt, List<JSON> list) {
        this.cod = cod;
        this.message = message;
        this.cnt = cnt;
        this.list = list;
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

    public List<JSON> getList() {
        return list;
    }

    public void setList(List<JSON> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "WeatherResponse{" +
                "cod='" + cod + '\'' +
                ", \nmessage=" + message +
                ", \ncnt=" + cnt +
                ", \nlist=" + list +
                '}';
    }

    public class JSON {
        String dt;
        Main main;
        List<Weather> weather;

        public JSON(String dt, Main main, List<Weather> weather) {
            this.dt = dt;
            this.main = main;
            this.weather = weather;
        }

        public String getDt() {
            return dt;
        }

        public void setDt(String dt) {
            this.dt = dt;
        }

        public Main getMain() {
            return main;
        }

        public void setMain(Main main) {
            this.main = main;
        }

        public List<Weather> getWeather() {
            return weather;
        }

        public void setWeather(List<Weather> weather) {
            this.weather = weather;
        }

        @Override
        public String toString() {
            return "\n{" +
                    "dt='" + dt + '\'' +
                    ", \nmain=" + main +
                    ", \nweather=" + weather +
                    '}';
        }
    }

    public class Weather {
        int id;
        String main;
        String description;
        String icon;

        public Weather(int id, String main, String description, String icon) {
            this.id = id;
            this.main = main;
            this.description = description;
            this.icon = icon;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getMain() {
            return main;
        }

        public void setMain(String main) {
            this.main = main;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        @Override
        public String toString() {
            return "\nWeather{" +
                    "\nid=" + id +
                    "\n, main='" + main + '\'' +
                    "\n, description='" + description + '\'' +
                    "\n, icon='" + icon + '\'' +
                    '}';
        }
    }

    public class Main {
        float temp;
        float temp_min;
        float temp_max;
        float pressure;
        float sea_level;
        float grnd_level;
        int humidity;
        float temp_kf;

        public Main(float temp, float temp_min, float temp_max, float pressure, float sea_level, float grnd_level, int humidity, float temp_kf) {
            this.temp = temp;
            this.temp_min = temp_min;
            this.temp_max = temp_max;
            this.pressure = pressure;
            this.sea_level = sea_level;
            this.grnd_level = grnd_level;
            this.humidity = humidity;
            this.temp_kf = temp_kf;
        }

        public float getTemp() {
            return temp;
        }

        public void setTemp(float temp) {
            this.temp = temp;
        }

        public float getTemp_min() {
            return temp_min;
        }

        public void setTemp_min(float temp_min) {
            this.temp_min = temp_min;
        }

        public float getTemp_max() {
            return temp_max;
        }

        public void setTemp_max(float temp_max) {
            this.temp_max = temp_max;
        }

        public float getPressure() {
            return pressure;
        }

        public void setPressure(float pressure) {
            this.pressure = pressure;
        }

        public float getSea_level() {
            return sea_level;
        }

        public void setSea_level(float sea_level) {
            this.sea_level = sea_level;
        }

        public float getGrnd_level() {
            return grnd_level;
        }

        public void setGrnd_level(float grnd_level) {
            this.grnd_level = grnd_level;
        }

        public int getHumidity() {
            return humidity;
        }

        public void setHumidity(int humidity) {
            this.humidity = humidity;
        }

        public float getTemp_kf() {
            return temp_kf;
        }

        public void setTemp_kf(float temp_kf) {
            this.temp_kf = temp_kf;
        }

        @Override
        public String toString() {
            return "Main{" +
                    "\ntemp=" + temp +
                    "\n, temp_min=" + temp_min +
                    "\n, temp_max=" + temp_max +
                    "\n, pressure=" + pressure +
                    "\n, sea_level=" + sea_level +
                    "\n, grnd_level=" + grnd_level +
                    "\n, humidity=" + humidity +
                    "\n, temp_kf=" + temp_kf +
                    '}';
        }
    }
}
