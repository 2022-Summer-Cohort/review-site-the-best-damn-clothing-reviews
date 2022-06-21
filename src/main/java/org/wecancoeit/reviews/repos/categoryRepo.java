package org.wecancoeit.reviews.repos;

import org.springframework.data.repository.CrudRepository;
import org.wecancoeit.reviews.model.Category;
import org.wecancoeit.reviews.model.Hashtag;

public interface categoryRepo extends CrudRepository<Category,Long> {
    Category findByName(String name);

}
