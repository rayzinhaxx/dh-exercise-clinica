package br.com.dh.clinica.paciente;

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
public class PacienteRepositoryTeste {
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Test
	public void verificaIdPacienteNull() {
		Paciente paciente = new Paciente("Fulano", "rua 2", LocalDate.now(), "868888888", LocalDate.now(), "fulano@email.com", 5, 0.15, "333.333.333-55");
		
		this.pacienteRepository.save(paciente);

		Assertions.assertThat(this.pacienteRepository.findOneByNome(paciente.getNome()).getIdPaciente()).isNotNull();
	}
	
	@Test
	public void verificaNomePacienteNull() {
		Paciente paciente = new Paciente("Fulano", "rua 2", LocalDate.now(), "868888888", LocalDate.now(), "fulano@email.com", 5, 0.15, "333.333.333-55");
		
		this.pacienteRepository.save(paciente);

		Assertions.assertThat(this.pacienteRepository.findByCpf(paciente.getCpf()).getNome()).isNotNull();
	}
	
}
