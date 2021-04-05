package dev.bearded.apigesthor.controller;

import dev.bearded.apigesthor.model.Contrato;
import dev.bearded.apigesthor.model.dto.ContratoDTO;
import dev.bearded.apigesthor.repository.ContratoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/contratos/")
public class ContratoController {

    private ContratoRepository contratoRepository;
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    public ContratoController(ContratoRepository contratoRepository) {

        this.contratoRepository = contratoRepository;
    }

    @GetMapping(value = "/lista-contratos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ContratoDTO>> getListaContratos() {
        log.info("BUSCANDO CONTRATOS...");
        List<ContratoDTO> listaContratosDTO = contratoRepository.findAll()
                .stream().map(contrato -> ContratoDTO.build(contrato)).
                        collect(Collectors.toList());
        return ResponseEntity.ok(listaContratosDTO);
    }

    @PostMapping(value = "/salvar-novo-contrato")
    public ResponseEntity salvarNovoContrato(@RequestBody Contrato contrato) throws Exception {
        log.info("SALVANDO NOVO CONTRATO NA BASE...");
        log.info("Contrato .: " + contrato.toString());

       if(contratoRepository.findByNumeroContrato(contrato.getNumeroContrato())!= null){
           throw new Exception("Contrato com número "+ contrato.getNumeroContrato()+ " já existente na base de dados");
       }

        return null;
    }
}
