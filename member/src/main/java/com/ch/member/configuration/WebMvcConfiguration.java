package com.ch.member.configuration;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ch.member.service.SessionChk;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver cmr = new CommonsMultipartResolver();
		cmr.setDefaultEncoding("utf-8");
		cmr.setMaxUploadSizePerFile(10 * 1024 * 1024); // 10M
		return cmr;
	}

	public void addInterceptors(InterceptorRegistry ir) {
		List<String> URL_PATTERNS = Arrays.asList("/**/main.do", "/**/updateForm.do", "/**/update.do", "/**/delete.do",
				"/**/view.do");
		ir.addInterceptor(new SessionChk()).addPathPatterns(URL_PATTERNS);
//			.addPathPatterns("/**/*.do")
//			.excludePathPatterns("/**/joinForm.do","/**/join.do","/**/idChk.do"
//				,"/**/loginForm.do","/**/join.do");
	}
}