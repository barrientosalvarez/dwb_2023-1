package practica01;
import java.util.Scanner;

/**
 * Clase desde la que se le dara uso a la clase CategoryManager.
 * @author Jorge Miguel Aaron Barrientos Alvarez
 */
public class Main{
    /* Instancia estatica de Scanner, que nos permitira obtener datos desde
      la terminal*/
    private static Scanner sc=new Scanner(System.in);

    /* Instancia estatica de CategoryManager, que nos permitira acceder al 
      funcionamiento de la clase CategoryManager */
    private static CategoryManager catMan=new CategoryManager();

    /**
     * Metodo que nos permite emular un menu interactivo para darle uso al 
     * funcionamiento de la clase CategoryManager
     */
    public static void menu(){
        int seleccion=0;
        do{
            System.out.println("\nSelecciona una opcion:\n"
                    +"[1] Crear una categoria.\n"
                    +"[2] Ver todas las categorias existentes.\n"
                    +"[3] Ver una categoria en especifico (buscar por id).\n"
                    +"[4] Eliminar una categoria en especifico (por id).\n"
                    +"[5] Salir.");

            try{
                seleccion=sc.nextInt();
                switch(seleccion){
                    case 1:
                        createCategory();
                        break;

                    case 2:
                        catMan.getCategories();
                        break;

                    case 3:
                        getCategory();
                        break;

                    case 4:
                        deleteCategory();
                        break;


                    case 5:
                        System.out.println("\n\nTerminando ejecucion...");
                        break;

                    default:
                        System.out.println("Opcion invalida.\n\n");
                        seleccion=5;
                }

            }catch(Exception e){
                System.out.println("\nError de input\n");
                sc.next();
            }
        }while(seleccion!=5);
    }

    /** 
     * Metodo que nos permite solicitar informacion al usuario atraves de terminal,
     * para posteriormente llamar al metodo 'createCategory' de la clase CategoryManeger
     * con la informacion recibida por el usuario.
     */
    public static void createCategory(){
        sc.nextLine();
        System.out.println("\nIngresa el id: ");
        String id=sc.nextLine();
        id=id.replaceAll("\\s", "");
        System.out.println("\nIngresa el nombre: ");
        String name=sc.nextLine();
        int respuesta=catMan.createCategory(id, name);
        if(respuesta==0)
            System.out.println("\n\nCategoria creada correctamente\n");
    }

    /** 
     * Metodo que nos permite solicitar informacion al usuario atraves de terminal,
     * para posteriormente llamar al metodo 'getCategory' de la clase CategoryManeger
     * con la informacion recibida por el usuario.
     */
    public static void getCategory(){
        sc.nextLine();
        System.out.println("\nIngresa el id de la categoria a buscar:");
        String id=sc.nextLine();
        catMan.getCategory(id);
    }

    /** 
     * Metodo que nos permite solicitar informacion al usuario atraves de terminal,
     * para posteriormente llamar al metodo 'deleteCategory' de la clase CategoryManeger
     * con la informacion recibida por el usuario.
     */
    public static void deleteCategory(){
        sc.nextLine();
        System.out.println("\nIngresa el id de la categoria a eliminar:");
        String id=sc.nextLine();
        int respuesta=catMan.deleteCategory(id);
        if(respuesta==0)
            System.out.println("\n\nRegistro eliminado correctamente\n\n");
    }

    /** 
     * Main de la clase, llama al metodo 'menu'.
     */
    public static void main(String[] args){
        menu();
    }
}
