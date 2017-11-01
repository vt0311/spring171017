package com.java119.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		/*Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );*/
		
		return "home";
	}
	
	@RequestMapping(value = "/oraTest", method = RequestMethod.GET)
	public String oraTest(Locale locale, Model model) {
		//logger.info("Welcome home! The client locale is {}.", locale);
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "scott";
		String pwd = "tiger";
		
		Connection conn = null;
	    Statement stmt = null;
	    String sql = "select b_no, b_title, b_writer, b_contents, reg_date from board";
	    //String sql = "select * from board";
		ResultSet rs = null;	
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, id, pwd);
			//stmt = conn.prepareStatement(sql);
			stmt = conn.createStatement();
			//stmt.setString(1, b_no);
			
		    rs = stmt.executeQuery(sql);
		    
			while(rs.next()){
			
				//bVo = new BoardVO();
				System.out.println( rs.getString("b_no"));
				System.out.println( rs.getString("b_title"));
				System.out.println( rs.getString("b_writer"));
				System.out.println( rs.getString("b_contents"));
				System.out.println( rs.getString("reg_date"));
				
			/*	bVo = new BoardVO();
				bVo.setB_no(rs.getString("b_no"));
				bVo.setB_title(rs.getString("b_title"));
				bVo.setB_writer(rs.getString("b_writer"));
				bVo.setB_contents(rs.getString("b_contents"));
				bVo.setReg_date(rs.getString("reg_date"));*/
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		   try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		model.addAttribute("serverTime", "hah sw го╫б©Ь" );
		
		return "home";
	}
	
}
