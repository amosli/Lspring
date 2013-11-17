package com.lspring.ioc;

import java.beans.BeanDescriptor;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
class Person {
 
 private String name;
 
 private int age;
 
 public int getAge() {
  return age;
 }
 
 public void setAge(int age) {
  this.age = age;
 }
 
 public String getName() {
  return name;
 }
 
 public void setName(String name) {
  this.name = name;
 }
 
}
public class IntrospectorTest {
 
 public static void main(String[] args) throws IntrospectionException {
  // TODO Auto-generated method stub
  BeanInfo beanInfo = Introspector.getBeanInfo(Person.class);
  
  System.out.println("BeanDescriptor===========================================");
  BeanDescriptor beanDesc = beanInfo.getBeanDescriptor();
  Class cls = beanDesc.getBeanClass();
  System.out.println(cls.getName());
  
  System.out.println("MethodDescriptor===========================================");
  MethodDescriptor[] methodDescs = beanInfo.getMethodDescriptors();
  for (int i = 0; i < methodDescs.length; i++) {
   Method method = methodDescs[i].getMethod();
   System.out.println(method.getName());
  }
  
  System.out.println("PropertyDescriptor===========================================");
  PropertyDescriptor[] propDescs = beanInfo.getPropertyDescriptors();
  for (int i = 0; i < propDescs.length; i++) {
   Method methodR = propDescs[i].getReadMethod();
   if (methodR != null) {
    System.out.println(methodR.getName());
   }
   Method methodW = propDescs[i].getWriteMethod();
   if (methodW != null) {
    System.out.println(methodW.getName());
   }
  }
 }
}