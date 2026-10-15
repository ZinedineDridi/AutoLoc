package tn.esprit.autoloc.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.entities.Contrat;
import tn.esprit.autoloc.repositories.ContratRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContratService implements IContratService{

    private final ContratRepository contratRepository;

    @Override
    public Contrat ajouterContrat(Contrat contrat){
        return contratRepository.save(contrat);
    }

    @Override
    public Contrat modifierContrat(Contrat contrat){
        return contratRepository.save(contrat);
    }

    @Override
    public List<Contrat> afficherContrat() {
        return contratRepository.findAll();
    }

    @Override
    public void supprimerContrat(Long id) {
        contratRepository.deleteById(id);
    }

}
