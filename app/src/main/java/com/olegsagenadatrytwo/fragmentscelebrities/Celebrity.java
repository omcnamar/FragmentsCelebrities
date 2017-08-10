package com.olegsagenadatrytwo.fragmentscelebrities;



import java.io.Serializable;

/**
 * Created by omcna on 8/10/2017.
 */

public class Celebrity implements Serializable{
    private String name;
    private String title;
    private String birthDate;


    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    private int pic;

    public Celebrity(String name, String title, String birthDate, int pic) {
        this.name = name;
        this.title = title;
        this.birthDate = birthDate;
        this.pic = pic;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}

