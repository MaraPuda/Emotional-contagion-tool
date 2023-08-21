
package emotioncontagion;

import emo_mas.EmotionalAgent;
import jade.gui.GuiEvent;
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import org.graphstream.graph.Element;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.view.Viewer;


/**
 *
 * @author Mara Pudane
 */
public class EmotionalContagionInterface extends javax.swing.JFrame {

    public static char CURRENT_EMOTION = 'n';
    public final javax.swing.JFileChooser JFileChooser1 = new JFileChooser();
    public static int[][] COMMUNICATION; 
    public static boolean NETWORK_READY = false;
    public static boolean PERSONALITY_READY = false;
    public static boolean START_CONTAGION = false;
    public static boolean FIRST_IRRITATION = true;
    public static boolean visualisation = false;
    public static double[] STATES;
    public static int oldY = 0;
    public static double y = 0;
    public static int oldyvisiem = 0;
    public static double step = 0;
    public static double step2 = 0;
    public static int oldExpr = 0;
    public static double Expr = 0;
    static Graph graph = new SingleGraph("Try");
    static Viewer viewer;
    private static emotioncontagion.InterfaceAgent myAgent;
    public static ArrayList IntensityAverageChanges = new ArrayList();
    public static ArrayList IntensityChangesSingleAgent = new ArrayList();
    public static ArrayList ExpressionChangesSingleAgent = new ArrayList();
    public static double SimulationN = 0;
    public static double SimulationE = 0;
    public static int SimulationLambda = 0;
    

    /**
     * Creates new form EmotionalContagionInterface
     */
    public EmotionalContagionInterface(emotioncontagion.InterfaceAgent a) {
        myAgent = a;
         initComponents();
       
        OrientedButton.setEnabled(false);
        GenerateMASButton.setEnabled(false);

        jTabbedPane1.setEnabledAt(1, false);
       
        



    }

    public static void drawAxis() {
        Graphics2D Appraisal = (Graphics2D) jPanel3.getGraphics();
        Appraisal.drawLine(10, 10, 10, 260);
        Appraisal.drawLine(10, 260, 530, 260);
        Appraisal.drawLine(10, 10, 5, 20);
        Appraisal.drawLine(10, 10, 15, 20);
        Appraisal.drawLine(530, 260, 520, 255);
        Appraisal.drawLine(530, 260, 520, 265);
        Graphics2D visiem = (Graphics2D) jPanel8.getGraphics();
        visiem.drawLine(10, 10, 10, 260);
        visiem.drawLine(10, 260, 530, 260);
        visiem.drawLine(10, 10, 5, 20);
        visiem.drawLine(10, 10, 15, 20);
        visiem.drawLine(530, 260, 520, 255);
        visiem.drawLine(530, 260, 520, 265);
    }

    public static void dynamicOutput(double internalI, double iExpr, char emotion) {

        int xkoord;
        int ykoord;
        int yExprkoord;
        int oldXCoord;

        step = step + 0.01;

        double doublexkoord = step * 260;
        double doubleoldxkoord = (step - 0.01) * 260;
        double doubleykoord = internalI * 260;
        double doubleExprkoord = iExpr * 260;

        xkoord = (int) doublexkoord; //(int)doublexkoord;
        ykoord = (int) doubleykoord;
        yExprkoord = (int) doubleExprkoord;
        oldXCoord = (int) doubleoldxkoord;
        //System.out.print(doublexkoord + " un " + doubleykoord);
        Graphics2D Dynamics = (Graphics2D) jPanel3.getGraphics();
        Graphics2D Expression = (Graphics2D) jPanel3.getGraphics();
        
        IntensityChangesSingleAgent.add(internalI);
        ExpressionChangesSingleAgent.add(iExpr);
        Dynamics.setColor(Color.gray);
        
        
        switch (CURRENT_EMOTION)
        {
            case 'a':
                Dynamics.setColor(Color.red);
            break;
            case 'd':
                Dynamics.setColor(Color.magenta);
            break;
            case 'f':
                Dynamics.setColor(Color.green);
            break;
            case 'j':
                Dynamics.setColor(Color.yellow);
            break;
            case 's':
                Dynamics.setColor(Color.blue);
            break;
        
        }
        Dynamics.drawLine(10 + oldXCoord, 260 - oldY, 10 + xkoord, 260 - ykoord);
        

        Expression.setColor(Color.gray);
        Expression.drawLine(10 + oldXCoord, 260 - oldExpr, 10 + xkoord, 260 - yExprkoord);

        oldY = ykoord;
        oldExpr = yExprkoord;
        //dinamiskaisoutputs


    }

