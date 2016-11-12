/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arturo
 */
public class Test2 {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        String salida = null;
        String comando = "ping www.google.com";

        try {

            // Ejecucion Basica del Comando
            Process proceso = Runtime.getRuntime().exec(comando);
            InputStreamReader entrada = new InputStreamReader(proceso.getInputStream());
            BufferedReader stdInput = new BufferedReader(entrada);

            //Si el comando tiene una salida la mostramos
            if ((salida = stdInput.readLine()) != null) {
                System.out.println("Comando: " + comando + "ejecutado Correctamente");
                while ((salida = stdInput.readLine()) != null) {
                    System.out.println(salida);
                }
            } else {
                System.out.println("No se a producido ninguna salida");
            }
            System.out.println("Exit value " + proceso.exitValue());
        } catch (IOException e) {
            System.out.println("Excepción: ");
            e.printStackTrace();
        }
        System.exit(0);
    }
}
