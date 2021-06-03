import com.thinking.machines.common.*;
class eg1psp
{
public static void main(String gg[])
{
char a;
System.out.println("Enter a character:");
a=Keyboard.getCharacter();
System.out.println(a);
char b;
b=Keyboard.getCharacter("Enter another character");
System.out.println(b);
long l;
System.out.println("Enter a long value:");
l=Keyboard.getLong();
System.out.println(l);
long l1;
l1=Keyboard.getLong("Enter another long");
System.out.println(l1);
String s;
System.out.println("Enter a stringvalue:");
s=Keyboard.getString();
System.out.println(s);
String s1;
s1=Keyboard.getString("Enter another string value");
System.out.println(s1);
int i;
System.out.println("Enter a int value:");
i=Keyboard.getInt();
System.out.println(i);
int i1;
i1=Keyboard.getInt("Enter another int value");
System.out.println(i1);
}
}