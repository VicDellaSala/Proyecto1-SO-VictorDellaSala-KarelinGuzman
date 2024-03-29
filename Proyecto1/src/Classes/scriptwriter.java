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
public class scriptwriter extends Thread {

    estudio estudio;
    int salary = 20;
    private int dayCicle;

    public scriptwriter(estudio estudio) {
        this.estudio = estudio;
    }

    public int getEmployeeAmount() {
        return estudio.getScriptwriterEmployeeAmount();
    }

    public void setEmployeeAmount(int employeeAmount) {
        estudio.setScriptwriterEmployeeAmount(employeeAmount);
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
        // System.out.println("El equipo de " + getEmployeeAmount() + " guionistas" + "
        // gana: " + salary*24*getEmployeeAmount()+"$");
    }

    public drive getScriptwriterDrive() {
        return estudio.getScriptwriterDrive();
    }

    public void operate() {
        setDayCicle(getDayCicle() + 1);
        if (getDayCicle() >= 4) {
            try {

                getScriptwriterSemaphore().acquire(); // wait
                int addedAmount = getScriptwriterDrive().add(getEmployeeAmount()); 
                System.out.println("drive de guionistas:" + getScriptwriterDrive().getResourse() + " guiones-------");
                getScriptwriterSemaphore().release(); // wait
                setDayCicle(0);

            } catch (InterruptedException ex) {
                Logger.getLogger(scriptwriter.class.getName()).log(Level.SEVERE, null, ex);
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
                estudio.setDaysGoneBy(estudio.getDaysGoneBy() + 1);

            } catch (InterruptedException ex) {
                Logger.getLogger(scriptwriter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public Semaphore getScriptwriterSemaphore() {
        return estudio.getScriptwriterSemaphore();
    }
}
