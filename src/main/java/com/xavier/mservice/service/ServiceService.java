package com.xavier.mservice.service;

import com.xavier.mservice.model.Service;
import com.xavier.mservice.repository.ServiceRepository;
import com.xavier.mservice.service.exception.ServiceExistException;
import com.xavier.mservice.service.exception.ServiceNotFoundExcetion;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;


@org.springframework.stereotype.Service
public class ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;

    public ServiceService(@Autowired ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public Service save(final Service service) {
        verifyIfServiceExist(service);
        return serviceRepository.save(service);
    }

    public List<Service> findAll() {
        return serviceRepository.findAll();
    }

    public void delete(Long id) {
        Optional<Service> foundService = serviceRepository.findById(id);
        if (!foundService.isPresent()) {
            throw new ServiceNotFoundExcetion();
        }
        serviceRepository.deleteById(id);
    }

    private void verifyIfServiceExist(Service service) {
        Optional<Service> foundService = serviceRepository.findByServiceName(service.getServiceName());
        if (foundService.isPresent() && (service.isNew() || isUpdatingToADifferentService(service, foundService))) {
            throw new ServiceExistException();
        }
    }

    private boolean isUpdatingToADifferentService(Service service, Optional<Service> foundService) {
        return service.Exist() && !service.equals(foundService.get());
    }
}
