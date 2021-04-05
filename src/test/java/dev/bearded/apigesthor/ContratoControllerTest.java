package dev.bearded.apigesthor;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.bearded.apigesthor.model.dto.ContratoDTO;
import org.assertj.core.api.LocalDateAssert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.time.LocalDate;


@SpringBootTest
@AutoConfigureMockMvc
public class ContratoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testListaContratosRetornadosOk() throws Exception {
        var url = "http://localhost:8081/contratos/lista-contratos";
        /*var jsonResponse = "[{\n" +
                "    \"id\": 1,\n" +
                "    \"numeroContrato\": 123456,\n" +
                "    \"dataAssinatura\": \"2021-03-18\",\n" +
                "    \"valor\": 10000,\n" +
                "    \"objeto\": \"Um contrato de teste\"\n" +
                "  }]";*/

        mockMvc.perform(MockMvcRequestBuilders.get(url)).
                andDo(MockMvcResultHandlers.print()).
                andExpect(MockMvcResultMatchers.content().contentType("application/json")).
                andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void testSalvarNovoContratoAPI() throws Exception {

        var url = "http://localhost:8081/contratos/salvar-novo-contrato";
        var jsonRequest = "{\n" +
                "\t\"numeroContrato\":\"1000\",\n" +
                "\t\"dataAssinatura\":\"2021-03-20\",\n" +
                "\t\"valor\":\"5000\",\n" +
                "\t\"objeto\":\"teste de contrato mockado\"\n" +
                "}";
        mockMvc.perform(MockMvcRequestBuilders.post(url)
                .content(jsonRequest).contentType("application/json")).
                andDo(MockMvcResultHandlers.print()).
                andExpect(MockMvcResultMatchers.content().string("Contrato N° 1000 já foi cadastrado anteriormente")).
                andExpect(MockMvcResultMatchers.status().isBadRequest());

    }

    @Test
    public void testAtualizarContrato() throws Exception {

        var url = "http://localhost:8081/contratos/atualizar-contrato";
        var jsonRequest = "{\n" + "id : 1" +
                "\t\"numeroContrato\":\"1000\",\n" +
                "\t\"dataAssinatura\":\"2021-03-20\",\n" +
                "\t\"valor\":\"5000\",\n" +
                "\t\"objeto\":\"teste de contrato mockado\"\n" +
                "}";
        mockMvc.perform(MockMvcRequestBuilders.post(url)
                .content(jsonRequest).contentType("application/json")).
                andDo(MockMvcResultHandlers.print()).
                andExpect(MockMvcResultMatchers.content().string("CONTRATO SALVO")).
                andExpect(MockMvcResultMatchers.status().isOk());

    }

}
