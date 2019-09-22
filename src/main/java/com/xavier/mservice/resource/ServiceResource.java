package com.xavier.mservice.resource;

import com.xavier.mservice.model.Service;
import com.xavier.mservice.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/services")
public class ServiceResource {

    @Autowired
    private ServiceService sService;

    @GetMapping
    public List<Service> findAll() {
        return sService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Service create(@Valid @RequestBody Service service) {
        return sService.save(service);
    }

    @PutMapping("/{id}")
    public Service update(@PathVariable Long id, @Valid @RequestBody Service service) {
        service.setServiceId(id);
        return sService.save(service);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id) {
        sService.delete(id);
    }
}
