package org.wecancodeit.reviews.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@Entity
public class Retailer {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    @ManyToMany
    private Collection<Category> categories;
    @ManyToMany
    private Collection<Hashtag> hashtags;

    public Retailer(String name, Category category, Hashtag...hashtags) {
        this.name = name;
        this.categories = new ArrayList<Category>();
        this.categories.add(category);
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

    public Collection<Category> getCategories() {
        return categories;
    }

    public Collection<Hashtag> getHashtags() {
        return hashtags;
    }
    public void addCategory(Category category){
        categories.add(category);
    }
}
