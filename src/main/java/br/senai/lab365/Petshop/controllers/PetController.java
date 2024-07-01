package br.senai.lab365.Petshop.controllers;

import br.senai.lab365.Petshop.controllers.dto.PetRequest;
import br.senai.lab365.Petshop.models.Guardian;
import br.senai.lab365.Petshop.models.Pet;
import br.senai.lab365.Petshop.services.GuardianService;
import br.senai.lab365.Petshop.services.PetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

    private final PetService petService;
    private final GuardianService guardianService;

    public PetController(PetService petService, GuardianService guardianService) {
        this.petService = petService;
        this.guardianService = guardianService;
    }

    @PostMapping()
    public Pet add(@RequestBody PetRequest pet) {
        return petService.savePet(pet);
    }

    @GetMapping()
    public List<Pet> list() {
        var pets = petService.list();
        if (pets.isEmpty()){
            return null;
        } else {
        return pets;
        }
    }

    @GetMapping("/{id}")
    public Pet search(@PathVariable long id) {
        Pet pet = petService.search(id);
        if (pet != null) {
            return  pet;
        } else {
            throw new RuntimeException("404");
        }
    }

    @DeleteMapping("/{id}")
    public String remove(@PathVariable long id) {
        return petService.remove(id)
                ? "Pet excluído com sucesso."
                :  String.format("Pet com id: %d não foi encontrado.", id);
    }

    @PutMapping("/{id}")
    public Pet update(@PathVariable long id, @RequestBody Pet updatedPet) {
        Pet pet = petService.update(id, updatedPet);
        if (pet != null) {
            return pet;
        } else {
            throw new RuntimeException("404");
        }
    }


}
