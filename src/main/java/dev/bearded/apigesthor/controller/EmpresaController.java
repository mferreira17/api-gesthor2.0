package dev.bearded.apigesthor.controller;


import dev.bearded.apigesthor.model.Empresa;
import dev.bearded.apigesthor.repository.EmpresaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/empresas/")
@CrossOrigin(origins = "http://localhost:8080")
public class EmpresaController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EmpresaRepository empresaRepository;

    @PostMapping(value = "/salvar")
    public ResponseEntity salvarNovoContrato(@RequestBody Empresa empresa) throws Exception {
        log.info("SALVANDO NOVO CONTRATO NA BASE...");
        log.info(empresa.toString());
        Empresa salvo = empresaRepository.save(empresa);
        return ResponseEntity.ok(salvo);
    }

}
