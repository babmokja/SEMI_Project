package com.BoB.mvc.common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.BoB.mvc.common.config.ConfigLocation;

/**
 * Servlet Filter implementation class ContextConfigFilter
 */
@WebFilter("/*")
public class ContextConfigFilter implements Filter {

    public ContextConfigFilter() { }

	public void destroy() { }

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		/* DB 접속 설정 정보 파일의 경로가 비어있는 경우 초기화 작업 */
		if(ConfigLocation.CONNECTION_CONFIG_LOCATION == null) {
			
			String root = request.getServletContext().getRealPath("/");
			String connectionInfoPath = request.getServletContext().getInitParameter("connection-info");
			
			System.out.println("DB접속경로 설정 완료!!");
			System.out.println("경로 : " + root + "/" + connectionInfoPath);
			
			ConfigLocation.CONNECTION_CONFIG_LOCATION = root + "/" + connectionInfoPath;
		}
		
		/* 매버폴더안의 xml을 초기화하는 작업 */
		if(ConfigLocation.MAPPER_LOCATION == null) {
			
			String root = request.getServletContext().getRealPath("/");
			String mapperLocation = request.getServletContext().getInitParameter("mapper-location");
			
			System.out.println("매퍼경로 설정 완료!!");
			System.out.println("경로 : " + root + "/" + mapperLocation);
			
			ConfigLocation.MAPPER_LOCATION = root + "/" + mapperLocation;
		}
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
