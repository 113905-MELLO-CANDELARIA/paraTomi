package ar.edu.utn.frc.tup.lciv.dtos.vendedor;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendedorDto {
    private String nombre;
    private String apellido;
    private Integer idTurno;
}
