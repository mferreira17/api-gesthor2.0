package dev.bearded.apigesthor.model.dto;

import dev.bearded.apigesthor.model.Contrato;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ContratoDTO {

    private Long id;
    private Integer numeroContrato;
    private LocalDate dataAssinatura;
    private BigDecimal valor;
    private String objeto;

    private ContratoDTO(Contrato contrato) {
        this.id = contrato.getId();
        this.numeroContrato = contrato.getNumeroContrato();
        this.dataAssinatura = contrato.getDataAssinatura();
        this.valor = contrato.getValor();
        this.objeto = contrato.getObjeto();
    }

    public Long getId() {
        return id;
    }

    public Integer getNumeroContrato() {
        return numeroContrato;
    }

    public LocalDate getDataAssinatura() {
        return dataAssinatura;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getObjeto() {
        return objeto;
    }

    public static ContratoDTO build(Contrato contrato){
        return new ContratoDTO(contrato);
    }

    @Override
    public String toString() {
        return "ContratoDTO{" +
                "id=" + id +
                ", numeroContrato=" + numeroContrato +
                ", dataAssinatura=" + dataAssinatura +
                ", valor=" + valor +
                ", objeto='" + objeto + '\'' +
                '}';
    }
}
