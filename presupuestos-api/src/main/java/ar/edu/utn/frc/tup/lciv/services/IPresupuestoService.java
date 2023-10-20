package ar.edu.utn.frc.tup.lciv.services;


import ar.edu.utn.frc.tup.lciv.dtos.Presupuestos.PresupuestoRequest;
import ar.edu.utn.frc.tup.lciv.dtos.Presupuestos.PresupuestoResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPresupuestoService {
    List<PresupuestoResponse> GetAllPresupuestos();
    PresupuestoResponse GetPresupuestoByClienteId(Long Id);
    PresupuestoResponse SavePresupuesto(PresupuestoRequest presupuesto);
    List<PresupuestoResponse> GetAllPresupuestosFromDB();
    PresupuestoResponse GetPresupuestosFromDBById(Long Id);
}