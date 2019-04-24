package com.qf.with_my_car.interceptor;

import com.qf.with_my_car.pojo.Member;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@Component
public class LoginInterceptor implements HandlerInterceptor {
//    @Override
/*    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("权限拦截");
        String uri = request.getRequestURI();//请求路径
//		System.out.println("request URI："+uri);
        if(handler instanceof HandlerMethod){//是否为处理器的方法
            HandlerMethod handlerMethod = (HandlerMethod)handler;
            Object bean = handlerMethod.getBean();//获取方法的对象
            if(bean instanceof BaseController ){//需要登录后才可访问的资源
                HttpSession session = request.getSession(true);
                Object user = session.getAttribute("user");
                if(user==null){
//				导航到登陆页
                    request.getRequestDispatcher("login").forward(request, response);
                }
            }
        }
        return true;
    }*/
    @Override
    //这个方法是在访问接口之前执行的，我们只需要在这里写验证登陆状态的业务逻辑，就可以在用户调用指定接口之前验证登陆状态了
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //每一个项目对于登陆的实现逻辑都有所区别，我这里使用最简单的Session提取User来验证登陆。
        HttpSession session = request.getSession();
        //这里的User是登陆时放入session的
        Member user = (Member) session.getAttribute("user");
        //如果session中没有user，表示没登陆
        if (user == null){
            //这个方法返回false表示忽略当前请求，如果一个用户调用了需要登陆才能使用的接口，如果他没有登陆这里会直接忽略掉
            //当然你可以利用response给用户返回一些提示信息，告诉他没登陆
//            request.getRequestDispatcher("/login").forward(request,response);
            response.sendRedirect("/login");
//            return false;
        }else {
            return true;    //如果session里有user，表示该用户已经登陆，放行，用户即可继续调用自己需要的接口
        }
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
