package com.fikani;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.fikani.config.WebConfig;
import com.fikani.service.impl.RoutesService;

@Configuration
@ComponentScan({ "com.fikani" })
public class App {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App.class);
		new WebConfig(ctx.getBean(RoutesService.class));
		ctx.registerShutdownHook();
	}

}
