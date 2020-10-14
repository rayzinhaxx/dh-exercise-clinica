package br.com.dh.clinica.prontuario;

import java.time.LocalDate;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProntuarioRepositoryTeste {

	@Autowired
	ProntuarioRepository prontuarioRepository;
	
	@Test
	public void verificaDataConsultaNull() {
		Prontuario prontuario = new Prontuario(LocalDate.now());
		
		this.prontuarioRepository.save(prontuario);
		
		Assertions.assertThat(prontuario.getDataConsulta()).isNotNull();
	}
	
	
}
