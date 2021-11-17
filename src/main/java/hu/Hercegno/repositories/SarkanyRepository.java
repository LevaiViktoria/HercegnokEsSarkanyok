package hu.Hercegno.repositories;


import hu.Hercegno.domain.Sarkany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SarkanyRepository extends JpaRepository<Sarkany , Integer> {
    public List <Sarkany> findAllByOrderByNev();
}
