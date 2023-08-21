/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emo_mas;

/**
 *
 * @author Mara
 */  
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.core.behaviours.WakerBehaviour;
import jade.gui.GuiEvent;
import jade.lang.acl.ACLMessage;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmotionalAgent extends Agent {
    
    double[] OCEAN = {0,0,0,0,0};




      
    @Override
    protected void setup() //inicializaacija
      { 
      Object[] args = getArguments();
      
          System.out.println("Hi! My name is "+ getLocalName());
          
          OCEAN[4] = (double) args[4];
          OCEAN[2] = (double) args[2];
          System.out.print("My personality is: " + args[2] + " " + args[4]);
         

          System.out.println();
         System.out.println(" ");
         // addBehaviour(new ContagionSendFirst());
         addBehaviour(new ContagionGet(this, 1000));
          addBehaviour (new EmotionalBehaviours (this,1000));
        // contagionMessage();
         //this.IAngChanges = new ArrayList();
         //addBehaviour(new emo_mas.EmotionalBehaviours(this, 1000));
         
         
      }
    
    

   protected void takeDown()
{
  

    
   System.out.println(getLocalName() + " off!!!");
       
}
    

       

   
   
    
    
private class ContagionGet extends TickerBehaviour{

        public ContagionGet(Agent a, long period) {
        super(a, period);
    }


  
    @Override
    public void onTick() {
      //pie zinas sanemsanas iestata agenta kairinājumu kā parametru
          Object[] args = myAgent.getArguments();
          ACLMessage msg = myAgent.receive();
          
      
        if (msg != null) {

            if ("kill".equals(msg.getContent())) {
                myAgent.doDelete(); //drizak janonullee viss
                                
                ACLMessage reply = msg.createReply();
                    reply.setPerformative( ACLMessage.INFORM );
                    reply.setContent("Got it!");
                    send(reply);
                
                
                
            } else {

                String sender = msg.getSender().getLocalName();
                    if ("UserInterface".equals(sender))
                    {
                    args[10] = true;
                    }
               
                    

                    String message = msg.getContent();
                    String[] arrOfStr = message.split(" ");
                    char Type =  arrOfStr[0].charAt(0);
                    Double value = Double.parseDouble(arrOfStr[1]);
                    double N = (double) args[4];
                    double E = (double) args[2];
                    double est = 0;
                    double susc = 0;
                    double traitDep = 0;
                    
                    switch (Type)
                    {
                    case'a': 
                    traitDep = 0.95926 * N + 0.11563;
                    break;
                        
                    case'd': 
                    traitDep = 1.177632*N + 0.104483;
                    break;
                        
                    case'f': 
                    traitDep = 0.947368*N + 0.161053;
                    break;
                        
                    case'j': 
                    traitDep = 0.986*E + 0.07036;                    
                    break;
                        
                    case's': 
                    traitDep = 0.921053*N + 0.24515;
                    break;
                        
                    }
                    
                    traitDep = normalize(traitDep);
                    est = estimationAppraisal(value, traitDep);
                    susc = susceptibility(est, traitDep);
                    
                    if (susc < value) {//(value >= 0.03) { //if value larger than the succeptibility threshold!!!, as current plus overall
                        try {
                            int a = args.length - 15;
                            emotioncontagion.EmotionalContagionInterface.jTextArea2.append(myAgent.getLocalName() + " Local degree: " + a + "\n");
                            args[6] = value; 
                            args[9] = Type;
                            myAgent.setArguments(args);
                            
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(EmotionalAgent.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                   
                
            }
        } else {
            block();
        }
     }  }
        
       public  double susceptibility(double iSubj, double traitDep)
    {
       double treshold = -0.09382*traitDep +0.110849;
       return treshold;
    }
       public double estimationAppraisal(double Irritation, double traitDep) {
      
        double maxY = -0.7 * traitDep + 1.2;
        double s = -maxY / (Math.log(0.001) - Math.log(999));
        double x0 = Math.log(999) * s;
        double subjInt;
        return subjInt = traitDep / (1 + Math.exp((-(Irritation - x0)) / s));
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

     
    
}

   
    


