package packages;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class final_centrality
 */
@WebServlet("/final_centrality")
public class final_centrality extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public final_centrality() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        //		response.getWriter().append("Served at: ").append(request.getContextPath());
        Graph g = new Graph(Graph_Declarations.no_of_vertices);
        //        Graph_Declarations g_declare = new Graph_Declarations(Graph_Declarations.no_of_vertices);
        //        BufferedReader br = null;
        //        String line = "";
        //        br = new BufferedReader(new FileReader(Graph_Declarations.path));
        //        while ((line = br.readLine()) != null) {
        //
        //            // use comma as separator
        //            String[] edges = line.split(" ");
        //            g.edge_add(Graph_Declarations.map_vertices.get(edges[0]), Graph_Declarations.map_vertices.get(edges[1]));
        //        }
        //        g.traverse();
        //            g.closeness_centrality();
        //            response.sendRedirect("Display_Graph.jsp");
        Map<Integer, Float> map = new HashMap<>();
        float max_centrality = Float.MIN_VALUE;
        int final_max_vertice = 0;
        for (int i = 0; i < Graph_Declarations.total_centrality.length; i++) {
            map.put(i, Graph_Declarations.total_centrality[i]);
            if (Graph_Declarations.total_centrality[i] > max_centrality) {
                max_centrality = Graph_Declarations.total_centrality[i];
                //                final_max_vertice = Graph_Declarations.map_vertices.get(i);
                final_max_vertice = i;
            }

        }
        int vertex = 0;
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Betweenness Centrality</title>");
        out.println("<style>");
        out.println(".torrent-graph {");
        out.println(" width: 100%;");
        out.println("  height: 200%;");
        out.println("}");
        out.println("</style>");
        out.println("</head>");

        out.println("<body>");
        out.println("<h2>Betweenness Centrality</h2>");
        out.println("<h2>Max Centrality " + final_max_vertice + " : " + max_centrality + "</h2>");
        out.println("<div class=\"torrent-graph\"></div>");

        out.println("<script type=\"text/javascript\" src=\"./p2p-graph.min.js\"></script>");
        out.println("<script>");
        out.println("let graph = new window.P2PGraph('.torrent-graph')");
        Map<Integer, String> map_id = new HashMap<>();
        for (String tmp_key : Graph_Declarations.map_vertices.keySet()) {
            out.println("graph.add({");
            out.println("id: '" + Graph_Declarations.map_vertices.get(tmp_key) + "' ,");
            map_id.put(Graph_Declarations.map_vertices.get(tmp_key), tmp_key);
            out.println("me: false,");
            out.println(
                    "name: 'Vertex " + tmp_key + " : " + map.get(Graph_Declarations.map_vertices.get(tmp_key)) + "'");
            out.println(" })");
        }
        //            }
        //            out.println("graph.add({");
        //            out.println("id: '0',");
        //            out.println("me: false,");
        //            out.println("name: 'Vertex 1 : " + map.get(vertex++) + "'");
        //            out.println(" })");
        //            out.println("graph.add({");
        //            out.println("id: '1',");
        //            out.println("me: false,");
        //            out.println("name: 'Vertex 2 : " + map.get(vertex++) + "'");
        //            out.println("})");
        //            out.println("graph.add({");
        //            out.println("id: '2',");
        //            out.println("me: false,");
        //            out.println("name: 'Vertex 3 : " + map.get(vertex++) + "'");
        //            out.println("})");
        //            out.println("graph.add({");
        //            out.println("id: '3',");
        //            out.println("me: false,");
        //            out.println("name: 'Vertex 4 : " + map.get(vertex++) + "'");
        //            out.println("})");
        //            out.println("graph.add({");
        //            out.println("id: '4',");
        //            out.println("me: false,");
        //            out.println("name: 'Vertex 5 : " + map.get(vertex++) + "'");
        //            out.println("})");
        //            out.println("graph.add({");
        //            out.println("id: '5',");
        //            out.println("me: false,");
        //            out.println("name: 'Vertex 6 : " + map.get(vertex++) + "'");
        //            out.println("})");
        BufferedReader br = null;
        String line = "";
        br = new BufferedReader(new FileReader(Graph_Declarations.path));
        while ((line = br.readLine()) != null) {
            String[] edges = line.split(" ");
            out.println("graph.connect('" + Graph_Declarations.map_vertices.get(edges[0]) + "','"
                    + Graph_Declarations.map_vertices.get(edges[1]) + "')");
        }

        out.println("graph.list()");
        out.println("</script>");
        out.println("</body>");
        out.println("</html>");

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
