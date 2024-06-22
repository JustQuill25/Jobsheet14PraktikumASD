package Praktikum123;

class GraphMatriks01 {
    int vertex;
    int[][] matriks;

    GraphMatriks01(int v) {
        vertex = v;
        matriks = new int[v][v];
    }

    // Method untuk menambahkan edge dengan bobot (weight)
    public void makeEdge(int asal, int tujuan, int jarak) {
        matriks[asal][tujuan] = jarak;
    }

    // Method untuk menghapus edge
    public void removeEdge(int asal, int tujuan) {
        matriks[asal][tujuan] = -1;
    }

    // Method untuk mencetak graph
    public void printGraph() {
        for (int i = 0; i < vertex; i++) {
            System.out.print("Gedung " + (char) ('A' + i) + ": ");
            boolean adaEdge = false;
            for (int j = 0; j < vertex; j++) {
                if (matriks[i][j] != -1) {
                    adaEdge = true;
                    System.out.print("Gedung " + (char) ('A' + j) + " (" + matriks[i][j] + "m), ");
                }
            }
            if (adaEdge) {
                System.out.println();
            } else {
                System.out.println("Tidak terhubung dengan gedung manapun.");
            }
        }
        System.out.println();
    }

    // Method untuk menghitung outDegree dari sebuah vertex
    public int outDegree(int vertex) {
        int outDegree = 0;
        for (int j = 0; j < this.vertex; j++) {
            if (matriks[vertex][j] != -1) {
                outDegree++;
            }
        }
        return outDegree;
    }

    // Method untuk menghitung inDegree dari sebuah vertex
    public int inDegree(int vertex) {
        int inDegree = 0;
        for (int i = 0; i < this.vertex; i++) {
            if (matriks[i][vertex] != -1) {
                inDegree++;
            }
        }
        return inDegree;
    }

    // Method untuk menghitung total degree (inDegree + outDegree)
    public int degree(int vertex) {
        return inDegree(vertex) + outDegree(vertex);
    }
}
