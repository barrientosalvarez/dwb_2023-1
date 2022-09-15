package com.product.api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.api.entity.Category;

@RestController
@RequestMapping("/category")
public class CtrlCategory{

    private static List<Category> categorias=new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<Category>> getCategories(){
        if(categorias.isEmpty()){
            Category cat1=new Category(1, "Auto", 1);
            Category cat2=new Category(2, "Nave", 1);
            Category cat3=new Category(3, "Avion", 1);
            Category cat4=new Category(4, "Barco", 1);
            Category cat5=new Category(5, "Motocicleta", 1);
            categorias.add(cat1);
            categorias.add(cat2);
            categorias.add(cat3);
            categorias.add(cat4);
            categorias.add(cat5);
        }

        return new ResponseEntity<>(categorias, HttpStatus.OK);
    }

    @GetMapping("/{category_id}")
    public ResponseEntity<Integer> getCategory(@PathVariable Integer category_id){
        return new ResponseEntity<>(category_id, HttpStatus.OK);
    }

    private static boolean esIgual(Category cat, Category c){
        if(cat.getCategory_id()!=c.getCategory_id())
            return false;

        if(!(cat.getCategory().equals(c.getCategory())))
            return false;

        return true;
    }

    @PostMapping
    public ResponseEntity<String> createCategory(@Valid @RequestBody Category c){
        String mensaje="category created";
        for(Category cat : categorias){
            if(esIgual(cat,c)){
                mensaje="category already exist";
                return new ResponseEntity<>(mensaje, HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String> updateCategory(@Valid @RequestBody Category c){
        String mensaje="category does not exist";

        for(Category cat : categorias){
            if(esIgual(cat, c)){
                mensaje="category updated";
                return new ResponseEntity<>(mensaje, HttpStatus.OK);
            }
        }

        return new ResponseEntity<>(mensaje, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{category_id}")
    public ResponseEntity<String> deleteCategory(@PathVariable int category_id){
        String mensaje="category does not exist";

        for(Category cat : categorias){
            if(cat.getCategory_id()==category_id){
                mensaje="category removed";
                return new ResponseEntity<>(mensaje, HttpStatus.OK);
            }
        }

        return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);

    }

}
