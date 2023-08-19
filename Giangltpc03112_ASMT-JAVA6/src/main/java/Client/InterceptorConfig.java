package Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InterceptorConfig implements WebMvcConfigurer  {
    	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if(request.getHeader("X-Requested-With") == null) {
//			request.setAttribute("cates", categoryService.findAll());
		}
	}

}
