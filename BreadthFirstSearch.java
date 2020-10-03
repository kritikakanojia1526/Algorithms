package com.akbar.mohd;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class BreadthFirstSearch {

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

        Scanner Sc = new Scanner(new File("Input.txt"));

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
        }

        ArrayList<Boolean> visited=new ArrayList<>(Collections.nCopies(n,false));
        ArrayList<Integer> temp=new ArrayList<>();
        breadthFirstSearch(nodes.get(0),visited,nodes);
        System.out.println();
    }

    private static void breadthFirstSearch(Node node, ArrayList<Boolean> visited,ArrayList<Node> nodes) {

        Queue<Integer> queue=new LinkedList<>();
        queue.add(node.key);
        visited.set(node.key-1,true);
        while (queue.size()!=0)
        {
            int j=queue.poll();
            System.out.print(j+"  ");
            for(Node a:nodes.get(j-1).adjacentChild) {
                if(!visited.get(a.key-1))
                {
                    visited.set(a.key-1,true);
                    queue.add(a.key);
                }
            }
        }
    }

}