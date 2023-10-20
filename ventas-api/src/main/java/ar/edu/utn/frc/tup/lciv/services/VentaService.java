package ar.edu.utn.frc.tup.lciv.services;

import ar.edu.utn.frc.tup.lciv.models.Venta;
import ar.edu.utn.frc.tup.lciv.models.dtos.requests.VentaRequest;
import ar.edu.utn.frc.tup.lciv.models.dtos.responses.VentaResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VentaService {
    VentaResponse getById(Long id);
    VentaResponse save(VentaRequest venta);
    List<Venta> getAll();
}
