package practica01;

import java.util.List;
import java.util.ArrayList;

/**
 * Clase CategoryManager que maneja objetos de la clase embebida Category.
 * @author Jorge Miguel Aaron Barrientos Alvarez
 * @since 28/Ago/2022
 */
public class CategoryManager{
   
    /**
     * Clase embebida Category que modela un objeto del tipo 'Categoría'
     */
    public class Category{
        
        /* Identificador para las categorías. */
        private String category_id;

        /* Nombre de la categoría. */
        private String category;

        /**
         * Constructor de la clase Category
         * @param id identificador de la categoría.
         * @param category nombre de la categoría.
         */ 
        public Category(String id, String category){
            this.category_id=id;
            this.category=category;
        }

        @Override
        public String toString(){
            return "{"+this.category_id+", "+this.category+"}";
        }

        /**
         * Metodo geter para el id de las categorías.
         * @return el id de la categoria que invoca el método.
         */
        public String getId(){
            return this.category_id;
        }

        /**
         * Metodo geter para el nombre de las categorias.
         * @return el nombre de la categoria que invoca el metodo.
         */
        public String getCategory(){
            return this.category;
        }
    }

    /* Lista de los registros de las categorias. */
    private static List<Category> registros;

    /**
     * Constructor de la clase CategoryManager: inicializa a la variable 'registros'
     * para poder comenzar a guardas los registros de las instancias de Category.
     */
    public CategoryManager(){
        registros=new ArrayList<Category>();
    }

    /**
     * Metodo que crea una categoria, creando una instancia de Category; la instancia
     * es almacenada en la variable registros. Si se recibe un 'id' repetido
     * la categoria no puede ser creada y se le informa al usuario atraves de 
     * un mensaje de texto.
     * @param id el id de la categoria que se quiere crear.
     * @param name el nombre de la categoria que se quiere crear.
     * @return 0 si la categoria fue creada correctamente (creada y agregada a 
     *         'registros'), -1 en otro caso.
     */
    public int createCategory(String id, String name){
        if(checkId(id)==null){
            Category categoria=new Category(id, name);
            registros.add(categoria);
            return 0;
        }
        else{
            System.out.println("\nNo se puede crear una categoria con id repetido.\n");
            return -1;
        }
    }

    /**
     * Metodo auxiliar que nos permite verificar si ya tenemos un registro de una
     * categoria con un id en especifico; sirve para no crear categorias distintas
     * con un mismo identificador
     * @param id el id que se verificara si existe o no existe en los registros.
     * @return si el id ya existe con anterioridad, se regresara a la instancia de
     *         Category que cuenta con dicho identificador; si no se encuentra un registro
     *         que contenga al identificador id, se regresa <code>null</code>
     */
    private static Category checkId(String id){
        for(Category cat : registros){
            if(cat.getId().equals(id))
                return cat;
        }

        return null;
    }

    /**
     * Metodo que muestra en pantalla todas las instancias de Category de las que
     * se tiene registro hasta el momento. En caso de no existir ningun registro,
     * notifica atraves de un mensaje que no existen registros.
     */
    public void getCategories(){
        if(registros.isEmpty())
            System.out.println("\nNo existen registros\n");

        else
            System.out.println("\nRegistros actuales: "+registros.toString());
    }

    /**
     * Metodo que muestra una categoria en especifico; la categoria es buscada dentro
     * de nuestros registros usando como valor de referencia su identificador.
     * @param id id de la categoria que se quiere mostrar en pantalla.
     */
    public void getCategory(String id){
        Category cat=checkId(id);
        if(cat!=null)
            System.out.println("\nCategoria con el identificador "+id+ ": "+cat.toString());
        else
            System.out.println("\nNo se encontro un registro con ese identificador.\n");
        
    }

    /**
     * Metodo que elimina una categoria en especifico de los registros de categorias.
     * La categoria a eliminar se encuentra usando como valor de referencia su 
     * identificarod.
     * @param id el identificador de la categoria que se busca eliminar.
     * @return 0 si el registro de la categoria fue eliminado correctamente, -1 en
     * otro caso (cuando no se encontro ningun registro que coincidiera con el 
     * identificador proporcionado por el usuario).
     */
    public int deleteCategory(String id){
        Category cat=checkId(id);
        if(cat!=null){
            registros.remove(cat);
            return 0;
        }
        
        else{
            System.out.println("\nNo se encontro un regsitro con ese identificador.\n");
            return -1;
        }
    }
}
