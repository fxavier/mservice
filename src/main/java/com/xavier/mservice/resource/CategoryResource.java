package com.xavier.mservice.resource;

import com.xavier.mservice.model.Category;
import com.xavier.mservice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryResource {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<Category> findAll() {
        return categoryService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Category create(@Valid @RequestBody Category category) {
        return categoryService.save(category);
    }

    @PutMapping("/{categoryId}")
    public Category update(@PathVariable Long categoryId, @Valid @RequestBody Category category) {
        category.setCategoryId(categoryId);
        return categoryService.save(category);
    }

    @DeleteMapping("/{categoryId}")
    public void remove(@PathVariable Long categoryId) {
        categoryService.delete(categoryId);
    }

}
