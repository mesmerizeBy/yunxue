package yunxue.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import yunxue.dao.PersonalinfoDao;
import yunxue.dao.PersonalinfoDaoImpl;
import yunxue.mo.TidentityMo;
import yunxue.mo.UserMo;

/**
 * Servlet implementation class Tidentity
 */
@WebServlet("/tidentity.do")
public class Tidentity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tidentity() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext servletContext = getServletConfig().getServletContext();

		String realPath = servletContext.getRealPath("/");

		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		factory.setRepository(new File(realPath));

		factory.setSizeThreshold(1024 * 1024 * 20);

		ServletFileUpload upload = new ServletFileUpload(factory);

		List items = null;
		
		String fosPath="";
		
		try {
			items = upload.parseRequest(request);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}

		String tIdcardImg="";
		String tStudentcardImg="";
		HttpSession session =request.getSession();
		UserMo s=(UserMo) session.getAttribute("tealoginer");
		int teacherNo=s.getUserNo();
		String tIdcard="";
		String fosName="";
		for (int i = 0; i < items.size(); i++) {
			FileItem item = (FileItem) items.get(i);

			if (!item.isFormField()){

			    String fieldName = item.getFieldName();
				String fileName = item.getName();
			    
				if(fieldName.equals("teacherImg2")){
					if(fileName==null){
						tIdcardImg="0";
				    }
					else{
					fosPath=System.currentTimeMillis()
			        + fileName.substring(fileName.lastIndexOf("."),fileName.length());
					fosName=realPath+"/IMG/teacherIdIMG/"+fosPath;
					tIdcardImg=fosPath;
					}
				}
				else{
					if(fileName==null){
						tStudentcardImg="0";
				    }
					else{
					fosPath=System.currentTimeMillis()
			        + fileName.substring(fileName.lastIndexOf("."),fileName.length());
					fosName=realPath+"/IMG/teacherIdIMG2/"+fosPath;
					tStudentcardImg=fosPath;
					}
				}
				
				try{
				   File file=new File(fosName);
				   item.write(file);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			else{
				   if(item.getName()==null){
					   tIdcard="0";
				   }
				   else{
				   tIdcard=item.getName();
				   }
				}
		}

		try{
			
			PersonalinfoDao personal=new PersonalinfoDaoImpl();
			TidentityMo tt=new TidentityMo();
			tt.setTeacherNo(teacherNo);
			tt.settIdcard(tIdcard);
			tt.settIdcardImg(tIdcardImg);
			tt.settStudentcardImg(tStudentcardImg);
			personal.updateTeacher2(tt);
		
	}catch(Exception e){
		e.printStackTrace();
	}
		
		response.sendRedirect(request.getContextPath()+"/TidentityStep3.do");
  }

}
