package dev.bearded.apigesthor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "empresa")
public class Empresa extends BaseEntity implements Serializable {

    @Column
    private String nome;

    @Column
    private String ramo;

    @Column
    private String email;

    @Column(name="tel_comercial")
    private String telefone;

    @Column(name = "tel_celular")
    private String celular;

    public Empresa() { }

    public Empresa(String nome, String ramo, String email, String telefone, String celular) {
        this.nome = nome;
        this.ramo = ramo;
        this.email = email;
        this.telefone = telefone;
        this.celular = celular;
    }

    public String getNome() {
        return nome;
    }

    public String getRamo() {
        return ramo;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCelular() {
        return celular;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "nome='" + nome + '\'' +
                ", ramo='" + ramo + '\'' +
                ", email='" + email + '\'' +
                ", telefoneComercial='" + telefone + '\'' +
                ", telefoneCelular='" + celular + '\'' +
                '}';
    }
}
