package packages;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
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
 * Servlet implementation class Calculate_Closeness_Centrality
 */
@WebServlet("/Calculate_Closeness_Centrality")
public class Calculate_Closeness_Centrality extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Calculate_Closeness_Centrality() {
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

        /*Reference : https://www.mkyong.com/java/how-to-read-and-parse-csv-file-in-java/*/
        Graph_Declarations.path = request.getParameter("input_path");
        System.out.print(Graph_Declarations.path);

        /*  String csvFile = "/Users/mkyong/csv/country.csv";*/
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = " ";

        try {

            br = new BufferedReader(new FileReader(Graph_Declarations.path));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] edges = line.split(" ");
                g.edge_add(Graph_Declarations.map_vertices.get(edges[0]),
                        Graph_Declarations.map_vertices.get(edges[1]));
            }
            g.traverse();
            g.closeness_centrality();
            //            response.sendRedirect("Display_Graph.jsp");
            Map<Integer, Float> map = new HashMap<>();
            for (int i = 0; i < g.closeness_centrality.length; i++)
                map.put(i, g.closeness_centrality[i]);
            int vertex = 0;
            PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Betweenness Centrality</title>");
            out.println("<style>");
            out.println(".torrent-graph {");
            out.println(" width: 200%;");
            out.println("  height: 200%;");
            out.println("}");
            out.println("</style>");
            out.println("</head>");

            out.println("<body>");
            out.println("<h2>Betweenness Centrality</h2>");
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
                out.println("name: 'Vertex " + tmp_key + " : " + map.get(Graph_Declarations.map_vertices.get(tmp_key))
                        + "'");
                out.println(" })");
            }
            br = new BufferedReader(new FileReader(Graph_Declarations.path));
            while ((line = br.readLine()) != null) {
                String[] edges = line.split(" ");
                out.println("graph.connect('" + Graph_Declarations.map_vertices.get(edges[0]) + "','"
                        + Graph_Declarations.map_vertices.get(edges[1]) + "')");
            }
            //            out.println("graph.connect('0','1')");
            //            out.println("graph.connect('0','2')");
            //            out.println("graph.connect('1','0')");
            //            out.println("graph.connect('1','3')");
            //            out.println("graph.connect('2','0')");
            //            out.println("graph.connect('2','3')");
            //            out.println("graph.connect('2','4')");
            //            out.println("graph.connect('2','5')");
            //            out.println("graph.connect('3','1')");
            //            out.println("graph.connect('3','2')");
            //            out.println("graph.connect('4','2')");
            //            out.println("graph.connect('4','5')");
            //            out.println("graph.connect('5','2')");
            //            out.println("graph.connect('5','4')");

            out.println("graph.list()");
            out.println("</script>");
            out.println("</body>");
            out.println("</html>");

            for (float tmp : g.CB)
                System.out.println(tmp);

        } catch (

        FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
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
