package emailapp;

import java.util.*;

public class EmailApp {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //User Info
        System.out.println("Enter First Name:");
        String f_name=sc.next();
        System.out.println("Enter Last Name:");
        String l_name=sc.next();

        //Creating Object for Email Class
        Email e1=new Email(f_name,l_name);
        int choice=-1;
        do{
            System.out.println("\n*******\nEnter Your Choice\n1.Show Info\n2.Change Password\n3.Change MailBox Capacity\n4.Set Alternate Email\n5.Store Data into The File\n6.Read Data From The File\n7.Exit");
            System.out.println("Enter Your Choice");
            choice=sc.nextInt();
            switch (choice){

                case 1:e1.getInfo();
                break;
                case 2: e1.setPassword();
                break;
                case 3: e1.set_mailCap();
                break;
                case 4: e1.setAlter_email();
                break;
                case 5:e1.storeFile();
                break;
                case 6:e1.readFile();
                break;
                case 7: System.out.println("Thank you For Using Our Application");
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        }while (choice!=7);
    }
}
