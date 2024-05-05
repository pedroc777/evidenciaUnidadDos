/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Random;

/**
 *
 * @author PC
 */
public class RevisionFiguraAcademica extends Thread{
    private volatile int totalMinutos;
    
    public int getTotalMinutos(){
        return totalMinutos;
    }
    
    @Override
    public void run(){
        int minutos = 60;
        while (minutos > 0) {
            Random random = new Random();
            int numeroAleatorio = random.nextInt(6);
            numeroAleatorio = numeroAleatorio + 1000;
            System.out.println("Minuto revisión figura academica: " + minutos);
            minutos--;
            try {
                Thread.sleep(numeroAleatorio);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            totalMinutos = minutos;
        }
        //totalMinutos = minutos;
        //retornarTiempo();
        System.out.println("Se acabó el tiempo para realizar su revisión");
        System.out.println("Estos son los minutos que quedan: "+minutos);
        System.out.println(Thread.currentThread().getState());
    }
}
