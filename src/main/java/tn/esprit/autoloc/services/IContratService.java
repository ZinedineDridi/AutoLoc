package tn.esprit.autoloc.services;

import tn.esprit.autoloc.entities.Contrat;
import java.util.List;

public interface IContratService {
    Contrat ajouterContrat(Contrat contrat);
    Contrat modifierContrat(Contrat contrat);
    List<Contrat> afficherContrat();
    void supprimerContrat(Long id);
}