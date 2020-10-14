package br.com.dh.clinica.receita;

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
public class ReceitaRepositoryTeste {
	
	@Autowired
	ReceitaRepositoryTeste receitaRepository;
	
	@Test
	public void verificaIdReceitaNull() {
		Receita receita = new Receita("maracujina", 5, "8 em 8 horas");
		
		this.receitaRepository.save(receita);
		
		Assertions.assertThat(this.receitaRepository.findByDescricao(receita.getDescricao()).getReceitaId()).isNull();
	}
}
