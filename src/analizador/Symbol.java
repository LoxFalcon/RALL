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
    
    
}
