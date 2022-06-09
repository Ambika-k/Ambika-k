package com.zensar.springCoreAutowireEx1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zensar.beans.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        Employee emp= context.getBean("emp1",Employee.class);
        System.out.println(emp);
    }
}
