/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyecto1.Main;

/**
 *
 * @author Victor Daniel
 */
public class proyectManager extends Thread {

    int salary = 40;
    estudio estudio;
    private boolean WatchingAnime;
    private int hourlyCycle;

    public proyectManager(estudio estudio) {
        this.estudio = estudio;
        this.WatchingAnime = false;
        this.hourlyCycle = 0;
    }

    public void addDailySalary() {
        System.out.println("La cuenta antes de pagarle al PM: " + estudio.getSalaryAccount() );
        estudio.setSalaryAccount(
                estudio.getSalaryAccount() + salary * 24);
        System.out.println("La cuenta luego de pagarle al PM: " + estudio.getSalaryAccount() );
    }

    public void operate() {
        int timeSpent = 0;
        int halfHour = estudio.getDayDuration() / 48;
        int hour = estudio.getDayDuration() / 24;
        setHourlyCycle(0);
        while (hourlyCycle < 16) {
            try {
                
                setWatchingAnime(true);

               
                Main.interfaceView.getProjectStatus().setText("Anime");
                Main.interfaceView.getProjectStatusStar1().setText("Anime");

               ;
                sleep(halfHour);
                timeSpent =+ halfHour;
                setWatchingAnime(false);

               
                Main.interfaceView.getProjectStatus().setText("Trabajando");
                Main.interfaceView.getProjectStatusStar1().setText("Trabajando");

                
                sleep(halfHour);
                timeSpent += halfHour;
                setHourlyCycle(getHourlyCycle() + 1);
            } catch (InterruptedException ex) {
                Logger.getLogger(proyectManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        setWatchingAnime(false);

       
        Main.interfaceView.getProjectStatus().setText("Trabajando");
        Main.interfaceView.getProjectStatusStar1().setText("Trabajando");

        while (hourlyCycle < 24) {
            try {
                sleep(hour);
                timeSpent += hour;
            } catch (InterruptedException ex) {
                Logger.getLogger(proyectManager.class.getName()).log(Level.SEVERE, null, ex);
            }
            setHourlyCycle(getHourlyCycle() + 1);

        } 
        try {
            sleep(estudio.getDayDuration() - timeSpent);
                
            estudio.getDaysLeftSemaphore().acquire(); 
            estudio.setDaysLeftRelease(estudio.getDaysLeftRelease() - 1);
            if (estudio.getDaysLeftRelease() < 1) {
                estudio.setDaysLeftRelease(0);
            }
            estudio.getDaysLeftSemaphore().release(); 
            System.out.println("Days left for release: " + estudio.getDaysLeftRelease());

        } catch (InterruptedException ex) {
            Logger.getLogger(proyectManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {

        while (true) {
            operate();
            addDailySalary();
        }

    }

    public boolean isWatchingAnime() {
        return WatchingAnime;
    }

    public void setWatchingAnime(boolean WatchingAnime) {
        this.WatchingAnime = WatchingAnime;
    }

    public int getHourlyCycle() {
        return hourlyCycle;
    }

    public void setHourlyCycle(int hourlyCycle) {
        this.hourlyCycle = hourlyCycle;
    }
}