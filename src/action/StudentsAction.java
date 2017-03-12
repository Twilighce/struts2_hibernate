package action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import entity.Students;
import service.StudentsDAO;
import service.impl.StudentsDAOImpl;

public class StudentsAction extends SuperAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	//查询所有学生的动作
	public String query(){
		StudentsDAO sdao=new StudentsDAOImpl();
		List<Students> list=sdao.queryAllStudents();
		
		//放进session中
		if(list!=null&&list.size()>0){
			session.setAttribute("students_list", list);
			//return "Students_query_success";
		}
		
		return "query_success";
	}
	
	public String add() throws ParseException{
		Students s=new Students();
		s.setSname(request.getParameter("sname"));
		s.setGender(request.getParameter("gender"));
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyy-MM-dd");
		s.setBirthday(sdf.parse(request.getParameter("birthday")));
		s.setAddress(request.getParameter("address"));
		StudentsDAO sdao=new StudentsDAOImpl();
		sdao.addStudents(s);
		return "add_success";
	}
	
	
	//删除学生的动作
	public String delete(){
		StudentsDAO sdao=new StudentsDAOImpl();
		String sid=request.getParameter("sid");
		sdao.deleteStudents(sid);//调用删除方法
		return "delete_success";
	}
	
	//修改学生资料
	public String modify(){
		//获得传递过来的学生编号
		String sid=request.getParameter("sid");
		StudentsDAO sdao=new StudentsDAOImpl();
		Students s=sdao.queryStudentsById(sid);
		//保留在会话中
		session.setAttribute("modify_students", s);
		return "modify_success";
	}
	
	//保存修改后的学生资料
	public String save() throws ParseException{
		Students s=new Students();
		s.setSid(request.getParameter("sid"));
		s.setSname(request.getParameter("sname"));
		s.setGender(request.getParameter("gender"));
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyy-MM-dd");
		s.setBirthday(sdf.parse(request.getParameter("birthday")));
		s.setAddress(request.getParameter("address"));
		StudentsDAO sdao=new StudentsDAOImpl();
		sdao.updateStudents(s);
		return "save_success";
		
	}
}
