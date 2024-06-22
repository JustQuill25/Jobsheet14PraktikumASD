package Praktikum123;

import java.util.ArrayList;
import java.util.LinkedList;

public class Graph01 {
    int vertex;
    DoubleLinkedList01 list[];

    public Graph01(int v) {
        vertex = v;
        list = new DoubleLinkedList01[v];
        for (int i = 0; i < v; i++) {
            list[i] = new DoubleLinkedList01();
        }
    }

    public void addEdge(int asal, int tujuan, int jarak) {
        list[asal].addFirst(tujuan, jarak);
    }

    public void degree(int asal) throws Exception {
        int totalIn = 0, totalOut = 0;

        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j < list[i].size(); j++) {
                if (list[i].get(j) == asal) {
                    ++totalIn;
                }
            }
        }

        totalOut = list[asal].size();

        System.out.println("InDegree dari Gedung " + (char) ('A' + asal) + ": " + totalIn);
        System.out.println("OutDegree dari Gedung " + (char) ('A' + asal) + ": " + totalOut);
        System.out.println("Degree dari Gedung " + (char) ('A' + asal) + ": " + (totalIn + totalOut));
    }

    public void removeEdge(int asal, int tujuan) throws Exception {
        list[asal].remove(tujuan);
    }

    public void removeAllEdges() {
        for (int i = 0; i < vertex; i++) {
            list[i].clear();
        }
        System.out.println("Graf berhasil dikosongkan");
    }

    public void printGraph() throws Exception {
        for (int i = 0; i < vertex; i++) {
            if (list[i].size() > 0) {
                System.out.println("Gedung " + (char) ('A' + i) + " terhubung dengan ");
                for (int j = 0; j < list[i].size(); j++) {
                    System.out.print((char) ('A' + list[i].get(j)) + "(" + list[i].getJarak(j) + "m), ");
                }
                System.out.println();
            }
        }
        System.out.println();
    }

    public boolean hasPath(int asal, int tujuan) {
        boolean[] visited = new boolean[vertex];
        LinkedList<Integer> queue = new LinkedList<>();

        visited[asal] = true;
        queue.add(asal);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == tujuan) {
                return true;
            }

            for (int neighbor : list[current].getAllData()) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }

        return false;
    }

    public void updateJarak(int asal, int tujuan, int newJarak) {
        list[asal].updateJarak(tujuan, newJarak);
    }

    public int hitungEdge() {
        int count = 0;
        for (int i = 0; i < vertex; i++) {
            count += list[i].size();
        }
        return count;
    }
}
