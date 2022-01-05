package br.com.worker.resource;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.worker.entities.Worker;
import br.com.worker.service.WorkerService;

@RestController
@RequestMapping("/workers")
public class WorkerResource {
    
    public static Logger logger = org.slf4j.LoggerFactory.getLogger(WorkerResource.class);
    
    @Autowired
    private Environment env;
    
    @Autowired
    private WorkerService workerService;
    
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Worker> findAllWorkers(){
        return workerService.findAllWorkers();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Worker> findByIdWorker(@PathVariable Long id){
        
        logger.info("PORT " + env.getProperty("local.server.port"));
        
        Optional<Worker> objResponse = workerService.findByIdWorker(id);
        if(objResponse.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(objResponse.get());
    }

}
