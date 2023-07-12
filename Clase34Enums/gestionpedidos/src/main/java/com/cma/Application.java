package com.cma;

import com.cma.servicios.MenuServicio;

/**
 * Aplicación de gestión de pedidos
 * 
 * Crea una aplicación de gestión de pedidos utilizando
 * el patrón experto. Para ello, se requiere implementar
 * un Enum llamado EstadoPedido que represente los posibles
 * estados de un pedido. Los estados posibles son
 * "pendiente", "en proceso", "enviado" y "entregado".
 * 
 * Crea el modelo Pedido que contenga los siguientes
 * atributos: número de pedido, cliente, lista de
 * productos y estado del pedido. El estado del pedido
 * debe ser una constante de la enumeración "EstadoPedido". La lista de
 * productos debe ser un array de Strings
 * 
 * Crea la clase PedidoServicio que se encargue de
 * gestionar los pedidos. Esta clase debe tener métodos
 * para crear un nuevo pedido, actualizar el estado de un
 * pedido existente, buscar pedidos por estado,
 * y obtener la lista completa de pedidos y
 * realizar filtros sobre la misma.
 * 
 * Crea la clase MenuServicio para interactuar con el
 * usuario al inicio de la aplicación.
 * El menú debe mostrar opciones para que el usuario
 * pueda crear un nuevo pedido, actualizar el estado de
 * un pedido, buscar pedidos por estado, mostrar lista de
 * pedidos (también poder filtrarlos) y salir de la
 * aplicación.
 * 
 * 
 * 
 */
public class Application {

    public static void main(String[] args) {
        MenuServicio menu = new MenuServicio();
        menu.generarMenu();
        System.out.println("+----------------+");
        System.out.println("|Fin del programa|");
        System.out.println("+----------------+");
    }
}
