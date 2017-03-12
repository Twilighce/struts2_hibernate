package service.impl;

import junit.framework.Assert;

import org.junit.Test;

import entity.Users;

public class TestUsersDAOImpl {
	
	
	@Test
	public void testUsersLogin(){
		Users u =new Users(1,"zhangsan","123456");
		UsersDAOImpl udao=new UsersDAOImpl();
		Assert.assertEquals(true, udao.userLogin(u)); 
	}
}
