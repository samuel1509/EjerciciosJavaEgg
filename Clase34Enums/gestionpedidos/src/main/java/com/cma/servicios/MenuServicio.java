package com.cma.servicios;

import java.util.List;
import java.util.Scanner;

import com.cma.enums.EstadoPedido;
import com.cma.models.Pedido;

/**
 * Crea la clase MenuServicio para interactuar con el
 * usuario al inicio de la aplicación.
 * El menú debe mostrar opciones para que el usuario
 * pueda
 * crear un nuevo pedido,
 * actualizar el estado de un pedido,
 * buscar pedidos por ¿estado?, no seria nroPedido?
 * mostrar lista depedidos (también poder filtrarlos)
 * y salir de la aplicación.
 */

public class MenuServicio {

    private Scanner scan;

    Servicios servicios;

    public MenuServicio() {
        scan = new Scanner(System.in);
        servicios = new Servicios();
    }

    public void imprimirMenu() {
        servicios.limpiarConsola();
        System.out.println("---------------------------------");
        System.out.println("|MENU SERVICIOS                  |");
        System.out.println("---------------------------------");
        System.out.println("|1- Nuevo Pedido                 |");
        System.out.println("|2- Actualizar Estado Pedido     |");
        System.out.println("|3- Listar Pedidos               |");
        System.out.println("|4- Buscar Pedido                |");
        System.out.println("|0- Salir                        |");
        System.out.println("|--------------------------------|");
        System.out.println("( Cantidad de pedidos: " + servicios.cantidadPedidos() + " )");
        System.out.println("|--------------------------------|");
        System.out.print("Elija opcion: ");

    }

    public void generarMenu() {
        boolean salir = false;
        Integer op;
        do {
            imprimirMenu();
            try {
                op = scan.nextInt();
                salir = switch (op) {
                    case 1 -> crearPedido();
                    case 2 -> actualizarEstadoPedido();
                    case 3 -> listarPedidos();
                    case 4 -> buscarPedido();
                    case 0 -> true;
                    default -> false;
                };

            } catch (Exception e) {
                System.out.println("Ingreso erroneo, intente de nuevo");
                salir = false;
            }

        } while (!salir);
        scan.close();
    }

    private boolean crearPedido() {
        try {
            scan.nextLine();// limpiar
            System.out.println("---------------------");
            System.out.print("Ingrese el cliente: ");
            String cliente = scan.nextLine();
            servicios.crearNuevoPedido(cliente);
            System.out.println("Nuevo pedido creado!!!");
            Pedido pedido = servicios.ultimoPedido();
            if (pedido != null) {
                pedido.mostrar();
                
            }

        } catch (Exception e) {
            System.out.print("Error al generar Nuevo Pedido ");
        }
        System.out.print("Presione una tecla para seguir!!");
        scan.nextLine();// limpiabuffer
        return false;
    }

    private boolean actualizarEstadoPedido() {
        int nroPedido = 0;
        int opEstado = 0;
        try {
            System.out.print("Ingrese Nro de Pedido a actualizar: ");
            nroPedido = scan.nextInt();
            Pedido pedido = servicios.buscarPedido(nroPedido);
            if (pedido != null) {
                pedido.mostrar();
                System.out.println("Ingrese nuevo estado del pedido: ");
                servicios.mostrarEstados();
                opEstado = scan.nextInt();
                scan.nextLine();// limpiabuffer
                if (servicios.actualizarEstadoPedido(nroPedido,
                        EstadoPedido.values()[opEstado])) {
                    System.out.println("Pedido actualizado");
                    pedido.mostrar();
                } else {
                    System.out.println("El Pedido no pudo actualizarse");
                }
            } else {
                System.out.println("Pedido no encotrado!!");
            }
        } catch (Exception e) {
            System.out.print("Error al actualizar estado Pedido ");
        }
        System.out.print("Presione una tecla para seguir!!");
        scan.nextLine();// limpiabuffer
        return false;
    }

    private boolean listarPedidos() {
        System.out.println("Filtro x estado estado? ");
        servicios.mostrarEstados();
        int filtroEstado = scan.nextInt();
        scan.nextLine();// limpiabuffer
        List<Pedido> lstPedidos = null;
        if (filtroEstado < EstadoPedido.values().length &&
                filtroEstado >= 0)
            lstPedidos = servicios.listarPedidos(EstadoPedido.values()[filtroEstado]);
        else
            lstPedidos = servicios.listarPedidos();
        if (lstPedidos != null && !lstPedidos.isEmpty()) {
            for (Pedido pedido : lstPedidos) {
                pedido.mostrar();
            }
        }
        System.out.print("Presione una tecla para seguir!!");
        scan.nextLine();// limpiabuffer
        return false;
    }

    private boolean buscarPedido() {
        try {
            System.out.print("Ingrese nro de pedido a buscar: ");
            int nroPedido = scan.nextInt();
            scan.nextLine();// limpiabuffer
            Pedido pedido = servicios.buscarPedido(nroPedido);
            if (pedido != null) {
                pedido.mostrar();
            } else {
                System.out.println("Pedido no encontrado");
            }
        } catch (Exception e) {
            System.out.println("Error al ingresar nro pedido");
        }
        System.out.print("Presione una tecla para seguir!!");
        scan.nextLine();// limpiabufferer
        return false;
    }
}