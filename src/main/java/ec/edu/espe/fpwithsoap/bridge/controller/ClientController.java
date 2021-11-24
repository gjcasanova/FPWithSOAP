package ec.edu.espe.fpwithsoap.bridge.controller;

import ec.edu.espe.fpwithsoap.bridge.dto.ClientSerializer;
import ec.edu.espe.fpwithsoap.bridge.dto.EchoSerializer;
import ec.edu.espe.fpwithsoap.bridge.service.ClientService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

@Slf4j
@RestController
@Data
@RequestMapping("/api/v1/clients/")
public class ClientController {
    
    @Autowired
    private ClientService clientService;    

    @GetMapping("/echo")
    public ResponseEntity echo(){
        String message = clientService.echo();
        EchoSerializer responseBody = EchoSerializer.builder().message(message).build();
        return ResponseEntity.ok(responseBody);
    }

    @PostMapping("/")
    public ResponseEntity create(@RequestBody ClientSerializer requestBody){        
        try{
            log.info("Creando cliente: {},{},{},{},{}", requestBody.getCedula(), requestBody.getNombre(), requestBody.getApellido(), requestBody.getCorreo(), requestBody.getDireccion());
            String message = clientService.create(requestBody);                        
            log.info("{}",message);
            return ResponseEntity.ok(message);                
        }catch (Exception e){  
            log.info("Error creando cliente: {},{},{},{},{}", requestBody.getCedula(), requestBody.getNombre(), requestBody.getApellido(), requestBody.getCorreo(), requestBody.getDireccion());                      
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/{identityCard}/")
    public ResponseEntity retrieve(@PathVariable String identityCard){
        log.info("Buscando cliente con C.I.: {}", identityCard);
        try{
            ClientSerializer response = clientService.retrieve(identityCard);
            return ResponseEntity.ok(response);
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PutMapping("/")
    public ResponseEntity update(@RequestBody ClientSerializer requestBody){
        try{
            log.info("Actualizando cliente: {},{},{},{},{}", requestBody.getCedula(), requestBody.getNombre(), requestBody.getApellido(), requestBody.getCorreo(), requestBody.getDireccion());
            String message = clientService.update(requestBody);
            log.info("{}",message);
            return ResponseEntity.ok(message);                 
        }catch (Exception e){  
            log.info("Error actualizando cliente: {},{},{},{},{}", requestBody.getCedula(), requestBody.getNombre(), requestBody.getApellido(), requestBody.getCorreo(), requestBody.getDireccion());          
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
