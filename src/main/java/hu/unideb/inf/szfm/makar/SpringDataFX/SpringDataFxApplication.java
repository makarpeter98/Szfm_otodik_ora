package hu.unideb.inf.szfm.makar.SpringDataFX;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import hu.unideb.inf.szfm.makar.SpringDataFX.model.personRepository;
import hu.unideb.inf.szfm.makar.SpringDataFX.model.Person;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class SpringDataFxApplication implements CommandLineRunner{
    //Teszt komment
	public static void main(String[] args) {
		SpringApplication.run(SpringDataFxApplication.class, args);
	}
    Scanner scanner = new Scanner(System.in);
    @Autowired
    personRepository personRepository;

    @Override
    public void run(String... args) throws Exception {
        personRepository.save(Person.builder().name("Jóska Pista").age(40).build());
        personRepository.save(Person.builder().name("Nagy Erika").age(5).build());
        personRepository.save(Person.builder().name("Gandalf").age(4000).build());
        personRepository.save(Person.builder().name("Dezső").age(99).build());
        printAll();
        //System.out.println("Nyomj Entert a folytatáshoz...");
        //scanner.nextLine();

        List<Person> persons = personRepository.findAll();

        for (Person p : persons) {
            if( p.getName() == "Jóska Pista" )
            {
                personRepository.delete(p);
            }
        }

        printAll();
        //System.out.println("Nyomj Entert a folytatáshoz...");
        //scanner.nextLine();

        persons = personRepository.findAll();
        int IdToModify = -1;
        for (Person p : persons) {
            if( p.getName() == "Gandalf" )
            {
                p.setAge(4001);
                personRepository.save(p);
            }
        }

        printAll();

    }
    public void printAll(){
        System.out.println("");
        Iterable<Person> persons= personRepository.findAll();

        for (Person p: persons) {
            System.out.println(p);
        }
        System.out.println("");

    }

}
