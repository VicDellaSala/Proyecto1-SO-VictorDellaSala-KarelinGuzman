/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Karelin
 */

public class estudio extends Thread{ 
    private String estudioName;
    private int deadlineRatio;
    private int daysLeftRelease;
    private int dayDuration;
    private int daysGoneBy;
    private int profits;
    private int pmFaults;
    private int pmDiscountedAmount;
    private int salaryAccount;
    private int episodesReleased;
    private int plotEpisodesReleased;
    private int commonEpisodeProfit;
    private int plotEpisodeProfit;
    private Semaphore scriptwriterSemaphore;
    private Semaphore setDesignerSemaphore;
    private Semaphore animatorSemaphore;
    private Semaphore duberSemaphore;
    private Semaphore twisterSemaphore;
    private Semaphore assemblerSemaphore; 
    private Semaphore daysLeftSemaphore;
    private Semaphore salaryAccountSemaphore;
    private drive scriptwriterDrive;
    private drive setDesignerDrive;
    private drive animatorDrive;
    private drive duberDrive;
    private drive twisterDrive;
    private driveEpisodes assemblerDrive;
    private driveEpisodes plotAssemblerDrive;
    private int scriptReq;
    private int sceneryReq;
    private int animationReq;
    private int dubReq;
    private int plotEpisodeRatio;
    private int plotTwistsAmount;
    private int scriptwriterEmployeeAmount;
    private int setDesignerEmployeeAmount;
    private int animatorEmployeeAmount;
    private int duberEmployeeAmount;
    private int twisterEmployeeAmount;
    private int assemblerEmployeeAmount;
    private scriptwriter scriptwriter;
    private setDesigner setDesigner;
    private animator animator;
    private duber duber;
    private twister twister;
    private assembler assembler;
    private proyectManager proyectManager;
    private director director;
    
    

    public estudio(String estudioName,int commonEpisodeProfit,int plotEpisodeProfit, int deadlineRatio, int dayDuration, int scriptReq, int sceneryReq, int animationReq, int dubReq, int plotEpisodeRatio, int plotTwistsAmount, int scriptwriterEmployeeAmount, int setDesignerEmployeeAmount, int animatorEmployeeAmount, int duberEmployeeAmount, int twisterEmployeeAmount, int assemblerEmployeeAmount) {
     
        this.estudioName = estudioName;
        this.commonEpisodeProfit = commonEpisodeProfit;
        this.plotEpisodeProfit = plotEpisodeProfit;
        this.profits = 0;
        this.pmFaults = 0;
        this.pmDiscountedAmount = 0;
        this.salaryAccount = 0;
        this.episodesReleased = 0;
        this.plotEpisodesReleased = 0;
        this.deadlineRatio = deadlineRatio;
        this.daysLeftRelease = deadlineRatio;
        this.dayDuration = dayDuration;
        this.scriptwriterSemaphore = new Semaphore(1);
        this.setDesignerSemaphore = new Semaphore(1);
        this.animatorSemaphore = new Semaphore(1);
        this.duberSemaphore = new Semaphore(1);
        this.twisterSemaphore = new Semaphore(1);
        this.assemblerSemaphore = new Semaphore(1);
        this.daysLeftSemaphore = new Semaphore(1);
        this.salaryAccountSemaphore = new Semaphore(1);
        this.scriptwriterDrive = new drive(25);
        this.setDesignerDrive = new drive(20);
        this.animatorDrive = new drive(55);
        this.duberDrive = new drive(35);
        this.twisterDrive = new drive(10);
        this.assemblerDrive = new driveEpisodes(69);
        this.plotAssemblerDrive = new driveEpisodes(69);
        this.scriptReq = scriptReq;
        this.sceneryReq = sceneryReq;
        this.animationReq = animationReq;
        this.dubReq = dubReq;
        this.plotEpisodeRatio = plotEpisodeRatio;
        this.plotTwistsAmount = plotTwistsAmount;
        this.scriptwriterEmployeeAmount = scriptwriterEmployeeAmount;
        this.setDesignerEmployeeAmount = setDesignerEmployeeAmount;
        this.animatorEmployeeAmount = animatorEmployeeAmount;
        this.duberEmployeeAmount = duberEmployeeAmount;
        this.twisterEmployeeAmount = twisterEmployeeAmount;
        this.assemblerEmployeeAmount = assemblerEmployeeAmount;       
        this.scriptwriter = new scriptwriter(this);
        this.setDesigner = new setDesigner(this);
        this.animator = new animator(this);
        this.duber = new duber(this);
        this.twister = new twister(this);
        this.assembler = new assembler(this);
        this.proyectManager = new proyectManager(this);
        this.director = new director(this);
    }
    @Override
    public void run() {                                         
                    getScriptwriter().start();
                    getSetDesigner().start();
                    getAnimator().start();
                    getDuber().start();
                    getTwister().start();
                    getAssembler().start();
                    getProyectManager().start();
                    getDirector().start();
    }
    
    public String getEstudioName() {
        return estudioName;
    }

    public int getDeadlineRatio() {
        return deadlineRatio;
    }

    public void setDeadlineRatio(int deadlineRatio) {
        this.deadlineRatio = deadlineRatio;
    }

    public int getDaysLeftRelease() {
        return daysLeftRelease;
    }

