package org.obus.test.obus_spring_ws.config;

import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Component
public class KuliConfig {
	@Bean(name="kuli")
	public DefaultWsdl11Definition kuliDefinition(XsdSchema kuliSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("KuliPort");
		wsdl11Definition.setLocationUri("/obus");
		wsdl11Definition.setTargetNamespace("http://obus.org/test/obus-spring-ws");
		wsdl11Definition.setSchema(kuliSchema);
		return wsdl11Definition;
	}
	
	@Bean
	public XsdSchema kuliSchema() {
		return new SimpleXsdSchema(new ClassPathResource("kuli.xsd"));
	}
}
