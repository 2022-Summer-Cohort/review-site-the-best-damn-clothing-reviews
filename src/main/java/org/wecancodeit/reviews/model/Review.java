package org.wecancodeit.reviews.model;

import javax.persistence.*;

@Entity
public class Review {
    @Id
    @GeneratedValue
    private long id;
    private String review;
    private int rating;
    @ManyToOne
    private Retailer retailer;

    public Review(String review, int rating, Retailer retailer) {
        this.review = review;
        this.rating = rating;
        this.retailer = retailer;
    }

    public Review(){
    }

    public long getId() {
        return id;
    }


    public int getRating() {
        return rating;
    }

    public String getReview() {
        return review;
    }

    public Retailer getRetailer() {
        return retailer;
    }
}
