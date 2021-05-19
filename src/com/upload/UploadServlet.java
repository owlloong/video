package com.upload;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.util.MyProgressListener;



/**
 * Servlet implementation class UploadServlet
 */
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {
	        
	        String progress=(String) req.getSession().getAttribute("progress");
	        
	        resp.getWriter().print(progress);
	        
//	        req.getSession().removeAttribute("progress");
	    }
	    @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {
	        req.setCharacterEncoding("UTF-8");
	        DiskFileItemFactory factory=new DiskFileItemFactory();
	        ServletFileUpload upload=new ServletFileUpload(factory);
	        upload.setProgressListener(new MyProgressListener(req));
	        try {
	            List<FileItem> list = upload.parseRequest(req);
	            for (FileItem fileItem : list) {
	                if (fileItem.isFormField()) {
	                }else{
	                    String path=req.getRealPath("uploads");
	                    String fileName=fileItem.getName();
	                    File file=new File(path, fileName);
	                    fileItem.write(file);
	                    System.out.println("shipin"+fileName);
	                }
	            }
	        } catch (Exception e) {
	            System.out.println("上传成功！");
	            e.printStackTrace();
	        }
	    }

}
