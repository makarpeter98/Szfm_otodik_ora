package inf.unideb.szfm.makar;
import java.util.List;

public interface AnimalDAO extends AutoCloseable {

    public void saveAnimal(Animal a);
    public void deleteAnimal(Animal a);
    public void updateAnimal(Animal a);
    public List<Animal> getAnimals();

    public void saveZoo(Zoo zoo);
}
