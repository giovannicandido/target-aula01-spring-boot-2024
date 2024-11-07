package br.com.eadtt.aula01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * [
 *         {
 *             "id": 1,
 *             "marca": "Ford",
 *             "modelo": "Focus",
 *             "ano": 2019
 *         }
 *     ]
 */
@SpringBootApplication
@EnableConfigurationProperties
public class Aula01Application {

	public static void main(String[] args) {
		SpringApplication.run(Aula01Application.class, args);
	}

}
