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

public class assembler extends Thread {

    private estudio estudio;
    private Semaphore assemblerSemaphore;
    private Semaphore animatorSemaphore;
    private Semaphore twisterSemaphore;
    private Semaphore scriptwriterSemaphore;
    private Semaphore setDesignerSemaphore;
    private Semaphore duberSemaphore;
    private drive animatorDrive;
    private drive twisterDrive;
    private drive scriptwriterDrive;
    private drive setDesignerDrive;
    private drive duberDrive;
    private int employeeAmount;
    private int dayDuration;
    private int dayCicle;
    private int episodeCicle;
    private int salaryAccount;
    private driveEpisodes assemblerDrive;
    private driveEpisodes plotAssemblerDrive;
    int salary = 50;
    private int scriptReq; 
    private int sceneryReq;
    private int animationReq; 
    private int dubReq; 
    private int plotEpisodeRatio; 
    private int plotTwistsAmount; 

    public assembler(estudio estudio) {
        this.estudio = estudio;
        this.assemblerSemaphore = estudio.getAssemblerSemaphore();
        this.employeeAmount = estudio.getAssemblerEmployeeAmount();
        this.dayDuration = estudio.getDayDuration();
        this.dayCicle = 0;
        this.episodeCicle = 0;
        this.salaryAccount = estudio.getSalaryAccount();
        this.assemblerDrive = estudio.getAssemblerDrive();
        this.animatorSemaphore = estudio.getAnimatorSemaphore();
        this.animatorDrive = estudio.getAnimatorDrive();
        this.twisterSemaphore = estudio.getTwisterSemaphore();
        this.twisterDrive = estudio.getTwisterDrive();
        this.scriptwriterSemaphore = estudio.getScriptwriterSemaphore();
        this.scriptwriterDrive = estudio.getScriptwriterDrive();
        this.setDesignerSemaphore = estudio.getSetDesignerSemaphore();
        this.setDesignerDrive = estudio.getSetDesignerDrive();
        this.duberSemaphore = estudio.getDuberSemaphore();
        this.duberDrive = estudio.getDuberDrive();
        this.plotTwistsAmount = estudio.getPlotTwistsAmount();
        this.plotAssemblerDrive = estudio.getPlotAssemblerDrive();
        this.plotEpisodeRatio = estudio.getPlotEpisodeRatio();
        this.scriptReq = estudio.getScriptReq();
        this.sceneryReq = estudio.getSceneryReq();
        this.animationReq = estudio.getAnimationReq();
        this.dubReq = estudio.getDubReq();

    }

    public int getEmployeeAmount() {
        return employeeAmount;
    }

    public void setEmployeeAmount(int employeeAmount) {
        this.employeeAmount = employeeAmount;
    }

    public int getDayDuration() {
        return dayDuration;
    }

    public void setDayDuration(int dayDuration) {
        this.dayDuration = dayDuration;
    }

    public int getDayCicle() {
        return dayCicle;
    }

    public void setDayCicle(int dayCicle) {
        this.dayCicle = dayCicle;
    }

    public int getSalaryAccount() {
        return salaryAccount;
    }

    public void setSalaryAccount(int salaryAccount) {
        this.salaryAccount = salaryAccount;
    }

    public void addDailySalary() {
        System.out.println("La cuenta antes de pagarle al assembler: " + estudio.getSalaryAccount() );
        estudio.setSalaryAccount(
                estudio.getSalaryAccount() + salary * 24 * getEmployeeAmount());
        System.out.println("El equipo de " + getEmployeeAmount() + " assembler" + " gana: " + salary*24*getEmployeeAmount()+"$");
        System.out.println("La cuenta luego de pagarle al assembler: " + estudio.getSalaryAccount() );
    }

    public driveEpisodes getAssemblerDrive() {
        return assemblerDrive;
    }

