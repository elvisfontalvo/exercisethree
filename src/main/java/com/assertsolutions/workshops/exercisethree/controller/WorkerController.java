package com.assertsolutions.workshops.exercisethree.controller;

import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.assertsolutions.workshops.exercisethree.dao.WorkerDao;
import com.assertsolutions.workshops.exercisethree.entity.Worker;

@RestController
public class WorkerController {

	@Autowired
	private WorkerDao workerDao;

	private static final Log LOG = LogFactory.getLog(WorkerController.class);

	@GetMapping("/worker/getAll")
	public @ResponseBody ResponseEntity<?> getAll() {
		ResponseEntity<?> re = null;
		try {
			Iterable<Worker> workers = workerDao.findAll();
			re = new ResponseEntity<Iterable<Worker>>(workers, HttpStatus.OK);
		} catch (Exception e) {
			LOG.error("Se produjo un error al consultar los trabajadores", e);
			String error = "Se produjo un error al consultar los trabajadores";
			re = new ResponseEntity<String>(error, HttpStatus.BAD_REQUEST);
		}
		return re;
	}

	@GetMapping("/worker/getById/{id}")
	public @ResponseBody ResponseEntity<?> getById(@PathVariable Long id) {
		ResponseEntity<?> re = null;
		try {
			Optional<Worker> worker = workerDao.findById(id);
			re = new ResponseEntity<Optional<Worker>>(worker, HttpStatus.OK);
		} catch (Exception e) {
			LOG.error("Se produjo un error al consultar el trabajador", e);
			String error = "Se produjo un error al consultar el trabajador";
			re = new ResponseEntity<String>(error, HttpStatus.BAD_REQUEST);
		}
		return re;
	}

	@PostMapping("/worker/insert")
	public @ResponseBody ResponseEntity<?> insert(@RequestBody Worker worker) {
		ResponseEntity<?> re = null;
		try {
			Worker newWorker = workerDao.save(worker);
			re = new ResponseEntity<Worker>(newWorker, HttpStatus.OK);
		} catch (Exception e) {
			LOG.error("Se produjo un error al crear el trabajador", e);
			String error = "Se produjo un error al crear el trabajador";
			re = new ResponseEntity<String>(error, HttpStatus.BAD_REQUEST);
		}
		return re;
	}

	@DeleteMapping("/worker/delete/{id}")
	public @ResponseBody ResponseEntity<?> delete(@PathVariable Long id) {
		ResponseEntity<?> re = null;
		try {
			Optional<Worker> worker = workerDao.findById(id);
			workerDao.deleteById(id);
			re = new ResponseEntity<Optional<Worker>>(worker, HttpStatus.OK);
		} catch (Exception e) {
			LOG.error("Se produjo un error al eliminar el trabajador", e);
			String error = "Se produjo un error al eliminar el trabajador";
			re = new ResponseEntity<String>(error, HttpStatus.BAD_REQUEST);
		}
		return re;
	}

	@PostMapping("/worker/update/{id}")
	public @ResponseBody ResponseEntity<?> update(@PathVariable Long id, @RequestBody Worker worker) {
		ResponseEntity<?> re = null;
		try {
			Optional<Worker> getWorker = workerDao.findById(id);
			Worker oldWorker = getWorker.get();
			oldWorker.setName(worker.getName());
			oldWorker.setLastname(worker.getLastname());
			oldWorker.setPhone(worker.getPhone());
			oldWorker.setMail(worker.getMail());
			Worker newWorker = workerDao.save(oldWorker);
			re = new ResponseEntity<Worker>(newWorker, HttpStatus.OK);
		} catch (Exception e) {
			LOG.error("Se produjo un error al editar el trabajador", e);
			String error = "Se produjo un error al editar el trabajador";
			re = new ResponseEntity<String>(error, HttpStatus.BAD_REQUEST);
		}
		return re;
	}
}
