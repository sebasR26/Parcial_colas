
import java.util.Queue;
import java.util.Scanner;



public class metodos {

    public Queue<obj> registrar(Queue<obj> c, Scanner sc) {
        metodos m = new metodos();
        boolean con = true;

        while (con) {
            obj o = new obj();

            System.out.println("ingrese Id de cliente: ");
            o.setId(sc.next());
            System.out.println("Ingrese tipo de servicio: ");
            o.setServicio(m.MenuTramite(sc));
            o.setState(1);
            System.out.println("en que caja esta?");
            o.setCaja(m.ValidarEentero(sc));

            System.out.println("agregar otro cliente? 1-SI o 2-NO");
            int op = m.ValidarEentero(sc);
            if (op == 2) {
                con = false;

            }

            c.offer(o);

        }

        return c;

    }

    private int MenuTramite(Scanner sc) {
        metodos m = new metodos();

        System.out.println("1- Pagar");
        System.out.println("2- Pedir informacion");

        return m.ValidarEentero(sc);

    }

    public int ValidarEentero(Scanner sc) {

        while (!sc.hasNextInt()) {
            System.out.println(
                    "Por favor ingrese un numero ENTERO");
            sc.next();
        }
        return sc.nextInt();
    }

    public String CancelarTurno(Queue<obj> c, Scanner sc) {
        
        System.out.println("ingrese el id del cliente: ");
        String id = sc.next();
        for (obj o : c) {
            if (o.getId().equals(id)) {
                c.remove();
                System.out.println("eliminado");

            }

        }

        return "";
    }

    

    public String CambioCaja(Queue<obj> c, Scanner sc) {
        metodos m = new metodos();
        System.out.println("ingrese el id del cliente: ");
        String id = sc.next();
        for (obj o : c) {
            if (o.getId().equals(id)) {
                System.out.println("a cual caja desea cambiar?");
                int op = m.ValidarEentero(sc);
                o.setCaja(op);

            }

        }

        return "cambio exitoso";
    }

    public Queue<obj> Atender(Queue<obj> c, Scanner sc) {
        metodos m = new metodos();

        for (obj o : c) {
            if (o.getState() == 1) {
                System.out.println("por cual caja fue atendido?");
                int op = m.ValidarEentero(sc);
                o.setCaja(op);

                o.setState(2);
                break;
            }
        }
        System.out.println("Turno atendido correctamente ");
        return c;
    }

    public String MostrarClientes(Queue<obj> c) {

        if (c.isEmpty()) {
            System.out.println("\nno hay clientes\n");
        }

        for (obj o : c) {

            System.out.println("Id: " + o.getId());
            System.out.println("Servicio: " + o.getServicio());
            System.out.println("Estado: " + o.getState());
            System.out.println("Caja: " + o.getCaja());
            System.out.println("----------------------------------");

        }

        return "Mostrado con exito";

    }

}
