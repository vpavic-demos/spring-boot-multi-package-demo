package co.sys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class CoontrolApp extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(CoontrolApp.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(CoontrolApp.class, args);
	}

	@Configuration
	static class WebMvcConfig implements WebMvcConfigurer {

		@Override
		public void addViewControllers(ViewControllerRegistry registry) {
			registry.addViewController("/").setViewName("home");
		}

	}

}
