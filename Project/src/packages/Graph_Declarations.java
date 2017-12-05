package packages;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Graph_Declarations {
    public static float[] total_centrality;
    static Map<String, Integer> map_vertices = new HashMap<String, Integer>();
    static int no_of_vertices = 0;
    static LinkedList<Integer> adj[];
    static Map<Integer, Integer> degree_centrality = new HashMap<>();
    public static String path;

    Graph_Declarations(int vertices) {
        total_centrality = new float[vertices];
    }
}
