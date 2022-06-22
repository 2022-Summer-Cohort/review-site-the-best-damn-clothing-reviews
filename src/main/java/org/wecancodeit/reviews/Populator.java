package org.wecancodeit.reviews;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wecancodeit.reviews.model.Category;
import org.wecancodeit.reviews.model.Hashtag;
import org.wecancodeit.reviews.model.Retailer;
import org.wecancodeit.reviews.repos.CategoryRepository;
import org.wecancodeit.reviews.repos.HashtagRepository;
import org.wecancodeit.reviews.repos.RetailerRepository;

@Component
public class Populator implements CommandLineRunner {
    private CategoryRepository categoryRepo;
    private HashtagRepository hashtagRepo;
    private RetailerRepository retailerRepo;

    public Populator(CategoryRepository categoryRepo, HashtagRepository hashtagRepo, RetailerRepository retailerRepo) {
        this.categoryRepo = categoryRepo;
        this.hashtagRepo = hashtagRepo;
        this.retailerRepo = retailerRepo;
    }
    @Override
    public void run(String...args) throws Exception{

        Hashtag sexy = new Hashtag("#sexy");
        hashtagRepo.save(sexy);
        hashtagRepo.save(new Hashtag("#fresh"));

        Category shoes = new Category("shoes");
        categoryRepo.save(shoes);

        Retailer gap = new Retailer("gap", "shoes");
        retailerRepo.save(gap);

    }
}
