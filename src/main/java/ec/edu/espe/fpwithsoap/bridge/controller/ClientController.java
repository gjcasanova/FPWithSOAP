package ec.edu.espe.fpwithsoap.bridge.controller;

import ec.edu.espe.fpwithsoap.bridge.dto.ClientSerializer;
import ec.edu.espe.fpwithsoap.bridge.dto.EchoSerializer;
import ec.edu.espe.fpwithsoap.bridge.service.ClientService;
import lombok.Data;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        String message = clientService.create(requestBody);
        EchoSerializer responseBody = EchoSerializer.builder().message(message).build();
        return ResponseEntity.ok(responseBody);
    }

    @GetMapping("/{identityCard}/")
    public ResponseEntity retrieve(@PathVariable String identityCard){
        // TODO
        return ResponseEntity.ok().build();
    }

    @PutMapping("/")
    public ResponseEntity update(@RequestBody ClientSerializer requestBody){
        // TODO
        return ResponseEntity.ok().build();
    }
}
