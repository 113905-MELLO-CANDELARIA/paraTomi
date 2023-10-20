package ar.edu.utn.frc.tup.lciv.entities;

import jakarta.persistence.*;
import lombok.Data;

import javax.naming.Name;

@Data@Entity
@Table(name="detalles_presupuestos")
public class DetallePresupuestoEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String descripcion;
    @Column
    private Integer cantidad;
    @Column
    private String unidad;

    @ManyToOne
    @JoinColumn
    private PresupuestoEntity presupuesto;

}
