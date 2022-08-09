package com.example.forum;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@EnableMongoAuditing
@SpringBootApplication
@Log4j2
public class ForumApplication {

	@Bean // Want a new obj every time
  	@Scope("prototype")
  	public ModelMapper modelMapper() {
    	return new ModelMapper();
  	}

	public static void main(String[] args) {
		SpringApplication.run(ForumApplication.class, args);

		log.info("Congrats! Your Forum-Application has started");
	}
	

}
