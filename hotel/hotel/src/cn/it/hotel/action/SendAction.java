package cn.it.hotel.action;
/*
 * (此action用来处web-inf中jsp与jsp页面的转发功能，不处理业务逻辑)
 */

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller
public class SendAction extends ActionSupport {
	
	public SendAction(){
		System.out.println("---SendAction---");
	}
	public String execute(){
		return "send";
	}
}