    public static void dynamicOutput2() {

        int xkoord;
        int ykoord;
        double State;
        int oldXCoord;
        double sum = 0;

     
        for (int i = 0; i < STATES.length; i++) {
            sum = sum + STATES[i];

        }

        State = sum / STATES.length;

        step2 = step2 + 0.01;

        double doublexkoord = step2 * 260;
        double doubleoldxkoord = (step2 - 0.01) * 260;

        double doubleykoord = State * 260;




        xkoord = (int) doublexkoord;
        ykoord = (int) doubleykoord;
        oldXCoord = (int) doubleoldxkoord;
        IntensityAverageChanges.add(State);
        // System.out.print("KOPEJA INTENSITATE:      "+ State);



        Graphics2D Dynamics = (Graphics2D) jPanel8.getGraphics();

        Dynamics.setColor(Color.gray);
        Dynamics.drawLine(oldXCoord + 10, 260 - oldyvisiem, xkoord + 10, 260 - ykoord);




        oldyvisiem = ykoord;

        //dinamiskaisoutputs


    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel7 = new javax.swing.JPanel();
        eLow = new javax.swing.JTextField();
        eHigh = new javax.swing.JTextField();
        nLow = new javax.swing.JTextField();
        nHigh = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        GenerateMASButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        OrientedButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        ContagionParameterPanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        initAnger = new javax.swing.JTextField();
        initSadness = new javax.swing.JTextField();
        initJoy = new javax.swing.JTextField();
        initDisgust = new javax.swing.JTextField();
        initFear = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        start = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        startButton = new javax.swing.JButton();
        FrequencyField = new javax.swing.JTextField();
        newSimulationButton = new javax.swing.JButton();
        currentEmoWarning = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Emotional Contagion Tool");

        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jButton1.setText("Generate Graph");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Load Graph");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Agent Parameters"));

        eLow.setText("0.63");
        eLow.setToolTipText("");
        eLow.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        eLow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eLowActionPerformed(evt);
            }
        });

        eHigh.setText("0.63");
        eHigh.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        eHigh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eHighActionPerformed(evt);
            }
        });

        nLow.setText("0.48");
        nLow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nLowActionPerformed(evt);
            }
        });

        nHigh.setText("0.48");
        nHigh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nHighActionPerformed(evt);
            }
        });

        jLabel16.setText("Neuroticism");

        jLabel18.setText("Extraversion");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(eLow)
                    .addComponent(nLow, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(eHigh)
                    .addComponent(nHigh, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE))
                .addGap(25, 25, 25))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(eLow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eHigh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(nLow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nHigh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jButton5.setText("Generate Agent Parameters");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        GenerateMASButton.setText("Generate MAS");
        GenerateMASButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerateMASButtonActionPerformed(evt);
            }
        });

        jLabel6.setText("To generate agent personalities in the defined range...");

        jLabel17.setText("To load graph which determines how agents are connected...");

        jLabel2.setText("By the default graph is not oriented.");

        OrientedButton.setText("Make it oriented!");
        OrientedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrientedButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(GenerateMASButton, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel17)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(OrientedButton)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(OrientedButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(GenerateMASButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Generate Network", jPanel1);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Statistics and Contagion Results"), "Statistics and Contagion results"));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("First Agent"));
        jPanel3.setPreferredSize(new java.awt.Dimension(535, 268));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 542, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 261, Short.MAX_VALUE)
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Average Intensity"));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 266, Short.MAX_VALUE)
        );

        jTextArea2.setColumns(20);
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(5);
        jTextArea2.setWrapStyleWord(true);
        jScrollPane2.setViewportView(jTextArea2);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 9, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(jScrollPane2)))
        );

        ContagionParameterPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Contagion Parameters"));

        jLabel7.setText("Anger");

        jLabel9.setText("Sadness");

        jLabel10.setText("Joy");

        jLabel11.setText("Disgust");

        jLabel12.setText("Fear");

        initAnger.setText("0");
        initAnger.setDisabledTextColor(new java.awt.Color(255, 51, 51));
        initAnger.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                initAngerActionPerformed(evt);
            }
        });

        initSadness.setText("0");
        initSadness.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        initSadness.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                initSadnessActionPerformed(evt);
            }
        });

        initJoy.setText("0");
        initJoy.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        initJoy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                initJoyActionPerformed(evt);
            }
        });

        initDisgust.setText("0");
        initDisgust.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        initDisgust.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                initDisgustActionPerformed(evt);
            }
        });

        initFear.setText("0");
        initFear.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        initFear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                initFearActionPerformed(evt);
            }
        });

        jLabel15.setText("Starting agent number");

        start.setText("0");
        start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startActionPerformed(evt);
            }
        });

        jLabel1.setText("Add irritation strength and press enter!");

        javax.swing.GroupLayout ContagionParameterPanelLayout = new javax.swing.GroupLayout(ContagionParameterPanel);
        ContagionParameterPanel.setLayout(ContagionParameterPanelLayout);
        ContagionParameterPanelLayout.setHorizontalGroup(
            ContagionParameterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContagionParameterPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ContagionParameterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(ContagionParameterPanelLayout.createSequentialGroup()
                        .addGroup(ContagionParameterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel12)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10))
                        .addGroup(ContagionParameterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(ContagionParameterPanelLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(initAnger, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ContagionParameterPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(ContagionParameterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(initSadness, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(initJoy, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(initDisgust, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(initFear, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(ContagionParameterPanelLayout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 36, Short.MAX_VALUE))
        );
        ContagionParameterPanelLayout.setVerticalGroup(
            ContagionParameterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContagionParameterPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(ContagionParameterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(ContagionParameterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(initAnger, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ContagionParameterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(initSadness, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ContagionParameterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(initJoy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ContagionParameterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(initDisgust, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ContagionParameterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(initFear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(19, 19, 19))
        );

        startButton.setText("Start Contagion/ Add irritation");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        FrequencyField.setText("5");
        FrequencyField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FrequencyFieldActionPerformed(evt);
            }
        });

        newSimulationButton.setText("Start new simulation!");
        newSimulationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newSimulationButtonActionPerformed(evt);
            }
        });

        currentEmoWarning.setText(" ");

        jLabel3.setText("Enter interaction frequency [1..10] seconds!");

        saveButton.setText("Save simulation results!");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ContagionParameterPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(currentEmoWarning, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(FrequencyField, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(startButton))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(saveButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(newSimulationButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(ContagionParameterPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FrequencyField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(currentEmoWarning)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(startButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(saveButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(newSimulationButton)
                        .addGap(21, 21, 21))))
        );

        jPanel4.getAccessibleContext().setAccessibleName("Statistics and Contagion Results");

        jTabbedPane1.addTab("Emotional Contagion Simulation", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1096, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newSimulationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newSimulationButtonActionPerformed
        // TODO add your handling code here:
        
        GuiEvent ge = new GuiEvent(this, 3);

        myAgent.postGuiEvent(ge);
      saveButton.setEnabled(false);

    }//GEN-LAST:event_newSimulationButtonActionPerformed

    private void FrequencyFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FrequencyFieldActionPerformed
        int n = Integer.parseInt(emotioncontagion.EmotionalContagionInterface.FrequencyField.getText());
        emotioncontagion.ContagionParameters.generatePoissonDistribution(n);
        startButton.setEnabled(true);
         FrequencyField.setEditable(false);
    }//GEN-LAST:event_FrequencyFieldActionPerformed

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        // TODO add your handling code here:
        
        //OCEAN = ContagionAgentArgs.getOCEAN();
        START_CONTAGION = true;
        GuiEvent ge = new GuiEvent(this, 1);
        ge.addParameter(Integer.parseInt(emotioncontagion.EmotionalContagionInterface.start.getText()));
        ge.addParameter(Double.parseDouble(emotioncontagion.EmotionalContagionInterface.initAnger.getText()));
        ge.addParameter(Double.parseDouble(emotioncontagion.EmotionalContagionInterface.initDisgust.getText()));
        ge.addParameter(Double.parseDouble(emotioncontagion.EmotionalContagionInterface.initFear.getText()));
        ge.addParameter(Double.parseDouble(emotioncontagion.EmotionalContagionInterface.initJoy.getText()));
        ge.addParameter(Double.parseDouble(emotioncontagion.EmotionalContagionInterface.initSadness.getText()));
        myAgent.postGuiEvent(ge);
        if (FIRST_IRRITATION ==true)
                {
        startVisualisation();
        FIRST_IRRITATION = false;
                }

        newSimulationButton.setEnabled(true);
        saveButton.setEnabled(true);



    }//GEN-LAST:event_startButtonActionPerformed

    private void startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startActionPerformed
        initSadness.setEditable(true);
        initAnger.setEditable(true);
        initJoy.setEditable(true);
        initDisgust.setEditable(true);
        initFear.setEditable(true);
        start.setEditable(false);


    }//GEN-LAST:event_startActionPerformed

    private void initFearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_initFearActionPerformed
        emotioncontagion.EmotionalContagionInterface.initAnger.setText("0");
        emotioncontagion.EmotionalContagionInterface.initSadness.setText("0");
        emotioncontagion.EmotionalContagionInterface.initJoy.setText("0");
        emotioncontagion.EmotionalContagionInterface.initDisgust.setText("0");
        emotioncontagion.EmotionalContagionInterface.initSadness.setEditable(false);
        emotioncontagion.EmotionalContagionInterface.initAnger.setEditable(false);
        emotioncontagion.EmotionalContagionInterface.initJoy.setEditable(false);
        emotioncontagion.EmotionalContagionInterface.initDisgust.setEditable(false);
        emotioncontagion.EmotionalContagionInterface.currentEmoWarning.setText("You are currently analysing FEAR.");
        CURRENT_EMOTION = 'f';

        FrequencyField.setEditable(true);
        start.setEditable(false);

    }//GEN-LAST:event_initFearActionPerformed

    private void initDisgustActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_initDisgustActionPerformed
        emotioncontagion.EmotionalContagionInterface.initAnger.setText("0");
        emotioncontagion.EmotionalContagionInterface.initFear.setText("0");
        emotioncontagion.EmotionalContagionInterface.initJoy.setText("0");
        emotioncontagion.EmotionalContagionInterface.initSadness.setText("0");
        emotioncontagion.EmotionalContagionInterface.initSadness.setEditable(false);
        emotioncontagion.EmotionalContagionInterface.initFear.setEditable(false);
        emotioncontagion.EmotionalContagionInterface.initJoy.setEditable(false);
        emotioncontagion.EmotionalContagionInterface.initAnger.setEditable(false);
        emotioncontagion.EmotionalContagionInterface.currentEmoWarning.setText("You are currently analysing DISGUST.");
        CURRENT_EMOTION = 'd';

        FrequencyField.setEditable(true);
        start.setEditable(false);
    }//GEN-LAST:event_initDisgustActionPerformed

    private void initJoyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_initJoyActionPerformed
        emotioncontagion.EmotionalContagionInterface.initAnger.setText("0");
        emotioncontagion.EmotionalContagionInterface.initFear.setText("0");
        emotioncontagion.EmotionalContagionInterface.initSadness.setText("0");
        emotioncontagion.EmotionalContagionInterface.initDisgust.setText("0");
        emotioncontagion.EmotionalContagionInterface.initSadness.setEditable(false);
        emotioncontagion.EmotionalContagionInterface.initFear.setEditable(false);
        emotioncontagion.EmotionalContagionInterface.initAnger.setEditable(false);
        emotioncontagion.EmotionalContagionInterface.initDisgust.setEditable(false);
        emotioncontagion.EmotionalContagionInterface.currentEmoWarning.setText("You are currently analysing JOY.");
        CURRENT_EMOTION = 'j';

        FrequencyField.setEditable(true);
        start.setEditable(false);
    }//GEN-LAST:event_initJoyActionPerformed

    private void initSadnessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_initSadnessActionPerformed
        // TODO add your handling code here:
        emotioncontagion.EmotionalContagionInterface.initAnger.setText("0");
        emotioncontagion.EmotionalContagionInterface.initFear.setText("0");
        emotioncontagion.EmotionalContagionInterface.initJoy.setText("0");
        emotioncontagion.EmotionalContagionInterface.initDisgust.setText("0");
        emotioncontagion.EmotionalContagionInterface.initAnger.setEditable(false);
        emotioncontagion.EmotionalContagionInterface.initFear.setEditable(false);
        emotioncontagion.EmotionalContagionInterface.initJoy.setEditable(false);
        emotioncontagion.EmotionalContagionInterface.initDisgust.setEditable(false);
        emotioncontagion.EmotionalContagionInterface.currentEmoWarning.setText("You are currently analysing SADNESS.");
        CURRENT_EMOTION = 's';

        FrequencyField.setEditable(true);
        start.setEditable(false);

    }//GEN-LAST:event_initSadnessActionPerformed

    private void initAngerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_initAngerActionPerformed


        //doma: panākt, ka viņš nodod lietotāja aģentam 2 lietas: aģentu, kuru paredzēts kaitināt un kairinājuma vērtību
        emotioncontagion.EmotionalContagionInterface.initSadness.setText("0");
        emotioncontagion.EmotionalContagionInterface.initFear.setText("0");
        emotioncontagion.EmotionalContagionInterface.initJoy.setText("0");
        emotioncontagion.EmotionalContagionInterface.initDisgust.setText("0");
        emotioncontagion.EmotionalContagionInterface.initSadness.setEditable(false);
        emotioncontagion.EmotionalContagionInterface.initFear.setEditable(false);
        emotioncontagion.EmotionalContagionInterface.initJoy.setEditable(false);
        emotioncontagion.EmotionalContagionInterface.initDisgust.setEditable(false);
        emotioncontagion.EmotionalContagionInterface.currentEmoWarning.setText("You are currently analysing ANGER.");
        CURRENT_EMOTION = 'a';

        FrequencyField.setEditable(true);
        start.setEditable(false);





//GEN-LAST:event_initAngerActionPerformed
    }
        private void GenerateMASButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerateMASButtonActionPerformed
            // TODO add your handling code here:
            NETWORK_READY = true;
            PERSONALITY_READY = true;

            emo_mas.EMO_MAS.runAgents();
            jTabbedPane1.setEnabledAt(1, true);
            
            eLow.setEditable(false);
            eHigh.setEditable(false);
            nLow.setEditable(false);
            nHigh.setEditable(false);
            jButton1.setEnabled(false);
            jButton2.setEnabled(false);
            jButton5.setEnabled(false);
            OrientedButton.setEnabled(false);
            GenerateMASButton.setEnabled(false);
            
            
            
            jTabbedPane1.setEnabledAt(0, false);
            initSadness.setEditable(false);
            initAnger.setEditable(false);
            initJoy.setEditable(false);
            initDisgust.setEditable(false);
            initFear.setEditable(false);
            start.setEditable(true);
            FrequencyField.setEditable(false);
            startButton.setEnabled(false);
            newSimulationButton.setEnabled(false);
            saveButton.setEnabled(false);
            
            
    }//GEN-LAST:event_GenerateMASButtonActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        emotioncontagion.ContagionAgentArgs.getOCEAN();
        SimulationN = Double.parseDouble(nLow.getText());
        SimulationE = Double.parseDouble(eLow.getText());

    }//GEN-LAST:event_jButton5ActionPerformed

    private void nHighActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nHighActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nHighActionPerformed

    private void nLowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nLowActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nLowActionPerformed

    private void eHighActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eHighActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eHighActionPerformed

    private void eLowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eLowActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eLowActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int returnVal = JFileChooser1.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = JFileChooser1.getSelectedFile();
            int size = 0;
            try {
                // What to do with the file, e.g. display it in a TextArea
                emotioncontagion.EmotionalContagionInterface.jTextArea1.read(new FileReader(file.getAbsolutePath()), null);
                //ielasa masīvā
                Scanner count = new Scanner(file).useDelimiter(" *");
                while (count.hasNextInt() && count.hasNext()) {
                    count.nextInt();
                    size = size + 1;
                }

                COMMUNICATION = new int[size][size];
                STATES = new double[size];
                count.close();


                Scanner toArray = new Scanner(file);

                //System.out.println("Aaraa no cikla!");
                System.out.println("Size: " + size);
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {

                        COMMUNICATION[i][j] = toArray.nextInt();
                        System.out.print(COMMUNICATION[i][j]);


                    }
                    STATES[i] = 0;
                    System.out.println();
                }

                toArray.close();
                //NETWORK_READY = true;

            } catch (IOException ex) {
                System.out.println("problem accessing file" + file.getAbsolutePath());
            }
        } else {
            System.out.println("File access cancelled by user.");
        }
        //dispose();
        OrientedButton.setEnabled(true);
        GenerateMASButton.setEnabled(true);


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new emotioncontagion.GraphOutput().setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void OrientedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrientedButtonActionPerformed
        COMMUNICATION = emotioncontagion.ContagionParameters.turnGraph(COMMUNICATION);
        System.out.println();
        jTextArea1.setText("");
        for (int i = 0; i < COMMUNICATION.length; i++) {
            for (int j = 0; j < COMMUNICATION.length; j++) {
                jTextArea1.append(COMMUNICATION[i][j] + " ");


            }
            jTextArea1.append("\n");
        }
    }//GEN-LAST:event_OrientedButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        SimulationToFile();
    }//GEN-LAST:event_saveButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EmotionalContagionInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmotionalContagionInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmotionalContagionInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmotionalContagionInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                // new EmotionalContagionInterface().setVisible(true);
            }
        });

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ContagionParameterPanel;
    private static javax.swing.JTextField FrequencyField;
    private javax.swing.JButton GenerateMASButton;
    private javax.swing.JButton OrientedButton;
    public static javax.swing.JLabel currentEmoWarning;
    public static javax.swing.JTextField eHigh;
    public static javax.swing.JTextField eLow;
    private javax.swing.Box.Filler filler1;
    private static javax.swing.JTextField initAnger;
    private static javax.swing.JTextField initDisgust;
    private static javax.swing.JTextField initFear;
    private static javax.swing.JTextField initJoy;
    private static javax.swing.JTextField initSadness;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private static javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private static javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    public static javax.swing.JTextArea jTextArea1;
    public static javax.swing.JTextArea jTextArea2;
    public static javax.swing.JTextField nHigh;
    public static javax.swing.JTextField nLow;
    private static javax.swing.JButton newSimulationButton;
    private javax.swing.JButton saveButton;
    private static javax.swing.JTextField start;
    private static javax.swing.JButton startButton;
    // End of variables declaration//GEN-END:variables

    public static void visualize() throws InterruptedException {
       

        if (visualisation == false) //konstruee grafu
        {
            for (int i = 0; i < emotioncontagion.EmotionalContagionInterface.COMMUNICATION.length; i++) {
                graph.addNode(String.valueOf(i));

            }

            int k = 10000;
            for (int i = 0; i < emotioncontagion.EmotionalContagionInterface.COMMUNICATION.length; i++) {
                for (int j = 0; j < emotioncontagion.EmotionalContagionInterface.COMMUNICATION.length; j++) {

                    if (j >= i) {
                        k = k + 1;
                        if (emotioncontagion.EmotionalContagionInterface.COMMUNICATION[i][j] == 1) {
                            if(emotioncontagion.EmotionalContagionInterface.COMMUNICATION[j][i] == 0)
                            graph.addEdge(String.valueOf(k), String.valueOf(i), String.valueOf(j), true);//jaaizdomaa labaaka metode, citaadi vizualizacija>1000 elementiem nestraadaas
                            else
                            graph.addEdge(String.valueOf(k), String.valueOf(i), String.valueOf(j));
                        }
                    }

                }

         

            }
 
            viewer = graph.display();
            visualisation = true;

        } else {
            int tone2;
            String end = ("fill-color: rgb(255,255,255);");
            for (int i = 0; i < STATES.length; i++) {

                String a = Integer.toString(i);
                Element e = graph.getNode(a);
                    e.addAttribute("ui.style","text-size: 25;");
                    if (STATES[i] >= 0.001) {
                        double tone = 204 - (204 * STATES[i]);
                        tone2 = (int) tone;
                                        switch (CURRENT_EMOTION)
                        {
                            case 'a':
                                end = ("fill-color: rgb(255," + tone2 + "," + tone2 + ");");
                            break;
                            case 'd':
                                end = ("fill-color: rgb(255," + tone2 + ",255);");
                            break;
                            case 'f':
                                end = ("fill-color: rgb("+ tone2+ ",255," + tone2 +");");
                            break;
                            case 'j':
                                end = ("fill-color: rgb(255,255," + tone2 +");");
                            break;
                            case 's':
                                end = ("fill-color: rgb(" + tone2+ "," + tone2 + ",255);");
                            break;

                        }
  
                    } else {
                        end = ("fill-color: rgb(0,0,0);");
                    }
                    
                    e.addAttribute("ui.style", end);
                    e.addAttribute("ui.label", e.getId());
                    graph.addAttribute("ui.stylesheet", "edge{arrow-shape: arrow; fill-color: rgb(105,105,105);}");
                   // e.addAttribute("ui.stylesheet", "");

            }

        }



    }

    //funkcija, kuru katrs agents izsauc un apdeito masīvu,katrs elementu no sava vārda,
    public static void updateStates(int agent, double intensity) {
        STATES[agent] = intensity;

    }

    public static void SimulationToFile() {
        try {
            PrintWriter writer = new PrintWriter("C:\\Users\\marye\\Desktop\\" + "Average_intensity_N_" + SimulationN + "_E_" + SimulationE + "_" +CURRENT_EMOTION + ".txt", "UTF-8");


            for (int i = 0; i < IntensityAverageChanges.toArray().length; i++) {
                writer.println(IntensityAverageChanges.toArray()[i]);

            }
            writer.close();




        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            Logger.getLogger(EmotionalAgent.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            PrintWriter writer = new PrintWriter("C:\\Users\\marye\\Desktop\\" + "Single_node_intensity_N_" + SimulationN + "_E_" + SimulationE + "_" +CURRENT_EMOTION + ".txt", "UTF-8");


            for (int i = 0; i < IntensityChangesSingleAgent.toArray().length; i++) {
                writer.println(IntensityChangesSingleAgent.toArray()[i]);

            }
            writer.close();




        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            Logger.getLogger(EmotionalAgent.class.getName()).log(Level.SEVERE, null, ex);
        }
 try {
            PrintWriter writer = new PrintWriter("C:\\Users\\marye\\Desktop\\" + "Single_node_expression_N_" + SimulationN + "_E_" + SimulationE + "_" +CURRENT_EMOTION + ".txt", "UTF-8");


            for (int i = 0; i < ExpressionChangesSingleAgent.toArray().length; i++) {
                writer.println(ExpressionChangesSingleAgent.toArray()[i]);

            }
            writer.close();




        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            Logger.getLogger(EmotionalAgent.class.getName()).log(Level.SEVERE, null, ex);
        }



    }

    public static void restart() {
       
        
        jPanel3.removeAll();
        jPanel3.repaint();
        jPanel8.removeAll();
        jPanel8.repaint();
        jTextArea2.setText("");
        IntensityAverageChanges.clear();
        ExpressionChangesSingleAgent.clear();
        IntensityChangesSingleAgent.clear();
        step2 = 0;
        oldyvisiem = 0;
        oldY = 0;
        y = 0;
        step = 0;
        oldExpr = 0;
        Expr = 0;
        FIRST_IRRITATION = true;


       
        NETWORK_READY = true;
        PERSONALITY_READY = true;
        emo_mas.EMO_MAS.runAgents();

        initSadness.setEditable(false);
        initAnger.setEditable(false);
        initJoy.setEditable(false);
        initDisgust.setEditable(false);
        initFear.setEditable(false);
        start.setEditable(true);
        FrequencyField.setEditable(false);
        startButton.setEnabled(false);
        newSimulationButton.setEnabled(false);
       
        




    }

    public void startVisualisation() {
        GuiEvent ge = new GuiEvent(this, 2);
        myAgent.postGuiEvent(ge);
    
    }
}

