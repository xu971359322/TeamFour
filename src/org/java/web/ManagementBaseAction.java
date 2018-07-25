package org.java.web;

import java.util.ArrayList;
import java.util.List;


import com.opensymphony.xwork2.ActionSupport;
import org.java.service.impl.ShowUserServiceImpl;


public class ManagementBaseAction extends ActionSupport{
	 protected ShowUserServiceImpl inf =new ShowUserServiceImpl();
}
