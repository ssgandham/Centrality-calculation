package packages;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Graph {
    static int V; // No. of vertices
    static float delta[], CB[];
    // Array  of lists for Adjacency List Representation

    static LinkedList<Integer> pred[];
    static Stack<Integer> st = new Stack<Integer>();
    static int sigma[], dist[];
    static Queue<Integer> q = new LinkedList<Integer>();
    int[] arr_dist = new int[100000];
    static int[][] shortest_path_dist;
    static float[] closeness_centrality;
    float[] matrix_weight;

    // Constructor
    Graph(int v) {
        System.out.println("V : " + v);
        V = v;
        Graph_Declarations.adj = new LinkedList[v];
        pred = new LinkedList[v];
        CB = new float[v];
        sigma = new int[v];
        dist = new int[v];
        delta = new float[v];

        shortest_path_dist = new int[v][v];
        closeness_centrality = new float[v];
        Graph_Declarations.katz_centrality = new float[v];

        for (int i = 0; i < v; ++i) {
            Graph_Declarations.adj[i] = new LinkedList<Integer>();
            pred[i] = new LinkedList<Integer>();
            sigma[i] = 0;
            dist[i] = -1;
            CB[i] = 0;
            delta[i] = 0;

        }
        dist[1] = 0;
        sigma[1] = 1;
        matrix_weight = new float[v];

    }

    public void edge_add(int src, int dest) {
        if (!Graph_Declarations.adj[src].contains(dest)) {
            Graph_Declarations.adj[src].add(dest);
            Graph_Declarations.adj[dest].add(src);
        }
    }

    public static void init(int src) {
        //        adj = new LinkedList[V];
        pred = new LinkedList[V];
        //        CB = new float[V];
        sigma = new int[V];
        dist = new int[V];
        delta = new float[V];
        for (int i = 0; i < V; ++i) {
            // adj[i] = new LinkedList<Integer>();
            pred[i] = new LinkedList<Integer>();
            sigma[i] = 0;
            dist[i] = -1;

            delta[i] = 0;

        }
        dist[src] = 0;
        sigma[src] = 1;
    }

    public static void traverse() {
        for (int i = 0; i < V; i++) {
            int src = i;
            init(src);
            st = new Stack<Integer>();
            //            dist[src] = 0;
            //            sigma[src] = 1;
            q.add(src);
            while (!q.isEmpty()) {
                int vertex = q.poll();
                st.push(vertex);
                for (int neigh : Graph_Declarations.adj[vertex]) {
                    if (dist[neigh] < 0) {
                        q.add(neigh);
                        dist[neigh] = dist[vertex] + 1;
                    }

                    if (dist[neigh] == dist[vertex] + 1) {
                        sigma[neigh] = sigma[neigh] + sigma[vertex];
                        if (!pred[neigh].contains(vertex))
                            pred[neigh].add(vertex);
                    }
                }

            }

            while (!st.isEmpty()) {
                int st_tmp = st.pop();
                for (int vertice : pred[st_tmp]) {
                    float tmp_delta = delta[vertice]
                            + (((float) ((float) sigma[vertice] / (float) sigma[st_tmp])) * (1 + delta[st_tmp]));
                    delta[vertice] += tmp_delta;
                    if (src != st_tmp)
                        CB[st_tmp] += delta[st_tmp];
                }
            }
            //            System.out.println("i :" + i);
            shortest_path_dist[src] = dist;
        }

    }

    public void betweeness_centrality() {
        for (int i = 0; i < CB.length; i++) {
            //            System.out.println(CB[i]);
            Graph_Declarations.total_centrality[i] += CB[i];
        }
    }

    public void degree_centrality() {
        for (int i = 0; i < Graph_Declarations.adj.length; i++) {
            //            for (int tmp_list : adj[i])
            Graph_Declarations.degree_centrality.put(i, Graph_Declarations.adj[i].size());
            Graph_Declarations.total_centrality[i] += Graph_Declarations.adj[i].size();
        }
    }

    public static void closeness_centrality() {
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                closeness_centrality[i] += shortest_path_dist[i][j];
                //                System.out.println("Before i : " + i + ":" + Graph_Declarations.katz_centrality[i]);
                //                System.out.println("Degree Centrality j : " + (float) Graph_Declarations.degree_centrality.get(j));
                //                System.out.println(
                //                        "Power Centrality" + Math.pow(Graph_Declarations.katz_constant, shortest_path_dist[i][j]));
                //                System.out.println("Shortest Path : " + shortest_path_dist[i][j]);
                Graph_Declarations.katz_centrality[i] += ((float) Graph_Declarations.degree_centrality.get(j))
                        * Math.pow(Graph_Declarations.katz_constant, shortest_path_dist[i][j]);
                //                System.out.println("After i : " + i + ":" + Graph_Declarations.katz_centrality[i]);
            }
            //            System.out.println("i:" + i + closeness_centrality[i]);
            closeness_centrality[i] = 1 / closeness_centrality[i];
        }

        //        System.out.println("Katz Centrality");
        for (int m = 0; m < V; m++) {
            //            System.out.println("m : " + closeness_centrality[m]);
            Graph_Declarations.total_centrality[m] += closeness_centrality[m];
            //            Graph_Declarations.total_centrality[m] += Graph_Declarations.katz_centrality[m];
        }
    }

    public static void Katz_Centrality() {
        for (int m = 0; m < V; m++) {
            //            Graph_Declarations.total_centrality[m] += closeness_centrality[m];
            Graph_Declarations.total_centrality[m] += Graph_Declarations.katz_centrality[m];
        }
    }
    //    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Graph graph = new Graph(100);
        //        graph.edge_add(0, 1);
        //        graph.edge_add(0, 2);
        //        graph.edge_add(1, 0);
        //        graph.edge_add(1, 3);
        //        graph.edge_add(2, 0);
        //        graph.edge_add(2, 3);
        //        graph.edge_add(2, 4);
        //        graph.edge_add(2, 5);
        //        graph.edge_add(3, 1);
        //        graph.edge_add(3, 2);
        //        graph.edge_add(4, 2);
        //        graph.edge_add(4, 5);
        //        graph.edge_add(5, 2);
        //        graph.edge_add(5, 4);
        graph.traverse();

    }

}
