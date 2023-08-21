package emotioncontagion;

import java.util.Random;

/**
 *
 * @author Mara Pudane
 */
public class ContagionParameters {

    public static double[] CURRENT_DISTRIBUTION = {0.004, 0.004, 0.004, 0.004, 0.004,
        0.004, 0.004, 0.004, 0.004, 0.004,
        0.004, 0.004, 0.004, 0.004, 0.004,
        0.004, 0.004, 0.004, 0.004, 0.004,
        0.004, 0.004, 0.004, 0.004, 0.004};
    public static Random rand = new Random();
//public static long seed = System.nanoTime();    

    public static void generatePoissonDistribution(int lambda) {
        double sum = 0;

        for (int i = 0; i < CURRENT_DISTRIBUTION.length; i++) {
            sum = sum + (Math.exp(-lambda) * Math.pow(lambda, i)) / factorial(i); //pagaidām nepilns, jo ir tikai daži intervāli
            CURRENT_DISTRIBUTION[i] = sum;

        }
        for (int i = 0; i < CURRENT_DISTRIBUTION.length; i++) {
            if (CURRENT_DISTRIBUTION[i] > 1 || CURRENT_DISTRIBUTION[i] < 0) {
                CURRENT_DISTRIBUTION[i] = 0;

                for (int j = i; j < CURRENT_DISTRIBUTION.length; j++) {
                    CURRENT_DISTRIBUTION[j] = 0;
                }




            }

        }

        for (int i = 0; i < 100; i++) {
            generateInterval();
        }



    }

    public static int generateInterval() {
        int lambda = 0;

        double a = rand.nextDouble();


        for (int i = 0; i < CURRENT_DISTRIBUTION.length; i++) {


            double prev;
            if (i == 0)//CURRENT_DISTRIBUTION.length-1)
            {
                prev = 1;
            } else {
                prev = CURRENT_DISTRIBUTION[i - 1];
            }

            if (a >= prev && a < CURRENT_DISTRIBUTION[i]) {
                lambda = i;
            }

        }



        return lambda;
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        int fact = 1; // this  will be the result
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    public static int[][] turnGraph(int[][] undirectedGraph) {
        int[][] directed = undirectedGraph;
        for (int i = 0; i < undirectedGraph.length; i++) {
            for (int j = 0; j < undirectedGraph[i].length; j++) {

                if (i > j) {
                    directed[i][j] = 0;
                }
            }

        }
        return directed;

    }
}
