package org.wecancodeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.wecancodeit.reviews.model.Hashtag;
import org.wecancodeit.reviews.model.Retailer;
import org.wecancodeit.reviews.repos.HashtagRepository;
import org.wecancodeit.reviews.repos.RetailerRepository;

import java.util.Optional;

@Controller
@RequestMapping("/retailer")
public class RetailerController {
    private RetailerRepository retailerRepo;
    private HashtagRepository hashtagRepo;

    public RetailerController(RetailerRepository retailerRepo, HashtagRepository hashtagRepo) {
        this.retailerRepo = retailerRepo;
        this.hashtagRepo = hashtagRepo;
    }

    @RequestMapping("/{id}")
    public String showRetailer(Model model, @PathVariable long id) {
        model.addAttribute("retailer", retailerRepo.findById(id).get());
        return "retailer";


    }

    @PostMapping("/{id}/addHashtag")
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
}
