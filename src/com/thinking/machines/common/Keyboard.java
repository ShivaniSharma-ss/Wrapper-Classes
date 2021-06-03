package com.thinking.machines.common;
import java.io.*;
public class Keyboard
{
private Keyboard()
{
}
private static InputStreamReader inputStreamReader;
private static BufferedReader bufferedReader;
static
{
inputStreamReader=new InputStreamReader(System.in);
bufferedReader=new BufferedReader(inputStreamReader);
}
public static char getCharacter()
{
char a;
try
{
a=(char)bufferedReader.read();
while(bufferedReader.ready()) bufferedReader.read();
}catch(IOException ioException)
{
a=0;
System.out.println(ioException);
}
return a;
}
public static char getCharacter(String message)
{
System.out.print(message);
return getCharacter();
}
public static int getInt()
{
int a;
try
{
a=Integer.parseInt(bufferedReader.readLine());
}catch(IOException ioException)
{
a=0;
System.out.println(ioException);
}
catch(NumberFormatException nfe)
{
a=0;
System.out.println(nfe);
}
return a;
}
public static int getInt(String message)
{
System.out.print(message);
return getInt();
}
public static long getLong()
{
long a;
try
{
a=Long.parseLong(bufferedReader.readLine());
}catch(IOException ioException)
{
a=0;
System.out.println(ioException);
}
catch(NumberFormatException nfe)
{
a=0;
System.out.println(nfe);
}
return a;
}
public static long getLong(String message)
{
System.out.print(message);
return getLong();
}
public static short getShort()
{
short a;
try
{
a=Short.parseShort(bufferedReader.readLine());
}catch(IOException | NumberFormatException exception)
{
a=0;
System.out.println(exception);
}
return a;
}
public static short getShort(String message)
{
System.out.print(message);
return getShort();
}
public static byte getByte()
{
byte a;
try
{
a=Byte.parseByte(bufferedReader.readLine());
}catch(IOException | NumberFormatException exception)
{
a=0;
System.out.println(exception);
}
return a;
}
public static byte getByte(String message)
{
System.out.print(message);
return getByte();
}
public static float getFloat()
{
float a;
try
{
a=Float.parseFloat(bufferedReader.readLine());
}catch(IOException | NumberFormatException exception)
{
a=0.0f;
System.out.println(exception);
}
return a;
}
public static float getFloat(String message)
{
System.out.print(message);
return getFloat();
}
public static double getDouble()
{
double a;
try
{
a=Double.parseDouble(bufferedReader.readLine());
}catch(IOException | NumberFormatException exception)
{
a=0.0;
System.out.println(exception);
}
return a;
}
public static double getDouble(String message)
{
System.out.print(message);
return getDouble();
}
public static String getString()
{
String a;
try
{
a=bufferedReader.readLine();
}catch(IOException ioException)
{
a="";
System.out.println(ioException);
}
return a;
}
public static String getString(String message)
{
System.out.print(message);
return getString();
}
}