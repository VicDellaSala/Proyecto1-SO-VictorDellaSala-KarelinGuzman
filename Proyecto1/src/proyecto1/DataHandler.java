/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author VicDellaSala
 */
public class DataHandler {

    public DoubleList ReadText() {
        
        DoubleList list = new DoubleList();

        BufferedReader reader;

        String line;
        String csvText = "";
        try {
            reader = new BufferedReader(new FileReader(new File("test/initialData.csv")));
            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty()) {
                    csvText += line + "\n";
                }
            }

            if (!"".equals(csvText)) {
                String[] data_split = csvText.split("\n");
                for (int i = 0; i < data_split.length; i++) {
                    String[] data = data_split[i].split("(,|, )");
                    if (!data_split[i].equals("secondsDuration, daysDeadline, screenwriters, stageDesigners, animators, voiceActors, plotTwistScriptwriters, assemblers")) {
                        InitialData initialData = new InitialData(data[4], data[7], data[1], data[6], data[2], data[0], data[3], data[5]);
                        list.insertFinal(initialData);
                    }
                }
            }

            reader.close();
        } catch (Exception e) {

        }
        return list;
    }

    public void WriteText(InitialData newDataNick, InitialData newDataStar) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("test/simulationData.csv"));
            PrintWriter wr = new PrintWriter(bw);
            wr.append("secondsDuration, daysDeadline, screenwriters, stageDesigners, animators, voiceActors, plotTwistScriptwriters, assemblers\n");

            wr.append(String.valueOf(newDataNick.getSimulationDuration()) + "," + String.valueOf(newDataNick.getDeadline()) + ","
                    + String.valueOf(newDataNick.getScreenwriters()) + "," + String.valueOf(newDataNick.getStageDesigner()) + ","
                    + String.valueOf(newDataNick.getAnimator()) + "," + String.valueOf(newDataNick.getVoiceActors()) + ","
                    + String.valueOf(newDataNick.getPlotTwistScriptwriters()) + "," + String.valueOf(newDataNick.getAssemblers()) + "\n");
            
            wr.append(String.valueOf(newDataStar.getSimulationDuration()) + "," + String.valueOf(newDataStar.getDeadline()) + ","
                    + String.valueOf(newDataStar.getScreenwriters()) + "," + String.valueOf(newDataStar.getStageDesigner()) + ","
                    + String.valueOf(newDataStar.getAnimator()) + "," + String.valueOf(newDataStar.getVoiceActors()) + ","
                    + String.valueOf(newDataStar.getPlotTwistScriptwriters()) + "," + String.valueOf(newDataStar.getAssemblers()) + "\n");

            wr.close();
            bw.close();

        } catch (IOException e) {

        }
    }
}
