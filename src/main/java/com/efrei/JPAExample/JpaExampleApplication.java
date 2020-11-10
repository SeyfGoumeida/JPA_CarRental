package com.efrei.JPAExample;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@SpringBootApplication
public class JpaExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaExampleApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(VehiculeRepository repository) {
		return (args) -> {
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date1 = dateFormat.parse("2020-11-09");
			Date date2 = dateFormat.parse("2020-11-19");

			Date date3 = dateFormat.parse("2020-10-05");
			Date date4 = dateFormat.parse("2020-11-29");

			Date date5 = dateFormat.parse("2020-09-19");
			Date date6 = dateFormat.parse("2020-12-09");


			Car car1 = new Car("AA11BB",2);
			Car car2 = new Car("AA22CC",4);
			Van van1 = new Van("BB33DD",700);

			Person moha = new Person("Mohammed");
			Person eri = new Person("Erifai");
			Person maa = new Person("MAAMIR");

			Rent rent1 = new Rent(date1,date2);
			Rent rent2 = new Rent(date3,date4);
			Rent rent3 = new Rent(date5,date6);

			car1.getRents().add(rent1);
			rent1.setVehicule(car1);
			moha.getRents().add(rent1);
			rent1.setPerson(moha);

			car2.getRents().add(rent2);
			eri.getRents().add(rent2);
			rent2.setVehicule(car2);
			rent2.setPerson(eri);

			van1.getRents().add(rent3);
			maa.getRents().add(rent3);
			rent3.setVehicule(van1);
			rent3.setPerson(maa);

			repository.save(car1);
			repository.save(car2);
			repository.save(van1);

			System.out.println("-------------------------------");
			System.out.println("Vehicules found with findAll():");
			for (Vehicule vehicule : repository.findAll()) {
				System.out.println(vehicule.toString());
			}

			System.out.println("-------------------------------");
			System.out.println("Persons associted with a vehicule");
			Iterable<City> cities = repository.findAll();
			City c = cities.iterator().next();

			List<Person> persons = c.getPersons();
			System.out.println(persons.toString());

			System.out.println("--------------------------------------------");
			System.out.println("City found with findName('Paris'):");
			repository.findByName("Paris").forEach(city -> {
				System.out.println(city.toString());
			}); */

		};
	}

}
