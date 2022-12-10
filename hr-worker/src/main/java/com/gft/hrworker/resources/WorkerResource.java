package com.gft.hrworker.resources;

import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gft.hrworker.entities.Worker;
import com.gft.hrworker.repositories.WorkerRepository;

@RestController
@RequestMapping(value= "/workers")
public class WorkerResource {
	
	private static Logger logger= org.slf4j.LoggerFactory.getLogger(WorkerResource.class);
	
	@Autowired
	private Environment env;
	
	@Autowired
	private WorkerRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll(){
		List<Worker> list= repository.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value= "/{id}")
	public ResponseEntity<Worker> findByAll(@PathVariable Long id){
		
		logger.info("PORT = " +env.getProperty("local.server.port"));
		
		Optional<Worker> obj= repository.findById(id);
		return ResponseEntity.ok(obj.get());
	}

}
