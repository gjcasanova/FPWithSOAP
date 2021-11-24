package ec.edu.espe.fpwithsoap.bridge.service;

import ec.edu.espe.fpwithsoap.bridge.dto.ClientSerializer;
import ec.edu.espe.fpwithsoap.bridge.soap.CrearClienteRequest;
import ec.edu.espe.fpwithsoap.bridge.soap.CrearClienteResponse;
import ec.edu.espe.fpwithsoap.bridge.soap.ClienteRQ;
import ec.edu.espe.fpwithsoap.bridge.soap.SoapClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

@Service
@RequiredArgsConstructor
@Component("Cliente")
public class ClientService extends WebServiceGatewaySupport {

    public String endpoint = "http://localhost:8080/ws/cliente.wsdl";

    public String echo(){
        return "echo";
    }

    public ClientSerializer retrieve(String identityCard){
        ClientSerializer clientSerializer = ClientSerializer.builder().build();
        // TODO
        return clientSerializer;
    }

    public String create(ClientSerializer clientSerializer){        
        ClienteRQ client = new ClienteRQ();
        client.setCedula(clientSerializer.getCedula());
        client.setNombre(clientSerializer.getNombre());
        client.setApellido(clientSerializer.getApellido());
        client.setCorreo(clientSerializer.getCorreo());
        client.setDireccion(clientSerializer.getDireccion());
        
        CrearClienteRequest request = new CrearClienteRequest();
        request.setClienteRQ(client);
        
        CrearClienteResponse response = (CrearClienteResponse) getWebServiceTemplate().marshalSendAndReceive(endpoint, request);
        return response.getStatus();
    }

    public void update(ClientSerializer clientSerializer){
        // TODO
    }
}
