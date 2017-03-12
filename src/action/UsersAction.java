package action;

import javax.persistence.metamodel.SetAttribute;

import org.apache.struts2.interceptor.validation.SkipValidation;

import service.UsersDAO;
import service.impl.UsersDAOImpl;

import com.opensymphony.xwork2.ModelDriven;

import entity.Users;


//ģ����ķ���
public class UsersAction extends SuperAction implements ModelDriven<Users>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Users user=new Users();
	
	//�û���¼����
	public String login(){
		UsersDAO udao=new UsersDAOImpl();
		if(udao.userLogin(user)){
			//在session中保存登陆成功的用户名
			session.setAttribute("loginUserName", user.getUsername());
			
			System.out.println("登陆成功"+":"+user.getUsername()+":"+user.getPassword());
			return "login_success";
		}
		else{
			
			//System.out.println("登陆失败"+":"+users.getUsername()+":"+users.getPassword());
			System.out.println("登陆失败"+":"+user);
			return "login_failure";
		}
	} 
	
	//用户注销
	@SkipValidation  //不进行表单验证
	public String logout(){
		if(session.getAttribute("loginUserName")!=null){
			session.removeAttribute("loginUserName");
		}
		
		return "logout_success";
	}
	

	@Override
	public Users getModel() {
		// TODO Auto-generated method stub
		return this.user;
	}

	@Override
	public void validate() {	//此方法会对所有的表单进行验证
		//用户名不能为空
		if("".equals(user.getUsername().trim())){
			this.addFieldError("usernameError", "用户名不能为空！");
			
			System.out.println("用户名不能为空");
		}
		
		if(user.getPassword().length()<1){
			this.addFieldError("passwordError", "密码长度不能过短");
			System.out.println("密码长度不能过短");
		}
		
		System.out.println("当前用户的信息"+user.getUsername()+":"+user.getPassword());
	}

	
	
	
}
