package com.product.api.entity;

public class Category{
    
    private int category_id;

    private String category;

    private int status;

    public Category(int category_id, String category, int status){
        this.category_id=category_id;
        this.category=category;
        this.status=status;
    }

    public int getCategory_id(){
        return this.category_id;
    }

    public String getCategory(){
        return this.category;
    }

    public int getStatus(){
        return this.status;
    }

    @Override
    public String toString(){
        return "{category_id="+category_id+", category="+category+", status="+status+"}";
    }

    @Override
    public boolean equals(Object o){
        if(this==o)
            return true;

        if(o==null || this.getClass()!=o.getClass())
            return false;

        @SuppressWarnings("unchecked") Category c = (Category) o;
        
        if(this.getCategory_id()!=c.getCategory_id())
            return false;

        if(this.getCategory()!=c.getCategory())
            return false;

        //if(this.getStatus()!=c.getStatus())
            //return false;

        return true;
    }
        
}
