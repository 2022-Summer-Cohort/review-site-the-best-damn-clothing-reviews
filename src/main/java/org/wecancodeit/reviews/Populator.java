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
        Review review1 = new Review("I wish I would have thought of it first. We can't understand how we've been living without Shein. I will refer everyone I know. Thank You!", 5, shein);
        Review review2 = new Review("I use Shein often.", 2, shein);
        Review review3 = new Review("Man, this thing is getting better and better as I learn more about it. Thank you for making it painless, pleasant and most of all hassle free!", 4, shein);
        Review review4 = new Review("I will refer everyone I know. I am really satisfied with my Blue Nile.", 5, blueNile);
        Review review5 = new Review("Very easy to use. Thanks to Blue Nile, we've just launched our 5th website! Blue Nile should be nominated for service of the year. Really good.", 4, blueNile);
        Review review6 = new Review("I bought a $2,599 necklace and my wife still left me.", 1, blueNile);
        Review review7 = new Review("asdfasdfa", 1, dsw);
        Review review8 = new Review("Great job, I will definitely be ordering again! I would like to personally thank you for your outstanding product.", 4, dsw);
        Review review9 = new Review("DSW is the most valuable business resource we have EVER purchased.", 2, dsw);
        Review review10 = new Review("Kohls is the most valuable business resource we have EVER purchased. Absolutely wonderful! Since I invested in Kohls I made over 100,000 dollars profits.", 3, kohls);
        Review review11 = new Review("Kohls has got everything I need. I will let my mum know about this, she could really make use of Kohls!", 3, kohls);
        Review review12 = new Review("Keep up the excellent work. Thank you so much for your help. Not able to tell you how happy I am with Kohls.", 4, kohls);
        Review review13 = new Review("I didn't even need training. Fashion Nova is the most valuable business resource we have EVER purchased.", 4, fashionNova);
        Review review14 = new Review("Really good.", 5, fashionNova);
        Review review15 = new Review("This is simply unbelievable!", 4, fashionNova);
        Review review16 = new Review("Needless to say we are extremely satisfied with the results. Without Shoe Dazzle, we would have gone bankrupt by now. I could probably go into sales for you.", 3, shoeDazzle);
        Review review17 = new Review("The service was excellent. We've seen amazing results already.", 4, shoeDazzle);
        Review review18 = new Review("The very best. I will let my mum know about this, she could really make use of Shoe Dazzle! I would like to personally thank you for your outstanding product.", 2, shoeDazzle);
        Review review19 = new Review("Nike should be nominated for service of the year.", 2, nike);
        Review review20 = new Review("We have no regrets! You've saved our business! I would gladly pay over 600 dollars for Nike. Nike is the most valuable business resource we have EVER purchased.", 4, nike);
        Review review21 = new Review("The best on the net!", 5, nike);

        shein.addReview(review1);
        shein.addReview(review2);
        shein.addReview(review3);
        blueNile.addReview(review4);
        blueNile.addReview(review5);
        blueNile.addReview(review6);
//        dsw.addReview(review7);
//        dsw.addReview(review7);
//        dsw.addReview(review8);
//        dsw.addReview(review9);
//        kohls.addReview(review10);
//        kohls.addReview(review11);
//        kohls.addReview(review12);
        fashionNova.addReview(review13);
        fashionNova.addReview(review14);
        fashionNova.addReview(review15);
//        shoeDazzle.addReview(review16);
//        shoeDazzle.addReview(review17);
//        shoeDazzle.addReview(review18);
//        nike.addReview(review19);
//        nike.addReview(review20);
//        nike.addReview(review21);

        reviewRepo.save(review1);
        reviewRepo.save(review2);
        reviewRepo.save(review3);
        reviewRepo.save(review4);
        reviewRepo.save(review5);
        reviewRepo.save(review6);
        reviewRepo.save(review7);
        reviewRepo.save(review8);
        reviewRepo.save(review9);
        reviewRepo.save(review10);
        reviewRepo.save(review11);
        reviewRepo.save(review12);
        reviewRepo.save(review13);
        reviewRepo.save(review14);
        reviewRepo.save(review15);
        reviewRepo.save(review16);
        reviewRepo.save(review17);
        reviewRepo.save(review18);
        reviewRepo.save(review19);
        reviewRepo.save(review20);
        reviewRepo.save(review21);

        retailerRepo.save(shein);
        retailerRepo.save(blueNile);
        retailerRepo.save(dsw);
        retailerRepo.save(kohls);
        retailerRepo.save(fashionNova);
        retailerRepo.save(shoeDazzle);
        retailerRepo.save(nike);

    }

}
