package com.example.B2Bproject;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@SpringBootApplication

public class DemoApplication {

	private static final Logger logger = LogManager.getLogger(DemoApplication.class);
	@Value("${openai.key}")
	private String openaiApiKey;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);}
	static {
		logger.info("Application B2B has been started");
	}

	@Bean
	public RestTemplate restTemplate(){
		RestTemplate restTemplate=new RestTemplate();
		restTemplate.getInterceptors().add(((request,body,execution)->{
			request.getHeaders().add("Authorization",
					"Bearer " + openaiApiKey);
			return execution.execute(request,body);
		}));
		return restTemplate;

	}

}
