package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
 * 如何写一个处理器：
 * 1.不用实现Controller接口
 * 2.可以在处理器类当中，添加多个方法，
 * 每一个方法处理一种类型的请求
 * 3.方法名不做要求，返回类型可以是ModelAndView，
 * 也可以是String
 * 4.使用@Controller，将该处理器纳入容器进行管理。
 * （也就是说，spring配置文件不用配置该处理器了)
 * 5.使用@RequestMapping，告诉前端控制器（DispatcherServlet），
 * 请求路径与处理器的方法对应关系。。（spring配置文件不用配置HandlerMapping了）
 */
@Controller
public class HelloController  {
	@RequestMapping("/hello.do")
	public String hello() {
		System.out.println("hello()");
		return "hello";
	}
	@RequestMapping("/toLogin.do")//模拟访问登录页面
	public String toLogin() {
		System.out.println("toLogin()");
		return "login";
	}
	@RequestMapping("/login.do")//提交登录后的页处理
	public String login1(String adminCode,
			@RequestParam("pwd") String password,HttpServletRequest request) {
		System.out.println("login1()");
		/*读取请求参数的值（有三种，这里我只写一种），
		使用注解@RequestParam*/
		System.out.println("账号："+adminCode+"密码："+password);
		/*向页面传值：有三种方式，这里讲一种。将读取的请求参数值绑定到request对象，
		 * 然后默认转发（springmvc默认会使用转发）
		 * */
		request.setAttribute("adminCode", adminCode);
		return "index";//视图解析器生成页面，并且将参数传送到页面
	}
}
