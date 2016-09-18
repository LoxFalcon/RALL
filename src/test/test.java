/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import analizador.SymbolsTable;

/**
 *
 * @author Arturo
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SymbolsTable tabla = new SymbolsTable();
        tabla.insert(10, "a");
        tabla.insert(10, "b");
        tabla.insert("x");
        System.out.println(tabla.getSymbols().length);
        System.out.println(tabla.contains("a"));
        tabla.showTable();
    }
    
}
