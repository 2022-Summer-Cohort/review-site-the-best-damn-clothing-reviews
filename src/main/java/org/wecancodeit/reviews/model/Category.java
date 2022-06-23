package org.wecancodeit.reviews.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Collection;

@Entity
public class Category {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    @ManyToMany(mappedBy = "categories")
    private Collection<Retailer> retailers;

    public Category(String name) {
        this.name = name;
    }

    public Category(){    }

    public Collection<Retailer> getRetailers() {
        return retailers;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
