package com.example.arunyadav.wheelrotation.Model;

import com.google.gson.annotations.SerializedName;

public class User implements  IUser{

    @SerializedName("status")
    String status;

    @SerializedName("min")
    String min;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public int getRandom() {
        return random;
    }

    public void setRandom(int random) {
        this.random = random;
    }

    @SerializedName("max")
    String max;
    @SerializedName("random")
    int random;


    public User(String status, String min, String max, int random ) {
            this.max= max;
            this.min = min;
            this.random = random;
            this.status = status;
    }
}
