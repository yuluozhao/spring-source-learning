package org.springframework.beans.factory;

import org.springframework.beans.BeansException;
import org.springframework.core.ResolvableType;

/**
 * 1.BeanFactory是Spring容器的Root Interface
 * 
 * 2.BeanFactory的作用是持有一定数量的Bean
 *   Definition，每一个都有一个独有的String名字。BeanFactory可以返回单例或多例的对象，取决于Bean定义文件。
 * 
 * 3. 通过setters,constructors进行依赖注入更好，其实这也是常用的方法
 * 
 * 4. BeanFactory通过载入配置源文件(XML文件)的方式，来配置Bean。
 * 
 * 5. BeanFactory支持的bean生命周期的顺序 
 * 
 * @author ylz
 *
 */
public interface BeanFactory {

	//使用转义符&来得到FactoryBean本身，用来区分通过容器获得FactoryBean本身和其产生的对象
	String FACTORY_BEAN_PREFIX = "&";

	//根据bean的名字和Class类型来得到bean实例，增加了类型安全验证机制
	Object getBean(String name) throws BeansException;

	//通过Bean类型获取bean实例
	<T> T getBean(String name, Class<T> requiredType) throws BeansException;

	 //增加更多获取的条件，同上方法
	<T> T getBean(Class<T> requiredType) throws BeansException;

	Object getBean(String name, Object... args) throws BeansException;

	<T> T getBean(Class<T> requiredType, Object... args) throws BeansException;

	//判断容器是否含有指定名字的bean
	boolean containsBean(String name);

	//查询指定名字的Bean是不是单例的Bean
	boolean isSingleton(String name) throws NoSuchBeanDefinitionException;

	//判断Bean是不是prototype类型的bean
	boolean isPrototype(String name) throws NoSuchBeanDefinitionException;
	
	boolean isTypeMatch(String name, ResolvableType typeToMatch) throws NoSuchBeanDefinitionException;

	//查询指定了名字的Bean的Class类型是否与指定类型匹配
	boolean isTypeMatch(String name, Class<?> typeToMatch) throws NoSuchBeanDefinitionException;

	 //获取指定名字bean的Class类型
	Class<?> getType(String name) throws NoSuchBeanDefinitionException;

	//查询指定了名字的bean的所有别名，这些别名都是在BeanDefinition中定义的
	String[] getAliases(String name);

}
