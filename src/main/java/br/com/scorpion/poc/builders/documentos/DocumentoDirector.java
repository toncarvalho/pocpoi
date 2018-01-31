package br.com.scorpion.poc.builders.documentos;

import br.com.scorpion.poc.model.Documento;

public class DocumentoDirector {

    protected DocumentoBuilder builder;

    public DocumentoDirector(DocumentoBuilder builder) {
        this.builder = builder;
    }

    public void buildDocumento() {
        builder.buildId();
        builder.buildDataHoraImportacao();
        builder.buildInicioPeriodo();
        builder.buildFinalPeriodo();
        builder.buildNomeDocumento();
        builder.buildStatusDocumento();
        builder.buildTipoDocumento();
        builder.buildUsuarioImportador();
        builder.buildIdArquivoFisico();

    }




    public Documento getDocumento() {

        return builder.getDocumento();
    }
}
