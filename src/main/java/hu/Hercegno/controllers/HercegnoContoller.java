package hu.Hercegno.controllers;

import hu.Hercegno.domain.Hercegno;
import hu.Hercegno.domain.Sarkany;
import hu.Hercegno.services.HercegnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HercegnoContoller {

    private HercegnoService service;

    @Autowired
    public void setHercegnoService(HercegnoService service){
        this.service =service;
    }

    @GetMapping("/hercegnok")
    public List <Hercegno> getHercegnok(){
        return service.getHercegnok();
    }
    @GetMapping("/hercegnok/{id}")
    public Hercegno getHercegno(@PathVariable("id")int id){
        return service.getHercegno(id);
    }
    @GetMapping("/hercegnok/{id}/sarkanyok")
    public List<Hercegno> getHercegnoInSarkany(@PathVariable("id")int id){
        return service.getHercegnoInSarkany(id);
    }
    @PostMapping("/hercegnok")
    @ResponseStatus(HttpStatus.CREATED)
    public Hercegno addHercegno(@RequestBody Hercegno hercegno){
        return service.addHercegno(hercegno);
    }
    @DeleteMapping("/hercegnok")
    public void deleteHercegno(@PathVariable("id")int id){
        service.deleteHercegno(id);
    }



}
