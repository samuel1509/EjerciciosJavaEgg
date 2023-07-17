package com.cma.servicios;

import java.util.ArrayList;
import java.util.List;

import com.cma.enums.EstadoPedido;
import com.cma.models.Pedido;

/**
 * Crea la clase PedidoServicio que se
 * encargue de gestionar los pedidos.
 * Esta clase debe tener métodos para
 * crear un nuevo pedido,
 * actualizar el estado de un pedido existente,
 * buscar pedidos por estado, y
 * obtener la lista completa de
 * pedidos y realizar filtros
 * sobre la misma.
 */
public class Servicios {

    List<Pedido> listaPedidos = null;

    public Servicios() {
        listaPedidos = new ArrayList<Pedido>();
    }

    public void crearNuevoPedido(String cliente) {
        listaPedidos.add(new Pedido(cliente));
    }

    public boolean actualizarEstadoPedido(int nroPedido, EstadoPedido estado) {
        Pedido pedido = buscarPedido(nroPedido);
        if (pedido != null) {
            pedido.setEstado(estado);
            return true;
        }
        return false;
    }

    public Pedido buscarPedido(int nroPedido) {
        for (Pedido pedido : listaPedidos) {
            if (pedido.getNroPedido() == nroPedido) {
                return pedido;
            }
        }
        return null;
    }

    public List<Pedido> listarPedidos() {
        return listaPedidos;
    }

    public List<Pedido> listarPedidos(EstadoPedido estado) {
        List<Pedido> lpFiltrada = new ArrayList<Pedido>();
        for (Pedido pedido : listaPedidos) {
            if (pedido.getEstado() == estado)
                lpFiltrada.add(pedido);
        }
        return lpFiltrada;
    }

    public long cantidadPedidos() {
        return Pedido.getCantPedidos();
    }

    public void mostrarEstados() {
        System.out.print("| ");
        for (EstadoPedido estado : EstadoPedido.values())
            System.out.print(estado.ordinal() + "-" + estado + " | ");
        System.out.print("\n\rEstado: ");
    }

    public Pedido ultimoPedido() {
        if (!listaPedidos.isEmpty())
            return listaPedidos.get(listaPedidos.size() - 1);
        return null;
    }

    public Pedido primerPedido() {
        if (!listaPedidos.isEmpty())
            return listaPedidos.get(0);
        return null;
    }

    public void limpiarConsola() {
        // limpiar pantalla
        System.out.print("\033[H\033[2J");
        System.out.flush(); 
    }

}
