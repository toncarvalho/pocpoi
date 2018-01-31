package br.com.scorpion.poc.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;
import java.util.Date;

public class Documento  implements Serializable{

    private Long id;
    private Date dataHoraImportacao;
    private Date inicioPeriodo;
    private Date finalPeriodo;
    private Usuario usuarioImportador;
    private StatusDocumento statusDocumento;
    private TipoDocumento tipoDocumento;
    private Long idArquivoFisico;
    private String nomeDocumento;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataHoraImportacao() {
        return dataHoraImportacao;
    }

    public void setDataHoraImportacao(Date dataHoraImportacao) {
        this.dataHoraImportacao = dataHoraImportacao;
    }

    public Date getInicioPeriodo() {
        return inicioPeriodo;
    }

    public void setInicioPeriodo(Date inicioPeriodo) {
        this.inicioPeriodo = inicioPeriodo;
    }

    public Date getFinalPeriodo() {
        return finalPeriodo;
    }

    public void setFinalPeriodo(Date finalPeriodo) {
        this.finalPeriodo = finalPeriodo;
    }

    public Usuario getUsuarioImportador() {
        return usuarioImportador;
    }

    public void setUsuarioImportador(Usuario usuarioImportador) {
        this.usuarioImportador = usuarioImportador;
    }

    public StatusDocumento getStatusDocumento() {
        return statusDocumento;
    }

    public void setStatusDocumento(StatusDocumento statusDocumento) {
        this.statusDocumento = statusDocumento;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Long getIdArquivoFisico() {
        return idArquivoFisico;
    }

    public void setIdArquivoFisico(Long idArquivoFisico) {
        this.idArquivoFisico = idArquivoFisico;
    }


    public String getNomeDocumento() {
        return nomeDocumento;
    }

    public void setNomeDocumento(String nomeDocumento) {
        this.nomeDocumento = nomeDocumento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Documento documento = (Documento) o;

        return new EqualsBuilder()
                .append(id, documento.id)
                .append(dataHoraImportacao, documento.dataHoraImportacao)
                .append(inicioPeriodo, documento.inicioPeriodo)
                .append(finalPeriodo, documento.finalPeriodo)
                .append(usuarioImportador, documento.usuarioImportador)
                .append(statusDocumento, documento.statusDocumento)
                .append(tipoDocumento, documento.tipoDocumento)
                .append(idArquivoFisico, documento.idArquivoFisico)
                .append(nomeDocumento, documento.nomeDocumento)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(dataHoraImportacao)
                .append(inicioPeriodo)
                .append(finalPeriodo)
                .append(usuarioImportador)
                .append(statusDocumento)
                .append(tipoDocumento)
                .append(idArquivoFisico)
                .append(nomeDocumento)
                .toHashCode();
    }
}
