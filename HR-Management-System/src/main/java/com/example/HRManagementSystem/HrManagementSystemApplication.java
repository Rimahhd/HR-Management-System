package com.example.HRManagementSystem;

import com.example.HRManagementSystem.Repositories.EmployeeRepository;
import lombok.Getter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Getter
@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.example.HRManagementSystem.Repositories"})
@EntityScan(basePackages = {"com.example.HRManagementSystem.Entities"})
@ComponentScan(basePackages = {"com.example.HRManagementSystem.Mappers", "com.example.HRManagementSystem.Controllers", "com.example.HRManagementSystem.Services"})
public class HrManagementSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(HrManagementSystemApplication.class, args);

	}


	private EmployeeRepository employeeRepository;


	@Override
	public void run(String... args) throws Exception {

	}

    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
}

