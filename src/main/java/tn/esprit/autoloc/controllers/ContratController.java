package tn.esprit.autoloc.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entities.Contrat;
import tn.esprit.autoloc.services.IContratService;

import java.util.List;

@RestController
@RequestMapping("/api/contrats")
@RequiredArgsConstructor
public class ContratController {

    private final IContratService contratService;

    @PostMapping
    public ResponseEntity<Contrat> add(@RequestBody Contrat contrat) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(contratService.ajouterContrat(contrat));
    }

    @GetMapping
    public ResponseEntity<List<Contrat>> getAll() {
        return ResponseEntity.ok(contratService.afficherContrat());
    }


    @PutMapping
    public ResponseEntity<Contrat> update(@RequestBody Contrat contrat) {
        return ResponseEntity.ok(contratService.modifierContrat(contrat));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        contratService.supprimerContrat(id);
        return ResponseEntity.noContent().build();
    }
}
