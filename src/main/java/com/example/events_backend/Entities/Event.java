package com.example.events_backend.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Event {
    
    //  Entity Properties
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    public String title;

    public String date;

    public String eventImage;

    public String city;

    //COnstructors
    public Event(){

    }

    public Event(String title, String date, String eventImage, String city) {
        this.title = title;
        this.date = date;
        this.eventImage = eventImage;
        this.city = city;
    }

    //GETTERS AND SETTERS

    public Integer getId(){
        return this.id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate(){
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEventImage(){
        return this.eventImage;
    }

    public void setEventImage(String eventImage) {
        this.eventImage = eventImage;
    }

    public String getCity(){
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
