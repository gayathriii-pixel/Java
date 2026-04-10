import java.util.*;
interface Shape 
{
    double pi = Math.PI;
    double calculateArea();
    double calculateVolume();
}
class Sphere implements Shape 
{
    double radius;
    public Sphere(double radius) 
    {
        this.radius = radius;
    }
    @Override
    public double calculateArea() 
    {
        return 4 * pi * radius * radius;
    }
    @Override
    public double calculateVolume() 
    {
        return (4.0 / 3.0) * pi * radius * radius * radius;
    }
}
class Cylinder implements Shape 
{
    double radius;
    double height;
    public Cylinder(double radius,double height) 
    {
        this.radius = radius;
        this.height = height;
    }
    @Override
    public double calculateArea() 
    {
        return 2 * pi * radius*(radius+height);
    }
    @Override
    public double calculateVolume() 
    {
        return pi * radius * radius * height;
    }
}
class Cone implements Shape 
{
    double radius;
    double height;
    public Cone(double radius,double height) 
    {
        this.radius = radius;
        this.height = height;
    }
    @Override
    public double calculateArea() 
    {
        double l = Math.sqrt(radius * radius + height * height);
        return pi * radius*(radius + l);
    }
    @Override
    public double calculateVolume() 
    {
        return (1.0 / 3.0) * pi * radius * radius * height;
    }
}
public class Shapes
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("=============MENU=============\n1.SPHERE\n2.CYLINDER\n3.CONE");
        System.out.println("ENTER YOUR CHOICE:");
        int choice = sc.nextInt();
        switch(choice)
        {
            case 1:
                {
                    System.out.println("ENTER RADIUS OF SPHERE:");
                    double r = sc.nextDouble();
                    Sphere s = new Sphere(r);
                    System.out.println("AREA OF SPHERE : "+s.calculateArea());
                    System.out.println("VOLUME OF SPHERE : "+s.calculateVolume());
                    break;
                }
            case 2:
                {
                    System.out.println("ENTER RADIUS OF CYLINDER:");
                    double r = sc.nextDouble();
                    System.out.println("ENTER HEIGHT OF THE CYLINDER:");
                    double h = sc.nextDouble();
                    Cylinder cy = new Cylinder(r,h);
                    System.out.println("AREA OF CYLINDER : "+cy.calculateArea());
                    System.out.println("VOLUME OF CYLINDER : "+cy.calculateVolume());
                    break;
                }
            case 3:
                {
                    System.out.println("ENTER RADIUS OF CONE:");
                    double r = sc.nextDouble();
                    System.out.println("ENTER HEIGHT OF THE CONE:");
                    double h = sc.nextDouble();
                    Cone c = new Cone(r,h);
                    System.out.println("AREA OF CONE : "+c.calculateArea());
                    System.out.println("VOLUME OF CONE : "+c.calculateVolume());
                    break;
                }
            default:
                {
                    System.out.println("INVALID CHOICE!");
                    break;
                }
        }
    }
}

