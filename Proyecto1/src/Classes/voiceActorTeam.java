/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import operativosjimenezmarcano.Main;

/**
 *
 * @author Victor Daniel
 */
public class voiceActorTeam extends Thread {

    private studio studio;
    private int dayCicle;

    int salary = 16;

    public voiceActorTeam(studio studio) {
        this.studio = studio;
        this.dayCicle = 0;

    }

    public int getEmployeeCount() {
        return studio.getVoiceActorEmployeeCount();
    }

    public int getDayDuration() {
        return studio.getDayDuration();
    }

    public int getDayCicle() {
        return dayCicle;
    }

    public void setDayCicle(int dayCicle) {
        this.dayCicle = dayCicle;
    }

    public int getSalaryAccount() {
        return studio.getSalaryAccount();
    }

    public void setSalaryAccount(int salaryAccount) {
        studio.setSalaryAccount(salaryAccount);
    }

    public void addDailySalary() {
        setSalaryAccount(
                getSalaryAccount() + salary * 24 * getEmployeeCount());
        // System.out.println("El equipo de " + getEmployeeCount() + " actore de
        // doblaje" + " gana: " + salary*24*getEmployeeCount()+"$");
    }

    public drive getVoiceActorDrive() {
        return studio.getVoiceActorDrive();
    }

    public void operate() {
        setDayCicle(getDayCicle() + 1);
        if (getDayCicle() >= 1) {
            try {
                getVoiceActorSemaphore().acquire(); // wait
                int addedAmount = getVoiceActorDrive().add(getEmployeeCount() * 5); // Adds 5 voice translations for
                                                                                    // each employee in the team the
                                                                                    // function .add() in drive class
                                                                                    // returns the added amount to be
                                                                                    // reported later
                System.out.println("El drive de doblajes tiene " + getVoiceActorDrive().getResourse() + " doblajes");
                getVoiceActorSemaphore().release(); // wait
                setDayCicle(0);

            } catch (InterruptedException ex) {
                Logger.getLogger(voiceActorTeam.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void run() {

        while (true) {

            try {

                operate();
                sleep(studio.getDayDuration());
                addDailySalary();
                

            } catch (InterruptedException ex) {
                Logger.getLogger(voiceActorTeam.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public Semaphore getVoiceActorSemaphore() {
        return studio.getVoiceActorSemaphore();
    }
}
