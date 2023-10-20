package ar.edu.utn.frc.tup.lciv.services.Imp;

import ar.edu.utn.frc.tup.lciv.dtos.Presupuestos.PresupuestoRequest;
import ar.edu.utn.frc.tup.lciv.dtos.Presupuestos.PresupuestoResponse;
import ar.edu.utn.frc.tup.lciv.entities.DetallePresupuestoEntity;
import ar.edu.utn.frc.tup.lciv.entities.PresupuestoEntity;
import ar.edu.utn.frc.tup.lciv.reporitories.IDetallePresupuestoRepository;
import ar.edu.utn.frc.tup.lciv.reporitories.IPresupuestoRepository;
import ar.edu.utn.frc.tup.lciv.services.IPresupuestoService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class PresupuestoServiceImp implements IPresupuestoService {

    @Autowired
    private RestTemplate restTemplate;
    @Value("${EXTERNAL_BASE_URL}")
    private String baseUrl;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IPresupuestoRepository presupuestoRepo;

    @Autowired
    private IDetallePresupuestoRepository detalleRepo;

    @Override
    public List<PresupuestoResponse> GetAllPresupuestos() {
        ResponseEntity<PresupuestoResponse[]> presupuestos = restTemplate.getForEntity(baseUrl+"/presupuestos",PresupuestoResponse[].class);
        if(presupuestos.getStatusCode().is2xxSuccessful()){return Arrays.asList(presupuestos.getBody());}
        throw new EntityNotFoundException();
    }

    @Override
    public PresupuestoResponse GetPresupuestoByClienteId(Long Id) {
        ResponseEntity<PresupuestoResponse> presupuesto = restTemplate.getForEntity(baseUrl+"/presupuestos/"+Id,PresupuestoResponse.class);
        if (presupuesto.getStatusCode().is2xxSuccessful()) {
            return presupuesto.getBody();
        }
        else{throw  new EntityNotFoundException();}

    }

    @Override
    @Transactional
    public PresupuestoResponse SavePresupuesto(PresupuestoRequest presupuesto) {
        PresupuestoEntity pE = modelMapper.map(presupuesto, PresupuestoEntity.class);
        PresupuestoEntity pESaved = presupuestoRepo.save(pE);

        for (DetallePresupuestoEntity detalle : pE.getProductos()) {
            detalle.setPresupuesto(pESaved);
            detalleRepo.save(detalle);
        }

        if (pESaved.getId() == null) {
            throw new EntityNotFoundException();
        }
        return modelMapper.map(pESaved, PresupuestoResponse.class);
    }

    @Override
    public List<PresupuestoResponse> GetAllPresupuestosFromDB() {
        List<PresupuestoEntity> lPE = presupuestoRepo.findAll();
        if (lPE.isEmpty()) {
            throw new EntityNotFoundException();
        }
        List<PresupuestoResponse> Response = new ArrayList<>();

        for (PresupuestoEntity p : lPE) {
            p.getProductos().size();
            Response.add(modelMapper.map(p, PresupuestoResponse.class));
        }

        return Response;
    }

    @Override
    public PresupuestoResponse GetPresupuestosFromDBById(Long Id) {
        Optional<PresupuestoEntity> pE = presupuestoRepo.findById(Id);
        if (pE.isPresent()) {
            PresupuestoEntity presupuesto = pE.get();
            presupuesto.getProductos().size();
            return modelMapper.map(presupuesto, PresupuestoResponse.class);
        } else {
            throw new EntityNotFoundException();
        }

    }

}
