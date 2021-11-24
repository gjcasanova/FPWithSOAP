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
        log.info("Creatting client: {}", requestBody.getCedula());
        String message = clientService.create(requestBody);
        EchoSerializer responseBody = EchoSerializer.builder().message(message).build();
        return ResponseEntity.ok(responseBody);                
    }

    @GetMapping("/{identityCard}/")
    public ResponseEntity retrieve(@PathVariable String identityCard){
        log.info("Searching client with identity card: {}", identityCard);
        try{
            ClientSerializer response = clientService.retrieve(identityCard);
            return ResponseEntity.ok(response);
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PutMapping("/")
    public ResponseEntity update(@RequestBody ClientSerializer requestBody){
        // TODO
        return ResponseEntity.ok().build();
    }
}
