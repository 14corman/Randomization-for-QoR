/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.qortest;

import edu.princeton.cs.algs4.In;
import java.io.File;
import java.net.URISyntaxException;
/**
 *
 * @author Cory Kromer-Edwards
 */
public class QoRTest {
    
    /**
     * @param args the command line arguments
     * @throws java.net.URISyntaxException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws URISyntaxException, ClassNotFoundException {
        // TODO code application logic here
        
        boolean random = false;
        String fileDir = "D:\\Grad School\\CS 5360 0001 Randomized Algorithms\\Final project\\Randomization-for-QoR\\QoRTest\\src\\main\\resources\\graph.txt";
        
        if(!random)
        {
            In in = new In(new File(fileDir));
            Network graph = new Network(in, random);
        
            graph.setPacket(1, 4);
            graph.setPacket(1, 11);
            graph.setPacket(1, 19);
            graph.setPacket(8, 5);
            graph.setPacket(8, 19);
            graph.setPacket(8, 12);
            graph.setPacket(16, 4);
            graph.setPacket(16, 11);
            long startTime = System.nanoTime();
            while(!graph.isComplete())
                graph.doTick();

            long endTime = System.nanoTime();
            long elapsed = endTime - startTime;
            double milliElapsed = elapsed / 1000000.0;

            System.out.println("Max dilation = " + graph.getMaxDilation());
            System.out.println("Max congestion = " + graph.getMaxCongestion());
            System.out.println("Time taken in milliseconds = " + milliElapsed);
            
            in.close();
        }
        else
        {
            double averageCong = 0.0;
            double averageDil = 0.0;
            double averageTime = 0.0;
            double minCong = Double.MAX_VALUE;
            double minDil = Double.MAX_VALUE;
            double minTime = Double.MAX_VALUE;
            double maxCong = 0.0;
            double maxDil = 0.0;
            double maxTime = 0.0;
            for(int i = 0; i < 100; i++)
            {
                In in = new In(new File(fileDir));
                Network graph = new Network(in, random);
        
                graph.setPacket(1, 4);
                graph.setPacket(1, 11);
                graph.setPacket(1, 19);
                graph.setPacket(8, 5);
                graph.setPacket(8, 19);
                graph.setPacket(8, 12);
                graph.setPacket(16, 4);
                graph.setPacket(16, 11);
                long startTime = System.nanoTime();
                while(!graph.isComplete())
                    graph.doTick();

                long endTime = System.nanoTime();
                long elapsed = endTime - startTime;
                double milliElapsed = elapsed / 1000000.0;

                System.out.println("Max dilation = " + graph.getMaxDilation());
                System.out.println("Max congestion = " + graph.getMaxCongestion());
                System.out.println("Time taken in milliseconds = " + milliElapsed);
                averageCong += graph.getMaxCongestion();
                averageDil += graph.getMaxDilation();
                averageTime += milliElapsed;
                
                if(minCong > graph.getMaxCongestion())
                    minCong = graph.getMaxCongestion();
                
                if(minDil > graph.getMaxDilation())
                    minDil = graph.getMaxDilation();
                
                if(minTime > milliElapsed)
                    minTime = milliElapsed;
                
                if(maxCong < graph.getMaxCongestion())
                    maxCong = graph.getMaxCongestion();
                
                if(maxDil < graph.getMaxDilation())
                    maxDil = graph.getMaxDilation();
                
                if(maxTime < milliElapsed)
                    maxTime = milliElapsed;
                
                in.close();
            }
            
            averageCong = averageCong / 100.0;
            averageDil = averageDil / 100.0;
            averageTime = averageTime / 100.0;
            System.out.println("Average max dilation = " + averageDil);
            System.out.println("Average max congestion = " + averageCong);
            System.out.println("Average time taken in milliseconds = " + averageTime);
            System.out.println();
            System.out.println("Min max dilation = " + minDil);
            System.out.println("Min max congestion = " + minCong);
            System.out.println("Min time taken in milliseconds = " + minTime);
            System.out.println();
            System.out.println("Max max dilation = " + maxDil);
            System.out.println("Max max congestion = " + maxCong);
            System.out.println("Max time taken in milliseconds = " + maxTime);
        }
    }
    
}
