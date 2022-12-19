package com.pyyh.inoutbound.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.pyyh.inoutbound"})
@SpringBootApplication
public class InOutBoundStarter {

	public static void main(String[] args){
		SpringApplication.run(InOutBoundStarter.class, args);
	}
}
