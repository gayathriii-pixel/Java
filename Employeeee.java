
    class Employee
	 {
	   String ename="Nivi";
		int eid=135;
		int eage=23;
		double ebp=80000;
		String egender="Female";
		String edeptname="CSE";
		String edesignation="HR";
		String ecity="Bangalore";
		void display()
		{
		  System.out.println("EMPLOYEE NAME:"+ ename);
		  System.out.println("EMPLOYEE ID:" + eid);
		  System.out.println("EMPLOYEE AGE:" + eage);
		  System.out.println("BASIC PAY:" + ebp);
		  System.out.println("GENDER:" + egender);
		  System.out.println("DEPARTMENT NAME:" + edeptname);
		  System.out.println("DESIGNATION:" + edesignation);
		  System.out.println("EMPLOYEE CITY:" + ecity);
	   }
		void computeSalary()
		{
		  double hra,da,incomeTax=0,grossSal,netSal;
		  hra=0.1* ebp;
		  da=0.3* ebp;
		  grossSal=ebp+hra+da;
		  if (grossSal>100000)
			{
		   incomeTax=0.1*grossSal;
			}
			netSal=grossSal - incomeTax;
			System.out.println("INCOME TAX:" + incomeTax);
			System.out.println("GROSS SALARY:" + grossSal);
			System.out.println("NET SALARY:" + netSal);
	   }
	}
	public class Employeeee
	{
	  public static void main(String args[])
	  {
	    Employeeee e=new Employeeee();
            e.display();
            e.computeSalary();
	   }
	}		