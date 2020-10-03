package com.akbar.mohd;

import javax.print.DocFlavor;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FindingConnectedComponentsUndirected {

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

    public static void main(String[] args) throws FileNotFoundException {

        //This algorithm is valid for undirected graph

        Scanner Sc = new Scanner(new File("Input2.txt"));

        int n = Sc.nextInt();
        int m = Sc.nextInt();

        int cost[][] = new int[n][n];

        ArrayList<Node> nodes = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            Node a = new Node(i);
            nodes.add(a);
        }

        for (int i = 1; i <= m; i++) {
            int a = Sc.nextInt();
            int b = Sc.nextInt();
            int c = Sc.nextInt();
            cost[a - 1][b - 1] = c;
            nodes.get(a - 1).adjacentChild.add(nodes.get(b - 1));
            nodes.get(b - 1).adjacentChild.add(nodes.get(a - 1));
        }

        ArrayList<Boolean> visited=new ArrayList<>(Collections.nCopies(n,false));

        for(Node a:nodes)
        {
            if(!visited.get(a.key-1))
            {
                ArrayList<Integer> temp=new ArrayList<>();
                depthFirstSearch(a,visited,temp);
                System.out.println(temp);
            }
        }
    }

    private static void depthFirstSearch(Node node, ArrayList<Boolean> visited, ArrayList<Integer> temp)
    {
        visited.set(node.key-1,true);
        temp.add(node.key);

        for(Node n:node.adjacentChild)
        {
            if(!visited.get(n.key-1))
                depthFirstSearch(n,visited,temp);
        }
    }

}
