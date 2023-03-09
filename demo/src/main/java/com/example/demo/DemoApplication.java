package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = { "hello", "Bean" })
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		// System.out.println(context.getBean("myBean"));
		String[] beanNames = context.getBeanDefinitionNames();
		for(String name: beanNames) {
			if (!(name.startsWith("org.") || name.startsWith("spring.")))
				System.out.println(name);
		}

		MyBean bean = (MyBean) context.getBean("myBean");
		System.out.println(bean);
//		Person p = (Person) context.getBean(Person.class);
		Person p = (Person) context.getBean("myPerson");
		System.out.println(p);
	}

}
