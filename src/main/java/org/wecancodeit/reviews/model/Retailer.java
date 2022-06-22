package org.wecancodeit.reviews.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Retailer {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String category;

    public Retailer(long id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public Retailer(){
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }


}
