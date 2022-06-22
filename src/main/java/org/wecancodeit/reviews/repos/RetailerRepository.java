package org.wecancodeit.reviews.repos;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.reviews.model.Retailer;

public interface RetailerRepository extends CrudRepository<Retailer,Long> {
//    Retailer findByHashtagsIgnoreCase(String hashtag);
//
//    Retailer findByCategoryIgnoreCase(String category);
}
