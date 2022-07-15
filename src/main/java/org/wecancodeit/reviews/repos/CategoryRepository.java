package org.wecancodeit.reviews.repos;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.reviews.model.Category;

public interface CategoryRepository extends CrudRepository<Category,Long> {
    Category findByName(String name);

}
