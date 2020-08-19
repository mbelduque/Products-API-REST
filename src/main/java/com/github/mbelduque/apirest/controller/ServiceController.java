package com.github.mbelduque.apirest.controller;

import com.github.mbelduque.apirest.model.Service;
import com.github.mbelduque.apirest.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api")
public class ServiceController {

    @Autowired
    ServiceRepository serviceRepository;

    @GetMapping("/services")
    public List<Service> getServices() {
        return serviceRepository.findAll();
    }

    @GetMapping("/service/{id}")
    public Service getService(@PathVariable(value = "id") long id) {
        return serviceRepository.findById(id);
    }

    @PostMapping("/service")
    public Service postService(@RequestBody Service service) {
        return serviceRepository.save(service);
    }

    @DeleteMapping("/service")
    public void deleteService(@RequestBody Service service) {
        serviceRepository.delete(service);
    }

    @PutMapping("/service")
    public Service putService(@RequestBody Service service) {
        return serviceRepository.save(service);
    }

}
