/* 
Exercise 1.1.6

Modify UseArgument.java to make a program UseThree.java that takes three names as 
command-line arguments and prints a proper sentence with the names in the reverse of
the order given, so that, for example, java UseThree Alice Bob Carol prints Hi Carol, Bob, and Alice.
*/

public class UseThree {
    public static void main(String[] args) {
        if (args.length == 3)
            System.out.println("Hi, " + args[2] + ", " + args[1] + ", and " + args[0] + ".");
        else
            System.exit(1);
    }
}
