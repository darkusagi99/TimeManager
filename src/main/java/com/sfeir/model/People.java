package com.sfeir.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;

@Document(collection = "people")
public class People {

    @Id
    private String id;

    @Indexed(unique = true, direction = IndexDirection.DESCENDING)
    private String fullname;

    private boolean enabled;

    private List<DayOfWeek> standardArrival;
    private List<DayOfWeek> standardDeparture;
    private List<DayOfWeek> standardMeal;

    @DBRef
    private Set<Presence> presences;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Presence> getPresences() {
        return presences;
    }

    public void setPresences(Set<Presence> presences) {
        this.presences = presences;
    }

    public List<DayOfWeek> getStandardArrival() {
        return standardArrival;
    }

    public void setStandardArrival(List<DayOfWeek> standardArrival) {
        this.standardArrival = standardArrival;
    }

    public List<DayOfWeek> getStandardDeparture() {
        return standardDeparture;
    }

    public void setStandardDeparture(List<DayOfWeek> standardDeparture) {
        this.standardDeparture = standardDeparture;
    }

    public List<DayOfWeek> getStandardMeal() {
        return standardMeal;
    }

    public void setStandardMeal(List<DayOfWeek> standardMeal) {
        this.standardMeal = standardMeal;
    }
}
