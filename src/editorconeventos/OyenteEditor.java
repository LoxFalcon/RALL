package editorconeventos;

import java.awt.event.*;
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
    private String archivoActual;
    private boolean cambioDocumento = false;

    public OyenteEditor(PanelEditor panel, VentanaEditor ventana) {
        this.ventana = ventana;
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        JMenuItem origen = (JMenuItem) ae.getSource();
        switch (origen.getName()) { //Pasa el nombre de la clase que escucho el oyente
            case "nuevo":
                if (confirmarGuardado()) {
                    panel.limpiarPantalla();
                    ventana.setTitle("Nuevo documento - " + ventana.getTitulo());
                }
                archivoActual = null;
                cambioDocumento = false;
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
                panel.analisisSintactico();
                break;
            case "sobre":
                ventana.mostrarAcercade();
                break;
        }
    }

    public void abrirArchivo() {
        if (!confirmarGuardado()) {
            return;
        }
        JFileChooser seleccion = new JFileChooser();
        seleccion.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filtro1 //Limita el tipo de archivo que se puede seleccionar en el FileChooser
                = new FileNameExtensionFilter("Archivos de texto", "txt");
        seleccion.setFileFilter(filtro1); //Pasar el parametro del filtro al FileChooser
        FileNameExtensionFilter filtro2 //Limita el tipo de archivo que se puede seleccionar en el FileChooser
                = new FileNameExtensionFilter("Archivo RALL", "rall");
        seleccion.setFileFilter(filtro2);
        int opcion = seleccion.showOpenDialog(panel);
        if (opcion == JFileChooser.APPROVE_OPTION) {
            panel.limpiarPantalla();
            ventana.setTitle(seleccion.getSelectedFile().getName() + " - " + ventana.getTitulo());
            String archivo = seleccion.getSelectedFile().getAbsolutePath();
            archivoActual = archivo;
            ArrayList<String> lineal = Archivo.leerArchivo(archivo);
            for (String linea : lineal) { //For each, no es necesario usar una variable de control
                panel.getAreaTexto().append(linea + "\n");
            }
            cambioDocumento = false;
        }
    }

    public void guardarArchivo() {
        String lineas[] = panel.getAreaTexto().getText().split("\n");
        if (archivoActual != null) {
            Archivo.grabarArchivo(archivoActual, lineas);
            cambioDocumento = false;
        } else {
            JFileChooser seleccion = new JFileChooser();
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
                ventana.setTitle(seleccion.getSelectedFile().getName() + " - " + ventana.getTitulo());
                String rutaArchivo = seleccion.getSelectedFile().getAbsolutePath();
                archivoActual = rutaArchivo;
                if (!rutaArchivo.endsWith(ext)) {
                    rutaArchivo += ext;
                }
                Archivo.grabarArchivo(rutaArchivo, lineas);
                cambioDocumento = false;
            }
        }

    }

    public void guardarArchivoComo() {
        String lineas[] = panel.getAreaTexto().getText().split("\n");
        JFileChooser seleccion = new JFileChooser();
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
            ventana.setTitle(seleccion.getSelectedFile().getName() + " - " + ventana.getTitulo());
            String rutaArchivo = seleccion.getSelectedFile().getAbsolutePath();
            archivoActual = rutaArchivo;
            if (!rutaArchivo.endsWith(ext)) {
                rutaArchivo += ext;
            }
            Archivo.grabarArchivo(rutaArchivo, lineas);
            cambioDocumento = false;
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

    @Override
    public void windowClosing(WindowEvent e) {
        if (confirmarGuardado()) {
            ventana.salirDePrograma();
        }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        cambioDocumento = !panel.getAreaTexto().getText().isEmpty();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        cambioDocumento = !panel.getAreaTexto().getText().isEmpty();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
    }
}
