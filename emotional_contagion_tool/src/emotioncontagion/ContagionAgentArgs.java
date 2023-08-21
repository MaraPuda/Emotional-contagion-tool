
package emotioncontagion;

import java.util.Random;

/**
 *
 * @author Mara Pudane
 */
public class ContagionAgentArgs {
   
   public static Random rand = new Random();
    
    public static double [] getOCEAN ()
    { 
       double [] ocean = {0,0,0,0,0};
        double nGenerated = 0;
        double eGenerated = 0;
        //generate random low..high
        double nLow = Double.parseDouble(emotioncontagion.EmotionalContagionInterface.nLow.getText());
        double nHigh = Double.parseDouble(emotioncontagion.EmotionalContagionInterface.nHigh.getText());
        double eLow = Double.parseDouble(emotioncontagion.EmotionalContagionInterface.eLow.getText());
        double eHigh = Double.parseDouble(emotioncontagion.EmotionalContagionInterface.eHigh.getText());;
        
        rand.nextDouble();
        nGenerated = (nHigh-nLow)*rand.nextDouble()+nLow;
        eGenerated = (eHigh-eLow)*rand.nextDouble()+eLow;
        
       
        ocean[0] = 0;
        ocean[1] = 0;
         double eroundedValue = Math.round(eGenerated*10000);
        ocean[2] = eroundedValue/10000;
        ocean[3] = 0;
        double nroundedValue = Math.round(nGenerated*10000);
        ocean[4] = nroundedValue/10000;
      
    
        return ocean;
    }
    
}
