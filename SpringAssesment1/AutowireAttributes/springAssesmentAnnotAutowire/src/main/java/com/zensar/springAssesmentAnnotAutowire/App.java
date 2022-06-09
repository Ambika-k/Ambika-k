package com.zensar.springAssesmentAnnotAutowire;

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
         Employee emp2= context.getBean("emp2",Employee.class);
         Employee emp3= context.getBean("emp3",Employee.class);
         System.out.println(emp);
         System.out.println(emp2);
         System.out.println(emp3);
    }
}
