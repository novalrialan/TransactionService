package com.transaction.dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class DevApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevApplication.class, args);
	}

	// @Bean
	// CommandLineRunner runner(ProductRepository repository){
	// 	return args->{

	// 		Product product = new Product(
	// 			"",
	// 			"soap",
	// 			"liquid soap",
	// 			30.000,
	// 			20,
	// 		);

	// 		repository.insert(product);

	// 	};

	// }

}
