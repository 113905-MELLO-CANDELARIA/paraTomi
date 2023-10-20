package ar.edu.utn.frc.tup.lciv.controllers;

import ar.edu.utn.frc.tup.lciv.models.Venta;
import ar.edu.utn.frc.tup.lciv.models.dtos.requests.VentaRequest;
import ar.edu.utn.frc.tup.lciv.models.dtos.responses.VentaResponse;
import ar.edu.utn.frc.tup.lciv.services.VentaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ventas")
public class VentaController {
    @Autowired
    private VentaService ventaService;
    @GetMapping("/byId/{id}")
    public ResponseEntity<VentaResponse> getById(@PathVariable Long id){
        return ResponseEntity.ok(ventaService.getById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Venta>> getAll(){
        return ResponseEntity.ok(ventaService.getAll());
    }

    @GetMapping("/byFilter")
    public ResponseEntity<List<Venta>> getByFilter(){
        return null;
    }
    @PostMapping("/save")
    public ResponseEntity<VentaResponse> save(@Valid @RequestBody VentaRequest request){
        return ResponseEntity.ok(ventaService.save(request));
    }


}
