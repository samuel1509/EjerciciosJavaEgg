
import java.util.Scanner;

/**
 * Ejercicios II
 * Escribir un programa en Java que permita al
 * usuario realizar diversas operaciones con una oración.
 * El programa debe cumplir con los siguientes requisitos:
 * 1. Mostrar un menú de opciones al usuario donde podrá:
 * a) "Crear oración" o "Borrar oración": Si la oración
 * está vacía, mostrar el mensaje "Crear oración".
 * Si la oración tiene contenido, mostrar el mensaje
 * "Borrar oración".
 * b) "Cantidad de caracteres de la oración": Calcular y
 * mostrar la cantidad total de caracteres en la
 * oración (incluyendo espacios).
 * c) "Cantidad de palabras de la oración": Calcular y
 * mostrar la cantidad de palabras en la oración.
 * d) "Mostrar palabras ordenadas alfabéticamente": Mostrar
 * las palabras de la oración ordenadas alfabéticamente.
 * e) "Ingresar un número y devolver la palabra correspondiente":
 * Solicitar al usuario ingresar un número y mostrar la palabra
 * correspondiente a esa posición en la oración. Si se ingresa
 * un número fuera del rango de número de palabras
 * (la primera palabra corresponde al número 1), mostrar el
 * mensaje "Número inválido. Intente nuevamente".
 * f) "Buscar palabra dentro de la oración": Solicitar al usuario
 * ingresar una palabra y verificar si esa palabra se encuentra
 * en la oración. Mostrar un mensaje indicando si la palabra fue
 * encontrada y la posición en la que se encuentra.
 * g) "Modificar palabra dentro de la oración": Solicitar al usuario
 * ingresar la palabra que se quiere cambiar, mostrar un mensaje
 * de error si no se encuentra y volver a solicitar la palabra.
 * Si la palabra es correcta, solicitar una nueva palabra (o frase)
 * y reemplazar la anterior. Mostrar la nueva oración modificada
 * (recuerda validar que solo contenga letras y espacios).
 * h) "Agregar contenido a la oración": Solicitar al usuario ingresar
 * contenido y agregar ese contenido al final de la oración.
 * i) "Salir": Terminar el programa.
 * 2. Después de realizar una operación, mostrar el menú de opciones
 * nuevamente para que el usuario pueda elegir otra acción, excepto
 * cuando elija "Salir".
 */

