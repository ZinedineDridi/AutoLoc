package tn.esprit.autoloc.services;

import tn.esprit.autoloc.entities.Employe;
import java.util.List;

public interface IEmployeService {
    Employe ajouterEmploye(Employe employe);
    Employe modifierEmploye(Employe employe);
    List<Employe> afficherEmployes();
    void supprimerEmploye(Long id);
}