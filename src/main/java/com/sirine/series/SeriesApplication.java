package com.sirine.series;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.sirine.series.entities.Serie;

@SpringBootApplication
public class SeriesApplication  implements CommandLineRunner{
	
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(SeriesApplication.class, args);
	}
		@Override
		public void run(String... args) throws Exception {
			repositoryRestConfiguration.exposeIdsFor(Serie.class);
		}

}
