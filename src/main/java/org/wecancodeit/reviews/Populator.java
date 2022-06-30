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

        // GENERATE HASHTAGS
        Hashtag fresh = new Hashtag("#fresh");
        Hashtag sexy = new Hashtag("#sexy");
        Hashtag designer = new Hashtag("#designer");
        Hashtag fashion = new Hashtag("#fashionable");
        Hashtag stylish = new Hashtag("#stylish");
        Hashtag ootd = new Hashtag("#ootd");
        Hashtag mwslm = new Hashtag("#myWifeStillLeftMe");
        hashtagRepo.save(fresh);
        hashtagRepo.save(sexy);
        hashtagRepo.save(designer);
        hashtagRepo.save(fashion);
        hashtagRepo.save(stylish);
        hashtagRepo.save(ootd);
        hashtagRepo.save(mwslm);

        // GENERATE CATEGORIES
        Category mens = new Category("mens clothing");
        Category womens = new Category("womens clothing");
        Category shoes = new Category("shoes");
        Category kids  = new Category("kids clothing");
        Category jewelery = new Category("jewelery");
        Category sportsWear = new Category("sportsWear");
        categoryRepo.save(shoes);
        categoryRepo.save(womens);
        categoryRepo.save(mens);
        categoryRepo.save(kids);
        categoryRepo.save(jewelery);
        categoryRepo.save(sportsWear);


        // RETAILER CATEGORIES
        Category[] cat1 = {womens,shoes};
        Category[] cat2 = {shoes,kids};
        Category[] cat3 = {jewelery};
        Category[] cat4 = {mens, womens, shoes, kids, jewelery, sportsWear};
        Category[] cat5 = {womens};
        Category[] cat6 = {shoes, mens, womens};
        Category[] cat7 = {shoes, sportsWear};

        // GENERATE RETAILERS
        Retailer shein = new Retailer("Shein","shein.com", "/images/shein-logo.jpg", womens, designer, sexy);
        Retailer dsw = new Retailer("dsw","dsw.com", "/images/DSW.png",cat2, sexy, stylish, fashion);
        Retailer blueNile = new Retailer("Blue Nile","bluenile.com", "/images/blueNileLogo.png", jewelery, sexy, stylish, mwslm);
        Retailer kohls = new Retailer("kohls","kohls.com", "/images/Kohls.jpg", cat4, ootd);
        Retailer fashionNova = new Retailer("fashion Nova","fashionNova.com", "/images/fashionnova.jpg", womens, ootd, designer);
        Retailer shoeDazzle = new Retailer("shoe Dazzle","shoeDazzle.com", "/images/shoedazzle.jpg", cat6, stylish, fresh);
        Retailer nike = new Retailer("nike","nike.com", "/images/nike.jpg", cat7, fresh, fashion);

        shein.addCategory(shoes);
        retailerRepo.save(shein);
        retailerRepo.save(blueNile);
        retailerRepo.save(dsw);
        retailerRepo.save(kohls);
        retailerRepo.save(fashionNova);
        retailerRepo.save(shoeDazzle);
        retailerRepo.save(nike);

        // ADD REVIEWS
        // TODO: possibly change Review:@ManyToOne mapped by behaviour
        Review review1 = new Review("At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium ", 5, shein);
        Review review2 = new Review("At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium", 2, shein);
        Review review3 = new Review("This is a review", 1, shein);
        Review review4 = new Review("I bought a $2,599 necklace and my wife still left me.", 1, blueNile);
        shein.addReview(review1);
        shein.addReview(review2);
        shein.addReview(review3);
        blueNile.addReview(review4);

        reviewRepo.save(review1);
        reviewRepo.save(review2);
        reviewRepo.save(review3);
        reviewRepo.save(review4);

        retailerRepo.save(shein);
        retailerRepo.save(blueNile);

    }

}
