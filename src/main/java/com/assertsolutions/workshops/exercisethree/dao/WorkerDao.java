package com.assertsolutions.workshops.exercisethree.dao;

import org.springframework.data.repository.CrudRepository;

import com.assertsolutions.workshops.exercisethree.entity.Worker;

public interface WorkerDao extends CrudRepository<Worker, Long>{

}
