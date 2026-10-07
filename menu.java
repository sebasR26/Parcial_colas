import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class menu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<obj> c = new LinkedList<>();
        metodos m = new metodos();

        boolean con = true;

        while (con) {
            System.out.println("MENU\n");
            System.out.println("1- Registrar clientes");
            System.out.println("2- Cancelar turno (Abandonar fila)");
            System.out.println("3- Cambiar de caja");
            System.out.println("4- Atender");
            System.out.println("5- Mostrar clientes");
            System.out.println("6- Salir");
            int op = m.ValidarEentero(sc);

            switch (op) {
                case 1:
                    m.registrar(c, sc);
                    
                    break;
                case 2:
                    m.cancelarTurno(c, sc);
                    
                    break;
                case 3:
                    m.CambioCaja(c, sc);
                    
                    break;
                case 4:
                    m.Atender(c, sc);
                    
                    break;
                case 5:
                    m.MostrarClientes(c);
                    
                    break;
                case 6:
                    System.out.println("Hasta luego");
                    con = false;
                    
                    break;
            
                default:
                    System.out.println("opcion no valida");
                    break;
            }
            
        }

    }

    
    
}
