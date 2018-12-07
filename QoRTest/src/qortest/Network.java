/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qortest;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 *
 * @author Cory Edwards
 */
public class Network extends Graph {
    
    public Queue<Packet>[] q;
    public ArrayList<Packet> deliveredPackets;
    private int totalPackets;
    private int largestQueue = 0;
    private final boolean isRandom;
    private final Random rand = new Random();
    
    
    public Network(In in, boolean r) {
        super(in);
        this.q = new LinkedList[V()];
        for(int v = 0; v < V(); v++)
        {
            q[v] = new LinkedList<>();
        }
            
        
        isRandom = r;
        deliveredPackets = new ArrayList();
    }
    
    public void setPacket(int source, int destination)
    {
        q[source].add(new Packet(rand.nextInt(), source, destination));
        totalPackets++;
    }
    
    public void sendPacket(int v)
    {
        if(!q[v].isEmpty())
        {
            Packet p = q[v].remove();
            int destination = p.getDestination();

            if(destination == v)
            {
                deliveredPackets.add(p);
                return;
            }
            
            int nextV = 0;

            if(isRandom)
            {
                Iterable<Integer> adj = adj(v);
                ArrayList<Integer> adjacent = new ArrayList<>();
                for(int newV : adj)
                    adjacent.add(newV);
                
                nextV = adjacent.get(rand.nextInt(adjacent.size()));
            }
            else
            {
                String a = Integer.toString(p.getSource() + 1);
                String b = Integer.toString(v + 1);
                String c = Integer.toString(destination + 1);
                switch(a + b + c)
                {
                    case "225":
                        nextV = 3;
                        break;
                    case "235":
                        nextV = 4;
                        break;
                    case "245":
                        nextV = 5;
                        break;
                    case "2212":
                        nextV = 1;
                        break;
                    case "2112":
                        nextV = 12;
                        break;
                    case "2220":
                        nextV = 1;
                        break;
                    case "2120":
                        nextV = 20;
                        break;
                    case "996":
                        nextV = 7;
                        break;
                    case "976":
                        nextV = 4;
                        break;
                    case "946":
                        nextV = 6;
                        break;
                    case "9913":
                        nextV = 8;
                        break;
                    case "9813":
                        nextV = 13;
                        break;
                    case "9920":
                        nextV = 21;
                        break;
                    case "92120":
                        nextV = 19;
                        break;
                    case "91920":
                        nextV = 20;
                        break;
                    case "171712":
                        nextV = 14;
                        break;
                    case "171412":
                        nextV = 11;
                        break;
                    case "171112":
                        nextV = 12;
                        break;
                    case "17175":
                        nextV = 16;
                        break;
                    case "17165":
                        nextV = 5;
                        break;
                    default:
                            System.err.println(a + ":" + b + ":" + c + " is not recognized");
                }
                
                nextV -= 1;
            }
            
            System.out.println("Packet " + (p.getSource() + 1) + ":" + (p.getDestination() + 1) + " going on edge " + (v + 1) + " - " + (nextV + 1));
            System.out.println();
            p.addDilation();
            q[nextV].add(p);
        }
    }
    
    public void doTick()
    {
        for(int v = 0; v < V(); v++)
        {
            sendPacket(v);
            if(largestQueue < q[v].size())
                largestQueue = q[v].size();
        }
    }
    
    public boolean isComplete()
    {
        return deliveredPackets.size() == totalPackets;
    }
    
    public int getMaxDilation()
    {
        int max = 0;
        for(Packet p : deliveredPackets)
        {
            if(max < p.getDilation())
                max = p.getDilation();
        }
        return max;
    }
    
    public int getMaxCongestion()
    {
        return largestQueue;
    }
    
}
