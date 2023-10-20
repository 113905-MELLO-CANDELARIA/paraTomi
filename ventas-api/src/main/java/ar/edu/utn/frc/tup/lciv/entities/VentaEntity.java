package ar.edu.utn.frc.tup.lciv.entities;

import ar.edu.utn.frc.tup.lciv.models.EstadoVenta;
import ar.edu.utn.frc.tup.lciv.models.FormaEntrega;
import ar.edu.utn.frc.tup.lciv.models.TipoVenta;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Ventas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VentaEntity {

    // Faltan hacer las relaciones de uno a muchos
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Date fecha;
    @Column
    private Long id_cliente;
    @Enumerated(EnumType.ORDINAL)
    @Column(columnDefinition = "smallint")
    private TipoVenta tipo_venta;
    @Enumerated(EnumType.ORDINAL)
    @Column(columnDefinition = "smallint")
    private FormaEntrega forma_entrega;
    @Column
    private Date fecha_entrega;
    @Column
    private Long id_vendedor;
    @Column
    private BigDecimal total;
    @Enumerated(EnumType.ORDINAL)
    @Column(columnDefinition = "smallint")
    private EstadoVenta estado;
    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
    private List<DetalleVentaEntity> detalles;
}
