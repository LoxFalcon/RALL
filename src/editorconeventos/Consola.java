/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorconeventos;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.Reader;
import javax.swing.JTextArea;

/**
 *
 * @author Arturo
 */
public class Consola extends OutputStream {

    private final PipedOutputStream out = new PipedOutputStream();
    private final Reader reader;
    private final JTextArea textArea;

    public Consola(JTextArea area) throws IOException {
        this.textArea = area;
        PipedInputStream in = new PipedInputStream(out);
        reader = new InputStreamReader(in, "UTF-8");
    }

    @Override
    public void write(int i) throws IOException {
        out.write(i);
    }

    @Override
    public void write(byte[] bytes, int i, int i1) throws IOException {
        out.write(bytes, i, i1);
    }

    @Override
    public void flush() throws IOException {
        String content;
        if (reader.ready()) {
            char[] chars = new char[1024];
            int n = reader.read(chars);
            content = new String(chars, 0, n);
            textArea.append(content);
        }
    }

}
