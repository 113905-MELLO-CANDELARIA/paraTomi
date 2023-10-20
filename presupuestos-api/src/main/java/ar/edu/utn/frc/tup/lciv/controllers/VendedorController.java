package ar.edu.utn.frc.tup.lciv.controllers;

import ar.edu.utn.frc.tup.lciv.dtos.vendedor.VendedorDto;
import ar.edu.utn.frc.tup.lciv.entities.VendedorEntity;
import ar.edu.utn.frc.tup.lciv.services.IVendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@RestController
public class VendedorController {

    @Qualifier("vendedorServiceImp")
    @Autowired
    private final IVendedorService vendedorService;

    public VendedorController(@Qualifier("vendedorServiceImp") IVendedorService vendedorService) {
        this.vendedorService = vendedorService;
    }


    @PostMapping("/vendedor")
    public ResponseEntity<VendedorDto> PostVendedor(@RequestBody VendedorEntity vendedor){
        VendedorDto vDto = vendedorService.PostVendedor(vendedor);
        if(Objects.isNull(vDto))
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "¡Hubo un problema en la carga del vendedor! Intente nuevamente luego.");
        }
        return ResponseEntity.ok(vDto);
    }
    @GetMapping("/vendedores")
    public List<VendedorDto> GetVendedores(){
        List<VendedorDto> lVDto = vendedorService.ObtenerVendedores();
        if(lVDto.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No existen vendedores en este momento!");
        }
        return lVDto;
    }
}