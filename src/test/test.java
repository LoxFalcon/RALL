/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import static analizador.lexicoConstants.INT;
import analizador.RALLConverter;
import static analizador.RALLConverter.Null;

/**
 *
 * @author Arturo
 */
public class test {

    public static void main(String[] args) {
        RALLConverter c = new RALLConverter();
        c.insertConstant(INT, "temp", "5 / 2");
        c.setContext(RALLConverter.MAINBLOCK);
        c.insertAssignment("temp", "5", Null);
        c.setContext(RALLConverter.SYMBOLS);
        c.insertAssignment("temp", "55", Null);
        c.printLine();
        c.printResult();
    }
}
