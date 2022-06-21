package org.wecancoeit.reviews.repos;

import org.springframework.data.repository.CrudRepository;
import org.wecancoeit.reviews.model.Hashtag;

public interface hashtagRepo extends CrudRepository<Hashtag, Long> {
    Hashtag findByName(String name);

}

