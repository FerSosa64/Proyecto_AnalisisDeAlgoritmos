/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Knapsack;

import java.util.Random;

/**
 *
 * @author carlo
 */
/* A Naive recursive implementation 
of 0-1 Knapsack problem */
class Knapsack { 

	// A utility function that returns 
	// maximum of two integers 
	static int max(int a, int b) { return (a > b) ? a : b; } 

	static int knapSack(int W, int wt[], int val[], int n) 
	{
		// Base Case 
            if (n == 0 || W == 0) 
                    return 0; 

            if (wt[n - 1] > W) {
                return knapSack(W, wt, val, n - 1); 
            }

            else {
                return max(val[n - 1] + knapSack(W - wt[n - 1], wt, val, n - 1), knapSack(W, wt, val, n - 1)); 
            }
	} 

        static int knapSackBU(int W, int wt[], int val[], int n) 
        { 
            int i, w; 
            int K[][] = new int[n + 1][W + 1]; 

            for (i = 0; i <= n; i++) { 
                for (w = 0; w <= W; w++) { 
                    if (i == 0 || w == 0) 
                        K[i][w] = 0; 
                    else if (wt[i - 1] <= w) 
                        K[i][w] 
                            = max(val[i - 1] 
                                    + K[i - 1][w - wt[i - 1]], 
                                K[i - 1][w]); 
                    else
                        K[i][w] = K[i - 1][w]; 
                } 
            } 

            return K[n][W]; 
        }
        
        static int knapSackHeavy(int W, int wt[], int val[]) {
            long start = System.nanoTime();
            int heavy[] = new int[val.length];
            int space = W;
            for (int i = 0; i < val.length; i++) {
                if (space < wt[heaviest(wt)])
                    wt[heaviest(wt)] = 0;
                else {
                    heavy[i] = val[heaviest(wt)];
                    space -= wt[heaviest(wt)];
                    wt[heaviest(wt)] = 0;
                }
            }
            long time = (System.nanoTime() - start);
            System.out.println("Tiempo transcurrido: "+time+" en nanosegundos");
            return W - space;
        }
        
        static int heaviest(int wt[]) {
            int heavy = 0;
            int index = 0;
            for (int i = 0; i < wt.length; i++) {
                if (wt[i] > heavy) {
                    heavy = wt[i];
                    index = i;
                }
            }
            return index;
        }
        
        static int knapSackLight(int W, int wt[], int val[]) {
            long start = System.nanoTime();
            int light[] = new int[val.length];
            int space = W;
            for (int i = 0; i < val.length; i++) {
                if (space < wt[lightest(wt)]) {
                    wt[lightest(wt)] = 4000;
                } else {
                    light[i] = val[lightest(wt)];
                    space -= wt[lightest(wt)];
                    wt[lightest(wt)] = 4000;
                }
            }
            long time = (System.nanoTime() - start);
            System.out.println("Tiempo transcurrido: "+time+" en nanosegundos");
            return W - space;
        }
        
        static int lightest(int wt[]) {
            int light = 3000;
            int index = 0;
            for (int i = 0; i < wt.length; i++) {
                if (wt[i] < light) {
                    light = wt[i];
                    index = i;
                }
            }
            return index;
        }
        
        public static void llenarArreglo(int[] arreglo) {
        Random rand = new Random();
        for (int i = 0; i < arreglo.length; i++) {
            // Generar un número aleatorio entre 0 y 100 (puedes ajustar el rango según tus necesidades)
            arreglo[i] = rand.nextInt(500); // Genera números entre 0 y 100
        }
    }
        
	// Driver code 
	public static void main(String args[]) 
	{ 
		int profit[] = new int[30]; 
		int weight[] = new int[30]; 
                llenarArreglo(profit);
                llenarArreglo(weight);
		int W = 50; 
		int n = profit.length;
		System.out.println("La ganancia con el menor fue de: "+knapSackLight(W, weight, profit)); 
		profit = new int[30]; 
		weight = new int[30];
                llenarArreglo(profit);
                llenarArreglo(weight);
		System.out.println("La ganancia con el mayor fue de: "+knapSackHeavy(W, weight, profit)); 
	} 
} 
/*This code is contributed by Rajat Mishra */
