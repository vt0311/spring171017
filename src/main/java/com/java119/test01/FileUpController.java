package com.java119.test01;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
//import org.springframework.util.FileCopyUtils;

@Controller
public class FileUpController {
	
	@RequestMapping(value="fileuptest", method=RequestMethod.GET)
	public String fileUpTest(Locale locale, Model model) {
		return "fileuptest";
	}
	
	@RequestMapping(value="fileupload", method=RequestMethod.POST)
	public String fileUpload(Locale locale, Model model, HttpServletRequest request, String path, 
			MultipartRequest multipartRequest) throws IOException {
		
		//String fileName = request.getParameter("file1");
				
		MultipartFile fileData = multipartRequest.getFile("file1");
		//	System.out.println(fileName);
		System.out.println(multipartRequest.getFile("file1"));
		//System.out.println(fileData.getB_title());
		//System.out.println(fileData.getB_writer());
		//System.out.println(fileData.getB_contents());
		//System.out.println(fileData.getFile1());
		
		
		return "fileuptest";
	}
	
}
