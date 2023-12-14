package com.SeleniumExpress.Config;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//dispatcher servlet initializer class
public class DSInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {MyAppConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
	
		return new String[]{"/"};
	}

}
