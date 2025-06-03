package Test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/ac")
public class NewAccountServlet extends HttpServlet
{
   @Override
protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
   {
	   int k=0;
	  PrintWriter pw=res.getWriter();
	  res.setContentType("text/html");
	  NewAcBean nb=new NewAcBean();
	  nb.setUname(req.getParameter("uname"));
	  nb.setPword(req.getParameter("pword"));
	  nb.setRepword(req.getParameter("repword"));
	  nb.setAmount(Double.parseDouble(req.getParameter("amt")));
	  nb.setAddress(req.getParameter("add"));
	  nb.setPhone(Long.parseLong(req.getParameter("phno")));
	  NewAcDao nd = new NewAcDao();
	   k= nd.NewAc(nb);
	   if(k>0)
	   {
		  System.out.println(nb);
		   pw.println("<h3>Account Created Successfully....</h3>");
		   req.setAttribute("ubean", nb);
		   RequestDispatcher rd=req.getRequestDispatcher("view.jsp");
		   rd.include(req, res);
		   
	   }
	   else
	   {
		   pw.println("Sorry Account Not Created ....");
		   RequestDispatcher rd=req.getRequestDispatcher("WelcomePage.html");
		   rd.include(req, res); 
	   }
   }
}
