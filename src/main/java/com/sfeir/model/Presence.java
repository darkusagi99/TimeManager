package com.sfeir.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "presence")
public class Presence {

    @Id
    private String id;

    /** Lien vers la personne présente */
    private String personId;

    /** Données de présence */
    private Date presenceDay;
    private Date arrival;
    private Date departure;
    private boolean hasMeal;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public Date getPresenceDay() {
        return presenceDay;
    }

    public void setPresenceDay(Date presenceDay) {
        this.presenceDay = presenceDay;
    }

    public Date getArrival() {
        return arrival;
    }

    public void setArrival(Date arrival) {
        this.arrival = arrival;
    }

    public Date getDeparture() {
        return departure;
    }

    public void setDeparture(Date departure) {
        this.departure = departure;
    }

    public boolean isHasMeal() {
        return hasMeal;
    }

    public void setHasMeal(boolean hasMeal) {
        this.hasMeal = hasMeal;
    }
}
