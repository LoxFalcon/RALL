/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package editorconeventos;

import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import javax.swing.JFrame;
/**
 *
 * @author Arturo
 */
public class EditorConEventos {

    /**
     * @param args the command line arguments
     * @throws java.io.UnsupportedEncodingException
     */
    public static void main(String[] args) throws UnsupportedEncodingException, IOException {
        // TODO code application logic here
        VentanaEditor f = new VentanaEditor();
        PanelEditor p = new PanelEditor();
        PrintStream out = new PrintStream(new Consola(p.getAreaConsola()), true, "UTF-16");
        System.setOut(out);
        OyenteEditor oyente = new OyenteEditor(p, f);
        f.setSize(800, 600);
        f.setTitle("Nuevo documento - " + f.getTitulo());
        f.setLocation(100,100);
        f.addEventos(oyente);
        p.addEventos(oyente);
        f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        f.add(p);
        f.setVisible(true);
        System.out.println("Hola como estás?");
        System.out.println("Bien, y tu?");
    }
    
}
