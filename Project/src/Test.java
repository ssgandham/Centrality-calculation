
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
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

        //        Reference : https://stackoverflow.com/questions/31099956/read-the-contents-of-a-file-upload-in-java
        if (ServletFileUpload.isMultipartContent(request)) {
            int i = 0;

            DiskFileItemFactory factory = new DiskFileItemFactory();
            // files smaller than 5MB will be held in memory
            factory.setSizeThreshold(5000000);

            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setFileSizeMax(10000000); // max size of attachment 10MB

            List list = null;
            try {
                list = upload.parseRequest(request);
            } catch (FileUploadException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            Iterator iter = list.iterator();

            String csv = null;

            while (iter.hasNext()) {
                FileItem param = (FileItem) iter.next();
                System.out.println(param.getString());
                if (!param.isFormField()) {
                    csv = param.getString();
                    break;
                }
            }

            if (csv == null) {
                try {
                    throw new Exception("CSV buffer not uploaded");
                } catch (Exception e) {
                    // TODO Auto-generated catch block
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
