package org.wecancodeit.reviews.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Hashtag {
    @Id
    @GeneratedValue
    private long id;
    private String name;

    public Hashtag(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Hashtag(){

    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
