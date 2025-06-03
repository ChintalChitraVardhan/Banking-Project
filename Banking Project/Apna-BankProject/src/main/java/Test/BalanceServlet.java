package Test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/bal")
public class BalanceServlet extends HttpServlet
{
      @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
    {
          PrintWriter pw=res.getWriter();
          res.setContentType("text/html");
          int acno=Integer.parseInt(req.getParameter("ano"));
          String uname=req.getParameter("uname");
          String pword=req.getParameter("pword");
          NewAcBean nb=new BalanceDao().balanceform(acno,uname);
          if(nb==null)
          {
        	  req.setAttribute("msg","Invalid Acount Number / UserName...<br>");
        		req.getRequestDispatcher("Msg.jsp").forward(req, res);
          }
          else
          {
        	 
        	  req.setAttribute("ubean", nb);
   		   RequestDispatcher rd=req.getRequestDispatcher("view.jsp");
   		   rd.include(req, res);
          }
    }
}
