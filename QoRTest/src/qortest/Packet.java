/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qortest;

/**
 *
 * @author Cory Edwards
 */
public class Packet {
    
    private final int data;
    private final int source;
    private final int destination;
    
    private int D = 0;
    
    public Packet(int d, int s, int des)
    {
        data = d;
        source = s;
        destination = des;
    }
    
    public void addDilation()
    {
        D++;
    }
    
    public int getDilation()
    {
        return D;
    }
    
    public int getDestination()
    {
        return destination;
    }
    
    public int getSource()
    {
        return source;
    }
}
