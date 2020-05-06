package onetomanymapping.example.springcontinue.repository;

import onetomanymapping.example.springcontinue.entities.City;
import onetomanymapping.example.springcontinue.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country,Integer> {
}
