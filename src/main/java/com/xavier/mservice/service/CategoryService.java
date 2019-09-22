package com.xavier.mservice.service;

import com.xavier.mservice.model.Category;
import com.xavier.mservice.repository.CategoryRepository;
import com.xavier.mservice.service.exception.CategoryExistException;
import com.xavier.mservice.service.exception.CategoryNotFoundException;
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

    public void delete(Long categoryId) {
        verifyIfCategoryNotExist(categoryId);
        categoryRepository.deleteById(categoryId);
    }

    private void verifyIfCategoryNotExist(Long categoryId) {
        Optional<Category> foundCategory = categoryRepository.findById(categoryId);
        if (!foundCategory.isPresent()) {
            throw new CategoryNotFoundException();
        }
    }


    private void verifyIfCategoryExist(Category category) {
        Optional<Category> foundCategory = categoryRepository.findByName(category.getName());
        if (foundCategory.isPresent() && (category.isNew() || isUpdatingToADifferentCategory(category, foundCategory))) {
            throw new CategoryExistException();
        }
    }

    private boolean isUpdatingToADifferentCategory(Category category, Optional<Category> foundCategory) {
        return category.exist() && !(category.equals(foundCategory.get()));
    }
}
