package br.usjt.hellospringboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import br.usjt.hellospringboot.interceptor.LoginInterceptor;
import br.usjt.hellospringboot.model.Tempo;

@Configuration
public class AppConfig implements WebMvcConfigurer {
	@Bean
	public Tempo getTempo() {
		return new Tempo();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginInterceptor()).
		addPathPatterns("/**").
		excludePathPatterns("/login", "/", "/fazerLogin");
	}
}

