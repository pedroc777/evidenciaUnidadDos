/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Operaciones;

import Modelo.Empleado;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 *
 * @author PC
 */
public class Lectura {
    public LinkedList<Empleado> lecturaEmpleado(){
        LinkedList<Empleado> listaCliente = new LinkedList();
        String cadenaLeida = "";
        FileReader fr;
        try {
            fr = new FileReader("Empleado.txt");
            BufferedReader archivoLectura = new BufferedReader(fr);
            cadenaLeida = archivoLectura.readLine();
            while (cadenaLeida != null) {
                Empleado empleado = new Empleado();
                StringTokenizer st = new StringTokenizer(cadenaLeida, ",");

                empleado.setNumeroEmpleado(st.nextToken());
                empleado.setNombreCompleto(st.nextToken());
                empleado.setGradoAcademico(st.nextToken());

                listaCliente.add(empleado);
                cadenaLeida = archivoLectura.readLine();
            }
            archivoLectura.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo encontrar el archivo");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("No se pudo leer del archivo");
            e.printStackTrace();
        }
        //System.out.println(listaCat.get(0).getClaveEncuestador());
        return listaCliente;
    }
}
