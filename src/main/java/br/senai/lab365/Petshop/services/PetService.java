package br.senai.lab365.Petshop.services;

import br.senai.lab365.Petshop.controllers.dto.PetRequest;
import br.senai.lab365.Petshop.models.Guardian;
import br.senai.lab365.Petshop.models.Pet;
import br.senai.lab365.Petshop.repositories.GuardianRepository;
import br.senai.lab365.Petshop.repositories.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    private final PetRepository petRepository;
    private final GuardianRepository guardianRepository;

    public PetService(PetRepository petRepository, GuardianRepository guardianRepository) {
        this.petRepository = petRepository;
        this.guardianRepository = guardianRepository;
    }

    public Pet add(Pet pet) {
        petRepository.add(pet);
        return pet;
    }

    public List<Pet> list() {
        return petRepository.list();
    }

    public Pet search(long id) {
        return petRepository.search(id);
    }

    public boolean remove(long id) {
        var petToBeRemoved = petRepository.search(id);
        if (petToBeRemoved != null) {
            petRepository.remove(petToBeRemoved);
            return true;
        }
        return false;
    }

    public Pet update(long id, Pet pet) {
        var petToBeUpdated = petRepository.search(pet.getId());
        if (petToBeUpdated != null) {
            petToBeUpdated.setName(pet.getName());
            petToBeUpdated.setSpecies(pet.getSpecies());
            petToBeUpdated.setSex(pet.getSex());
            petToBeUpdated.setBreed(pet.getBreed());
            petToBeUpdated.setWeight(pet.getWeight());
            petToBeUpdated.setBirthDate(pet.getBirthDate());
            return petToBeUpdated;
        } else {
            return null;
        }
    }

    public Pet savePet (PetRequest request) {
        Pet petToBeSaved = new Pet();
        petToBeSaved.setName(request.getName());
        petToBeSaved.setSpecies(request.getSpecies());
        petToBeSaved.setBreed(request.getBreed());
        petToBeSaved.setSex(request.getSex());
        petToBeSaved.setWeight(request.getWeight());
        petToBeSaved.setBirthDate(request.getBirthDate());
        Guardian guardian = guardianRepository.search(request.getGuardianId());
        petToBeSaved.setGuardian(guardian);
        petRepository.add(petToBeSaved);
        return petToBeSaved;
    }


    public boolean setGuardian(long petId, long guardianId){
        Pet pet = petRepository.search(petId);
        Guardian guardian = guardianRepository.search(guardianId);
        if (pet != null && guardian != null) {
            return petRepository.setGuardian(petId, guardian);
        }
        return false;
    }

}
