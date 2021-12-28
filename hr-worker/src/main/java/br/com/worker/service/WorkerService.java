package br.com.worker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.worker.entities.Worker;
import br.com.worker.repositories.WorkerRepository;

@Service
public class WorkerService {
    
    @Autowired
    private WorkerRepository workerRepository;
    
    public List<Worker> findAllWorkers() {
        return workerRepository.findAll();
    }
    
    public Optional<Worker> findByIdWorker(Long id){
        return workerRepository.findById(id);
    }

}
