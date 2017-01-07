package org.springframework.beans.factory;

import org.springframework.beans.BeansException;
import org.springframework.util.StringUtils;

@SuppressWarnings("serial")
public class NoSuchBeanDefinitionException extends BeansException{
	
	private String beanName;
	
	private Class<?> beanType;

	public NoSuchBeanDefinitionException(String name) {
		super("No bean named '" + name + "' is defined");
		this.beanName = name;
	}
	
	public NoSuchBeanDefinitionException(Class<?> type) {
		super("No qualifying bean of type [" + type.getName() + "] is defined");
		this.beanType = type;
	}
	
	public NoSuchBeanDefinitionException(Class<?> type, String message) {
		super("No qualifying bean of type [" + type.getName() + "] is defined: " + message);
		this.beanType = type;
	}
	
	public NoSuchBeanDefinitionException(Class<?> type, String dependencyDescription, String message) {
		super("No qualifying bean of type [" + type.getName() + "] found for dependency" +
				(StringUtils.hasLength(dependencyDescription) ? " [" + dependencyDescription + "]" : "") +
				": " + message);
		this.beanType = type;
	}
	
	public String getBeanName() {
		return this.beanName;
	}
	
	public Class<?> getBeanType() {
		return this.beanType;
	}
	
	public int getNumberOfBeansFound() {
		return 0;
	}

}
