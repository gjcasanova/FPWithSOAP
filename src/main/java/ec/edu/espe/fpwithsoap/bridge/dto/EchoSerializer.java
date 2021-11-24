package ec.edu.espe.fpwithsoap.bridge.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EchoSerializer {
    private String message;
}
