package Test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/dep")
public class DepositeServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	 PrintWriter pw=res.getWriter();
	 res.setContentType("text/html");
	 NewAcBean nb=new NewAcBean();
	 int acno=Integer.parseInt(req.getParameter("acno"));
	 String uname=req.getParameter("uname");
	 String pword=req.getParameter("pword");
	 double amt=Double.parseDouble(req.getParameter("amt"));
	 int k=DepositDao.depositform( amt,acno,uname);
	 if(k>0)
		{
			pw.println("Deposit Successful...");
			req.setAttribute("success", "your Balance has Increases");
			req.setAttribute("bal", amt);
			RequestDispatcher rd= req.getRequestDispatcher("success.jsp");
			rd.forward(req, res);
			
		}
		else
		{
			pw.println("Deposit failed...");
			req.setAttribute("msg", "check your balance");
			RequestDispatcher rd= req.getRequestDispatcher("msg.jsp");
			rd.forward(req, res);
		}
	}
    
}
