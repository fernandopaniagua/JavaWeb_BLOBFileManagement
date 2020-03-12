package com.fernandopaniagua.blobmanagement.persistence;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import javax.servlet.ServletContext;

public class FileImageManager {
    /**
     * Almacena el fichero en la carpeta bin de tomcat
     * 
     * @param nombreFichero
     * @param contenidoFichero
     * @throws IOException 
     */
    public static void storeImage(String nombreFichero, InputStream contenidoFichero) throws IOException{
        File fichero = new File(nombreFichero);
        FileOutputStream fos = new FileOutputStream(fichero);
        int b;
        while ((b=contenidoFichero.read())!=-1){
            fos.write(b);
        }
        fos.close();
    }
    
    public static void storeImageClasspath(ServletContext contexto, String nombreFichero, InputStream contenidoFichero) throws IOException, URISyntaxException{
        File fichero = new File(contexto.getRealPath("/") + nombreFichero);
        FileOutputStream fos = new FileOutputStream(fichero);
        int b;
        while ((b=contenidoFichero.read())!=-1){
            fos.write(b);
        }
        fos.close();
    }
}
