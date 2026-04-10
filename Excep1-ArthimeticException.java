import java.lang.*;
public class ExceptionExample2
{  
  public static void main(String args[])
{  
   try
   {  
      //code that may raise exception  
      int data=100/0;  
   }
   catch(ArithmeticException e)
   {
      System.out.println("Arthimatic Exception-Divison by Zero" + e);
    }    
  }  
}  