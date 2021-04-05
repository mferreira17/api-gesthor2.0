package dev.bearded.apigesthor.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="contrato")
public class Contrato extends BaseEntity implements Serializable {


    @Column(name = "num_contrato")
    private Integer numeroContrato;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "dt_assinatura")
    private LocalDate dataAssinatura;

    @Column
    private BigDecimal valor;

    @Column
    private String objeto;

    public Contrato() {}

    public Contrato(Integer numeroContrato, LocalDate dataAssinatura, BigDecimal valor, String objeto) {
        this.numeroContrato = numeroContrato;
        this.dataAssinatura = dataAssinatura;
        this.valor = valor;
        this.objeto = objeto;
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

    @Override
    public String toString() {
        return "Contrato{" +
                "numeroContrato=" + numeroContrato +
                ", dataAssinatura=" + dataAssinatura +
                ", valor=" + valor +
                ", objeto='" + objeto + '\'' +
                "} " + super.toString();
    }
}
