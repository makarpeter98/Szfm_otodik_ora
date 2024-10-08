package inf.unideb.szfm.makar;

import java.util.List;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.h2.tools.Server;

public class JpaAnimalDAO implements AnimalDAO{

    final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("br.com.fredericci.pu");
    final EntityManager entityManager = entityManagerFactory.createEntityManager();


    @Override
    public void saveAnimal(Animal a) {
        entityManager.getTransaction().begin();
        entityManager.persist(a);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteAnimal(Animal a) {
        entityManager.getTransaction().begin();
        entityManager.remove(a);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateAnimal(Animal a) {
        saveAnimal(a);
    }

    @Override
    public List<Animal> getAnimals() {
        TypedQuery<Animal> query = entityManager.createQuery(
                "SELECT a FROM Animal a", Animal.class);

        List<Animal> animals = query.getResultList();

        return animals;
    }

    @Override
    public void saveZoo(Zoo zoo) {
        entityManager.getTransaction().begin();
        entityManager.persist(zoo);
        entityManager.getTransaction().commit();
    }

    @Override
    public void close() throws Exception {
        entityManager.close();
        entityManagerFactory.close();
    }
}
