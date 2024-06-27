package br.senai.lab365.Petshop.services;

import br.senai.lab365.Petshop.models.Guardian;
import br.senai.lab365.Petshop.repositories.GuardianRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuardianService {

    private final GuardianRepository guardianRepository;

    public GuardianService(GuardianRepository guardianRepository){
        this.guardianRepository = guardianRepository;
    }

    public Guardian add(Guardian guardian){
        guardianRepository.add(guardian);
        return guardian;
    }

    public List<Guardian> list(){
        return guardianRepository.list();
    }

    public Guardian search(long id){
        return guardianRepository.search(id);
    }
    
    public boolean remove(long id){
        var guardianToBeRemoved = guardianRepository.search(id);
        if (guardianToBeRemoved != null) {
            guardianRepository.remove(guardianToBeRemoved);
            return true;
        }
        return false;
    }

    public Guardian update(long id, Guardian guardian) {
        var guardianToBeUpdated = guardianRepository.search(guardian.getId());
        if (guardianToBeUpdated != null) {
            guardianToBeUpdated.setName(guardian.getName());
            guardianToBeUpdated.setPhone(guardian.getPhone());
            guardianToBeUpdated.setAddress(guardian.getAddress());
            guardianToBeUpdated.setEmail(guardian.getEmail());
            return guardianToBeUpdated;
        } else {
            return null;
        }
    }

}
