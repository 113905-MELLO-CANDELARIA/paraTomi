package ar.edu.utn.frc.tup.lciv.dtos.Presupuestos;

import ar.edu.utn.frc.tup.lciv.dtos.DetallePresupuesto.DetallePresupuestoRequest;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data@AllArgsConstructor@NoArgsConstructor
public class PresupuestoResponse {
    private String cliente;
    @JsonFormat(timezone = "yyyy-MM-dd")
    private Date fecha_creacion;
    @JsonFormat(timezone = "yyyy-MM-dd")
    private Date fecha_vencimiento;
    private DetallePresupuestoRequest[] productos;
}
