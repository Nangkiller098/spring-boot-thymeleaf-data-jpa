package com.dinsaren.springbootthymeleaf.controller;

import com.dinsaren.springbootthymeleaf.models.Category;
import com.dinsaren.springbootthymeleaf.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/list")
    public String index(Model model){
        System.out.println(categoryService.findAllData());
        model.addAttribute("categories", categoryService.findAllData());
        return "admin/category/index";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("category", new Category());
        return "admin/category/form";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Category category){
        System.out.println(category);
        categoryService.create(category);
        return "redirect:/admin/category/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        model.addAttribute("category", categoryService.getById(id));
        return "admin/category/update";
    }

    // Update operation
    @PutMapping("/update/{id}")
    public Category
    update(@RequestBody Category category,
                     @PathVariable("id") Integer id)
    {
        return categoryService.update(category, id);
    }

    // Delete operation
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id)
    {
        categoryService.delete(id);
        return "Deleted Successfully";
    }

}
