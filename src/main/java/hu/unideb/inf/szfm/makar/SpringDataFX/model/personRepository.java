package hu.unideb.inf.szfm.makar.SpringDataFX.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface personRepository extends JpaRepository<Person, Long> {

}
