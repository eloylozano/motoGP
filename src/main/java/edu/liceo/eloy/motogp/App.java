package edu.liceo.eloy.motogp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.liceo.eloy.motogp.repositories.ICarreraRepository;
import edu.liceo.eloy.motogp.repositories.ICircuitoRepository;
import edu.liceo.eloy.motogp.repositories.IPilotoRepository;

@SpringBootApplication
public class App implements CommandLineRunner{


	@Autowired
	public IPilotoRepository pilotosRepo;

	@Autowired
	public ICarreraRepository carerasRepo;

	@Autowired
	public ICircuitoRepository cirucitosRepo;

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Todos los pilotos: " + pilotosRepo.findAll());
	}

}
