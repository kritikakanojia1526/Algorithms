package com.akbar.mohd;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TopologicalSortDAG {

    static class Node
    {
        int key;
        ArrayList<Node> adjacentChild;

        public Node(int key)
        {
            this.key=key;
            adjacentChild=new ArrayList<>();
        }
    }

    static ArrayList<Node> topologicalSort=new ArrayList<>();

    public static void main(String[] args)throws FileNotFoundException {

        Scanner Sc=new Scanner(new File("InputTopoSort.txt"));

        int n=Sc.nextInt();
        int m=Sc.nextInt();

        int cost[][]=new int[n][n];

        ArrayList<Node> nodes=new ArrayList<>();

        for(int i=1;i<=n;i++)
        {
            Node a=new Node(i);
            nodes.add(a);
        }

        for(int i=1;i<=m;i++)
        {
            int a=Sc.nextInt();
            int b=Sc.nextInt();
            int c=Sc.nextInt();
            cost[a-1][b-1]=c;
            nodes.get(a-1).adjacentChild.add(nodes.get(b-1));
        }

        ArrayList<Boolean> visited=new ArrayList<>(Collections.nCopies(n,false));
        dfsTopoSort(nodes.get(0),visited);
        for(boolean b:visited)
        {
            if(!b)
            {
                dfsTopoSort(nodes.get(visited.indexOf(b)),visited);
            }
        }
        for(Node a:topologicalSort)
            System.out.print(a.key+"  ");
        System.out.println();
    }

    static void dfsTopoSort(Node node,ArrayList<Boolean> visited)
    {
        visited.set(node.key-1,true);
        for(Node n:node.adjacentChild)
        {
            if(!visited.get(n.key-1))
                dfsTopoSort(n,visited);
        }
        topologicalSort.add(node);
    }

}
