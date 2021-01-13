package com.boot.poc.controller;

import com.boot.poc.excepions.PatientNotFoundException;
import com.boot.poc.excepions.UserNotFoundException;
import com.boot.poc.models.Doctor;
import com.boot.poc.models.Patient;
import com.boot.poc.models.User;
import com.boot.poc.service.HospitalDaoService;
import com.boot.poc.service.UserDaoService;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/filter")
public class FilterController {

    @Autowired
    private HospitalDaoService daoService;

    //Retrieve All Users // we'll demo static filtering
    @GetMapping(path = "/doctors")
    public List<Doctor> getAllDoctors() throws PatientNotFoundException {
        return daoService.findAllDoctors();
    }
    //Retrieve All Users
    @GetMapping(path = "/patients")
    public List<Patient> getAll() throws PatientNotFoundException {
        return daoService.findAll();
    }

    //DynamicFiltering .// we'll demo Dynamic filtering
    @GetMapping(path="/dynamicfilter/patients")
    public MappingJacksonValue getAllPatients() throws PatientNotFoundException {

        List<Patient> patients=daoService.findAll();
        SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("id","name","birthDate");
        FilterProvider filterProvider=new SimpleFilterProvider().addFilter("MyHospitalFilter",filter);
        MappingJacksonValue mapping=new MappingJacksonValue(patients);
        mapping.setFilters(filterProvider);

        return mapping;
    }
    //retrieve single user
    @GetMapping(path = "/patients/{id}")
    public Patient getUser(@PathVariable int id) throws PatientNotFoundException {
        Patient patient = daoService.findOne(id);
        if (patient == null) {
            throw new PatientNotFoundException("Id-" + id);
        }
        return patient;
    }

    //Save user
    @PostMapping(path = "/patients")
    public ResponseEntity<Object> savePatient(@Valid @RequestBody Patient patient) {
        Patient savedPatient = daoService.save(patient);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPatient.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    //Completely Replace user
    @PutMapping(path = "/patients/{id}")
    public ResponseEntity<Object> updateUser(@RequestBody Patient patient,@PathVariable int id) throws PatientNotFoundException {
        Patient savedPatient = daoService.update(id,patient);
        if(savedPatient==null){
            throw new PatientNotFoundException("Id-" + id);
        }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "/patients/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable int id) throws PatientNotFoundException {
        Patient deletedUser = daoService.delete(id);
        if (deletedUser == null) {
            throw new PatientNotFoundException("Id-" + id);
        }
        return ResponseEntity.noContent().build();
    }
}
