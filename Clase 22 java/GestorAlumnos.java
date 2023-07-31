import java.util.Scanner;

/**
 * Ejercicios III
 * Escribir un programa en Java que permita llevar un registro de alumnos.
 * El programa debe cumplir con los siguientes requisitos:
 * 
 * 1. Mostrar un menú de opciones al usuario, donde podrá seleccionar una
 * de las siguientes acciones:
 * 
 * a) "Registrar alumno": Permitir al usuario registrar un nuevo alumno
 * ingresando su nombre y nota.
 * 💡Para lograr esto, te recomendamos utilizar un array de tipo String
 * para almacenar los nombres de los alumnos y un array de tipo Double
 * para guardar las notas correspondientes. De esta manera, podrás
 * asociar los nombres con las notas utilizando los índices de los arrays.
 * b) "Mostrar todos los alumnos": Mostrar en pantalla el nombre y la nota de
 * todos los alumnos registrados hasta el momento.
 * 
 * c) "Mostrar promedio de notas": Calcular y mostrar en pantalla el promedio
 * de las notas de todos los alumnos registrados hasta el momento.
 * 
 * d) "Buscar alumno por nombre": Solicitar al usuario ingresar el nombre de un
 * alumno y mostrar en pantalla su nota si el alumno existe.
 * 
 * e) "Modificar nota por nombre": Solicitar al usuario ingresar el nombre de un
 * alumno y permitir modificar su nota si el alumno existe.
 * 
 * f) "Eliminar alumno por nombre": Solicitar al usuario ingresar el nombre de
 * un alumno y eliminar al alumno si existe.
 * 
 * g) "Salir": Terminar el programa.
 * 
 * 2. El programa debe validar que el nombre no esté vacío y que la nota sea un
 * número válido entre 0.00 y 10.00.
 * 
 * 3. El programa debe utilizar las estructuras de control adecuadas (if,
 * switch, for, while, do-while) según corresponda para implementar las
 * diferentes opcionesdel menú.
 * 
 * 4. El programa debe manejar excepciones utilizando bloques try-catch para
 * manejar posibles excepciones al leer datos de entrada del usuario.
 * 
 * 5. Después de realizar una operación, mostrar el menú de opciones nuevamente
 * para que el usuario pueda elegir otra acción hasta que elija la opción
 * "Salir".
 */

public class GestorAlumnos {
    public static void main(String[] args) {
        int cantAlumnos = 10;
        boolean salir = false;
        String[] alumnos = new String[cantAlumnos];
        Double[] notas = new Double[cantAlumnos];
        boolean listaLLena = false;
        int opcionMenu;
        Scanner scan = null;
        do {
            try {
                scan = new Scanner(System.in);
                System.out.println("Menu ALumnos");
                System.out.println("[1] Registrar Alumno");
                System.out.println("[2] Mostrar Todos los Alumnos");
                System.out.println("[3] Mostrar Promedio Notas");
                System.out.println("[4] Buscar Alumno por Nombre");
                System.out.println("[5] Modificar Nota por Nombre");
                System.out.println("[6] Eliminar Alumno por Nombre");
                System.out.println("------------------------");
                System.out.println("[0] Salir!!");
                System.out.println("------------------------");
                System.out.println("------------------------");
                System.out.print("Ingrese opcion de menu: ");
                opcionMenu = scan.nextInt();
                scan.nextLine();
                switch (opcionMenu) {
                    case 0:// salir
                        salir = true;
                        break;
                    case 1:// registrar alumno
                        if (!listaLLena) {
                            System.out.print("Ingrese el nombre del alumno: ");
                            String nombre = scan.nextLine();
                            if (!nombre.isEmpty() && !nombre.isBlank()) {
                                try {
                                    System.out.print("Ingrese la nota del alumno: ");
                                    Double nota = scan.nextDouble();
                                    scan.nextLine();
                                    if (nota >= 0 && nota <= 10) {
                                        for (int i = 0; i < notas.length; i++) {
                                            if (alumnos[i] == null) {
                                                alumnos[i] = nombre;
                                                notas[i] = nota;
                                                System.out.println("Alunmo registrado correctamente");
                                                break;
                                            }
                                        }
                                    } else {
                                        System.out.println("La nota debe ser estar entre 0.0 y 10.0");
                                    }
                                } catch (Exception e) {
                                    System.out.println("Error!!!!Bebe ingresar un valor entre 0.0 y 10.0");
                                }
                            } else {
                                System.out.println("El nombre no puede estar vacio o con espacios");
                            }
                        } else {
                            System.out.println("La lista de alumnos esta llena");
                        }
                        break;
                    case 2:// mostrar todos
                        System.out.println("LISTADO DE ALUMNOS Y NOTAS");
                        for (int i = 0; i < alumnos.length; i++) {
                            if (alumnos[i] != null)
                                System.out.println("[" + i + "]" + alumnos[i] + " - " + notas[i]);
                        }
                        break;
                    case 3:// promedio notas
                        Double sumaNotas = 0.0;
                        int cantidadNotas = 0;
                        for (int i = 0; i < notas.length; i++) {
                            if (notas[i] != null) {
                                sumaNotas = sumaNotas + notas[i];
                                cantidadNotas++;
                            }
                        }
                        System.out.println("Total Notas: " + sumaNotas + " Cantidad Notas: " + cantidadNotas);
                        System.out.println("El promedio de notas es: " + sumaNotas / cantidadNotas);
                        break;
                    case 4:// buscar por nombre
                        System.out.print("Ingrese el nombre del alumno a buscar: ");
                        String buscado = scan.nextLine();
                        boolean noEncontrado = true;
                        for (int i = 0; i < alumnos.length; i++) {
                            if (alumnos[i] != null && alumnos[i].equals(buscado)) {
                                System.out.println("La nota del alumno es: " + notas[i]);
                                noEncontrado = false;
                                break;
                            }
                        }
                        if (noEncontrado)
                            System.out.println("Alumno no registrado");
                        break;
                    case 5:// modificar nota
                        System.out.print("Ingrese el nombre del alumno a modificar: ");
                        String alumnoBuscado = scan.nextLine();
                        for (int i = 0; i < alumnos.length; i++) {
                            if (alumnos[i] != null && alumnoBuscado.equals(alumnos[i])) {
                                System.out.print("Su nota es: " + notas[i] + ". Ingrese nueva nota: ");
                                try {
                                    Double nota = scan.nextDouble();
                                    scan.nextLine();
                                    if (nota >= 0.0 && nota <= 10.0) {
                                        notas[i] = nota;
                                        System.out.println("Nota modificada exitosamente");
                                    } else {
                                        System.out.println("Error al ingresar la nota.Debe ser entre 0 y 10");
                                    }
                                } catch (Exception e) {
                                    System.out.println("Error!!!!Bebe ingrsa un valor entre 0.0 y 10.0");
                                }
                                break;
                            }
                        }
                        break;
                    case 6:// eliminar alumno
                        System.out.print("Ingrese el nombre del alumno a eliminar: ");
                        String eliminar = scan.nextLine();
                        boolean noEliminado = true;
                        for (int i = 0; i < alumnos.length; i++) {
                            if (alumnos[i] != null && eliminar.equals(alumnos[i])) {
                                alumnos[i] = null;
                                notas[i] = null;
                                System.out.println("Alumno eliminado!!");
                                noEliminado = false;
                                break;
                            }
                        }
                        if (noEliminado)
                            System.out.println("El alumno no fue eliminado");
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
