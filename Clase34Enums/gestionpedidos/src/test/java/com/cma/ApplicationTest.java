package com.cma;

import org.junit.jupiter.api.Test;

import com.cma.enums.Producto;
import com.cma.models.Pedido;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {

    @Test
    void pedidoTest() {
        Pedido nuevoPedido = new Pedido("Juan Perez");
        assertNotNull(nuevoPedido); // Verificar que el objeto nuevoPedido no sea nulo
        assertEquals("Juan Perez", nuevoPedido.getCliente()); // Verificar que el nombre del cliente sea "Juan Perez"
    }

    @Test
    void productoTest() {
        System.out.println(Producto.values());

    }
}
