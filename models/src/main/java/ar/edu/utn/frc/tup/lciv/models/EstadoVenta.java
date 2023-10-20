package ar.edu.utn.frc.tup.lciv.models;

import org.springframework.stereotype.Component;

@Component
public enum EstadoVenta {
    Entregado,Cancelado,Pendiente_Facturacion,Facturado,En_Preparacion
}
