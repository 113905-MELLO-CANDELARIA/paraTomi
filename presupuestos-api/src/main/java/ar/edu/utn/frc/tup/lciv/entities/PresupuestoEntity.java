package ar.edu.utn.frc.tup.lciv.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.IdGeneratorType;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Presupuestos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PresupuestoEntity {

    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column
    private String cliente;

    @Column
    private Date fecha_creacion;

    @Column
    private Date fecha_vencimiento;

    @OneToMany(mappedBy = "presupuesto")
    private List<DetallePresupuestoEntity> productos;

}
