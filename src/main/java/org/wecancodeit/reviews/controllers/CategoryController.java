package org.wecancodeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.reviews.repos.CategoryRepository;

import java.util.List;

@Controller
public class CategoryController {
    private CategoryRepository categoryRepo;

    public CategoryController(CategoryRepository categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @RequestMapping("categories/{id}")
    public String showCategory(Model model, @PathVariable long id) {
        model.addAttribute("category",categoryRepo.findById(id).get());
        return "category";
    }
    @RequestMapping("/")
    public String allCategories(Model model){
        model.addAttribute("categories", categoryRepo.findAll());
        return "categories";
    }

}