    public void setDaysLeftRelease(int daysLeftRelease) {
        this.daysLeftRelease = daysLeftRelease;
    }

    public int getProfits() {
        return profits;
    }

    public void setProfits(int profits) {
        this.profits = profits;
    }

    public int getPmFaults() {
        return pmFaults;
    }

    public void setPmFaults(int pmFaults) {
        this.pmFaults = pmFaults;
    }

    public int getPmDiscountedAmount() {
        return pmDiscountedAmount;
    }

    public void setPmDiscountedAmount(int pmDiscountedAmount) {
        this.pmDiscountedAmount = pmDiscountedAmount;
    }

    public int getSalaryAccount() {
        return salaryAccount;
    }

    public void setSalaryAccount(int salaryAccount) {
        try {
            getSalaryAccountSemaphore().acquire();
            this.salaryAccount = salaryAccount;
            getSalaryAccountSemaphore().release();
        } catch (InterruptedException ex) {
            Logger.getLogger(estudio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public Semaphore getScriptwriterSemaphore() {
        return scriptwriterSemaphore;
    }

    public Semaphore getSetDesignerSemaphore() {
        return setDesignerSemaphore;
    }

    public Semaphore getAnimatorSemaphore() {
        return animatorSemaphore;
    }

    public Semaphore getDuberSemaphore() {
        return duberSemaphore;
    }

    public Semaphore getTwisterSemaphore() {
        return twisterSemaphore;
    }

    public Semaphore getAssemblerSemaphore() {
        return assemblerSemaphore;
    }

    public drive getScriptwriterDrive() {
        return scriptwriterDrive;
    }

    public drive getSetDesignerDrive() {
        return setDesignerDrive;
    }

    public drive getAnimatorDrive() {
        return animatorDrive;
    }

    public drive getDuberDrive() {
        return duberDrive;
    }

    public drive getTwisterDrive() {
        return twisterDrive;
    }

    public driveEpisodes getAssemblerDrive() {
        return assemblerDrive;
    }

    public driveEpisodes getPlotAssemblerDrive() {
        return plotAssemblerDrive;
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

    public int getScriptwriterEmployeeAmount() {
        return scriptwriterEmployeeAmount;
    }

    public void setScriptwriterEmployeeAmount(int scriptwriterEmployeeAmount) {
        this.scriptwriterEmployeeAmount = scriptwriterEmployeeAmount;
    }

    public int getSetDesignerEmployeeAmount() {
        return setDesignerEmployeeAmount;
    }

    public void setSetDesignerEmployeeAmount(int setDesignerEmployeeAmount) {
        this.setDesignerEmployeeAmount = setDesignerEmployeeAmount;
    }

    public int getAnimatorEmployeeAmount() {
        return animatorEmployeeAmount;
    }

    public void setAnimatorEmployeeAmount(int animatorEmployeeAmount) {
        this.animatorEmployeeAmount = animatorEmployeeAmount;
    }

    public int getDuberEmployeeAmount() {
        return duberEmployeeAmount;
    }

    public void setDuberEmployeeAmount(int duberEmployeeAmount) {
        this.duberEmployeeAmount = duberEmployeeAmount;
    }

    public int getTwisterEmployeeAmount() {
        return twisterEmployeeAmount;
    }

    public void setTwisterEmployeeAmount(int twisterEmployeeAmount) {
        this.twisterEmployeeAmount = twisterEmployeeAmount;
    }

    public int getAssemblerEmployeeAmount() {
        return assemblerEmployeeAmount;
    }

    public void setAssemblerEmployeeAmount(int assemblerEmployeeAmount) {
        this.assemblerEmployeeAmount = assemblerEmployeeAmount;
    }

    public int getDayDuration() {
        return dayDuration;
    }

    public void setDayDuration(int dayDuration) {
        this.dayDuration = dayDuration;
    }

    public scriptwriter getScriptwriter() {
        return scriptwriter;
    }

    public setDesigner getSetDesigner() {
        return setDesigner;
    }

    public animator getAnimator() {
        return animator;
    }

    public duber getDuber() {
        return duber;
    }

    public twister getTwister() {
        return twister;
    }

    public assembler getAssembler() {
        return assembler;
    }

    public void setAssembler(assembler assembler) {
        this.assembler = assembler;
    }

    public proyectManager getProyectManager() {
        return proyectManager;
    }

    public int getEpisodesReleased() {
        return episodesReleased;
    }

    public void setEpisodesReleased(int episodesReleased) {
        this.episodesReleased = episodesReleased;
    }

    public int getPlotEpisodesReleased() {
        return plotEpisodesReleased;
    }

    public void setPlotEpisodesReleased(int plotEpisodesReleased) {
        this.plotEpisodesReleased = plotEpisodesReleased;
    }

    public int getCommonEpisodeProfit() {
        return commonEpisodeProfit;
    }

    public int getPlotEpisodeProfit() {
        return plotEpisodeProfit;
    }

    public director getDirector() {
        return director;
    }

    public Semaphore getDaysLeftSemaphore() {
        return daysLeftSemaphore;
    }

    public Semaphore getSalaryAccountSemaphore() {
        return salaryAccountSemaphore;
    }

    public int getDaysGoneBy() {
        return daysGoneBy;
    }

    public void setDaysGoneBy(int daysGoneBy) {
        this.daysGoneBy = daysGoneBy;
    }
    
    
    
}