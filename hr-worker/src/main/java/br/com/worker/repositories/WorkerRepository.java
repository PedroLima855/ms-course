package br.com.worker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.worker.entities.Worker;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
