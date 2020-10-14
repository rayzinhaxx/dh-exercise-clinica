package br.com.dh.clinica.consulta;

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
public class ConsultaRepositoryTeste {

	@Autowired
	private ConsultaRepository consultaRepository;
	
	public void verificaIdConsultaNull() {
		Consulta consulta = new Consulta(LocalDate.now(), 400.00, "consulta", 1, "Ciclano da Silva");
		
		this.consultaRepository.save(consulta);
		
		Assertions.assertThat(this.consultaRepository.findByDescricao(consulta.getDescricao()).getConsultaId).isNotNull();
	}
	
	@Test
	public void verificaConsultaAtualizada() {
		Consulta consulta = new Consulta(LocalDate.now(), 400.00, "consulta", 1, "Ciclano da Silva");
		
		this.consultaRepository.save(consulta);
		
		consulta.setValor(399);
		
		this.consultaRepository.save(consulta);
		
		Assertions.assertThat(this.consultaRepository.findByValor(399)).isNotNull();
	}
	
}
