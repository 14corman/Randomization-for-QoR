/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qortest;

import edu.princeton.cs.algs4.In;
import java.io.File;
/**
 *
 * @author Cory Kromer-Edwards
 */
public class QoRTest {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        In in = new In(new File("D:\\Grad School\\CS 5360 0001 Randomized Algorithms\\Final project\\QoRTest\\graph.txt"));
        Network graph = new Network(in, false);
        
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
    }
    
}
