package uk.ac.ox.its.damaro.data.reporter.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.jersey.api.client.WebResource;

import uk.ac.ox.its.damaro.cdi.Injectee;
import uk.ac.ox.its.damaro.utility.Registry;
import uk.ac.ox.its.databank.ws.restful.client.Silos;
import uk.ac.ox.its.databank.ws.restful.client.WebResourceBuilder;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Inject
	Registry registry;
	
	@Inject Injectee i;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		WebResource webResource = WebResourceBuilder.getInstance("http://163.1.127.173/", "eidcsr", "eidcsr").getWebResource();
		
		System.out.println("Silos().getAllSilosAsJSON()");
        new Silos().getAllSilosAsJSON(webResource);  
        
		EntityManager entityManager = registry.getEmf()
				.createEntityManager();
		entityManager.getTransaction().begin();
		uk.ac.ox.its.damaro.model.User user = new uk.ac.ox.its.damaro.model.User("Bill", "Smith", "bill.smith@myexample123.com",
				"NeverGuess");
		entityManager.persist(user);
		entityManager.getTransaction().commit();
		entityManager.close();
		out.println("Inserted.");
		
		out.println("Hello, world!");
		out.println(i.sayHi());
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("In Post method");
		// Set response content type
	      response.setContentType("text/html");

	      PrintWriter out = response.getWriter();
		  String title = "Using GET Method to Read Form Data";
	      String docType =
	      "<!doctype html public \"-//w3c//dtd html 4.0 " +
	      "transitional//en\">\n";
	      out.println(docType +
	                "<html>\n" +
	                "<head><title>" + title + "</title></head>\n" +
	                "<body bgcolor=\"#f0f0f0\">\n" +
	                "<h1 align=\"center\">" + title + "</h1>\n" +
	                "<ul>\n" +
	                "  <li><b>First Name</b>: "
	                + request.getParameter("first_name") + "\n" +
	                "  <li><b>Last Name</b>: "
	                + request.getParameter("last_name") + "\n" +
	                "</ul>\n" +
	                "</body></html>");
	}

}
