package com.github.mbelduque.apirest.controller;

import com.github.mbelduque.apirest.model.Service;
import com.github.mbelduque.apirest.repository.ServiceRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@Api(value = "API REST Demo")
@RequestMapping(value = "/api")
public class ServiceEndpoint {

    @Autowired
    ServiceRepository serviceRepository;

    @GetMapping("/services")
    @ApiOperation(value = "Returns a list of services")
    public List<Service> getServices() {
        return serviceRepository.findAll();
    }

    @GetMapping("/service/{id}")
    @ApiOperation(value = "Read a service")
    public Service getService(@PathVariable(value = "id") long id) {
        return serviceRepository.findById(id);
    }

    @PostMapping("/service")
    @ApiOperation(value = "Create a new service")
    public Service postService(@RequestBody Service service) {
        return serviceRepository.save(service);
    }

    @DeleteMapping("/service")
    @ApiOperation(value = "Delete a service")
    public void deleteService(@RequestBody Service service) {
        serviceRepository.delete(service);
    }

    @PutMapping("/service")
    @ApiOperation(value = "Update a service")
    public Service putService(@RequestBody Service service) {
        return serviceRepository.save(service);
    }

}
