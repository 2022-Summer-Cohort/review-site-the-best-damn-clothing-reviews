package org.wecancodeit.reviews;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wecancodeit.reviews.model.Category;
import org.wecancodeit.reviews.model.Hashtag;
import org.wecancodeit.reviews.model.Retailer;
import org.wecancodeit.reviews.model.Review;
import org.wecancodeit.reviews.repos.CategoryRepository;
import org.wecancodeit.reviews.repos.HashtagRepository;
import org.wecancodeit.reviews.repos.RetailerRepository;
import org.wecancodeit.reviews.repos.ReviewRepository;

@Component
public class Populator implements CommandLineRunner {
    private CategoryRepository categoryRepo;
    private HashtagRepository hashtagRepo;
    private RetailerRepository retailerRepo;
    private ReviewRepository reviewRepo;

    public Populator(CategoryRepository categoryRepo, HashtagRepository hashtagRepo, RetailerRepository retailerRepo, ReviewRepository reviewRepo) {
        this.categoryRepo = categoryRepo;
        this.hashtagRepo = hashtagRepo;
        this.retailerRepo = retailerRepo;
        this.reviewRepo = reviewRepo;
    }

    @Override
    public void run(String...args) throws Exception{

        // HASHTAGS
        Hashtag sexy = new Hashtag("#sexy");
        hashtagRepo.save(sexy);
        hashtagRepo.save(new Hashtag("#fresh"));
        Hashtag designer = new Hashtag("#designer");
        hashtagRepo.save(designer);
        Hashtag fashion = new Hashtag("#fashionable");
        hashtagRepo.save(fashion);
        Hashtag stylish = new Hashtag("#stylish");
        hashtagRepo.save(stylish);
        Hashtag ootd = new Hashtag("#ootd");
        hashtagRepo.save(ootd);

        // CATEGORIES
        Category shoes = new Category("shoes");
        Category womens = new Category("womens clothing");
        categoryRepo.save(shoes);
        categoryRepo.save(womens);
        Category mens = new Category("mens clothing");
        Category kids  = new Category("kids clothing");
        categoryRepo.save(mens);
        categoryRepo.save(kids);
        Category jewelery = new Category("jewelery");
        Category headWear = new Category("headWear");
        categoryRepo.save(jewelery);
        categoryRepo.save(headWear);
        Category sportsWear = new Category("sportsWear");
        Category underWear = new Category("underWear");
        categoryRepo.save(sportsWear);
        categoryRepo.save(underWear);
        Category outDoors = new Category("outDoors");
        Category purses = new Category("purses");
        categoryRepo.save(outDoors);
        categoryRepo.save(purses);

        // RETAILERS
        Retailer shein = new Retailer("Shein","shein.com", "/images/shein-logo.jpg", shoes, sexy);
        shein.addCategory(womens);
        retailerRepo.save(shein);
        Retailer blueNile = new Retailer("Blue Nile","bluenile.com", "/images/blueNileLogo.png", shoes, sexy);
        blueNile.addCategory(jewelery);
        retailerRepo.save(blueNile);
        Category[] dswCategory={shoes,mens};
        Retailer dsw = new Retailer("dsw","dsw.com", "/images/DSW.png",dswCategory, sexy,stylish);
        //dsw.addCategory(purses);
        retailerRepo.save(dsw);
        Retailer kohls = new Retailer("kohls","kohls.com", "/images/Kohls.jpg", shoes, sexy);
        kohls.addCategory(womens);
        kohls.addCategory(mens);
        kohls.addCategory(kids);
        kohls.addCategory(sportsWear);
        retailerRepo.save(kohls);
        Retailer fashionNova = new Retailer("fashion Nova","fashionNova.com", "/images/fashionnova.jpg", shoes, sexy);
        fashionNova.addCategory(womens);
        retailerRepo.save(fashionNova);
        Retailer shoeDazzle = new Retailer("shoe Dazzle","shoeDazzle.com", "/images/shoedazzle.jpg", shoes, sexy);
        retailerRepo.save(shoeDazzle);
        Retailer nike = new Retailer("nike","nike.com", "/images/nike.jpg", shoes, sexy);
        nike.addCategory(sportsWear);
        retailerRepo.save(nike);

        // ADD REVIEWS
        // TODO: possibly change Review:@ManyToOne mapped by behaviour
        Review review1 = new Review("This is a review", 5, shein);
        Review review2 = new Review("This is a review 2", 2, shein);
        Review review3 = new Review("This is a review 3", 1, shein);
        shein.addReview(review1);
        shein.addReview(review2);
        shein.addReview(review3);
        reviewRepo.save(review1);
        reviewRepo.save(review2);
        reviewRepo.save(review3);
        retailerRepo.save(shein);

    }

}
