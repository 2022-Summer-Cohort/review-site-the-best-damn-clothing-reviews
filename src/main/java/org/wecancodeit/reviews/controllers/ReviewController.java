package org.wecancodeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.wecancodeit.reviews.repos.RetailerRepository;
import org.wecancodeit.reviews.repos.ReviewRepository;

@Controller
public class ReviewController {
    private ReviewRepository reviewRepo;
    private RetailerRepository retailerRepo;

    public ReviewController(ReviewRepository reviewRepo, RetailerRepository retailerRepo) {
        this.reviewRepo = reviewRepo;
        this.retailerRepo = retailerRepo;
    }
}


