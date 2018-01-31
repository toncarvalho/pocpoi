package br.com.scorpion.poc.builders.documentos;

import br.com.scorpion.poc.model.Documento;

public abstract class DocumentoBuilder {

    protected Documento documento;

    public DocumentoBuilder() {
        this.documento = new Documento();
    }

    public abstract void buildId();

    public abstract void buildDataHoraImportacao();

    public abstract void buildInicioPeriodo();

    public abstract void buildFinalPeriodo();

    public abstract void buildUsuarioImportador();

    public abstract void buildStatusDocumento();

    public abstract void buildTipoDocumento();

    public abstract void buildIdArquivoFisico();

    public abstract void buildNomeDocumento();

    public Documento getDocumento() {
        return documento;
    }

}
