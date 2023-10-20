package ar.edu.utn.frc.tup.lciv.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
@Component
@Data@AllArgsConstructor@NoArgsConstructor
public class Venta {
    private Long id;
    private Date fecha;
    private Long id_cliente;
    private TipoVenta tipo_venta;
    private FormaEntrega forma_entrega;
    private Date fecha_entrega;
    private Long id_vendedor;
    private List<DetalleVenta> detalles;
    private BigDecimal total;
    private EstadoVenta estado;
}
