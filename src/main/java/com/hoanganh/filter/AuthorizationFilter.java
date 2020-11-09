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

import com.hoanganh.model.UserModel;
import com.hoanganh.utils.SessionUtil;

public class AuthorizationFilter implements Filter {

	private ServletContext context;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.context = filterConfig.getServletContext();

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String url = request.getRequestURI();
		if (url.startsWith("/Jsp-Servlet/admin")) {
			UserModel model = (UserModel) SessionUtil.getInstance().getValue(request, "MODEL");
			if (model != null) {
				if (model.getRole().getCode().equals("ADMIN")) {
					filterChain.doFilter(servletRequest, servletResponse);
				} else if (model.getRole().getCode().equals("USER")) {
					response.sendRedirect(
							request.getContextPath() + "/dang-nhap?action=login&message=Not Permission&alert=danger");
				}
			} else {
				response.sendRedirect(
						request.getContextPath() + "/dang-nhap?action=login&message=Not Login&alert=danger");
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
