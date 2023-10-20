package ar.edu.utn.frc.tup.lciv.services.impl;

import ar.edu.utn.frc.tup.lciv.entities.VentaEntity;
import ar.edu.utn.frc.tup.lciv.models.Venta;
import ar.edu.utn.frc.tup.lciv.models.dtos.requests.VentaRequest;
import ar.edu.utn.frc.tup.lciv.models.dtos.responses.VentaResponse;
import ar.edu.utn.frc.tup.lciv.repositories.VentasJpaRepository;
import ar.edu.utn.frc.tup.lciv.services.VentaService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VentaServiceImpl implements VentaService {
    @Autowired
    private VentasJpaRepository ventasJpaRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public VentaResponse getById(Long id) {
        Optional<VentaEntity> ventaEntity = ventasJpaRepository.findById(id);
        if(ventaEntity.isEmpty()){
            throw new EntityNotFoundException("No se encontró la venta con el id "+id);
        }
        return modelMapper.map(ventaEntity,VentaResponse.class);
    }

    @Override
    public VentaResponse save(VentaRequest request){
        return null;
    }

    @Override
    public List<Venta> getAll() {
        List<Venta> ventas = new ArrayList<>();
        List<VentaEntity> ventaEntities = ventasJpaRepository.findAll();
        if(ventaEntities.size()==0){
            throw new EntityNotFoundException("No se encontraron ventas");
        }
        for (VentaEntity v:ventaEntities) {
            ventas.add(modelMapper.map(v,Venta.class));
        }
        return ventas;
    }
}
