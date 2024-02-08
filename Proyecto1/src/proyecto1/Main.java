/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto1;

import Classes.estudio;

/**
 *
 * @author VicDellaSala
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static DataHandler dataHandler = new DataHandler();
    public static InitialData initialDataNick = (InitialData) dataHandler.ReadText().getHead().getElement();
    public static InitialData initialDataStar = (InitialData) dataHandler.ReadText().getTail().getElement();

    static int durationNick = Integer.parseInt((String) initialDataNick.getSimulationDuration()) * 1000;
    static int deadlineNick = Integer.parseInt((String) initialDataNick.getDeadline());

    static int durationStar = Integer.parseInt((String) initialDataStar.getSimulationDuration()) * 1000;
    static int deadlineStar = Integer.parseInt((String) initialDataStar.getDeadline());

    // Employee amount
    static int scriptwriterNick = Integer.parseInt((String) initialDataNick.getScreenwriters());
    static int setDesignerNick = Integer.parseInt((String) initialDataNick.getStageDesigner());
    static int animatorNick = Integer.parseInt((String) initialDataNick.getAnimator());
    static int voiceActorNick = Integer.parseInt((String) initialDataNick.getVoiceActors());
    static int plotTwisterNick = Integer.parseInt((String) initialDataNick.getPlotTwistScriptwriters());
    static int assemblerNick = Integer.parseInt((String) initialDataNick.getAssemblers());

    static int scriptwriterStar = Integer.parseInt((String) initialDataStar.getScreenwriters());
    static int setDesignerStar = Integer.parseInt((String) initialDataStar.getStageDesigner());
    static int animatorStar = Integer.parseInt((String) initialDataStar.getAnimator());
    static int voiceActorStar = Integer.parseInt((String) initialDataStar.getVoiceActors());
    static int plotTwisterStar = Integer.parseInt((String) initialDataStar.getPlotTwistScriptwriters());
    static int assemblerStar = Integer.parseInt((String) initialDataStar.getAssemblers());

    public static estudio Nickelodeon = new estudio("Nickelodeon", 450000, 500000, deadlineNick, durationNick, 2, 1, 4, 4, 5, 1, scriptwriterNick, setDesignerNick, animatorNick, voiceActorNick, plotTwisterNick, assemblerNick);
    public static estudio StarChannel = new estudio("Star Channel", 350000, 800000, deadlineStar, durationStar, 2, 3, 4, 6, 3, 1, scriptwriterStar, setDesignerStar, animatorStar, voiceActorStar, plotTwisterStar, assemblerStar);

    public static InterfaceView interfaceView = new InterfaceView();

    public static void main(String[] args) {
        Nickelodeon.start();
        StarChannel.start();

        while (true) {
            interfaceView.getCosts().setText(String.valueOf(Nickelodeon.getSalaryAccount()));
            interfaceView.getEarnings().setText(String.valueOf(Nickelodeon.getProfits()));
            interfaceView.getProfit().setText(String.valueOf(Main.Nickelodeon.getProfits() - Nickelodeon.getSalaryAccount()));
            interfaceView.getCostsStar().setText(String.valueOf(StarChannel.getSalaryAccount()));
            interfaceView.getEarningsStar().setText(String.valueOf(StarChannel.getProfits()));
            interfaceView.getProfitStar().setText(String.valueOf(StarChannel.getProfits() - StarChannel.getSalaryAccount()));

            interfaceView.getProjectFaults().setText(String.valueOf(Nickelodeon.getPmFaults()));
            interfaceView.getProjectManagerDeduction().setText(String.valueOf(Nickelodeon.getPmDiscountedAmount()));
            interfaceView.getProjectFaultsStar1().setText(String.valueOf(StarChannel.getPmFaults()));
            interfaceView.getProjectManagerDeductionStar().setText(String.valueOf(StarChannel.getPmDiscountedAmount()));

            interfaceView.getSpriptStorageStar().setText(String.valueOf(StarChannel.getScriptwriterDrive().getResourse()) + "/25");
            interfaceView.getDubbingStorageStar().setText(String.valueOf(StarChannel.getDuberDrive().getResourse()) + "/35");
            interfaceView.getDesignerStorageStar().setText(String.valueOf(StarChannel.getSetDesignerDrive().getResourse()) + "/20");
            interfaceView.getAnimatorStorageStar().setText(String.valueOf(StarChannel.getAnimatorDrive().getResourse()) + "/55");
            interfaceView.getPlotStorageStar().setText(String.valueOf(StarChannel.getTwisterDrive().getResourse()) + "/10");
            interfaceView.getSpriptStorage().setText(String.valueOf(Nickelodeon.getScriptwriterDrive().getResourse()) + "/25");
            interfaceView.getDubbingStorage().setText(String.valueOf(Nickelodeon.getDuberDrive().getResourse()) + "/35");
            interfaceView.getDesignerStorage().setText(String.valueOf(Nickelodeon.getSetDesignerDrive().getResourse()) + "/20");
            interfaceView.getAnimatorStorage().setText(String.valueOf(Nickelodeon.getAnimatorDrive().getResourse()) + "/55");
            interfaceView.getPlotStorage().setText(String.valueOf(Nickelodeon.getTwisterDrive().getResourse()) + "/10");

            interfaceView.getPlotTwist().setText(String.valueOf(Nickelodeon.getPlotAssemblerDrive().getResourse()));
            interfaceView.getStandard().setText(String.valueOf(Nickelodeon.getAssemblerDrive().getResourse()));
            interfaceView.getPlotTwist1().setText(String.valueOf(StarChannel.getPlotAssemblerDrive().getResourse()));
            interfaceView.getStandardStar1().setText(String.valueOf(StarChannel.getAssemblerDrive().getResourse()));

            interfaceView.getDeadlineCounter().setText(String.valueOf(Nickelodeon.getDaysLeftRelease()));
            interfaceView.getDeadlineCounterStar1().setText(String.valueOf(StarChannel.getDaysLeftRelease()));
        }
    }
}