public class GestorOracion {
    public static void main(String[] args) {
        boolean salir = false;
        String oracion = null;
        String[] palabras = null;
        int opcionMenu;
        Scanner scan = null;
        do {
            try {
                scan = new Scanner(System.in);
                System.out.println("Menu Oraciones");
                System.out.println("[1] Crear oracion");
                System.out.println("[2] Borrar oracion");
                System.out.println("[3] Cantidad caracteres");
                System.out.println("[4] Cantidad de palabras");
                System.out.println("[5] Ordenar palabras (A->Z)");
                System.out.println("[6] Buscar palabra por nro indice");
                System.out.println("[7] Buscar palabra por texto");
                System.out.println("[8] Modificar palabra");
                System.out.println("[9] Agregar contenido");
                System.out.println("------------------------");
                System.out.println("[0] Salir!!");
                System.out.println("------------------------");
                if (oracion != null)
                    System.out.println(oracion);
                System.out.println("------------------------");
                System.out.print("Ingrese opcion de menu: ");
                opcionMenu = scan.nextInt();
                scan.nextLine();
                switch (opcionMenu) {
                    case 0:// salida del menu
                        salir = true;
                        break;
                    case 1:// Crear oracion
                        if (oracion == null) {
                            System.out.print("Igrese una nueva oracion:");
                            oracion = scan.nextLine();
                            System.out.println("La oracion ingresada es: " + oracion);
                        } else {
                            System.out.println("Ya tiene ingresada una oracion");
                        }
                        break;
                    case 2:// Borrar oracion
                        if (oracion != null) {
                            System.out.println("La oracion a borrar es: " + oracion);
                            // scan,nextLine;
                            oracion = null;
                            System.out.println("Oracion Borrada!!!");
                        } else {
                            System.out.println("No hay oracion");
                        }
                        break;
                    case 3:// Cantidad caracteres
                        if (oracion != null) {
                            System.out.println("La oracion tiene: " + oracion.length() + " caracteres");
                        } else {
                            System.out.println("No hay oracion");
                        }
                        break;
                    case 4:// Cantidad de palabras
                        if (oracion != null) {
                            palabras = oracion.split(" ");
                            System.out.println("La oracion tiene: " + palabras.length + " palabras");
                            // muestra las palabra por separado. El separador sera el espacion blanco " "
                            for (int i = 0; i < oracion.split(" ").length; i++) {
                                System.out.println("[" + (i + 1) + "]" + palabras[i]);
                            }
                        } else {
                            System.out.println("No hay oracion");
                        }
                        break;
                    case 5:// Ordenar palabras
                        if (oracion != null) {
                            palabras = oracion.split(" ");
                            for (int i = 0; i < palabras.length; i++) {
                                for (int j = 0; j < palabras.length; j++) {
                                    if (palabras[i].compareTo(palabras[j].toLowerCase()) < 0) {
                                        String aux = palabras[i];
                                        palabras[i] = palabras[j];
                                        palabras[j] = aux;
                                        continue;
                                    }
                                }
                            }
                            System.out.println("Palabras ordenadas (a->z)");
                            for (int i = 0; i < palabras.length; i++) {
                                System.out.println("[" + (i + 1) + "]" + palabras[i]);
                            }
                        } else {
                            System.out.println("No hay oracion");
                        }
                        break;
                    case 6:// Buscar palabra por orden ingreso
                        if (oracion != null) {
                            palabras = oracion.split(" ");
                            System.out.print(
                                    "Ingrese nro de orden de la palabra a buscar, no mayor a "
                                            + (palabras.length - 1) + ": ");
                            int idPalabra = scan.nextInt();
                            scan.nextLine();
                            if (idPalabra > 0 && idPalabra < palabras.length) {
                                System.out.println("La palabra buscada es: " + palabras[idPalabra]);
                            } else {
                                System.out.println("El nro no debe ser negativo o mayor a" + (palabras.length - 1));
                            }
                        } else {
                            System.out.println("No hay oracion");
                        }
                        break;
                    case 7:// buscar palabra por texto
                        if (oracion != null) {
                            System.out.print("Ingrese la palabra a buscar: ");
                            String palabra = scan.nextLine();
                            int idPalabra = oracion.indexOf(palabra);
                            if (idPalabra > 0) {
                                System.out.println(
                                        "La palabra ingresada se econtro, su posicion inicial es: " + idPalabra);
                            } else {
                                System.out.println("La palabra ingresada no esta en la oracion");
                            }
                        } else {
                            System.out.println("No hay oracion");
                        }
                        break;
                    case 8:// modificar palabra
                        if (oracion != null) {
                            System.out.print("Ingrese la palabra a modificar: ");
                            String palabra = scan.nextLine();
                            if (oracion.indexOf(palabra) > 0) {
                                System.out.println("Igrese la nueva palabra: ");
                                String nuevaPalabra = scan.nextLine();
                                oracion = oracion.replaceFirst(palabra, nuevaPalabra);
                                System.out.println("La palabra fue reeplazada correctamente");
                            } else {
                                System.out.println("La palabra ingresada no esta en la oracion");
                            }
                        } else {
                            System.out.println("No hay oracion");
                        }
                        break;
                    case 9:// agregar contenido
                        if (oracion != null) {
                            System.out.print("Ingrese el contenido a agregar a la oracion: ");
                            String agregarPalabras = scan.nextLine();
                            oracion = oracion.concat(" " + agregarPalabras);
                            System.out.println("El nuevo contenido fu agregegado a la oracion");
                        } else {
                            System.out.println("No hay oracion");
                        }
                        break;
                    default:
                        System.out.println("Error, debe ingresar alguna opcion del menu");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Ups!!Hubo un error en el ingreso de la opcion de menu");
            }
            System.out.print("Pulse Enter para seguir");
            scan.nextLine();
        } while (!salir);
        System.out.println("FIN DEL PROGRAMA");
        scan.close();
    }
}
