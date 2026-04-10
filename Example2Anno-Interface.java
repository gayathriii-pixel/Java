// Java Program to Illustrate Anonymous inner classes
// Declaration Without any Name As an implementer of the
// specified interface
 
// Interface
interface Hello {
 
    // Method defined inside interface
    void show();
}
 
// Main class
class GFG {
 
    // Class implementing interface
    static Hello h = new Hello() {
        // show() method inside main class
        public void show()
        {
 
            // Print statement
            System.out.println("i am in anonymous class");
        }
    };
 
    // Method 2
    // Main driver method
    public static void main(String[] args)
    {
        // Calling show() method inside main() method
        h.show();
    }
}