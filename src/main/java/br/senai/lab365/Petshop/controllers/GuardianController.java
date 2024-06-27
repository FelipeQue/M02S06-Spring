package br.senai.lab365.Petshop.controllers;

import br.senai.lab365.Petshop.models.Guardian;
import br.senai.lab365.Petshop.services.GuardianService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guardians")
public class GuardianController {

    private final GuardianService guardianService;

    public GuardianController(GuardianService guardianService) {
        this.guardianService = guardianService;
    }

    @PostMapping()
    public Guardian add(@RequestBody Guardian guardian) {
        return guardianService.add(guardian);
    }

    @GetMapping()
    public List<Guardian> list() {
        var guardians = guardianService.list();
        if (guardians.isEmpty()){
            return null;
        } else {
            return guardians;
        }
    }

    @GetMapping("/{id}")
    public Guardian search(@PathVariable long id) {
        Guardian guardian = guardianService.search(id);
        if (guardian != null) {
            return guardian;
        } else {
            throw new RuntimeException("404");
        }
    }

    @DeleteMapping("/{id}")
    public String remove(@PathVariable long id) {
        return guardianService.remove(id)
                ? "Pessoa tutora removida com sucesso."
                :  String.format("Pessoa tutora com o id: %d não encontrada.", id);
    }

    @PutMapping("/{id}")
    public Guardian update(@PathVariable long id, @RequestBody Guardian updatedGuardian) {
        Guardian guardian = guardianService.update(id, updatedGuardian);
        if (guardian != null){
            return guardian;
        } else {
            throw new RuntimeException("404");
        }

    }
}
