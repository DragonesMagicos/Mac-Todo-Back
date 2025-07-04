package com.techlab.ferreteria_api.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*; // Importar todo de jakarta.persistence
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // MODIFICADO: Ahora es una relación con la entidad Cliente
    @ManyToOne
    @JoinColumn(name = "cliente_id") // Esta será la columna de clave foránea
    private Cliente cliente;

    private LocalDateTime fecha;
    private Double total;
    private String estado;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<DetallePedido> items;

    // Getters y Setters (actualizar para cliente)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }
    public Double getTotal() { return total; }
    public void setTotal(Double total) { this.total = total; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public List<DetallePedido> getItems() { return items; }
    public void setItems(List<DetallePedido> items) { this.items = items; }
}
