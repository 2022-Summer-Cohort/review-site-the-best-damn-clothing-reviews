package org.wecancodeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.reviews.model.Hashtag;
import org.wecancodeit.reviews.repos.RetailerRepository;
@Controller
@RequestMapping("/retailers")
public class RetailerController {
    private RetailerRepository retailerRepo;
    public RetailerController(RetailerRepository retailerRepo) {
        this.retailerRepo = retailerRepo;
    }
    @RequestMapping("/{id}")

    public String showRetailer(Model model, @PathVariable long id){
        model.addAttribute("Retailer",retailerRepo.findById(id).get());
        return "retailer";
    }


}
