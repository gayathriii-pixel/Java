import java.util.*;
class Doctor
{
	int id;
	String name;
	public Doctor(int id,String name)
	{
		this.id=id;
		this.name=name;
	}
	@Override
	public boolean equals(Object obj)
	{
		if(this==obj)
			return true;
		if(obj==null||getClass()!=obj.getClass())
			return false;
		Doctor doctor=(Doctor) obj;
		return id==doctor.id&&name.equals(doctor.name);
	}
	@Override
	public int hashCode()
	{
		return id;
	}
	@Override
	public String toString()
	{
		return "Doctor Name:"+name+"ID:"+id;
	}
}
class Surgeon extends Doctor{
	String department;
	public Surgeon(int id,String name,String depart)
	{
		super(id,name);
		this.department=depart;
	}
	@Override
	public String toString()
	{
		return "Name:"+name+"\n"+"Department:"+department;
	}
}
public class OverrideDemo
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter name and id:");
		String name=sc.next();
		int id=sc.nextInt();
		Doctor d1=new Doctor(id,name);
		System.out.println("Enter name and id:");
		String name1=sc.next();
		int id1=sc.nextInt();
		Doctor d2=new Doctor(id1,name1);
		System.out.println("Enter name,id,department of surgeon:");
		String name2=sc.next();
		int id2=sc.nextInt();
		String dep=sc.next();
		Surgeon s1=new Surgeon(id2,name2,dep);
		System.out.println("d1 equals d2?:"+d1.equals(d2));
		System.out.println("d1 hashcode:"+d1.hashCode());
		System.out.println("Surgeon details:\n"+s1.toString());
	}
}
