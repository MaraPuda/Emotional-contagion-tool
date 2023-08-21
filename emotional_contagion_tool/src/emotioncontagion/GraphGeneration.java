
package emotioncontagion;

import java.util.Random;

/**
 *
 * @author Mara Pudane
 */
public class GraphGeneration {

    public static Random rand = new Random();



  public static int[][] AdjMatrix; 
   
      public static int [][] initMatrix(int i){
                    
            AdjMatrix = new int [i][i];
            return AdjMatrix;
      }
      
       public static int [][] getMatrix(){
        
          
             return AdjMatrix;
      }
    
    
    
    public static int [][] generatePG(int V, double P){
        initMatrix (V);
        double z;
        
            for(int i = 0; i < V; i++) { 
                for(int j = 0; j < V; j++) {
             
                    z = rand.nextDouble();
                    System.out.println(z);
                    if ((z<P) && (j<i))
                    {
                        
                    AdjMatrix[i][j] = 1;
                    AdjMatrix[j][i] = 1; 
                    }
                    }
                }
 
        
        
        
        
        return AdjMatrix;      
    }
    
    
    
    
  public static int [][] generatePAG(int m, double P, int N, int e){

     
     
    int TotalNodes = N+m;
    initMatrix (TotalNodes);
    int[] Degree = new int[TotalNodes];
    double[] Prob = new double[TotalNodes]; 
    int sumMatr = 0;
    int sum = 0;
    
    int ekopija;
    //genere sakotnejo grafu
    for(int i = 0; i < m; i++) { 
                for(int j = 0; j < m; j++) {
                    if (i==j)
                        AdjMatrix[i][j] = 8;
                    else
                    if (rand.nextDouble()<P)
                    {AdjMatrix[i][j] = 1;
                     AdjMatrix[j][i] = 1;//VEELAAK VAJADZEES ATVEERT
                    }
                    }
                }
    
    
     for(int i = 0; i < TotalNodes; i++) { 
                for(int j = 0; j < TotalNodes; j++) {    
                   System.out.print(AdjMatrix[i][j]+ " ");
                    }
                System.out.println();
                }

   
   
      
  
         for(int v = TotalNodes-N; v < TotalNodes; v++) { 
             
          System.out.println();
      System.out.println();
     
      System.out.print(v+ ". ITERAACIJA _________________________________________________________________________________:");
       System.out.println();
     
                            for (int i = 0; i < TotalNodes; i++) 
                           {
                              for(int j = 0; j < TotalNodes; j++)
                                  {

                                          sumMatr += AdjMatrix[i][j];
                                   }
                          
                          
                            }           
               System.out.println();
               System.out.print(sumMatr+ "<- MATRICAS SUMMA");
                System.out.println();

        //apreekinaat virsotnu lokaalaas pakaaapes
                            for (int k = 0; k<v; k++)
                            {        
                                    for (int i = 0; i < TotalNodes; i++)    
                                     {
                                        for(int j = 0; j < TotalNodes; j++)
                                            {
                                                 if (i == k)
                                                    sum += AdjMatrix[i][j];
                                             }
                                      }
                                    if (sum>1)
                                        Degree[k] = sum;
                                    else
                                        Degree[k] = sum;
                                    System.out.print(Degree[k]+ "   ");
                                    sum = 0;
                            }
    
     System.out.println();
      System.out.println();
     
      System.out.print("VARBUTIBAS:");
       System.out.println();
       //nosakaam kaiminu summu
       
       int Neighbours = 0;
        //apreekinaat varbuutiibas
                           for (int k = 0; k<v; k++)
                            {        
                                   for (int i = 0; i < TotalNodes; i++) 
                                         {
                                         
                                                        if (AdjMatrix[k][i] == 1)
                                                        {
                                                            Neighbours = Neighbours+Degree[i];
                                                        }
    
                                                         
                                                   
                          
                                         }
                             Prob[k] = ((double)Degree[k])/sumMatr; 
                            System.out.print(Prob[k]+ "   ");
                            Neighbours = 0;
                          }
  System.out.println();
      System.out.println();
                           
   //veic pievienošanu pa vienai virsotnei
                
       
      
   
                            
                            //loku generesana, kur skaititajs = pievienojamo virsotnu skaits 1 operacija
                     //te jaapieliek, ka ja ir mazaak kaa e, tad genere no 0 liidz v
                     if (e>v)
                         ekopija = 1+(int)(rand.nextDouble()*v);
                     else
                          ekopija = 1+(int)(rand.nextDouble()*e);
                               
                          
                                 double g;
                                 long g2;
                                 double reekinaamaav;
                                
                                do  {     //loku generesanas cikls
                                    
                                    
                                    for(int i = 0; i<v; i++) {   
                                                        AdjMatrix[i][i] = 1;   
                                                           if (ekopija>0)
                                                           {
                                                               g = rand.nextDouble();
                                                              
                                                               
                                                               if(g < Prob[i] && AdjMatrix[i][v] !=1) {
                                                               AdjMatrix[i][v] = 1;
                                                                 AdjMatrix[v][i] = 1;
                                                           
                                                                   ekopija--;
                                                               
                                                            
                                                            System.out.print("Pievienotais loks:" + i + "    " + v + "     un varbuutiiba:" + g + "...un loku skaits...");
                                                                System.out.println();
                                                               }
                                                               }
                         
                                                           
                                                           }
                           
                                
                                } while (ekopija>0);
                                         
                                     for(int i = 0; i < TotalNodes; i++) { 
                for(int j = 0; j < TotalNodes; j++) {    
                   System.out.print(AdjMatrix[i][j]+ " ");
                    }
                System.out.println();
                }
                      //
                             //       }                
    }
    
       System.out.println();
    
    
    for(int i = 0; i < TotalNodes; i++) { 
                for(int j = 0; j < TotalNodes; j++) {    
                   System.out.print(AdjMatrix[i][j]+ " ");
                    }
                System.out.println();
                }
      
        



    System.out.println();

    
     for(int i = 0; i < TotalNodes; i++) { 
                for(int j = 0; j < TotalNodes; j++) {    
                   if (i==j) AdjMatrix[i][j] = 0;
                    }
                //System.out.println();
                }
    
    
    
    
       for(int i = 0; i < TotalNodes; i++) { 
                for(int j = 0; j < TotalNodes; j++) {    
                   System.out.print(AdjMatrix[i][j]+ " ");
                    }
                System.out.println();
                }
    
    return AdjMatrix;
    }
    
    
    
}
