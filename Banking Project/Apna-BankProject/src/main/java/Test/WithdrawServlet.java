package Test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/wdraw")
public class WithdrawServlet extends HttpServlet
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
		 int k=withdrawDao.withdrawform( amt,acno,uname);
		 if(k>0)
			{
				pw.println("Withdraw Successful...");
				req.setAttribute("success", "your Balance decrase");
				req.setAttribute("bal", amt);
				RequestDispatcher rd= req.getRequestDispatcher("success.jsp");
				rd.forward(req, res);
				
			}
			else
			{
				pw.println("withdraw failed...");
				req.setAttribute("msg", "Try Again");
				RequestDispatcher rd= req.getRequestDispatcher("msg.jsp");
				rd.forward(req, res);
			}
}
}
