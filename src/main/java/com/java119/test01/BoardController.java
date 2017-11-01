package com.java119.test01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
    private SqlSession sqlSession;

	@RequestMapping(value = "/boardList", method = RequestMethod.GET)
	public String boardList(Locale locale, Model model) {
		
		
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );

		//JDBC Start
		/*
    	SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(org.gjt.mm.mysql.Driver.class);
        dataSource.setUsername("boarduser");
        dataSource.setUrl("jdbc:mysql://localhost:3306/boarddb");
        dataSource.setPassword("11111");

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        List<BoardList> fblistArr = jdbcTemplate.query(
            "select fblistno, fbsubject, fbwriter, fbwritedate from fbbase",
            new RowMapper<BoardList>() {
                @Override
                public BoardList mapRow(ResultSet rs, int rowNum) throws SQLException {
                    return new BoardList(rs.getString(1), rs.getString(2),
                   						rs.getString(3), rs.getString(4));
                }
            });
        */

		List<BoardVO> listArr = sqlSession.selectList("BoardMapper.boardList");

        model.addAttribute("fblistArr", listArr);
        //JDBC End

        
		
		return "boardlist";
	
	}
	
	
	@RequestMapping(value = "/boardDetail", method = RequestMethod.GET)
	public String boardDetail(Locale locale, Model model, String b_no, BoardVO invo) {
		
		System.out.println("b_no:"+b_no);
		System.out.println("getB_no():"+invo.getB_no());
		
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );

		BoardVO detailVO = sqlSession.selectOne("BoardMapper.boardDetail", invo);

        model.addAttribute("detailVO", detailVO);
        //JDBC End
		
		return "boarddetail";
	
	}
	
	

	@RequestMapping(value = "/boardWriteForm", method = RequestMethod.GET)
	public String boardWriteForm() {
		
		//System.out.println("b_no:"+b_no);
		//System.out.println("getB_no():"+invo.getB_no());
		
		//logger.info("Welcome home! The client locale is {}.", locale);
		
		

		//BoardVO detailVO = sqlSession.selectOne("BoardMapper.boardDetail");

       // model.addAttribute("detailVO", detailVO);
        //JDBC End
		
		return "boardwriteform";
	
	}
	
	@RequestMapping(value = "/boardWrite", method = RequestMethod.POST)
	public String boardWrite(Locale locale, Model model, HttpServletRequest request, String path, 
			MultipartRequest multipartRequest, BoardVO inVO) throws IOException {
		
		//MultipartFile fileData = multipartRequest.getFile("file1");
		//	System.out.println(fileName);
		
		String tmpNm = inVO.getFile1().getOriginalFilename();
		System.out.println(tmpNm);
		
		String saveFolder = "C:/tmpsave/";
		
		InputStream ins = inVO.getFile1().getInputStream();
		OutputStream outs = new FileOutputStream(saveFolder + tmpNm);
		
		FileCopyUtils.copy(ins, outs);
		
		inVO.setFile_path(saveFolder+tmpNm);
		
		int i = sqlSession.insert("BoardMapper.boardWrite", inVO);
		
		if(i == 0 ) {
			return "boardwriteerror";
		} 
		//else {
		    return "redirect:./boardList";
		//}
		//System.out.println(multipartRequest.getFile("file1"));
		//System.out.println(inVO.getB_title());
		//System.out.println(inVO.getB_writer());
		//System.out.println(inVO.getB_contents());
		//System.out.println(inVO.getFile1());
        //JDBC End
		
		//return "boardwriteform";
	
	}
	
	
	
	@RequestMapping(value = "/boardFileDown", method = RequestMethod.GET)
	public void boardFileDown(Locale locale, Model model, HttpServletResponse response, String fileName) throws IOException {
		
		
		response.setHeader("Content-Disposition", "attachment;filename="+fileName);
		
		String fullPath = "C:/tmpsave/"+ fileName;
		
		FileInputStream fis = new FileInputStream(fullPath);
		ServletOutputStream sos = response.getOutputStream();
		
		byte[] bArr = new byte[1024];
		
		int eofInt = fis.read(bArr);
		
		while (eofInt != -1 ) {
			sos.write(bArr);
			eofInt = fis.read(bArr); 
		}
		
		//System.out.println("b_no:"+b_no);
		//System.out.println("getB_no():"+invo.getB_no());
		
		//logger.info("Welcome home! The client locale is {}.", locale);
		sos.close();
		fis.close();
		

		//BoardVO detailVO = sqlSession.selectOne("BoardMapper.boardDetail");

       // model.addAttribute("detailVO", detailVO);
        //JDBC End
		
		//return "boardwriteform";
	
	}
	
	
}
