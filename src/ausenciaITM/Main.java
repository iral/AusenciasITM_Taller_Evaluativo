package ausenciaITM;

import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static int tam = 100;
    static Ausencia empleado[] = new Ausencia[tam];

    public static int buscar(String id, Fecha fecha) {
        for (int i = 0; i < empleado.length; i++) {
            if (empleado[i].getId_empleado() == id && empleado[i].getFecha() == fecha)
                return i;
        }
        return -1;
    }

    public static int buscar(Fecha fecha) {
        int dia = 0;
        for (int i = 0; i < empleado.length; i++) {
            if (empleado[i].getFecha == fecha)
                dia++;
        }
        return dia;
    }

    public static String motivo() {
        String motivo = "";
        int opc;
        System.out.println("Indica el numero de tu motivo de ausencia:");
        System.out.println("1. Personal");
        System.out.println("2. Academico");
        System.out.println("3. Calamidad");
        System.out.println("4. Compensatorio");
        opc = sc.nextInt();
        switch (opc) {
        case 1:
            motivo = "personal";
            break;
        case 2:
            motivo = "academico";
            break;
        case 3:
            motivo = "calamidad";
            break;
        case 4:
            motivo = "compensatorio";
            break;
        default:
            System.out.println("Has elejido una opcion incorrecta.");
            motivo();
            break;
        }
        return motivo;
    }

    public static void registrarAusencia() {
        int siguiente = 0;
        String id, motivo;
        int dia, mes, anyo, duracion;
        System.out.print("Ingresa tu ID: ");
        id = sc.next();
        motivo = motivo();
        System.out.println("Fecha:");
        System.out.print("Dia: ");
        dia = sc.nextInt();
        System.out.print("Mes: ");
        mes = sc.nextInt();
        System.out.print("Año: ");
        anyo = sc.nextInt();
        System.out.println("Dias de ausencia: ");
        duracion = sc.nextInt();

        if (siguiente < empleado.length) {
            empleado[siguiente] = new Ausencia(id, motivo, new Fecha(dia, mes, anyo), duracion);
            siguiente++;
        } else {
            System.out.println("Solo se pueden registrar 100 ausencias al mes.");
        }
    }

    public static int porcentajeAusencia() {
        String motivo;
        int cont = 0;
        motivo = motivo();
        for (int i = 0; i < empleado.length; i++) {
            if (empleado[i].getMotivo() == motivo) {
                cont++;
            }
        }
        return cont;
    }

    public static void listarAusenciasEmpleado() {
        int cont = 0;
        String id;
        System.out.print("Digitar el ID del empleado: ");
        id = sc.next();
        for (int i = 0; i < empleados.length; i++) {
            if (empleado[i].getId_empleado == id) {
                System.out.println(
                        "El empleado " + empleado[i].getId_empleado + "tiene ausecia el dia " + empleado[i].getFecha);
                cont++;
            }
        }
        System.out.println("Tiene un total de " + cont + " ausencias.");
    }

    public static int mesMayorAusencia() {
        int[] mes = new int[empleado.length];
        int aux;
        for (int i = 0; i < empleado.length; i++) {
            mes[i] = empleado[i].getFecha().getMes;
        }
        for (int k = 0; k < mes.length; k++) {
            for (int j = k + 1; j <= mes.length; j++) {
                if (mes[k] > mes[j]) {
                    aux = mes[k];
                    mes[k] = mes[j];
                    mes[j] = aux;
                }
            }
        }
        return mes[0];
    }

    public static void eliminarAusencia() {
        String id;
        int dia, mes, anyo, pos;
        Fecha fecha;
        System.out.print("Digite el ID del empleado: ");
        id = sc.next();
        System.out.println("Fecha que desea eliminar.");
        System.out.print("Dia: ");
        dia = sc.nextInt();
        System.out.print("Mes: ");
        mes = sc.nextInt();
        System.out.print("Año: ");
        anyo = sc.nextInt();
        fecha = new Fecha(dia, mes, anyo);
        pos = buscar(id, fecha);
        empleado[pos] = null;
        System.out.println("Se ha eliminado la fecha con exito.");
    }

    public static void modificarFechaAusencia() {
        String id;
        int dia, mes, anyo, pos;
        Fecha fecha;
        System.out.print("Digite el ID del empleado: ");
        id = sc.next();
        System.out.println("Fecha que desea modificar.");
        System.out.print("Dia: ");
        dia = sc.nextInt();
        System.out.print("Mes: ");
        mes = sc.nextInt();
        System.out.print("Año: ");
        anyo = sc.nextInt();
        fecha = new Fecha(dia, mes, anyo);
        pos = buscar(id, fecha);
        System.out.println("Nueva fecha");
        System.out.print("Dia: ");
        dia = sc.nextInt();
        System.out.print("Mes: ");
        mes = sc.nextInt();
        System.out.print("Año: ");
        empleado[pos].getFecha().setDia(dia);
        empleado[pos].getFecha().setMes(mes);
        empleado[pos].getFecha().setAnyo(anyo);
        System.out.println("La nueva fecha ingresada es: " + empleado[pos].getFecha());
    }

    public static void diasMotivo() {
        int personal = 0, academico = 0, calamidad = 0, compensatorio = 0;
        for (int i = 0; i < empleado.length; i++) {
            if (empleado[i].getMotivo() == "personal") {
                personal++;
            } else if (empleado[i].getMotivo() == "academico") {
                academico++;
            } else if (empleado[i].getMotivo() == "calamidad") {
                calamidad++;
            } else if (empleado[i].getMotivo() == "compensatorio") {
                compensatorio++;
            }
        }
        System.out.println("Personal: " + personal);
        System.out.println("Academico: " + academico);
        System.out.println("Calamidad: " + calamidad);
        System.out.println("Compensatorio: " + compensatorio);
    }

    public static void ausenciaDiaDeterminado() {
        int dia, mes, anyo, total;
        Fecha fecha;
        System.out.println("Ausencias de un dia determinado.");
        System.out.print("Dia: ");
        dia = sc.nextInt();
        System.out.print("Mes: ");
        mes = sc.nextInt();
        System.out.print("Año: ");
        anyo = sc.nextInt();
        fecha = new Fecha(dia, mes, anyo);
        total = buscar(fecha);
        System.out.println("El total de ausencia para el dia " + fecha.toString() + " es de " + total);
    }

    public static void main(String[] args) {

        boolean condiction = true;
        int option;

        do {

            System.out.println("Digite el numero de su opcion.");
            System.out.println("1. Registrar ausencia");
            System.out.println("2. Porcentaje de ausenciar de acuerdo el motivo");
            System.out.println("3. Listar ausencias del empleado");
            System.out.println("4. Mes con mayor ausencias");
            System.out.println("5. Eliminar ausencia");
            System.out.println("6. Modificar fecha");
            System.out.println("7. Cantidad de dias por cada motivo de ausencia");
            System.out.println("8. Listar las ausencias de un dia determinado");
            System.out.println("0. Salir");

            option = sc.nextInt();

            if (option < 0 && option > 8) {
                System.out.println("Elejir una opcion correcta.");
            } else {
                if (option == 0) {
                    condiction = false;
                }
            }

            switch (option) {
            case 1:
                registrarAusencia();
                break;
            case 2:
                porcentajeAusencia();
                break;
            case 3:
                listarAusenciasEmpleado();
                break;
            case 4:
                System.out.println("El mes con mas ausencias es: " + (mesMayorAusencia() + 1));
                break;
            case 5:
                eliminarAusencia();
                break;
            case 6:
                modificarFechaAusencia();
                break;
            case 7:
                diasMotivo();
                break;
            case 8:
                ausenciaDiaDeterminado();
                break;
            default:
                System.out.println("Su computador explotara en 5 segundos.");
                break;
            }

        } while (condiction);

    }

}