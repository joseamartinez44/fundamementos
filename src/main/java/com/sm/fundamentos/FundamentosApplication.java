package com.sm.fundamentos;

import com.sm.fundamentos.component.ComponentDependency;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {
//	La variable es una interfaz y no una clase concreta
	private final ComponentDependency componentDependency;

//	Si dos componentes implementan la misma dependencia, hay que poner la anotación Qualifier con el nombre del componente empezando en minúscula
//	Se inyecta la dependencia en el constructor
	public FundamentosApplication(@Qualifier("componentImplementTwo") ComponentDependency componentDependency) {
		this.componentDependency = componentDependency;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) {
		componentDependency.saludar();
	}
}
