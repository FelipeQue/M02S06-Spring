package br.senai.lab365.Petshop.models;

import java.time.LocalDate;
import java.util.Map;

public class Pet {

    private long id;
    private String name;
    private String species;
    private String breed;
    private double weight;
    private String birthDate;
    private Map<LocalDate, Double> weightHistory;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Map<LocalDate, Double> getWeightHistory() {
        return weightHistory;
    }

    public void setWeightHistory(Map<LocalDate, Double> weightHistory) {
        this.weightHistory = weightHistory;
    }
}
