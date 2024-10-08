package inf.unideb.szfm.makar;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Zoo {

    private int id;

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String name;

    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Set<Animal> animals = new HashSet<>();

    @OneToMany
    @JoinColumn(name="zoo_id")
    public Set<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(Set<Animal> animals) {
        this.animals = animals;
    }
}
