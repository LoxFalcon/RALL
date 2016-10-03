/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizador;

import java.util.HashMap;

/**
 *
 * @author Arturo
 */
public class SymbolsTable implements lexicoConstants{

    private final HashMap table;

    public SymbolsTable() {
        table = new HashMap();
    }

    public void insert(String value) {
        Symbol s = new Symbol(0, value);
        table.put(value, s);
    }
	
	public void insert(String key, Symbol symbol){
		table.put(key, symbol);
	}

    public Symbol search(String name) {
        return (Symbol) (table.get(name));
    }
    
    public boolean contains(String value){
        return !(search(value) == null);
    }
    
    public Symbol[] getSymbols(){
        Object[] tableValues = table.values().toArray();
        int valuesLenght = tableValues.length;
        Symbol[] symbols = new Symbol[valuesLenght];
        for(int i = 0;i < valuesLenght;i++){
            symbols[i] = (Symbol) tableValues[i];
        }
        return symbols;
    }

    public void showTable() {
        Object[] symbols = table.values().toArray();
        System.out.println("-Symbols Table-");
        for (Object symbol : symbols) {
            Symbol sym = (Symbol) symbol;
            System.out.println("Type: " + sym.getType() + " Value: " + sym.getValue());
        }
    }
}
