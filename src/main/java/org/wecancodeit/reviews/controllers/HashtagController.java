package org.wecancodeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.reviews.repos.HashtagRepository;

@Controller
public class HashtagController {

    private HashtagRepository hashtagRepo;

    public HashtagController(HashtagRepository hashtagRepo) {
        this.hashtagRepo = hashtagRepo;
    }
@RequestMapping("hashtags/{id}")
    public String showHashtag(Model model, @PathVariable long id){
        model.addAttribute("Hashtag",hashtagRepo.findById(id).get());
        return "hashtag";
}


}
