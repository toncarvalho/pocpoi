package br.com.scorpion.poc.xls_interpreter;

import br.com.scorpion.poc.dao.UsuarioDao;

public class StartXlsInterpreter {


    public static void main(String[] args) {

     /*   ReaderPlan readerPlan = new ReaderPlan();
        try {
            readerPlan.ReadXLSX();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        UsuarioDao connection = new UsuarioDao();
        //connection.inserir();
  //      connection.imprimirPrimeiro();
       // connection.excluir("rebeca");
        connection.listarTodos();


    }
}
