package hu.Hercegno.controllers;

import hu.Hercegno.domain.Sarkany;
import hu.Hercegno.services.SarkanyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SarkanyContoller {

    private SarkanyService service;


    public SarkanyContoller(SarkanyService service) {
        this.service = service;
    }

    @GetMapping("/sarkany")
    public List<Sarkany> getSarkanyok(){
        return service.getSarkanyok();
    }

    @GetMapping("/sarkany/{id}")
    public Sarkany getSarkany(@PathVariable("id") int id){
        return service.getSarkany(id);
    }
}
