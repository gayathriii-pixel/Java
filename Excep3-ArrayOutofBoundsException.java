import java.lang.*;
public class ExceptionExample4
{  
  public static void main(String args[])
{  
   try
   {  
      int a[] = new int[5];
      a[7] = 9;
   }
   catch(ArrayIndexOutOfBoundsException e)
   {
      System.out.println("Array Index Out of Bounds Exception-Divison by Zero");
    }    
  }  
}  