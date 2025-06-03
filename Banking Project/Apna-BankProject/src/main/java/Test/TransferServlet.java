package Test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/tra")
public class TransferServlet extends HttpServlet
 {
 @Override
protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
 {
     PrintWriter pw=res.getWriter();
     res.setContentType("text/html");
    int acno=Integer.parseInt(req.getParameter("acno"));
    String uname= req.getParameter("uname");
    String pword= req.getParameter("pword");
    int tacno=Integer.parseInt(req.getParameter("tacno"));
    double amt=Double.parseDouble(req.getParameter("amt"));
    String msg=new TransferDao().Transferform(acno,uname,tacno,amt);
    if(msg.equals("Transaction Successful"))
    {
    	pw.println(msg);
		req.setAttribute("success", "Created in Account Balance is ");
		req.setAttribute("bal", amt);
		//req.setAttribute("success1", "depited  Account Balance is ");
		RequestDispatcher rd= req.getRequestDispatcher("success.jsp");
		rd.forward(req, res);
		
	}
	else
	{
		pw.println("Transaction failed...");
		req.setAttribute("msg", "Try Again");
		RequestDispatcher rd= req.getRequestDispatcher("msg.jsp");
		rd.forward(req, res);
	}
    }

}
