package ar.edu.utn.frc.tup.lciv.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="vendedores")
@AllArgsConstructor
@NoArgsConstructor
public class VendedorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private String email;
    @Column
    private String direccion;
    @Column
    private Long telefono;
    @Column
    private Integer idTurno;

}
