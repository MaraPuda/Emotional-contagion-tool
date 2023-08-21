
package emo_mas;

/**
 *
 * @author Mara Pudane
 * Class contains methods that generate agent network
 */
public class AgentNetwork {

    public AgentNetwork(int number) {
    }

    public static int getNumber() {
        int nr = emotioncontagion.EmotionalContagionInterface.COMMUNICATION.length;
        return nr;
    }

    public static int countCommunication(int A) {

        int size = 0;

        for (int i = 0; i < emotioncontagion.EmotionalContagionInterface.COMMUNICATION.length; i++) {
            for (int j = 0; j < emotioncontagion.EmotionalContagionInterface.COMMUNICATION[i].length; j++) {
                if (i == A) {
                    if (emotioncontagion.EmotionalContagionInterface.COMMUNICATION[i][j] == 1) {
                        size = size + 1;
                    }
                }

            }
        }

        return size;
    }

//gets one agent's communication from adjacency matrix 
    public static int[] getCommunication(int A) {
        int[] agentsCommunications;
        int n = 0;


        agentsCommunications = new int[countCommunication(A)];

        for (int i = 0; i < emotioncontagion.EmotionalContagionInterface.COMMUNICATION.length; i++) {
            for (int j = 0; j < emotioncontagion.EmotionalContagionInterface.COMMUNICATION[i].length; j++) {
                if (i == A) {
                    if (emotioncontagion.EmotionalContagionInterface.COMMUNICATION[i][j] == 1) {
                        agentsCommunications[n] = j;
                        n = n + 1;
                    }
                }

            }

        }




        return agentsCommunications;
    }
}
