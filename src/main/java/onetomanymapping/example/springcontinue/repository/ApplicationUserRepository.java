package onetomanymapping.example.springcontinue.repository;

import onetomanymapping.example.springcontinue.entities.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Integer> {
    ApplicationUser findByUsername(String username);
}

