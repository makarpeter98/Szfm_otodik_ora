package inf.unideb.szfm.makar;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.h2.tools.Server;

public class Application {

    public static void main(String[] args) throws Exception {
        startDatabase();

//        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("br.com.fredericci.pu");
//        final EntityManager entityManager = entityManagerFactory.createEntityManager();

//        Customer customer = new Customer();
//        customer.setName("Nagy Janos");
//        customer.setGender(GenderEnum.MALE);
//        customer.setAge(70);
//
//        Animal dragon = new Animal();
//        dragon.setName("Drogon");
//        dragon.setAge(7);
//        dragon.setGender(GenderEnum.MALE);

//        entityManager.getTransaction().begin();
//        entityManager.persist(customer);
//        entityManager.persist(dragon);
//        entityManager.getTransaction().commit();


        try(AnimalDAO aDAO = new JpaAnimalDAO())
        {
//            Customer customer = new Customer();
//            customer.setName("Nagy Janos");
//            customer.setGender(GenderEnum.MALE);
//            customer.setAge(70);

            Animal dragon = new Animal();
            dragon.setName("Drogon");
            dragon.setAge(7);
            dragon.setGender(GenderEnum.MALE);
            aDAO.saveAnimal(dragon);

            Animal dragon_2 = new Animal();
            dragon_2.setName("Rhaegar");
            dragon_2.setAge(7);
            dragon_2.setGender(GenderEnum.MALE);
            aDAO.saveAnimal(dragon_2);

            System.out.println("Drogon és Nagy Janos letrehozva Enter....");
            (new Scanner(System.in)).nextLine();

            List<Animal> aList = aDAO.getAnimals();

            for(Animal a : aList)
            {
                a.setAge(a.getAge()+1);
                aDAO.saveAnimal(a);
            }

            System.out.println("Sarkanyok eletkora novelve Enter....");
            (new Scanner(System.in)).nextLine();

            Zoo zoo = new Zoo();
            zoo.setName("Dragons KLÁN");
            zoo.getAnimals().addAll(aList);
            aDAO.saveZoo(zoo);

            System.out.println("Allatkert elmentve Enter....");
            (new Scanner(System.in)).nextLine();
        }

        System.out.println("Open your browser and navigate to http://localhost:8082/");
        System.out.println("JDBC URL: jdbc:h2:mem:my_database");
        System.out.println("User Name: sa");
        System.out.println("Password: ");

    }

    private static void startDatabase() throws SQLException {
        new Server().runTool("-tcp", "-web", "-ifNotExists");
    }
}
