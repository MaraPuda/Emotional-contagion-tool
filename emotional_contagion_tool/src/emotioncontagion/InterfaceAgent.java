/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emotioncontagion;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.gui.GuiAgent;
import jade.gui.GuiEvent;
import jade.lang.acl.ACLMessage;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mara
 */
public class InterfaceAgent extends GuiAgent {
    
    transient protected emotioncontagion.EmotionalContagionInterface myGui;
    public static int agentNumber;
    public static boolean hasBehaviour;
    private int noofReplies;
    protected void setup() //inicializaacija
      {
         myGui = new emotioncontagion.EmotionalContagionInterface(this);
         myGui.setVisible(true);
         hasBehaviour = false;
         addBehaviour(new GetMessage(this));
         noofReplies = 0;
         
         
              }
    
    protected void takedown()
{
    
   System.out.println(getLocalName() + " off!!!");
       
}
         
    protected void onGuiEvent(GuiEvent ev) {
        switch (ev.getType())
        {
            case 0: 
            {
             
                break;
            }   
            case 1:
            { Integer startAgentNumber = (Integer) ev.getParameter(0);
               Double  startAngerLevel = (Double) ev.getParameter(1);
               Double  startDisgustLevel = (Double) ev.getParameter(2);
               Double  startFearLevel = (Double) ev.getParameter(3);
               Double  startJoyLevel = (Double) ev.getParameter(4);
               Double  startSadnessLevel = (Double) ev.getParameter(5);
               ACLMessage startMessage = new ACLMessage(ACLMessage.INFORM); 
               startMessage.addReceiver(new AID ("Agent"+startAgentNumber, AID.ISLOCALNAME));
               
               if (startAngerLevel!=0)                                   
               startMessage.setContent('a' + " " + Double.toString(startAngerLevel));
               if (startDisgustLevel!=0)                                   
               startMessage.setContent('d' + " " + Double.toString(startDisgustLevel));
               if (startFearLevel!=0)                                   
               startMessage.setContent('f' + " " + Double.toString(startFearLevel));
               if (startJoyLevel!=0)                                   
               startMessage.setContent('j' + " " + Double.toString(startJoyLevel));
               if (startSadnessLevel!=0)                                   
               startMessage.setContent('s' + " " + Double.toString(startSadnessLevel));
               
               send(startMessage);
            break;}
            //send message to the agent from text field
                
                
                
                
                
                
                
                
                
            case 2: //pievienot vizualizācijas uzvedību
               // EmotionalContagionInterface.visualize();
            EmotionalContagionInterface.drawAxis();
            
            {  
                if (hasBehaviour == false)
                        {
                addBehaviour(new Visualisation(this,1000));
                hasBehaviour = true;
                        }
            break;
            
            }
             case 3:
            {  
                ACLMessage killMessage = new ACLMessage(ACLMessage.INFORM); 
                killMessage.setContent("kill");
              //  tempArray = AgentNetwork.getCommunication(number);
              setAgentNumber();
              for (int skait = 0; skait<=agentNumber; skait++)
              { killMessage.addReceiver(new AID ("Agent"+skait, AID.ISLOCALNAME)); 
              System.out.println("Message sent to Agent" + skait);
              
              }
              EmotionalContagionInterface.NETWORK_READY = false;
              EmotionalContagionInterface.PERSONALITY_READY = false;
            
               send(killMessage);
             //  this.doDelete();
                
              
                
            break;}
            
        }
        
        
    }
    protected void setAgentNumber()
        {
            agentNumber = emotioncontagion.EmotionalContagionInterface.COMMUNICATION.length;
        }
         
private class Visualisation extends TickerBehaviour{

        public Visualisation(Agent a, long period) {
            super(a, period);
        }

  @Override
    public void onTick() {
           
            try {
                EmotionalContagionInterface.visualize();
               //EmotionalContagionInterface.drawAxis();
                
                
                
               if (EmotionalContagionInterface.visualisation == true)
                       {
                
               EmotionalContagionInterface.dynamicOutput2();
                       }
            } catch (InterruptedException ex) {
                Logger.getLogger(InterfaceAgent.class.getName()).log(Level.SEVERE, null, ex);
            }
             
      
        
    } 
               
        
    }     

private class GetMessage extends CyclicBehaviour{

        public GetMessage(Agent a) {
            super(a);
        }

  @Override
    public void action() {
      
       Object[] args = myAgent.getArguments();
          ACLMessage msg = myAgent.receive();
          
      
        if (msg != null) {

            if ("Got it!".equals(msg.getContent())) {
               noofReplies = noofReplies+1;
               
               if (noofReplies == agentNumber)
               {
                   
                   for (int i = 0; i<agentNumber;i++)
                   {
                   EmotionalContagionInterface.updateStates(i,0);
                   }
               EmotionalContagionInterface.restart();
               noofReplies = 0;
               }
               
                
                
            } else { 
                block();
            }
        
        
        
        
        
        }
      
      
      
      
      
           

  }

}
  
    


}
 
    
    



