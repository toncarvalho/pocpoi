package br.com.scorpion.poc.xls_interpreter;

import java.io.IOException;

public class StartXlsInterpreter {


    public static void main(String[] args) {

        ReaderPlan readerPlan = new ReaderPlan();
        try {
            readerPlan.ReadXLSX();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