    public void operate() {
        setDayCicle(getDayCicle() + 1);
        if (getDayCicle() >= 2) {
            try {
                for (int i = 0; i < getEmployeeAmount(); i++) { 

                    if (getEpisodeCicle() == getPlotEpisodeRatio()) { 
                        getScriptwriterSemaphore().acquire();
                        getAnimatorSemaphore().acquire();
                        getTwisterSemaphore().acquire();
                        getSetDesignerSemaphore().acquire();
                        getDuberSemaphore().acquire();
                        if (getScriptwriterDrive().getResourse() >= estudio.getScriptReq()
                                && 
                                getAnimatorDrive().getResourse() >= estudio.getAnimationReq()
                                && getSetDesignerDrive().getResourse() >= estudio.getSceneryReq()
                                && getDuberDrive().getResourse() >= estudio.getDubReq()
                                && getTwisterDrive().getResourse() >= estudio.getPlotTwistsAmount()) {
                            getScriptwriterDrive().substract(getScriptReq()); 
                            getAnimatorDrive().substract(getAnimationReq());
                            getSetDesignerDrive().substract(getSceneryReq());
                            getDuberDrive().substract(getDubReq());
                            getTwisterDrive().substract(getPlotTwistsAmount());

                        
                            getAssemblerSemaphore().acquire();
                            int addedAmount = getPlotAssemblerDrive().add(1);
                            System.out.println("Un ensamblador agrego " + addedAmount
                                    + " capitulo DE PLOTTWIST al drive de Plottwist! ");
                            System.out.println(" /---Hay " + getPlotAssemblerDrive().getResourse()
                                    + " capitulos de plotTwist ensamblados---/");
                            getAssemblerSemaphore().release();
                            setEpisodeCicle(0); 

                        } else { 
                            System.out.println(
                                    "Un ensamblador no pudo ensamblar un episodio de plotTwist por falta de requerimientos");

                        }
                        getScriptwriterSemaphore().release(); 
                        getAnimatorSemaphore().release();
                        getSetDesignerSemaphore().release();
                        getDuberSemaphore().release();
                        getTwisterSemaphore().release();

                    } else { 
                        getScriptwriterSemaphore().acquire();
                        getAnimatorSemaphore().acquire();
                        getSetDesignerSemaphore().acquire();
                        getDuberSemaphore().acquire();

                        if (getScriptwriterDrive().getResourse() >= estudio.getScriptReq()
                                && 
                                getAnimatorDrive().getResourse() >= estudio.getAnimationReq()
                                && getSetDesignerDrive().getResourse() >= estudio.getSceneryReq()
                                && getDuberDrive().getResourse() >= estudio.getDubReq()) {
                            getScriptwriterDrive().substract(getScriptReq());
                            getAnimatorDrive().substract(getAnimationReq());
                            getSetDesignerDrive().substract(getSceneryReq());
                            getDuberDrive().substract(getDubReq());

                          
                            getAssemblerSemaphore().acquire();
                            int addedAmount = getAssemblerDrive().add(1);

                            System.out.println("Un ensamblador agrego " + addedAmount + " capitulos a su drive! ");
                            System.out.println(" /---Hay " + getAssemblerDrive().getResourse()
                                    + " capitulos comunes ensamblados---/");
                            getAssemblerSemaphore().release();
                            setEpisodeCicle(getEpisodeCicle() + 1); 

                        } else { 
                            System.out.println(
                                    "Un ensamblador no pudo ensamblar un episodio por falta de requerimientos");
                        }
                        getScriptwriterSemaphore().release(); 
                        getAnimatorSemaphore().release();
                        getSetDesignerSemaphore().release();
                        getDuberSemaphore().release();
                    }
                }
                setDayCicle(0); 
            } catch (InterruptedException ex) {
                Logger.getLogger(assembler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void run() {

        while (true) {

            try {
                operate();
                sleep(this.dayDuration);
                addDailySalary();

                

            } catch (InterruptedException ex) {
                Logger.getLogger(assembler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public Semaphore getAssemblerSemaphore() {
        return assemblerSemaphore;
    }

    public int getEpisodeCicle() {
        return episodeCicle;
    }

    public void setEpisodeCicle(int episodeCicle) {
        this.episodeCicle = episodeCicle;
    }

    public Semaphore getAnimatorSemaphore() {
        return animatorSemaphore;
    }

    public Semaphore getTwisterSemaphore() {
        return twisterSemaphore;
    }

    public Semaphore getScriptwriterSemaphore() {
        return scriptwriterSemaphore;
    }

    public Semaphore getSetDesignerSemaphore() {
        return setDesignerSemaphore;
    }

    public Semaphore getDuberSemaphore() {
        return duberSemaphore;
    }

    public drive getAnimatorDrive() {
        return animatorDrive;
    }

    public drive getTwisterDrive() {
        return twisterDrive;
    }

    public drive getScriptwriterDrive() {
        return scriptwriterDrive;
    }

    public drive getSetDesignerDrive() {
        return setDesignerDrive;
    }

    public drive getDuberDrive() {
        return duberDrive;
    }

    public int getScriptReq() {
        return scriptReq;
    }

    public int getSceneryReq() {
        return sceneryReq;
    }

    public int getAnimationReq() {
        return animationReq;
    }

    public int getDubReq() {
        return dubReq;
    }

    public int getPlotEpisodeRatio() {
        return plotEpisodeRatio;
    }

    public int getPlotTwistsAmount() {
        return plotTwistsAmount;
    }

    public driveEpisodes getPlotAssemblerDrive() {
        return plotAssemblerDrive;
    }
}