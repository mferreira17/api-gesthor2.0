package dev.bearded.apigesthor.repository;

import dev.bearded.apigesthor.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}
