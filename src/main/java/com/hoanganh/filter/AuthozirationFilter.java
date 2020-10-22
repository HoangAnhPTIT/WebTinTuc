package com.hoanganh.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hoanganh.constant.SystemConstant;
import com.hoanganh.model.UserModel;
import com.hoanganh.ultis.SessionUtil;

public class AuthozirationFilter implements Filter {

	private ServletContext context;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.context = filterConfig.getServletContext();
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) servletRequest; 
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String url = request.getRequestURI();
		if(url.startsWith("/jps-servlet/admin")) {
			UserModel model = (UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
			if(model!=null) {
				if(model.getRole().getCode().equals(SystemConstant.ADMIN)) {
					filterChain.doFilter(servletRequest, servletResponse);
				} else if(model.getRole().getCode().equals(SystemConstant.USER)) {
					response.sendRedirect(request.getContextPath() + "/dang-nhap?action=login&message=not-permission&alert=danger");
				}
			} else {
				response.sendRedirect(request.getContextPath() + "/dang-nhap?action=login&message=not-login&alert=danger");
			}
		} else {
			filterChain.doFilter(servletRequest, servletResponse);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
