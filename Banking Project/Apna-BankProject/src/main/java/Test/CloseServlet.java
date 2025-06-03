package Test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/close")
public class CloseServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	PrintWriter pw=res.getWriter();
    	res.setContentType("text/html");
    	String uname=req.getParameter("uname");
    	String pword=req.getParameter("pword");
    	int acno=Integer.parseInt(req.getParameter("acno"));
    	int k=new CloseDao().closefrom(uname,pword,acno);
    	//System.out.println(k);
    	if(k>0)
    	{
            //System.out.println(k);
			req.setAttribute("msg", "Your Acount has Beean Closed Thanks for Using this Website");
			
			RequestDispatcher rd= req.getRequestDispatcher("msg.jsp");
			rd.forward(req, res);
			
		}
		else
		{
			
			req.setAttribute("msg", "Somthing Went Wrong ");
			RequestDispatcher rd= req.getRequestDispatcher("msg.jsp");
			rd.forward(req, res);
		}
    }
}
