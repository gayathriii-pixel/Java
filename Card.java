import java.util.*;
abstract class CreditCard 
{
    String hname;
    String cdno;
    double maxlmt;

    public CreditCard(String hname, String cdno, double maxlmt) 
    {
        this.hname = hname;
        this.cdno = cdno;
        this.maxlmt = maxlmt;
    }

    public void displayDetails() 
    {
        System.out.println("Card Holder: " + hname);
        System.out.println("Card Number: " + cdno);
        System.out.println("Maximum Credit Limit: " + maxlmt);
    }
    public abstract double calculateBill(double pamt);
}
class SilverCard extends CreditCard 
{
    public SilverCard(String hname, String cdno) 
    {
        super(hname, cdno, 200000.00); 
    }
    @Override
    public double calculateBill(double pamt) 
    {
        if (pamt<=200000)
        {
            return pamt;
        }
        else
        {
            Scanner sc1 = new Scanner(System.in); 
            System.out.println("PURCHASE AMOUNT IS BEYOND THE LIMIT OF CHOSEN CARD!");
            System.out.println("ENTER A VALID PURCHASE AMOUNT:");
            double newpamt = sc1.nextDouble();
            return calculateBill(newpamt);
        }
    }
}
class GoldCard extends CreditCard 
{
    public GoldCard(String hname, String cdno) 
    {
        super(hname, cdno, 500000.00);
    }
    @Override
    public double calculateBill(double pamt) 
    {
        if (pamt<=500000)
        {
            return pamt - (pamt * 0.05);
        }
        else
        {
            Scanner sc2 = new Scanner(System.in); 
            System.out.println("PURCHASE AMOUNT IS BEYOND THE LIMIT OF CHOSEN CARD!");
            System.out.println("ENTER A VALID PURCHASE AMOUNT:");
            double newpamt = sc2.nextDouble();
            return calculateBill(newpamt);  
        }
    }
}
class PlatinumCard extends CreditCard 
{
    public PlatinumCard(String hname, String cdno) 
    {
        super(hname, cdno, 1000000.00); 
    }
    @Override
    public double calculateBill(double pamt) 
    {
        if (pamt<=1000000)
        {
            return pamt - (pamt * 0.10);
        }
        else
        {
            Scanner sc3 = new Scanner(System.in);  
            System.out.println("PURCHASE AMOUNT IS BEYOND THE LIMIT OF CHOSEN CARD!");
            System.out.println("ENTER A VALID PURCHASE AMOUNT:");
            double newpamt = sc3.nextDouble();
            return calculateBill(newpamt);
        }
    }
}
public class Card 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER CARD HOLDER NAME:");
        String name = sc.next();
        System.out.println("ENTER CARD NUMBER:");
        String number = sc.next();
        System.out.println("============MENU============\n1.SILVER CARD\n2.GOLD CARD\n3.PLATINUM CARD\n");
        System.out.println("ENTER YOUR CHOICE:");
        int choice = sc.nextInt();
        CreditCard card = null;
        switch (choice) 
        {
            case 1:
                card = new SilverCard(name, number);
                break;
            case 2:
                card = new GoldCard(name, number);
                break;
            case 3:
                card = new PlatinumCard(name, number);
                break;
            default:
                System.out.println("INVALID CHOICE!");
                return;
        }
        System.out.println("ENTER PURCHASE AMOUNT:");
        double pamt = sc.nextDouble();
        System.out.println("============CARD DETAILS============");
        card.displayDetails();
        if (card instanceof SilverCard) 
        {
            System.out.println("- NO DISCOUNT ON PURCHASE!");
        } else if (card instanceof GoldCard) 
        {
            System.out.println("- 5% DISCOUNT ON PURCHASE!");
        } else if (card instanceof PlatinumCard) 
        {
            System.out.println("- 10% DISCOUNT ON PURCHASE!");
        }
        System.out.println("FINAL BILL AMOUNT: " + card.calculateBill(pamt));
    }
}