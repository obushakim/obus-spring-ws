package org.obus.test.obus_spring_ws.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
	
	@Bean
	public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext context) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(context);
		servlet.setTransformWsdlLocations(true);
		
		return new ServletRegistrationBean<MessageDispatcherServlet>(servlet, "/obus/*");
	}
	
	@Bean(name="karyawan")
	public DefaultWsdl11Definition karyawanDefinition(XsdSchema karyawanSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("KaryawanPort");
		wsdl11Definition.setLocationUri("/obus");
		wsdl11Definition.setTargetNamespace("http://obus.org/test/obus-spring-ws");
		wsdl11Definition.setSchema(karyawanSchema);
		return wsdl11Definition;
	}
	
	@Bean
	public XsdSchema karyawanSchema() {
		return new SimpleXsdSchema(new ClassPathResource("karyawan.xsd"));
	}

}
