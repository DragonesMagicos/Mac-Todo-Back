package com.techlab.ferreteria_api.model;

import com.fasterxml.jackson.annotation.JsonBackReference; // <-- IMPORTAR ESTO
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class DetallePedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Producto producto;
    private Integer cantidad;

    // Con esta anotación, le decimos a Jackson que esta es la parte "de vuelta"
    // de la relación y que no debe serializarla, rompiendo el bucle.
    @ManyToOne
    @JoinColumn(name = "pedido_id")
    @JsonBackReference // <-- AÑADIR ESTA LÍNEA
    private Pedido pedido;

    // Getters y Setters (sin cambios)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Producto getProducto() { return producto; }
    public void setProducto(Producto producto) { this.producto = producto; }
    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }
    public Pedido getPedido() { return pedido; }
    public void setPedido(Pedido pedido) { this.pedido = pedido; }
}
