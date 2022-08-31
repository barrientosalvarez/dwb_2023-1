

import java.util.List;

/**
 * Clase CategoryManager que maneja objetos de la clase embebida Category.
 * @author Jorge Miguel Aaron Barrientos Alvarez
 * @since 28/Ago/2022
 */
public class CategoryManager{
   
    /**
     * Clase embebida Category que modela un objeto del tipo 'Categoria'
     */
    public class Category{
        
        /* Identificador para las categorias. */
        private String category_id;

        /* Nombre de la categoria. */
        private String category;

        /**
         * Constructor de la clase Category
         * @param id identificador de la categoria.
         * @param category nombre de la categoria.
         */ 
        public Category(String id, String category){
            this.category_id=id;
            this.category=category;
        }

        @Override
        public String toString(){
            return "{"+this.category_id+", "+this.category+"}";
        }

        public String getId(){
            return this.category_id;
        }

        public String getCategory(){
            return this.category;
        }
    }

    /* Lista de los registros de las categorias. */
    private static List<Category> registros;

    public Category(){
        registros=new List<Category>();
    }

    public void createCategory(String id, String name){
        if(checkId(id)){
            Category categoria=new Category(id, name);
            registros.add(categoria)
        }
        else{
            System.out.println("No se puede crear una categoria con id repetido.");
        }
    }

    private static Category checkId(String id){
        for(Category cat : registros){
            if(cat.getId().equals(id))
                return cat;
        }

        return null;
    }


    public void getCategories(){
        if(registros.isEmpty())
            System.out.println("No existen registros");

        else
            System.out.println(registros.toString());
    }

    public void getCategory(String id){
        Category cat=checkId(id)
        if(cat!=null)
            System.out.println(cat.toString());
        else
            System.out.println("No se encontro un registro con ese identificador.");
        
    }

    public void deleteCategory(String id){
        Category cat=checkId(id)
        if(cat!=null)
            registros.remove(cat);
        
        else
            System.out.println("No se encontro un regsitro con ese identificador.");
    }
}
