package tn.esprit.autoloc.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entities.Employe;
import tn.esprit.autoloc.services.IEmployeService;

import java.util.List;

@RestController
@RequestMapping("/api/employes")
@RequiredArgsConstructor
public class EmployeController {

    private final IEmployeService employeService;

    @PostMapping
    public ResponseEntity<Employe> add(@RequestBody Employe employe) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(employeService.ajouterEmploye(employe));
    }

    @GetMapping
    public ResponseEntity<List<Employe>> getAll() {
        return ResponseEntity.ok(employeService.afficherEmployes());
    }


    @PutMapping
    public ResponseEntity<Employe> update(@RequestBody Employe employe) {
        return ResponseEntity.ok(employeService.modifierEmploye(employe));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        employeService.supprimerEmploye(id);
        return ResponseEntity.noContent().build();
    }
}
