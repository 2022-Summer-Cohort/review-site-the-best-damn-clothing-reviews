package org.wecancodeit.reviews.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Arrays;
import java.util.Collection;

@Entity
public class Retailer {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String category;
    @ManyToMany
    private Collection<Hashtag> hashtags;

    public Retailer(String name, String category, Hashtag...hashtags) {
        this.name = name;
        this.category = category;
        this.hashtags = Arrays.asList(hashtags);
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
