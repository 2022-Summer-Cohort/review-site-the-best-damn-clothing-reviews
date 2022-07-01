package org.wecancodeit.reviews.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@Entity
public class Retailer {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String website;
    private String imgUrl;
    @ManyToMany
    private Collection<Category> categories;
    @ManyToMany
    private Collection<Hashtag> hashtags;
    @OneToMany (mappedBy= "retailer")
    private Collection<Review> reviews;

    public String getWebsite() {
        return website;
    }

    public Retailer(String name, String website, String imgUrl, Category category, Hashtag...hashtags) {
        this.name = name;
        this.categories = new ArrayList<Category>();
        this.imgUrl = imgUrl;
        this.categories.add(category);
        this.hashtags = Arrays.asList(hashtags);
        this.website = website;
        this.reviews = new ArrayList<Review>();
    }

    public Retailer(String name, String website, String imgUrl, Category[] categories, Hashtag...hashtags) {
        this.name = name;
        this.imgUrl = imgUrl;
        this.categories=Arrays.asList(categories);
        this.hashtags = Arrays.asList(hashtags);
        this.website = website;
    }

    public Retailer(){
    }

    public String getImgUrl() {
        return imgUrl;
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
    public Collection<Review> getReviews() {
        return reviews;
    }

    public void addCategory(Category category){
        categories.add(category);
    }
    public void addHashtag(Hashtag hashtag) {
        hashtags.add(hashtag);
    }
    public void addReview(Review review) {reviews.add(review);}

    public int avgRating(){
        int toAvg = 0;
        for (Review thisReview: reviews){
            toAvg+=thisReview.getRating();
        }
        return toAvg/(reviews.size());
    }
}
