/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizador;

/**
 *
 * @author Arturo
 */
public class Symbol {
    private String value;
    private Integer type;
	private Integer size;
	private Integer symbolKind = KUNKNOWN;
	
	public static int KVARIABLE = 1;
	public static int KFUNCTION = 2;
	public static int KARRAY = 3;
	public static int KCONSTANT = 4;
	public static int KUNKNOWN = 0;
	public static int KSTACK = 5;
	public static int KLIST = 6;
    
    public Symbol(Integer type, String value){
        this.value = value;
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public Integer getType() {
        return type;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setType(Integer type) {
        this.type = type;
    }
	
	public void setSize(Integer size){
		this.size = size;
	}
	
	public Integer getSize(){
		return size;
	}
	
	public void setSymbolKind(Integer symbolKind){
		this.symbolKind = symbolKind;
	}
	
	public Integer getSymbolKind(){
		return symbolKind;
	}
    
}
