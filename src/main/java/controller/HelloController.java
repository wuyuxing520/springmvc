package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
 * ���дһ����������
 * 1.����ʵ��Controller�ӿ�
 * 2.�����ڴ������൱�У���Ӷ��������
 * ÿһ����������һ�����͵�����
 * 3.����������Ҫ�󣬷������Ϳ�����ModelAndView��
 * Ҳ������String
 * 4.ʹ��@Controller�����ô����������������й���
 * ��Ҳ����˵��spring�����ļ��������øô�������)
 * 5.ʹ��@RequestMapping������ǰ�˿�������DispatcherServlet����
 * ����·���봦�����ķ�����Ӧ��ϵ������spring�����ļ���������HandlerMapping�ˣ�
 */
@Controller
public class HelloController  {
	@RequestMapping("/hello.do")
	public String hello() {
		System.out.println("hello()");
		return "hello";
	}
	@RequestMapping("/toLogin.do")//ģ����ʵ�¼ҳ��
	public String toLogin() {
		System.out.println("toLogin()");
		return "login";
	}
	@RequestMapping("/login.do")//�ύ��¼���ҳ����
	public String login1(String adminCode,
			@RequestParam("pwd") String password,HttpServletRequest request) {
		System.out.println("login1()");
		/*��ȡ���������ֵ�������֣�������ֻдһ�֣���
		ʹ��ע��@RequestParam*/
		System.out.println("�˺ţ�"+adminCode+"���룺"+password);
		/*��ҳ�洫ֵ�������ַ�ʽ�����ｲһ�֡�����ȡ���������ֵ�󶨵�request����
		 * Ȼ��Ĭ��ת����springmvcĬ�ϻ�ʹ��ת����
		 * */
		request.setAttribute("adminCode", adminCode);
		return "index";//��ͼ����������ҳ�棬���ҽ��������͵�ҳ��
	}
}
