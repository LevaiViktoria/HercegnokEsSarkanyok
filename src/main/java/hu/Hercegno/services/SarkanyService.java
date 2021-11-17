package hu.Hercegno.services;

import hu.Hercegno.domain.Sarkany;
import hu.Hercegno.repositories.SarkanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class SarkanyService {

    @Autowired
    private SarkanyRepository repository;


    public List<Sarkany> getSarkanyok() {
        return repository.findAllByOrderByNev();
    }


    public Sarkany getSarkany(int id) {
        Optional<Sarkany> sarkany = repository.findById(id);
        if (sarkany.isPresent())
            return sarkany.get();
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
