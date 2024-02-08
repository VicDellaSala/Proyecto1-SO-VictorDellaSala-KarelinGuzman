/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Victor Daniel
 */
public class animator extends Thread {

    private estudio estudio;
    private int dayCicle;
    int salary = 40;

    public animator(estudio estudio) {
        this.estudio = estudio;
        this.dayCicle = 0;

    }

    public int getEmployeeAmount() {
        return estudio.getAnimatorEmployeeAmount();
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

    public drive getAnimatorDrive() {
        return estudio.getAnimatorDrive();
    }

    public void operate() {
        setDayCicle(getDayCicle() + 1);
        if (getDayCicle() >= 1) {
            try {
                getAnimatorSemaphore().acquire(); 
                int addedAmount = getAnimatorDrive().add(getEmployeeAmount());
                System.out
                        .println("El drive de animaciones tiene " + getAnimatorDrive().getResourse() + " animaciones");
                getAnimatorSemaphore().release();
                setDayCicle(0);

            } catch (InterruptedException ex) {
                Logger.getLogger(animator.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(animator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public Semaphore getAnimatorSemaphore() {
        return estudio.getAnimatorSemaphore();
    }
}
