package com.example.democrud;

import java.util.EnumSet;

import javax.faces.webapp.FacesServlet;
import javax.servlet.DispatcherType;
import javax.servlet.Servlet;

import org.ocpsoft.rewrite.servlet.RewriteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoCrudApplication.class, args);
	}
    @Bean
    public ServletRegistrationBean<Servlet> servletRegistrationBean() {
        FacesServlet servlet = new FacesServlet();
        return new ServletRegistrationBean<Servlet>(servlet, "*.jsf");
    }

    @Bean
    public FilterRegistrationBean<RewriteFilter> rewriteFilter() {
        FilterRegistrationBean<RewriteFilter> rwFilter = new FilterRegistrationBean<RewriteFilter>(new RewriteFilter());
        rwFilter.setDispatcherTypes(EnumSet.of(DispatcherType.FORWARD, DispatcherType.REQUEST,
                DispatcherType.ASYNC, DispatcherType.ERROR));
        rwFilter.addUrlPatterns("/*");
        return rwFilter;
    }
}
