/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Victor Daniel
 */

public class twister extends Thread {

    private estudio estudio;
    private int dayCicle;
    int salary = 34;

    public twister(estudio estudio) {
        this.estudio = estudio;
        this.dayCicle = 0;

    }

    public int getEmployeeAmount() {
        return estudio.getTwisterEmployeeAmount();
    }

    public int getDayDuration() {
        return estudio.getDayDuration();
    }

    public int getDayCicle() {
        return dayCicle;
    }

    public void setDayCicle(int dayCicle) {
        this.dayCicle = dayCicle;
    }

    public int getSalaryAccount() {
        return estudio.getSalaryAccount();
    }

    public void setSalaryAccount(int salaryAccount) {
        estudio.setSalaryAccount(salaryAccount);
    }

    public void addDailySalary() {
        setSalaryAccount(
                getSalaryAccount() + salary * 24 * getEmployeeAmount());
    }

    public drive getTwisterDrive() {
        return estudio.getTwisterDrive();
    }

    public void operate() {
        setDayCicle(getDayCicle() + 1);
        if (getDayCicle() >= 2) {
            try {
                getTwisterSemaphore().acquire(); // wait
                int addedAmount = getTwisterDrive().add(getEmployeeAmount());
                System.out
                        .println("El drive de plotTwist tiene " + getTwisterDrive().getResourse() + " plotTwists");
                getTwisterSemaphore().release(); // wait
                setDayCicle(0);

            } catch (InterruptedException ex) {
                Logger.getLogger(twister.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void run() {

        while (true) {

            try {

                operate();
                sleep(estudio.getDayDuration());
                addDailySalary();
                

            } catch (InterruptedException ex) {
                Logger.getLogger(twister.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public Semaphore getTwisterSemaphore() {
        return estudio.getTwisterSemaphore();
    }
}