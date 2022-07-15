package org.wecancodeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.wecancodeit.reviews.model.Hashtag;
import org.wecancodeit.reviews.model.Retailer;
import org.wecancodeit.reviews.model.Review;
import org.wecancodeit.reviews.repos.HashtagRepository;
import org.wecancodeit.reviews.repos.RetailerRepository;
import org.wecancodeit.reviews.repos.ReviewRepository;

import java.util.Optional;

@Controller

public class RetailerController {
    private RetailerRepository retailerRepo;
    private HashtagRepository hashtagRepo;
    private ReviewRepository reviewRepo;

    public RetailerController(RetailerRepository retailerRepo, HashtagRepository hashtagRepo, ReviewRepository reviewRepo) {
        this.retailerRepo = retailerRepo;
        this.hashtagRepo = hashtagRepo;
        this.reviewRepo = reviewRepo;
    }

    @RequestMapping("/retailer/{id}")
    public String showRetailer(Model model, @PathVariable long id) {
        model.addAttribute("retailer", retailerRepo.findById(id).get());
        return "retailer";
    }

    @PostMapping("/retailer/{id}/addHashtag")
    public String addHashtagToRetailer(@PathVariable Long id, @RequestParam String hashtag) {
        Retailer retailer = retailerRepo.findById(id).get();
        Optional<Hashtag> hashtagOptional = hashtagRepo.findByNameIgnoreCase(hashtag);
        if (hashtagOptional.isPresent()) {
            if (!retailer.getHashtags().contains(hashtagOptional.get())) {
                retailer.addHashtag(hashtagOptional.get());
            }
        }
        else {
            Hashtag hashtag1 = new Hashtag(hashtag);
            hashtagRepo.save(hashtag1);
            retailer.addHashtag(hashtag1);
        }
        retailerRepo.save(retailer);
        return "redirect:/retailer/" + id;
    }
    @PostMapping("/retailer/{id}/addReview")
    public String addReviewToRetailer(@PathVariable Long id, @RequestParam Integer rating, @RequestParam String review){
        Retailer retailer = retailerRepo.findById(id).get();
        Review newReview = new Review(review, rating, retailer);
        reviewRepo.save(newReview);
        retailer.addReview(newReview);
        retailerRepo.save(retailer);
        return "redirect:/retailer/" + id;
    }


}
