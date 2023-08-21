 /*
Implements the affective behaviour
 */
package emo_mas;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.core.behaviours.WakerBehaviour;
import jade.lang.acl.ACLMessage;

/**
 *
 * @author Mara Pudane
 */
public class EmotionalBehaviours extends TickerBehaviour {
    
    int i;
    
    
    public EmotionalBehaviours(Agent a, long period) {
        super(a, period);
    }

   
    
    @Override
    protected void onTick()
{
    
            Object[] args = myAgent.getArguments();
           // System.out.println("My name is " + myAgent.getLocalName() + ", parameters: " + (double) args[5] + (double) args[6]+ (char) args[9]);
            args[5]=dynamicsCalculator((double) args[6], (double) args[5], (char) args[9]); //isubj = (isubj,iobj)
            
            i++;
           
} 
    
    
     public double dynamicsCalculator(double iObj, double iSubj, char emotiontype) {

        Object[] args = myAgent.getArguments();
        double N = (double) args[4];
        double E = (double) args[2];
        double iExpr = 0;
        double maxY;
        double s;
        double x0;
        double DecN = 1.89444 * N - 0.06292;
        double DecSec = 35 * DecN;
        double lambda = -Math.log(0.01) / DecSec;
        String name = myAgent.getLocalName();
        String no[] = name.split("Agent");
        int number = Integer.valueOf(no[1]);

        switch (emotiontype) {

            case 'a':
                 double angON = 1.11485 * N + 0.07318;
                 double angTN = 0.95926 * N + 0.11563;
                 angTN = normalize(angTN);
                 angON = normalize(angON);
                 maxY = -0.7 * angTN + 1.2;
                 s = -maxY / (Math.log(0.001) - Math.log(999));
                 x0 = Math.log(999) * s;

                 if (iObj != 0) {

                     double iObj2 = -(s * Math.log((angTN / iSubj) - 1) - x0);

                     iObj = iObj + iObj2;
                     if (iObj >= 1) {
                         iObj = 1;
                     }

                     iSubj = appraisal(iObj, angTN, s, x0);

                     args[7] = Math.log(iSubj) / -lambda;
                     args[6] = (Double) 0.0;

                 }
                   //calculates decay
                 if (iSubj > 0.0001) {
                     System.out.println(myAgent.getLocalName()+ " " +number+ " " + iSubj);
                     emotioncontagion.EmotionalContagionInterface.updateStates(number, iSubj);

                     iSubj = decay((Double) args[7], lambda);
                     args[7] = (Double) args[7] + 1;
                 }
                 iExpr = expression(iSubj, angON, s, x0);
                break;
                
            case 'd':
                 double disEX = 1.251748*E - 0.1279;
                 double disAPR = 1.177632*N + 0.104483;
                 disEX = normalize(disEX);
                 disAPR = normalize(disAPR);
                 maxY = -0.7 * disAPR + 1.2;
                 s = -maxY / (Math.log(0.001) - Math.log(999));
                 x0 = Math.log(999) * s;

                 if (iObj != 0) {

                     double iObj2 = -(s * Math.log((disAPR / iSubj) - 1) - x0);

                     iObj = iObj + iObj2;
                     if (iObj >= 1) {
                         iObj = 1;
                     }

                     iSubj = appraisal(iObj, disAPR, s, x0);

                     args[7] = Math.log(iSubj) / -lambda;
                     args[6] = (Double) 0.0;

                 }
                   //calculates decay
                 if (iSubj > 0.0001) {
                     emotioncontagion.EmotionalContagionInterface.updateStates(number, iSubj);

                     iSubj = decay((Double) args[7], lambda);
                     args[7] = (Double) args[7] + 1;
                 }
                 iExpr = expression(iSubj, disEX, s, x0);
       
                break; 
                
            case 'f':
                 double feaAPR = 0.947368*N + 0.161053;
                 double feaEX = 1.006993*E - 0.02589;
                 feaAPR = normalize(feaAPR);
                 feaEX = normalize(feaEX);
                 maxY = -0.7 * feaAPR + 1.2;
                 s = -maxY / (Math.log(0.001) - Math.log(999));
                 x0 = Math.log(999) * s;

                 if (iObj != 0) {

                     double iObj2 = -(s * Math.log((feaAPR / iSubj) - 1) - x0);

                     iObj = iObj + iObj2;
                     if (iObj >= 1) {
                         iObj = 1;
                     }

                     iSubj = appraisal(iObj, feaAPR, s, x0);

                     args[7] = Math.log(iSubj) / -lambda;
                     args[6] = (Double) 0.0;

                 }
                   //calculates decay
                 if (iSubj > 0.0001) {
                     emotioncontagion.EmotionalContagionInterface.updateStates(number, iSubj);

                     iSubj = decay((Double) args[7], lambda);
                     args[7] = (Double) args[7] + 1;
                 }
                 iExpr = expression(iSubj, feaEX, s, x0);
        
                break;
            case 'j':
                 double joyAPREX = 0.986*E + 0.07036;
                 joyAPREX = normalize(joyAPREX);
                 maxY = -0.7 * joyAPREX + 1.2;
                 s = -maxY / (Math.log(0.001) - Math.log(999));
                 x0 = Math.log(999) * s;

                 if (iObj != 0) {

                     double iObj2 = -(s * Math.log((joyAPREX / iSubj) - 1) - x0);

                     iObj = iObj + iObj2;
                     if (iObj >= 1) {
                         iObj = 1;
                     }

                     iSubj = appraisal(iObj, joyAPREX, s, x0);

                     args[7] = Math.log(iSubj) / -lambda;
                     args[6] = (Double) 0.0;

                 }
                   //calculates decay
                 if (iSubj > 0.0001) {
                     emotioncontagion.EmotionalContagionInterface.updateStates(number, iSubj);

                     iSubj = decay((Double) args[7], lambda);
                     args[7] = (Double) args[7] + 1;
                 }
                 iExpr = expression(iSubj, joyAPREX, s, x0);
        break;

            case 's':
                 double sadEX = 1.006993*E - 0.02589;
                 double sadAPR = 0.921053*N + 0.24515;
                 sadAPR = normalize(sadAPR);
                 sadEX = normalize(sadEX);
                 maxY = -0.7 * sadAPR + 1.2;
                 s = -maxY / (Math.log(0.001) - Math.log(999));
                 x0 = Math.log(999) * s;

                 if (iObj != 0) {

                     double iObj2 = -(s * Math.log((sadAPR / iSubj) - 1) - x0);

                     iObj = iObj + iObj2;
                     if (iObj >= 1) {
                         iObj = 1;
                     }

                     iSubj = appraisal(iObj, sadAPR, s, x0);

                     args[7] = Math.log(iSubj) / -lambda;
                     args[6] = (Double) 0.0;

                 }
                   //calculates decay
                 if (iSubj > 0.0001) {
                     emotioncontagion.EmotionalContagionInterface.updateStates(number, iSubj);

                     iSubj = decay((Double) args[7], lambda);
                     args[7] = (Double) args[7] + 1;
                 }
                 iExpr = expression(iSubj, sadEX, s, x0);
                break;
         }
        
        
        if (iSubj > 0.01 && iObj != 0) //EXPRESSION THRESHOLD
        {
            long b = 0;

            //tik, cik aģentam ir argumentu no.. līdz uzgeneret laika intervalu un pievienot uzvedibu
            for (int i = 15; i < args.length; i++) {
                b = emotioncontagion.ContagionParameters.generateInterval() * 1000;
                myAgent.addBehaviour(new ContagionSend(myAgent, b, "Agent" + args[i]));
            }
        }

        args[5] = iSubj;
        args[8] = iExpr;
        myAgent.setArguments(args);
        boolean visualize = (boolean) args[10];
        if (visualize == true) {
            emotioncontagion.EmotionalContagionInterface.dynamicOutput(iSubj, iExpr, emotiontype);
        }


        return iSubj;

    }

