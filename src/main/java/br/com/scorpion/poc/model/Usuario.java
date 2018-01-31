package br.com.scorpion.poc.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;

public class Usuario implements Serializable {

    private String id;
    private String emailLogin;
    private String senha;
    private Status status;

    public Usuario(String emailLogin, String senha, Status status) {
        this.emailLogin = emailLogin;
        this.senha = senha;
        this.status = status;
    }

    public Usuario() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmailLogin() {
        return emailLogin;
    }

    public void setEmailLogin(String emailLogin) {
        this.emailLogin = emailLogin;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Usuario usuario = (Usuario) o;

        return new EqualsBuilder()
                .append(id, usuario.id)
                .append(emailLogin, usuario.emailLogin)
                .append(senha, usuario.senha)
                .append(status, usuario.status)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(emailLogin)
                .append(senha)
                .append(status)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "emailLogin='" + emailLogin + '\'' +
                ", senha='" + senha + '\'' +
                ", status=" + status.name() +
                '}';
    }
}
