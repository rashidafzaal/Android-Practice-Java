package com.example.rashid.recyclerview;

/**
 * Created by rashid on 8/28/2017.
 */

public class MyDataClass
{
    private String title, genre, year;
    private int img;

    public MyDataClass(String title, String genre, String year, int img) {
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.img = img;

    }


    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
