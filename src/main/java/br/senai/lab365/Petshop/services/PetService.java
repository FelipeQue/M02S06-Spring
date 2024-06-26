package br.senai.lab365.Petshop.services;

import br.senai.lab365.Petshop.models.Pet;
import br.senai.lab365.Petshop.repositories.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    private final PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
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

}
