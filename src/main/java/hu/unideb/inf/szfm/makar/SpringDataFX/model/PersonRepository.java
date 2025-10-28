package hu.unideb.inf.szfm.makar.SpringDataFX.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
