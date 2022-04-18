package com.sirius.elibrary;

import com.sirius.elibrary.properties.ResponseProperties;
import com.sirius.elibrary.service.FileDBService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.File;
import java.nio.file.NotDirectoryException;

@SpringBootApplication
@EnableJpaRepositories
@EnableConfigurationProperties(ResponseProperties.class)
public class ElibraryApplication {

	public static void main(String[] args) throws NotDirectoryException {
		if(!new File(FileDBService.SAVE_PATH).mkdir()){
			System.err.println("Directory could not be Created");
		}
		SpringApplication.run(ElibraryApplication.class, args);
	}
}
