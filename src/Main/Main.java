package Main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        while (true){
            System.out.println("1: Add WebUser");
            System.out.println("2: Remove WebUser ");
            System.out.println("3: Log In");
            System.out.println("4: Log Out");
            System.out.println("5: Make order");
            System.out.println("6: Display order");
            System.out.println("7: Add a Link Product");
            System.out.println("8: Add Product ");
            System.out.println( "9: Delete Product");
            System.out.println("10: ShowAllObjects");
            System.out.println("11: ShowObjectId ");
            Scanner scanner=new Scanner(System.in);
            int num=scanner.nextInt();

            switch (num){
                case 1:
                    System.out.println("Please enter a Login Id");
                    num=scanner.nextInt();

            }

        }


    }
}
