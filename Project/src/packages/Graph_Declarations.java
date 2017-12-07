package packages;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Graph_Declarations {
    public static float[] total_centrality;
    static Map<String, Integer> map_vertices = new HashMap<String, Integer>();
    static Map<Integer, String> map_vertices_edges = new HashMap<Integer, String>();
    static int no_of_vertices = 0;
    static LinkedList<Integer> adj[];
    static Map<Integer, Integer> degree_centrality = new HashMap<>();
    static float[] katz_centrality;
    public static String path = "";
    static float katz_constant = (float) 0.5;
    //    static String input_path = "";

    Graph_Declarations(int vertices) {
        total_centrality = new float[vertices];
    }
}
