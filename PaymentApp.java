import java.util.Scanner;

class Payment
{
    protected static int nextId = 0;
    protected int id;
    protected String payeeName;
    protected double billAmount;
    protected String date;

    public Payment(String payeeName, double billAmount, String date)
    {
        this.id = ++nextId; 
        this.payeeName = payeeName;
        this.billAmount = billAmount;
        this.date = date;
    }
}

class Card extends Payment
{
    protected long cardNo;
    protected int pin;
    protected double gst;

    public Card(String name, double amount, String date, long cardNo, int pin) 
    {
        super(name, amount, date);
        this.cardNo = cardNo;
        this.pin = pin;
        this.gst = 0.12 * billAmount;
    }
}

class DebitCard extends Card
{
    public DebitCard(String name, double amount, String date, long cardNo, int pin)
    {
        super(name, amount, date, cardNo, pin);
    }

    public double calculateFinalAmount() 
    {
        double transCharge = 0.10 * billAmount;
        return billAmount + gst + transCharge;
    }

    public void printReceipt()
    {
        System.out.println("\n----- Debit Card Payment Receipt -----");
        System.out.println("Payment ID: " + id);
        System.out.println("Payee Name: " + payeeName);
        System.out.println("Date: " + date);
        System.out.println("Bill Amount: " + billAmount);
        System.out.println("GST (12%): " + gst);
        System.out.println("Transaction Charge (10%): " + (0.10 * billAmount));
        System.out.println("Final Amount: " + calculateFinalAmount());
        System.out.println("--------------------------------------");
    }
}

class CreditCard extends Card
{
    public CreditCard(String name, double amount, String date, long cardNo, int pin)
    {
        super(name, amount, date, cardNo, pin);
    }

    public double calculateFinalAmount()
    {
        double transCharge = 0.05 * billAmount;
        return billAmount + gst + transCharge - 50;
    }

    public void printReceipt()
    {
        System.out.println("\n----- Credit Card Payment Receipt -----");
        System.out.println("Payment ID: " + id);
        System.out.println("Payee Name: " + payeeName);
        System.out.println("Date: " + date);
        System.out.println("Bill Amount: " + billAmount);
        System.out.println("GST (12%): " + gst);
        System.out.println("Transaction Charge (5%): " + (0.05 * billAmount));
        System.out.println("Discount: 50");
        System.out.println("Final Amount: " + calculateFinalAmount());
        System.out.println("---------------------------------------");
    }
}

class Cash extends Payment 
{
    private double gst;

    public Cash(String name, double amount, String date) 
    {
        super(name, amount, date);
        this.gst = 0.12 * billAmount;
    }

    public double calculateFinalAmount()
    {
        return billAmount + gst;
    }

    public void printReceipt()
    {
        System.out.println("\n----- Cash Payment Receipt -----");
        System.out.println("Payment ID: " + id);
        System.out.println("Payee Name: " + payeeName);
        System.out.println("Date: " + date);
        System.out.println("Bill Amount: " + billAmount);
        System.out.println("GST (12%): " + gst);
        System.out.println("Final Amount: " + calculateFinalAmount());
        System.out.println("--------------------------------");
    }
}

class Bill
{
    public void processBill()
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Payee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Bill Amount: ");
        double amount = sc.nextDouble();

        sc.nextLine();
        System.out.print("Enter Date: ");
        String date = sc.nextLine();

        System.out.println("\nSelect Mode of Payment:");
        System.out.println("1. Cash");
        System.out.println("2. Card");
        int choice = sc.nextInt();

        if (choice == 1) 
        {
            Cash c = new Cash(name, amount, date);
            c.printReceipt();
        } 
        else if (choice == 2)
        {
            System.out.print("Enter Card Number: ");
            long cno = sc.nextLong();
            System.out.print("Enter PIN: ");
            int pin = sc.nextInt();

            System.out.println("\nSelect Card Type:");
            System.out.println("1. Debit Card");
            System.out.println("2. Credit Card");
            int ctype = sc.nextInt();

            if (ctype == 1)
            {
                DebitCard d = new DebitCard(name, amount, date, cno, pin);
                d.printReceipt();
            }
            else
            {
                CreditCard cr = new CreditCard(name, amount, date, cno, pin);
                cr.printReceipt();
            }
        }
    }
}

public class PaymentApp
{
    public static void main(String[] args)
    {
        Bill b = new Bill();
        b.processBill();
    }
}


