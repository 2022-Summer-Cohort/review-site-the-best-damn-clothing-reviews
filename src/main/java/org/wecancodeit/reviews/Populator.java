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

        // HASHTAGS
        Hashtag sexy = new Hashtag("#sexy");
        hashtagRepo.save(sexy);
        hashtagRepo.save(new Hashtag("#fresh"));

        // CATEGORIES
        Category shoes = new Category("shoes");
        Category shirts = new Category("shirts");
        categoryRepo.save(shoes);
        categoryRepo.save(shirts);

        // RETAILERS
        Retailer shein = new Retailer("Shein","shein.com", "/images/shein-logo.jpg", shoes, sexy);
        retailerRepo.save(shein);

        Retailer blueNile = new Retailer("Blue Nile","bluenile.com", "/images/blueNileLogo.png", shoes, sexy);
        retailerRepo.save(blueNile);

        Retailer cision = new Retailer("cision","cision.com", "/images/Cision.png", shoes, sexy);
        retailerRepo.save(cision);

        Retailer dsw = new Retailer("dsw","dsw.com", "/images/DSW.png", shoes, sexy);
        retailerRepo.save(dsw);

        Retailer kohls = new Retailer("kohls","kohls.com", "/images/Kohls.jpg", shoes, sexy);
        retailerRepo.save(kohls);

        Retailer fashionNova = new Retailer("fashion Nova","fashionNova.com", "/images/fashionnova.jpg", shoes, sexy);
        retailerRepo.save(fashionNova);

        Retailer shoeDazzle = new Retailer("shoe Dazzle","shoeDazzle.com", "/images/shoedazzle.jpg", shoes, sexy);
        retailerRepo.save(shoeDazzle);

        Retailer nike = new Retailer("nike","nike.com", "/images/nike.jpg", shoes, sexy);
        retailerRepo.save(nike);


    }
}
