package hu.unideb.inf.szfm.makar.SpringDataFX;

import hu.unideb.inf.szfm.makar.SpringDataFX.model.Person;
import hu.unideb.inf.szfm.makar.SpringDataFX.model.personRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
class SpringJavaFxApplicationTests {

    @Autowired
    private personRepository personRepository;
    @Test
    void contextLoads() {
        System.out.println("Test futtatasa!");
        Person person = Person.builder()
                .age(20)
                .name("Sanyi a ló")
                .build();

        Person savedPerson = personRepository.save(person);
        Assertions.assertThat(savedPerson).isNotNull();
        Assertions.assertThat(savedPerson.getId()).isGreaterThan(0);
        Assertions.assertThat(savedPerson.getName()).isEqualTo(person.getName());
        Assertions.assertThat(savedPerson.getAge()).isEqualTo(person.getAge());
    }

    @Test
    void testFindAllPersons() {
        Iterable<Person> persons = personRepository.findAll();
        Assertions.assertThat(persons).hasSizeGreaterThan(0);

        for (Person p : persons) {
            System.out.println(p);
        }
    }

    @Test
    void testUpdatePerson() {
        Person person = Person.builder()
                .name("Rebeka")
                .age(21)
                .build();

        Person p1 = personRepository.save(person);
        p1.setAge(31);
        Person p2 = personRepository.save(p1);

        Assertions.assertThat(p2.getAge()).isEqualTo(31);
        Assertions.assertThat(p2.getName()).isEqualTo("Rebeka");
    }
}
