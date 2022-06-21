package org.wecancoeit.reviews.repos;

import org.springframework.data.repository.CrudRepository;
import org.wecancoeit.reviews.model.Hashtag;
import org.wecancoeit.reviews.model.Retailer;

public interface retailerRepo extends CrudRepository<Retailer,Long> {
    Retailer findByName(String name);
}
