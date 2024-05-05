/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Operaciones;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
//import javax.swing.text.Document;
import com.itextpdf.text.*;
//import com.itextpdf.text.log.Logger;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
//import java.lang.System.Logger.Level;

/**
 *
 * @author PC
 */
public class Escritura {

    public static void escrituraEmpleado(String numeroEmpleado, String nombreEmpleado,
            String gradoEmpleado) {

        //esto sirve para el método que determina la existencia del archivo
        boolean existencia = false;
        //construimos la ruta para el archivo
        String carpeta = "Empleado.txt";

        try {
            /**
             * Acá determinamos la existencia del archivo. Si no existe, se crea
             */
            File archivo = new File("Empleado.txt");
            existencia = archivo.exists();

            if (existencia == false) {
                FileWriter ubicacion = new FileWriter(carpeta, true);
                try {
                    //construimos el registro a insertar
                    String registro = numeroEmpleado + "," + nombreEmpleado + ","
                            + gradoEmpleado;

                    /**
                     * para abrir el documento en modo apertura y que podamos
                     * escribir una línea tras otra, de modo que no se sobrees
                     * criba la información.
                     */
                    FileWriter apertura = new FileWriter(carpeta, true);
                    BufferedWriter escritor = new BufferedWriter(apertura);

                    escritor.write(registro);
                    escritor.newLine();
                    escritor.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {
                try {
                    /**
                     * este código hace lo mismo que lo anterior, pero en caso
                     * de que ya exista ek archivo en la ubicación
                     */
                    String registro = numeroEmpleado + "," + nombreEmpleado + ","
                            + gradoEmpleado;

                    FileWriter apertura = new FileWriter(carpeta, true);
                    BufferedWriter escritor = new BufferedWriter(apertura);

                    escritor.write(registro);
                    escritor.newLine();
                    escritor.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        System.out.println(existencia);
    }

    public static void escrituraTiempos(String empleado,String revisionFiguraAcademica,
            String joornadaCoordinadora,String revisionPlanificadores,String revisionPlanesEstudio) {

        //esto sirve para el método que determina la existencia del archivo
        boolean existencia = false;
        //construimos la ruta para el archivo
        String carpeta = "Tiempos.txt";

        try {
            /**
             * Acá determinamos la existencia del archivo. Si no existe, se crea
             */
            File archivo = new File("Tiempos.txt");
            existencia = archivo.exists();

            if (existencia == false) {
                FileWriter ubicacion = new FileWriter(carpeta, true);
                try {
                    //construimos el registro a insertar
                    String registro = empleado+ "," +revisionFiguraAcademica+ "," +
                    joornadaCoordinadora+ "," +revisionPlanificadores+ "," +revisionPlanesEstudio;

                    /**
                     * para abrir el documento en modo apertura y que podamos
                     * escribir una línea tras otra, de modo que no se sobrees
                     * criba la información.
                     */
                    FileWriter apertura = new FileWriter(carpeta, true);
                    BufferedWriter escritor = new BufferedWriter(apertura);

                    escritor.write(registro);
                    escritor.newLine();
                    escritor.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {
                try {
                    /**
                     * este código hace lo mismo que lo anterior, pero en caso
                     * de que ya exista ek archivo en la ubicación
                     */
                    String registro =empleado+ "," +revisionFiguraAcademica+ "," +
                    joornadaCoordinadora+ "," +revisionPlanificadores+ "," +revisionPlanesEstudio;

                    FileWriter apertura = new FileWriter(carpeta, true);
                    BufferedWriter escritor = new BufferedWriter(apertura);

                    escritor.write(registro);
                    escritor.newLine();
                    escritor.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        System.out.println(existencia);
    }
    
    
    public void generarPdfPoblacion(String empleado,String revisionFiguraAcademica,
            String joornadaCoordinadora,String revisionPlanificadores,String revisionPlanesEstudio){
        FileOutputStream archivo = null;
        try{
            String nombre = "Tiempos"+empleado+".pdf";
            archivo = new FileOutputStream(nombre);
            Document documento = new Document();
            PdfWriter.getInstance(documento, archivo);
            documento.open();
            Paragraph parrafo = new Paragraph("Datos personales");
            parrafo.setAlignment(1);
            documento.add(parrafo);
            documento.add(new Paragraph("Nombre del Asesor: "+ empleado));
            documento.add(new Paragraph("Revisión figura académica: "+ revisionFiguraAcademica));
            documento.add(new Paragraph("Junta con la coordinadora: "+ joornadaCoordinadora));
            documento.add(new Paragraph("Revisión Planificadores: "+ revisionPlanificadores));
            documento.add(new Paragraph("Revisión Planes de estudio: "+ revisionPlanesEstudio));
            documento.close();
        }
        catch(FileNotFoundException ex){
            
        } catch (DocumentException ex) {
            ex.printStackTrace();
        }
        
    }
}
