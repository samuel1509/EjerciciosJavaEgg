package com.cma.enums;


/**
 * representae los posibles
 * estados de un pedido. Los estados posibles son
 * "pendiente", "en proceso", "enviado" y "entregado".
 */

public enum EstadoPedido {
    PENDIENTE("El estado es pendiente"),
    EN_PROCESO("El estado es en proceso"),
    ENVIADO("El estado es enviado"),
    ENTREGADO("El estado es entregado");

    private String descripcion;

    private EstadoPedido(String descripcion) {
        this.descripcion = descripcion;
        }

    public String getDescripcion() {
        return descripcion;
    }
}
