package ec.edu.espe.fpwithsoap.bridge.service;

import ec.edu.espe.fpwithsoap.bridge.dto.ClientSerializer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {
    public String echo(){
        return "echo";
    }

    public ClientSerializer retrieve(String identityCard){
        ClientSerializer clientSerializer = ClientSerializer.builder().build();
        // TODO
        return clientSerializer;
    }

    public void create(ClientSerializer clientSerializer){
        // TODO
    }

    public void update(ClientSerializer clientSerializer){
        // TODO
    }
}
