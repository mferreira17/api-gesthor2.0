package dev.bearded.apigesthor;

import dev.bearded.apigesthor.model.Contrato;
import dev.bearded.apigesthor.model.dto.ContratoDTO;
import dev.bearded.apigesthor.repository.ContratoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ContratoTest {

    @Autowired
    private ContratoRepository repository;

    @Test
    @Commit
    public void popularTabelaContrato(){
        Assertions.assertNotNull(repository.save(repository.
                save(new Contrato(123456 , LocalDate.now(),
                        new BigDecimal(10000), "Um contrato de teste"))));
    }

    @Test
    public void mapeamentoContratoParaContratoDTO(){
        List<ContratoDTO> listaContratosDTO = repository.findAll()
                .stream().map(contrato -> ContratoDTO.build(contrato)).
                        collect(Collectors.toList());

       Assertions.assertNotNull(listaContratosDTO);
       listaContratosDTO.forEach(contratoDTO -> System.out.println(contratoDTO.toString()));
    }
}
