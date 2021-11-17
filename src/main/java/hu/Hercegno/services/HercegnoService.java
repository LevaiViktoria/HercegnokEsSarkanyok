package hu.Hercegno.services;

import hu.Hercegno.domain.Hercegno;
import hu.Hercegno.domain.Sarkany;
import hu.Hercegno.repositories.HercegnoRepository;
import hu.Hercegno.repositories.SarkanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class HercegnoService {


    @Autowired
    private HercegnoRepository repository;
    @Autowired
    private SarkanyRepository sarkanyRepository;

    public List<Hercegno> getHercegnok() {
        return repository.findAll();
    }

    public Hercegno getHercegno(int id) {
        Optional<Hercegno> hercegno = repository.findById(id);
        if (hercegno.isPresent()){
            return hercegno.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public List<Hercegno> getHercegnoInSarkany(int id) {
        Optional<Sarkany> sarkany = sarkanyRepository.findById(id);
        if (sarkany.isPresent()){
            return repository.findAllBySarkany(sarkany.get());
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public Hercegno addHercegno(Hercegno hercegno) {
        if (isUnique(hercegno.getNev()))
            return repository.save(hercegno);
        throw new ResponseStatusException(HttpStatus.CONFLICT);
    }

    private boolean isUnique(String nev) {
        List <Hercegno> hercegnok = repository.findAll();
        for (Hercegno hercegno: hercegnok) {
            if (hercegno.getNev().equals(nev))
                return false;
        }
        return true;
    }

    public void deleteHercegno(int id) {
        Optional<Hercegno> hercegno = repository.findById(id);
        if (hercegno.isPresent()){
            repository.deleteById(id);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }


}
