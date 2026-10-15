package tn.esprit.autoloc.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entities.Client;
import tn.esprit.autoloc.services.IClientService;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {

    private final IClientService clientService;

    @PostMapping
    public ResponseEntity<Client> add(@RequestBody Client client) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(clientService.ajouterClient(client));
    }

    @GetMapping
    public ResponseEntity<List<Client>> getAll() {
        return ResponseEntity.ok(clientService.afficherClients());
    }


    @PutMapping
    public ResponseEntity<Client> update(@RequestBody Client client) {
        return ResponseEntity.ok(clientService.modifierClient(client));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clientService.supprimerClient(id);
        return ResponseEntity.noContent().build();
    }
}
