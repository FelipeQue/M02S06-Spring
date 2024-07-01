package br.senai.lab365.Petshop.repositories;

import br.senai.lab365.Petshop.models.Guardian;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GuardianRepository {

    private static final List<Guardian> guardians = new ArrayList<>();
    private static long lastId;

    public List<Guardian> list() {
        return guardians;
    }

    public void add(Guardian guardian) {
        guardian.setId(++lastId);
        guardians.add(guardian);
    }

    public void remove(Guardian guardian) {
        guardians.remove(guardian);
    }

    public Guardian search(long id) {
        return guardians.stream().filter(guardian -> id == guardian.getId()).findFirst().orElse(null);
    }


}