    public double appraisal(double iObj, double traitDependence, double s, double x0) {

        double subjInt = traitDependence / (1 + Math.exp((-(iObj - x0)) / s));

        return subjInt;
    }

    public double expression(double iSubj, double traitDependence, double s, double x0) {


        double expPower = traitDependence / (1 + Math.exp(-(iSubj - (x0)) / s));
        return expPower;
    }

    public double decay(double t, double lambda) {
        double subjInt = Math.exp(-lambda * t);
        return subjInt;
    }
    
    public double normalize(double value) {
        if (value > 1) {
            value = 1;
        }
        if (value < 0) {
            value = 0;
        }
        return value;
    }

   
  
     
   private class ContagionSend extends WakerBehaviour{
      private String agentName;
        public ContagionSend(Agent a, long timeout, String agent) {
            super(a, timeout);
            agentName = agent;
        }
       @Override
        public void onWake() {
            
                                Object[] args = myAgent.getArguments();
                ACLMessage primCont= new ACLMessage(ACLMessage.INFORM); 
                                primCont.addReceiver(new AID (this.agentName, AID.ISLOCALNAME));
                                    
                                //emocijas tips
                                double iExpr = (Double) args[8]; 
                                char emotiontype = (char) args[9];
                                primCont.setContent(emotiontype + " " + Double.toString(iExpr));
                                
                                myAgent.send(primCont);
        }
                                          
    
       
      
   }     
 
}
