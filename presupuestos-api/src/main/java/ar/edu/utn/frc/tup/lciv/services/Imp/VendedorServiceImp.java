package ar.edu.utn.frc.tup.lciv.services.Imp;

import ar.edu.utn.frc.tup.lciv.dtos.vendedor.VendedorDto;
import ar.edu.utn.frc.tup.lciv.dtos.vendedor.VendedorRequest;
import ar.edu.utn.frc.tup.lciv.entities.VendedorEntity;
import ar.edu.utn.frc.tup.lciv.reporitories.VendedorRepository;
import ar.edu.utn.frc.tup.lciv.services.IVendedorService;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Primary
@Service
@AllArgsConstructor
public class VendedorServiceImp implements IVendedorService {

    @Autowired
    private final VendedorRepository vendedorRepo;
    @Autowired
    private final ModelMapper mapper;

    @Override
    public VendedorDto PostVendedor(VendedorEntity vendedor) {
        VendedorEntity ve = vendedorRepo.save(vendedor);
        VendedorDto vDto = mapper.map(ve, VendedorDto.class);
        return vDto;
    }

    @Override
    public List<VendedorDto> ObtenerVendedores() {
        List<VendedorEntity> vendedoresEntities = vendedorRepo.findAll();
        List<VendedorDto> vendedoresDto = new ArrayList<>();

        for (VendedorEntity vendedorEntity : vendedoresEntities) {
            vendedoresDto.add(mapper.map(vendedorEntity, VendedorDto.class));
        }
        return vendedoresDto;
    }

    @Override
    public VendedorDto ObtenerVendedorById(Long id) {
        VendedorEntity vendedorEntity = vendedorRepo.getReferenceById(id);
        VendedorDto vendedor = mapper.map(vendedorEntity, VendedorDto.class);
        return vendedor;
    }

    @Override
    public VendedorDto ModificarVendedorById(VendedorEntity vendedor, Long id) {
        Optional<VendedorEntity> vendedorEntity = vendedorRepo.findById(id);
        if (vendedorEntity.isPresent()) {
            VendedorEntity vendedorActualizado = vendedorEntity.get();
            vendedorActualizado.setNombre(vendedor.getNombre());
            vendedorActualizado.setApellido(vendedor.getApellido());
            vendedorActualizado.setEmail(vendedor.getEmail());
            vendedorActualizado.setDireccion(vendedor.getDireccion());
            vendedorActualizado.setTelefono(vendedor.getTelefono());
            vendedorActualizado.setIdTurno(vendedor.getIdTurno());

            vendedorRepo.save(vendedorActualizado);
            return mapper.map(vendedorActualizado, VendedorDto.class);
        } else {
            throw new EntityNotFoundException("No se encontró el vendedor con ese ID");
        }
    }
}