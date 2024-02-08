/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

/**
 *
 * @author VicDellaSala
 */
public class InitialData {

    public Object getAnimator() {
        return animator;
    }

    public void setAnimator(Object animator) {
        this.animator = animator;
    }

    public Object getAssemblers() {
        return assemblers;
    }

    public void setAssemblers(Object assemblers) {
        this.assemblers = assemblers;
    }

    public Object getDeadline() {
        return deadline;
    }

    public void setDeadline(Object deadline) {
        this.deadline = deadline;
    }

    public Object getPlotTwistScriptwriters() {
        return plotTwistScriptwriters;
    }

    public void setPlotTwistScriptwriters(Object plotTwistScriptwriters) {
        this.plotTwistScriptwriters = plotTwistScriptwriters;
    }

    public Object getScreenwriters() {
        return screenwriters;
    }

    public void setScreenwriters(Object screenwriters) {
        this.screenwriters = screenwriters;
    }

    public Object getSimulationDuration() {
        return simulationDuration;
    }

    public void setSimulationDuration(Object simulationDuration) {
        this.simulationDuration = simulationDuration;
    }

    public Object getStageDesigner() {
        return stageDesigner;
    }

    public void setStageDesigner(Object stageDesigner) {
        this.stageDesigner = stageDesigner;
    }

    public Object getVoiceActors() {
        return voiceActors;
    }

    public void setVoiceActors(Object voiceActors) {
        this.voiceActors = voiceActors;
    }

    public InitialData(Object animator, Object assemblers, Object deadline, Object plotTwistScriptwriters, Object screenwriters, Object simulationDuration, Object stageDesigner, Object voiceActors) {
        this.animator = animator;
        this.assemblers = assemblers;
        this.deadline = deadline;
        this.plotTwistScriptwriters = plotTwistScriptwriters;
        this.screenwriters = screenwriters;
        this.simulationDuration = simulationDuration;
        this.stageDesigner = stageDesigner;
        this.voiceActors = voiceActors;
    }
    private Object animator;
    private Object assemblers;
    private Object deadline;
    private Object plotTwistScriptwriters;
    private Object screenwriters;
    private Object simulationDuration;
    private Object stageDesigner;
    private Object voiceActors;
}
