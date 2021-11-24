package ec.edu.espe.fpwithsoap.bridge.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientSerializer {
    //private Long id;
    private String cedula;
    private String nombre;
    private String apellido;
    private String correo;
    private String direccion;
}
