package br.com.fiap.AcolheMais;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

/**
 * Classe principal que inicia a aplicação Spring Boot da API Acolhe+.
 *
 * @author Nicolas Martins
 */
@SpringBootApplication
public class AcolheMaisApplication {

	// esse método fixa o fuso de Brasília e inicia a aplicação Spring Boot
	public static void main(String[] args) {
		// o Render roda em UTC; fixa o fuso de Brasilia para o "horario futuro" e as datas gravadas ficarem certos
		TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
		SpringApplication.run(AcolheMaisApplication.class, args);
	}

}
