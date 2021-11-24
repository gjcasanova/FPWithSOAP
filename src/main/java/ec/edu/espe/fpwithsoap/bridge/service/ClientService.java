package ec.edu.espe.fpwithsoap.bridge.service;

import ec.edu.espe.fpwithsoap.bridge.dto.ClientSerializer;
import ec.edu.espe.fpwithsoap.bridge.soap.CrearClienteRequest;
import ec.edu.espe.fpwithsoap.bridge.soap.CrearClienteResponse;
import ec.edu.espe.fpwithsoap.bridge.soap.BuscarClientePorCedulaRequest;
import ec.edu.espe.fpwithsoap.bridge.soap.BuscarClientePorCedulaResponse;
import ec.edu.espe.fpwithsoap.bridge.soap.ClienteRQ;
import ec.edu.espe.fpwithsoap.bridge.soap.ActualizarClienteRequest;
import ec.edu.espe.fpwithsoap.bridge.soap.ActualizarClienteResponse;
import ec.edu.espe.fpwithsoap.bridge.soap.ClienteActualizarRQ;
import ec.edu.espe.fpwithsoap.bridge.soap.SoapClient;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

@Service
@Slf4j
@RequiredArgsConstructor
@Component("Cliente")
public class ClientService extends WebServiceGatewaySupport {

    public String endpoint = "http://localhost:8080/ws/cliente.wsdl";

    public String echo(){
        return "echo";
    }

    public ClientSerializer retrieve(String identityCard){
        ClientSerializer clientSerializer;
        BuscarClientePorCedulaRequest request = new BuscarClientePorCedulaRequest();
        request.setCedula(identityCard);
        BuscarClientePorCedulaResponse response = (BuscarClientePorCedulaResponse) getWebServiceTemplate().marshalSendAndReceive(endpoint, request);
        clientSerializer = ClientSerializer.builder()
            .nombre(response.getStatus().getNombre())
            .apellido(response.getStatus().getApellido())
            .cedula(response.getStatus().getCedula())
            .correo(response.getStatus().getCorreo())
            .direccion(response.getStatus().getDireccion())
            .build();
        log.info("Respuesta de SOAP: {} ", clientSerializer.toString());
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
        log.info("Respuesta de SOAP: {} ", response.getStatus());
        return response.getStatus();
    }

    public String update(ClientSerializer clientSerializer){
        ClienteActualizarRQ client = new ClienteActualizarRQ();
        client.setNombre(clientSerializer.getNombre());
        client.setApellido(clientSerializer.getApellido());        
        client.setDireccion(clientSerializer.getDireccion());        
        ActualizarClienteRequest request = new ActualizarClienteRequest();
        request.setClienteRQ(client);
        request.setCedula(clientSerializer.getCedula());        
        ActualizarClienteResponse response = (ActualizarClienteResponse) getWebServiceTemplate().marshalSendAndReceive(endpoint, request);
        log.info("Respuesta de SOAP: {} ", response.getStatus());
        return response.getStatus();
    }
}
