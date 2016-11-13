package editorconeventos;

import analizador.lexico;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import util.Archivo;

/**
 *
 * @author Arturo M
 */
public class OyenteEditor extends WindowAdapter implements ActionListener, DocumentListener {

    private final VentanaEditor ventana;
    private final PanelEditor panel;
    private boolean cambioDocumento = false;
    private File archivoActual;
    private String defaultDirectory = "C:\\Users\\Arturo\\Documents\\RALLProyects";
    private File tempDirectory;
    private String compiledPath;
    private boolean isCompiled = false;
    private boolean isAnalized = false;

    public OyenteEditor(PanelEditor panel, VentanaEditor ventana) {
        this.ventana = ventana;
        this.panel = panel;
        try {
            tempDirectory = new File(Files.createTempDirectory("RALL").toString());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(ventana, ex.getMessage(), "Error Interno", JOptionPane.ERROR);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        JMenuItem origen = (JMenuItem) ae.getSource();
        switch (origen.getName()) { //Pasa el nombre de la clase que escucho el oyente
            case "nuevo":
                if (confirmarGuardado()) {
                    panel.limpiarPantalla();
                    ventana.setTitle("Nuevo documento - " + ventana.getTitulo());
                    archivoActual = null;
                    cambioDocumento = false;
                }
                break;
            case "abrir":
                abrirArchivo();
                break;
            case "guardar":
                guardarArchivo();
                break;
            case "guardarcomo":
                guardarArchivoComo();
                break;
            case "copiar":
                panel.getAreaTexto().copy();
                break;
            case "cortar":
                panel.getAreaTexto().cut();
                break;
            case "pegar":
                panel.getAreaTexto().paste();
                break;
            case "limpiar":
                panel.getAreaConsola().setText("");
                break;
            case "lexico":
                panel.analisisLexico();
                break;
            case "sintactico":
                isAnalized = panel.analisisSintactico();
                break;
            case "sobre":
                ventana.mostrarAcercade();
                break;
            case "compilar":
                compilar();
                break;
            case "iniciar":
                ejecutar();
                break;
        }
    }

    public void abrirArchivo() {
        if (!confirmarGuardado()) {
            return;
        }
        JFileChooser seleccion = new JFileChooser(defaultDirectory);
        seleccion.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filtro1 //Limita el tipo de archivo que se puede seleccionar en el FileChooser
                = new FileNameExtensionFilter("Archivos de texto", "txt");
        seleccion.setFileFilter(filtro1); //Pasar el parametro del filtro al FileChooser
        FileNameExtensionFilter filtro2 //Limita el tipo de archivo que se puede seleccionar en el FileChooser
                = new FileNameExtensionFilter("Archivo RALL", "rall");
        seleccion.setFileFilter(filtro2);
        int opcion = seleccion.showOpenDialog(panel);
        if (opcion == JFileChooser.APPROVE_OPTION) {
            archivoActual = seleccion.getSelectedFile();
            ArrayList<String> lineal = Archivo.leerArchivo(archivoActual.getAbsolutePath());
            String nombre = archivoActual.getName();
            ventana.setTitle(nombre.substring(0, nombre.indexOf(".")) + " - " + ventana.getTitulo());
            panel.limpiarPantalla();
            for (String linea : lineal) { //For each, no es necesario usar una variable de control
                panel.getAreaTexto().append(linea + "\n");
            }
            cambioDocumento = false;
            isCompiled = false;
            isAnalized = false;
        }
    }

    public void guardarArchivo() {
        String lineas[] = panel.getAreaTexto().getText().split("\n");
        if (archivoActual != null) {
            Archivo.grabarArchivo(archivoActual.getAbsolutePath(), lineas);
            cambioDocumento = false;
        } else {
            JFileChooser seleccion = new JFileChooser(defaultDirectory);
            seleccion.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter filtro1 //Limita el tipo de archivo que se puede seleccionar en el FileChooser
                    = new FileNameExtensionFilter("Archivos de texto (.txt)", "txt");
            seleccion.setFileFilter(filtro1);
            FileNameExtensionFilter filtro2 //Limita el tipo de archivo que se puede seleccionar en el FileChooser
                    = new FileNameExtensionFilter("Archivo RALL (.rall)", "rall");
            seleccion.setFileFilter(filtro2);
            int opcion = seleccion.showSaveDialog(panel);
            if (opcion == JFileChooser.APPROVE_OPTION) {
                String ext = "." + ((FileNameExtensionFilter) seleccion.getFileFilter()).getExtensions()[0];
                String rutaArchivo = seleccion.getSelectedFile().getAbsolutePath();
                if (!rutaArchivo.endsWith(ext)) {
                    rutaArchivo += ext;
                }
                Archivo.grabarArchivo(rutaArchivo, lineas);
                archivoActual = new File(rutaArchivo);
                String nombre = archivoActual.getName();
                nombre = nombre.substring(0, nombre.indexOf("."));
                ventana.setTitle(nombre + " - " + ventana.getTitulo());
                cambioDocumento = false;
            }
        }

    }

    public void guardarArchivoComo() {
        String lineas[] = panel.getAreaTexto().getText().split("\n");
        JFileChooser seleccion = new JFileChooser(defaultDirectory);
        seleccion.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filtro1 //Limita el tipo de archivo que se puede seleccionar en el FileChooser
                = new FileNameExtensionFilter("Archivos de texto (.txt)", "txt");
        seleccion.setFileFilter(filtro1);
        FileNameExtensionFilter filtro2 //Limita el tipo de archivo que se puede seleccionar en el FileChooser
                = new FileNameExtensionFilter("Archivo RALL (.rall)", "rall");
        seleccion.setFileFilter(filtro2);
        int opcion = seleccion.showSaveDialog(panel);
        if (opcion == JFileChooser.APPROVE_OPTION) {
            String ext = "." + ((FileNameExtensionFilter) seleccion.getFileFilter()).getExtensions()[0];
            archivoActual = seleccion.getSelectedFile();
            String rutaArchivo = archivoActual.getAbsolutePath();
            if (!rutaArchivo.endsWith(ext)) {
                rutaArchivo += ext;
            }
            Archivo.grabarArchivo(rutaArchivo, lineas);
            ventana.setTitle(seleccion.getSelectedFile().getName() + " - " + ventana.getTitulo());
            cambioDocumento = false;
        }
    }

    public void compilar() {
        if (isAnalized) {
            String code = lexico.result;
            String nombreArchivo = archivoActual.getName();
            nombreArchivo = nombreArchivo.substring(0, nombreArchivo.indexOf("."));
            String rutaArchivo = tempDirectory.getAbsolutePath() + "\\";
            String ruta = rutaArchivo + nombreArchivo + ".c";
            if (!code.isEmpty()) {
                Archivo.grabarArchivo(ruta, code.split("\n"));
                String output = archivoActual.getAbsolutePath();
                output = output.substring(0, output.lastIndexOf("\\") + 1);
                StringBuilder st = new StringBuilder();
                st.append("gcc ");
                st.append("\"");
                st.append(ruta);
                st.append("\"");
                st.append(" -o ");
                st.append("\"");
                st.append(output);
                st.append(nombreArchivo);
                st.append(".exe");
                st.append("\"");
                String command = st.toString();
                try {
                    Process proc = Runtime.getRuntime().exec(command);
                    InputStreamReader entrada = new InputStreamReader(proc.getErrorStream());
                    BufferedReader Input = new BufferedReader(entrada);
                    String salida;
                    if (Input.readLine() != null) {
                        while ((salida = Input.readLine()) != null) {
                            System.out.println(salida);
                        }
                    }
                    if (proc.exitValue() == 0) {
                        System.out.println("Compilacion terminada");
                        isCompiled = true;
                        compiledPath = output + nombreArchivo + ".exe";
                        JOptionPane.showMessageDialog(ventana, "Programa compilado con exito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(ventana, "No se ha podido compilar el programa", "Error de compilacion", JOptionPane.ERROR_MESSAGE);
                        isCompiled = false;
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(ventana, ex.getMessage(), "Error Interno", JOptionPane.ERROR_MESSAGE);
                }

            }
        } else {
            isAnalized = panel.analisisSintactico();
            if(isAnalized){
                compilar();
            }
        }
    }

    public void ejecutar() {
        if (isCompiled) {
            try {
                String command = "cmd /c start call " + "\"" + compiledPath + "\"";
                Process proc = Runtime.getRuntime().exec(command);
                System.out.println("Programa Iniciado");

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(ventana, ex.getMessage(), "Error de ejecucion", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(ventana, "Primero debe compilar el programa", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public boolean confirmarGuardado() {
        if (cambioDocumento) {
            int res = JOptionPane.showConfirmDialog(panel, "¿Deseas guardar los cambios realizados?",
                    "¿Guardar?", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (res == JOptionPane.YES_OPTION) {
                guardarArchivo();
            } else if (res == JOptionPane.CANCEL_OPTION) {
                return false;
            }
        }
        return true;
    }

    public String getDefaultDirectory() {
        return defaultDirectory;
    }

    public void setDefaultDirectory(String defaultDirectory) {
        this.defaultDirectory = defaultDirectory;
    }

    public void deleteTempFiles(File folder) {
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    deleteTempFiles(file);
                } else {
                    file.delete();
                }
            }
        }
        folder.delete();
    }

    public void deleteTempStuff() {
        deleteTempFiles(tempDirectory);
    }

    public void salirDePrograma() {
        deleteTempStuff();
        System.exit(0);
    }

    @Override
    public void windowClosing(WindowEvent e) {
        if (confirmarGuardado()) {
            salirDePrograma();
        }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        cambioDocumento = !panel.getAreaTexto().getText().isEmpty();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        cambioDocumento = !panel.getAreaTexto().getText().isEmpty();
        isAnalized = false;
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
    }
}
