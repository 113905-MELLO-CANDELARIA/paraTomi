package ar.edu.utn.frc.tup.lciv.dtos.vendedor;


import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class VendedorRequest {
    @NotNull
    private String nombre;
    @NotNull
    private String apellido;
    @NotNull @Email
    private String email;
    @NotNull
    private String direccion;
    @NotNull
    private Long telefono;
    @NotNull @Enumerated
    private Integer idTurno;
}
