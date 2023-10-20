package ar.edu.utn.frc.tup.lciv.controllers;

import ar.edu.utn.frc.tup.lciv.dtos.Presupuestos.PresupuestoRequest;
import ar.edu.utn.frc.tup.lciv.dtos.Presupuestos.PresupuestoResponse;
import ar.edu.utn.frc.tup.lciv.services.IPresupuestoService;
import ar.edu.utn.frc.tup.lciv.services.IVendedorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/presupuesto")
public class PresupuestoController {

    @Qualifier("presupuestoServiceImp")
    @Autowired
    private IPresupuestoService presupuestoService;
    @GetMapping("/All")
    public ResponseEntity<List<PresupuestoResponse>> GetAllPresupuestos() {
        return ResponseEntity.ok(presupuestoService.GetAllPresupuestos());
    }

    @GetMapping("/AllFromDB")
    public ResponseEntity<List<PresupuestoResponse>> GetAllPresupuestosFromDB() {
        return ResponseEntity.ok(presupuestoService.GetAllPresupuestosFromDB());
    }

    @GetMapping("/ById/{id}")
    public ResponseEntity<PresupuestoResponse> GetPresupuestoByClienteId(Long Id) {
        return ResponseEntity.ok(presupuestoService.GetPresupuestoByClienteId(Id));
    }

    @GetMapping("/ByIdFromDB/{id}")
    public ResponseEntity<PresupuestoResponse> GetPresupuestoByClienteIdFromDB(Long Id) {
        return ResponseEntity.ok(presupuestoService.GetPresupuestosFromDBById(Id));
    }

    @PostMapping("/Save")
    public ResponseEntity<PresupuestoResponse> SavePresupuesto(@RequestBody @Valid PresupuestoRequest presupuestoRequest) {
        PresupuestoResponse pResponse = presupuestoService.SavePresupuesto(presupuestoRequest);
        return ResponseEntity.ok(pResponse);
    }
}
