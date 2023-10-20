package ar.edu.utn.frc.tup.lciv.services;

import ar.edu.utn.frc.tup.lciv.dtos.vendedor.VendedorDto;
import ar.edu.utn.frc.tup.lciv.dtos.vendedor.VendedorRequest;
import ar.edu.utn.frc.tup.lciv.entities.VendedorEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IVendedorService {
    public VendedorDto PostVendedor(VendedorEntity vendedor);
    public List<VendedorDto> ObtenerVendedores();

    public VendedorDto ObtenerVendedorById(Long id);
    public VendedorDto ModificarVendedorById(VendedorEntity vendedor, Long id);

}
