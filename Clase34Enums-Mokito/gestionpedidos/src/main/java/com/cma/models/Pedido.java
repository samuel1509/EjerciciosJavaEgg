package com.cma.models;

import java.util.ArrayList;
import java.util.List;
import com.cma.enums.*;

/**
 * Patron experto pedidos
 */
public class Pedido {
    private static long cantPedidos = 0;

    private long nroPedido;
    private String cliente;
    private List<Producto> listaProductos;
    private EstadoPedido estado;

    /*----------------------------------------------- */
    public Pedido(String cliente) {
        cantPedidos++;// contador de pedidos generados
        this.nroPedido = cantPedidos;// nro de pedido autogenerado
        this.cliente = cliente;
        this.estado = EstadoPedido.PENDIENTE;
        // generamos una lista aleatoria de productos
        listaRandomProductos();
    }

    private void listaRandomProductos() {
        listaProductos = new ArrayList<Producto>();
        Producto[] lp = Producto.values();
        for (int i = 0; i < 2; i++) {
            int random = (int) (Math.random() * 4);
            listaProductos.add(lp[random]);
        }
    }

    /**
     * @return long return the nroPedido
     */
    public long getNroPedido() {
        return nroPedido;
    }

    // sin setNroPedido para no editar el nro auto generado

    /**
     * @return String return the cliente
     */
    public String getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    /**
     * @return List <String> return the listaProductos
     */
    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    /**
     * @param listaProductos the listaProductos to set
     */
    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    /**
     * @return EstadoPedido return the estado
     */
    public EstadoPedido getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    /**
     * @return Cantidad de pedidos generados
     */
    public static long getCantPedidos() {
        return cantPedidos;
    }

    public void mostrar() {
        System.out.println("|---------------------------------|");
        System.out.println("|Pedido nro: " + nroPedido);
        System.out.println("|Cliente: " + cliente);
        System.out.println("|Estado: " + estado);
        System.out.println("----------------------------------|");
        System.out.println("|Productos: ");
        for (Producto producto : listaProductos) {
            System.out.println("|" + producto.getNombre() + "-> $ " + producto.getPrecio());
        }
        System.out.println("|---------------------------------|");
    }
}
