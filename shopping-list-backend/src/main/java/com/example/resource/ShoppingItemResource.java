package com.example.resource;

import com.example.persist.ShoppingItem;
import com.example.service.ShoppingItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("http://localhost:63342")
@RequestMapping("/api/v1/item")
@RestController
public class ShoppingItemResource {
    ShoppingItemService service;

    @Autowired
    public ShoppingItemResource(ShoppingItemService service) {
        this.service = service;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ShoppingItem create(@RequestBody ShoppingItem item) {
        return service.save(item);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable("id") long id) {
        service.delete(id);
    }

    @GetMapping(path = "/all", produces = "application/json")
    public List<ShoppingItem> findAll() {
        return service.findAll();
    }
}
