package org.wecancodeit.reviews.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Arrays;
import java.util.Collection;

@Entity
public class Hashtag {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    @ManyToMany (mappedBy="hashtags")
    private Collection<Retailer> retailers;

    public Hashtag(String name, Retailer...retailers) {
        this.name = name;
        this.retailers = Arrays.asList(retailers);
    }

    public Hashtag(){

    }

    public long getId() {
        return id;
    }

    public Collection<Retailer> getRetailers() {
        return retailers;
    }

    public String getName() {
        return name;
    }
}
