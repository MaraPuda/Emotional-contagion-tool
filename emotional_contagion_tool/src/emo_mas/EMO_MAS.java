/*
Class runs agents
 */
package emo_mas;

import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Mara Pudane
 */
public class EMO_MAS {

    public static int nr = 0;
    public static boolean JADE_RUNNING = false;

    public static void main(String args[]) {





        if (JADE_RUNNING == false) {


//runs JADE

            RunJade r = new RunJade(false, "30000");
            ContainerController home = r.getHome();

//runs interface       


            try {


                AgentController ac = RunJade.home.createNewAgent("UserInterface", "emotioncontagion.InterfaceAgent", new Object[0]);

                ac.start();

            } catch (Exception e) {
                e.printStackTrace();

            }
            JADE_RUNNING = true;
        }

//runAgents();

    }

    public static void runAgents() {
        nr = 0;
        int length = AgentNetwork.getNumber();
//start emotional agents
        while (emotioncontagion.EmotionalContagionInterface.NETWORK_READY == false) {
            System.out.print("");
        }



        for (int i = 0; i < length; i++) {
            startAgent(i);

            
        }
    }

    //give args to agent
    public static void startAgent(int number) {

        try {
 
            Object[] args = new Object[AgentNetwork.countCommunication(number) + 15];
            for (int i = 0; i < args.length; i++) {

                args[i] = 0.0;
            }
            args[5] = 0.0001;

            while (emotioncontagion.EmotionalContagionInterface.PERSONALITY_READY == false) {
                System.out.print("");
            }

            
            double[] tempOCEANArray = new double[5];
            tempOCEANArray = emotioncontagion.ContagionAgentArgs.getOCEAN();

            int[] tempArray = new int[AgentNetwork.countCommunication(number)];
            tempArray = AgentNetwork.getCommunication(number);

            for (int i = 0; i < 5; i++) {
                args[i] = tempOCEANArray[i];
            }

            for (int i = 0; i < AgentNetwork.countCommunication(number); i++) {

                args[i + 15] = tempArray[i];
            }
            args[9] = 'x';
            args[10] = false;

            AgentController a = RunJade.home.createNewAgent("Agent" + nr, "emo_mas.EmotionalAgent", args);
            a.start();
     
            nr = nr + 1;

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

      
 
    
    

}
