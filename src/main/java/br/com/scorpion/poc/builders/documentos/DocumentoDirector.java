package br.com.scorpion.poc.builders;

import br.com.scorpion.poc.model.Documento;

public class DocumentoDirector {

    protected DocumentoBuilder builder;

    public DocumentoDirector(DocumentoBuilder builder) {
        this.builder = builder;
    }

    public void buildDocumento() {
        builder.buildId();
    }

    public Documento getDocumento() {

        return builder.getDocumento();
    }
}
