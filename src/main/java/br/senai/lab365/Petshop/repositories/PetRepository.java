package br.senai.lab365.Petshop.repositories;

import br.senai.lab365.Petshop.models.Guardian;
import br.senai.lab365.Petshop.models.Pet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PetRepository {

    private static final List<Pet> pets = new ArrayList<>();
    private static long lastId;

    public List<Pet> list() {
        return pets;
    }

    public void add(Pet pet) {
        pet.setId(++lastId);
        pets.add(pet);
    }

    public void remove(Pet pet) {
        pets.remove(pet);
    }

    public Pet search(long id) {
        return pets.stream().filter(pet -> id == pet.getId()).findFirst().orElse(null);
    }


}
