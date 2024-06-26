package br.senai.lab365.Petshop.controllers;

import br.senai.lab365.Petshop.models.Pet;
import br.senai.lab365.Petshop.services.PetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping()
    public Pet add(@RequestBody Pet pet) {
        return petService.add(pet);
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
        return petService.search(id);
    }

    @DeleteMapping("/{id}")
    public String remove(@PathVariable long id) {
        return petService.remove(id)
                ? "Pet excluído com sucesso."
                :  String.format("Pet com id: %d não foi encontrado.", id);
    }

    @PutMapping("/{id}")
    public Pet update(@PathVariable long id, @RequestBody Pet petAtualizado) {
        Pet pet = petService.update(id, petAtualizado);
        if (pet != null) {
            return pet;
        } else {
            throw new RuntimeException("404");
        }
    }


}
