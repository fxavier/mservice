package com.xavier.mservice.service;

import com.xavier.mservice.model.Category;
import com.xavier.mservice.repository.CategoryRepository;
import com.xavier.mservice.service.exception.CategoryExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryService(@Autowired CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category save(final Category category) {
        verifyIfCategoryExist(category);
        return categoryRepository.save(category);
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }


    private void verifyIfCategoryExist(Category category) {
        Optional<Category> foundCategory = categoryRepository.findByCategoryName(category.getCategoryName());
        if (foundCategory.isPresent() && (category.isNew() || isUpdatingToADifferentCategory(category, foundCategory))) {
            throw new CategoryExistException();
        }
    }

    private boolean isUpdatingToADifferentCategory(Category category, Optional<Category> foundCategory) {
        return category.exist() && !(category.equals(foundCategory.get()));
    }
}
