package ua.training.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import ua.training.objects.User;

public class CheckUsersInterceptor extends HandlerInterceptorAdapter {
	
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
		if(request.getRequestURI().contains("check-user")){
			User user = (User) modelAndView.getModel().get("user");
			if(user == null || !user.getAdmin()) {
				response.sendRedirect(request.getContextPath() + "/failed");
				//System.out.println("sendRedirect");
			}
		}	
	}
	

}
