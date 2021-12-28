package br.com.worker;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.worker.entities.Worker;
import br.com.worker.service.WorkerService;

@RestController
@RequestMapping("/workers")
public class WorkerResource {
    
    @Autowired
    private WorkerService workerService;
    
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Worker> findAllWorkers(){
        return workerService.findAllWorkers();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Worker> findByIdWorker(@PathVariable Long id){
        Optional<Worker> objResponse = workerService.findByIdWorker(id);
        if(objResponse.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(objResponse.get());
    }

}
