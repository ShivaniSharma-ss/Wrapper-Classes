package com.thinking.machines.common;
import java.util.*;
import java.lang.reflect.*;
public class POJOCopier
{
private POJOCopier()
{
}
public static void copy(Object target,Object source)
{
List<Method> setters=new ArrayList<>();
Class targetClass=target.getClass();
Method targetMethods[];
targetMethods=targetClass.getMethods();
int e;
Method method;
String methodName;
Class parameterTypes[];
Class returnType;
for(e=0;e<targetMethods.length;e++)
{
method=targetMethods[e];
methodName=method.getName();
if(methodName.length()<=3) continue;
if(methodName.startsWith("set")==false) continue;
parameterTypes=method.getParameterTypes();
if(parameterTypes.length!=1) continue;
returnType=method.getReturnType();
if(returnType.getName().equals("void")==false) continue;
char m=methodName.charAt(3);
if(m<65 || m>90) continue;
setters.add(method);
}
if(setters.size()==0) return;
List<Method>getters=new ArrayList<>();
Class sourceClass=source.getClass();
Method setterMethod;
Method  getterMethod;
int kkk=0;
String getterName;
String setterName;
String propertyName;
Class getterMethodReturnType;
while(kkk<setters.size())
{
setterMethod=setters.get(kkk);
parameterTypes=setterMethod.getParameterTypes();
setterName=setterMethod.getName();
propertyName=setterName.substring(3);
getterName="get"+propertyName;
try
{
getterMethod=sourceClass.getMethod(getterName,new Class[0]);
getterMethodReturnType=getterMethod.getReturnType();
if(getterMethodReturnType.equals(parameterTypes[0])==false)
{
setters.remove(kkk);
continue;
}
getters.add(getterMethod);
}
catch(NoSuchMethodException nsme)
{
setters.remove(kkk);
continue;
}
kkk++;
}
Object getterResult;
kkk=0;
while(kkk<setters.size())
{
setterMethod=setters.get(kkk);
getterMethod=getters.get(kkk);
try
{
getterResult=getterMethod.invoke(source,new Object[0]);
Class getterResultClass=getterResult.getClass();
if(isPrimitive(getterResultClass))
{
setterMethod.invoke(target,getterResult);
}
else
{
try
{
Object getterResultClassObject;
getterResultClassObject=getterResultClass.newInstance();
copy(getterResultClassObject,getterResult);
setterMethod.invoke(target,getterResultClassObject);
}
catch(Exception exception)
{
//do nothing
}
}
}
catch(Exception eee)
{
//do nothing
}
kkk++;
}
}
public static boolean isPrimitive(Class c)
{
String typeName=c.getName();
if(typeName.equals("long")==true || typeName.equals("java.lang.Long"))return true;
if(typeName.equals("int")==true || typeName.equals("java.lang.Integer"))return true;
if(typeName.equals("short")==true || typeName.equals("java.lang.Short"))return true;
if(typeName.equals("byte")==true || typeName.equals("java.lang.Byte"))return true;
if(typeName.equals("double")==true || typeName.equals("java.lang.Double"))return true;
if(typeName.equals("float")==true || typeName.equals("java.lang.Float"))return true;
if(typeName.equals("char")==true || typeName.equals("java.lang.Character"))return true;
if(typeName.equals("boolean")==true || typeName.equals("java.lang.Boolean"))return true;
if(typeName.equals("java.lang.String")==true )return true;
return false;
}
}