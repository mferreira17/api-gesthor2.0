package dev.bearded.apigesthor.repository;

import dev.bearded.apigesthor.model.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContratoRepository extends JpaRepository<Contrato, Long> {

    public Optional<Contrato> findByNumeroContrato(Integer numeroContrato);
}
