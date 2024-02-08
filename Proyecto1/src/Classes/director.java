/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Victor Daniel
 */
public class director extends Thread {

    int salary = 60;
    estudio estudio;
    private boolean checkingPM;
    private int hourlyCycle;

    public director(estudio estudio) {
        this.estudio = estudio;
        this.checkingPM = false;
        this.hourlyCycle = 0;
    }

    public void addDailySalary() {
        System.out.println("La cuenta antes de pagarle al Director: " + estudio.getSalaryAccount() );
        estudio.setSalaryAccount(
                estudio.getSalaryAccount() + salary * 24);
        System.out.println("El director gana " + salary*24+"$");
        System.out.println("La cuenta luego de pagarle al Director: " + estudio.getSalaryAccount() );
    }

    public void operate() {
        if (estudio.getDaysLeftRelease() == 0) { 
            try { 
                sleep(estudio.getDayDuration()); 

                estudio.getAssemblerSemaphore().acquire(); 
                int releasedCommonEpisodes = estudio.getAssemblerDrive().getResourse(); 
                estudio.getAssemblerDrive().setResourse(0); 
                int releasedPlotTwistEpisodes = estudio.getPlotAssemblerDrive().getResourse(); 
                estudio.getPlotAssemblerDrive().setResourse(0); 
                estudio.setEpisodesReleased(estudio.getEpisodesReleased() + releasedCommonEpisodes);
                estudio.setPlotEpisodesReleased(estudio.getPlotEpisodesReleased() + releasedPlotTwistEpisodes);
                int profitsToSum = releasedCommonEpisodes * estudio.getCommonEpisodeProfit()
                        + releasedPlotTwistEpisodes * estudio.getPlotEpisodeProfit(); 
                System.out.println("El director ha liberado " + releasedCommonEpisodes + " capitulos comunes y "
                        + releasedPlotTwistEpisodes + " capitulos de plotTwist");
                System.out.println("Las ganancias totales de este ciclo, han sido " + profitsToSum + "$");
                estudio.setProfits(estudio.getProfits() + profitsToSum);
                estudio.getDaysLeftSemaphore().acquire();
                estudio.setDaysLeftRelease(estudio.getDeadlineRatio());
                estudio.getDaysLeftSemaphore().release();
                estudio.getAssemblerSemaphore().release(); 
            } catch (InterruptedException ex) {
                Logger.getLogger(director.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else { 
                
                 int timeSpent = 0;
                 
            int halfHour = estudio.getDayDuration() / 48;
            int hour = estudio.getDayDuration() / 24;
            Random random = new Random();
            int randomHour = random.nextInt(24); 
            hourlyCycle = 0;
            while (hourlyCycle < randomHour) {
                try {
                    setCheckingPM(false);

                  
                    if (estudio == Main.CartoonNetwork) {
                        Main.gui.getDirectorStatus().setText("Administrando");
                    } else {
                        Main.gui.getDirectorStatusStar().setText("Administrando");
                    }

                    sleep(hour);
                    timeSpent += hour;
                } catch (InterruptedException ex) {
                    Logger.getLogger(director.class.getName()).log(Level.SEVERE, null, ex);
                }
                hourlyCycle++;
            }
            if (hourlyCycle == randomHour) { 
                setCheckingPM(true);

                
                if (estudio == Main.CartoonNetwork) {
                    Main.gui.getDirectorStatus().setText("Supervisando PM");
                } else {
                    Main.gui.getDirectorStatusStar().setText("Supervisando PM");
                }

                try {
                    sleep(halfHour); 
                    timeSpent += halfHour;
                } catch (InterruptedException ex) {
                    Logger.getLogger(director.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (estudio.getProyectManager().isWatchingAnime()) { 
                    estudio.setPmFaults(estudio.getPmFaults() + 1); 

                    estudio.setPmDiscountedAmount(estudio.getPmDiscountedAmount() + 100); 

                    estudio.setSalaryAccount(estudio.getSalaryAccount() - 100); 
                    System.out.println("El director atrapo al PM viendo anime");
                }

                try {
                    setCheckingPM(false);

                    if (estudio == Main.CartoonNetwork) {
                        Main.gui.getDirectorStatus().setText("Administrando");
                    } else {
                        Main.gui.getDirectorStatusStar().setText("Administrando");
                    }

                    sleep(halfHour);
                    timeSpent += halfHour;
                } catch (InterruptedException ex) {
                    Logger.getLogger(director.class.getName()).log(Level.SEVERE, null, ex);
                }
                hourlyCycle++; 
                while (hourlyCycle < 24) {
                    try {
                        sleep(hour);
                        timeSpent += hour;
                    } catch (InterruptedException ex) {
                        Logger.getLogger(director.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    hourlyCycle++;
                }

            }
            
            try {
                sleep(estudio.getDayDuration() - timeSpent);
            } catch (InterruptedException ex) {
                Logger.getLogger(director.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        

    }

    @Override
    public void run() {

        while (true) {
            operate();
            addDailySalary();
        }

    }

    public int getHourlyCycle() {
        return hourlyCycle;
    }

    public void setHourlyCycle(int hourlyCycle) {
        this.hourlyCycle = hourlyCycle;
    }

    public boolean isCheckingPM() {
        return checkingPM;
    }

    public void setCheckingPM(boolean checkingPM) {
        this.checkingPM = checkingPM;
    }
}
