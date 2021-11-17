package hu.Hercegno.repositories;

import hu.Hercegno.domain.Hercegno;
import hu.Hercegno.domain.Sarkany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface HercegnoRepository extends JpaRepository<Hercegno, Integer> {
    public List<Hercegno> findAllBySarkany(Sarkany sarkany);
}
