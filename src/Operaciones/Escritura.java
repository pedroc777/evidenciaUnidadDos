/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Operaciones;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author PC
 */
public class Escritura {
     public static void escrituraEmpleado(String numeroEmpleado,String nombreEmpleado,
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
}
