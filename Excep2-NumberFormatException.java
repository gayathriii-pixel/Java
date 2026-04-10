import java.lang.*;
public class ExceptionExample3
{  
  public static void main(String args[])
{  
   try
   {  
      int num = Integer.parseInt("java");
      System.out.println(num);
   }
   catch(NumberFormatException e)
   {
      System.out.println("Number Format Exception" + e);
    }    
  }  
}  