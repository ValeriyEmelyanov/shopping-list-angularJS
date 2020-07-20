package com.example.service;

import com.example.persist.ShoppingItem;
import com.example.persist.ShoppingItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingItemService {
    ShoppingItemRepository repository;

    @Autowired
    public ShoppingItemService(ShoppingItemRepository repository) {
        this.repository = repository;
    }

    public ShoppingItem save(ShoppingItem item) {
        return repository.save(item);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }

    public List<ShoppingItem> findAll() {
        return repository.findAll();
    }
}
