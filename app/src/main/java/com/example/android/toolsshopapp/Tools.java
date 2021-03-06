package com.example.android.toolsshopapp;

import androidx.annotation.NonNull;

public class Tools {

    private String title;
    private String info;
    private int idImageResource;

    public Tools(String title, String info, int idImageResource) {
        this.title = title;
        this.info = info;
        this.idImageResource = idImageResource;
    }

    public String getTitle() {
        return title;
    }

    public String getInfo() {
        return info;
    }

    public int getIdImageResource() {
        return idImageResource;
    }

    @NonNull
    @Override
    public String toString() {
        return title;
    }
}
