package hu.unideb.inf.szfm.makar.SpringDataFX;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import hu.unideb.inf.szfm.makar.SpringDataFX.model.PersonRepository;
import hu.unideb.inf.szfm.makar.SpringDataFX.model.Person;

@SpringBootApplication
public class SpringDataFxApplication implements CommandLineRunner{
    //Teszt komment
	public static void main(String[] args) {
		SpringApplication.run(SpringDataFxApplication.class, args);
	}

    @Autowired
    PersonRepository personRepository;

    @Override
    public void run(String... args) throws Exception {
        personRepository.save(Person.builder().name("Jóska Pista").age(40).build());
        personRepository.save(Person.builder().name("Nagy Erika").age(5).build());
        personRepository.save(Person.builder().name("Gandalf").age(4000).build());
        personRepository.save(Person.builder().name("Dezső").age(99).build());
        printAll();
    }
    public void printAll(){

        Iterable<Person> persons= personRepository.findAll();

        for (Person p: persons) {
            System.out.println(p);
        }
    }

}
