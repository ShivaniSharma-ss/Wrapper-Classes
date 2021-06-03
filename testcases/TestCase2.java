import com.thinking.machines.commonfolder.*;
class TestCase2
{
public static void main(String gg[])
{ int x[]=new int[10];
for(int y=0;y<x.length;y++)
{
x[y]=Keyboard.getInt("Enter a number : ");
} int t=0;
for(int y=0;y<x.length;y++) t+=x[y];
System.out.println("Total is : "+t);
}
}                                                                                                                                                                                                                                                                                                        