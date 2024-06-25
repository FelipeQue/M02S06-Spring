package br.senai.lab365.Petshop.controllers;

import br.senai.lab365.Petshop.models.Pet;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/pets")
public class PetController {

    @PostMapping()
    public String add() {
        return "Cadastrar foi chamado.";
    }

    @GetMapping()
    public String list() {
        return "Listar foi chamado.";
    }

    @GetMapping("/{id}")
    public String search(@PathVariable int id) {
        return "Buscar (por id) foi chamado.";

    }

    @DeleteMapping("/{id}")
    public String remove(@PathVariable int id) {
        return "Excluir foi chamado.";
    }

    @PutMapping
    public String update() {
        return "Atualizar foi chamado.";
    }


}
