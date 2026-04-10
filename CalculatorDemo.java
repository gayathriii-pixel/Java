import java.util.*;
import java.lang.*;
interface operation
{
	int operate(int a,int b);
} 
public class calculatorDemo
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter two numbers:");
		int x=sc.nextInt();
		int y=sc.nextInt();
		System.out.println("MENU\n 1.ADD\n 2.SUB\n 3.MUL\n 4.DIV");
			int ch=sc.nextInt();
			switch(ch)
		{
			case 1:
			{
				operation add=(a,b)->a+b;
				System.out.println("Addition:"+add.operate(x,y));
			}
			break;
			case 2:
			{
				operation sub=(a,b)->a-b;
				System.out.println("Subtraction:"+sub.operate(x,y));
			}
			break;
			case 3:
			{
				operation mul=(a,b)->a*b;
				System.out.println("Multiplication:"+mul.operate(x,y));
			}
			break;
			case 4:
			{
				operation div=(a,b)->a/b;
				System.out.println("Division:"+div.operate(x,y));
			}
			break;
		}
	}
}