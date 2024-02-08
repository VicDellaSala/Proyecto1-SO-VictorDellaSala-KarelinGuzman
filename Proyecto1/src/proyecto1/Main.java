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
        
    }

}
