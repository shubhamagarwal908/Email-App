package emailapp;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class Email {
    Scanner sc=new Scanner(System.in); // Scanner Class
    //Setting variables as Private
    private String fname;
    private String lname;
    private String password;
    private String email;
    private String dept;
    private int mailCapacity=500;
    private String alter_email;

    public Email(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
        System.out.println("New Employee:"+" "+this.fname+" "+this.lname);

        //Calling Methods
        this.dept=this.setDept();//Department
        this.password=this.generatePassword(10);
        this.email=this.generateEmail();//Email generation

    }
// Generate Mail method
    private String generateEmail(){
        return this.fname.toLowerCase()+"."+this.lname.toLowerCase()+"@"+this.dept.toLowerCase()+".company.com";
    }
//Asking for dept
    private String setDept(){
        System.out.println("Department Codes.\n1.Sales\n2.Development\n3.Accounting\n0.Blank");
        boolean flag=false;
        do{
            System.out.println("Enter Department Code");
            int choice=sc.nextInt();
            switch (choice){
                case 1: return "Sales";
//                break;
                case 2: return "Development";
//                break;
                case 3: return "Accounting";
//                break;
                case 0: return "None";
//                break;
                default:
                    System.out.println("Invalid Choice please choose it again!");

            }
        }while(!flag);
        return null;
    }

    //Genertae Random Password
    private String generatePassword(int length){
        Random r=new Random();
        String captialChar="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String smallChar="abcdefghijklmnopqrstuvwxyz";
        String number="0123456789";
        String symbols="!@#$%^&*?";
        String values=captialChar+smallChar+number+symbols;
        String password="";
        for (int i=0;i<length;i++){
            password=password+values.charAt(r.nextInt(values.length()));
        }
        return password;
    }
//Change Password
    public void setPassword(){
        boolean flag=false;
        do {
            System.out.println("Do You Wish to Change Your Password!(Y/N)");
            char choice= sc.next().charAt(0);
            if(choice=='Y' || choice=='y') {
                flag = true;
                System.out.println("Enter Current Password");
                String temp= sc.next();
                if(temp.equals(this.password)){
                    System.out.println("Enter new Password");
                    this.password= sc.next();
                    System.out.println("Password Change Successlly!!");
                }
                else{
                    System.out.println("Incorrect Password");
                }

            } else if(choice=='N' || choice=='n'){
                flag=true;
                System.out.println("Password changed Option Cancelled");

            }
            else{
                System.out.println("Enter Valid Choice");
            }
        }while(!flag);
    }

    //set Mail Capacity

    public void set_mailCap(){
        System.out.println("Current Capacity ="+this.mailCapacity+"mb");
        System.out.println("Enter new MailBox Capacity");
        this.mailCapacity= sc.nextInt();
        System.out.println("MailBox Capacity is Successfully Changed");
    }

    //Alternate Mail
    public void setAlter_email(){
        System.out.println("Enter your Alternate Email");
        this.alter_email= sc.next();
        System.out.println("Alternate email is set!");
    }
    //Display user Information
    public void getInfo(){
        System.out.println("New:"+this.fname+" "+this.lname);
        System.out.println("Department:"+this.dept);
        System.out.println("E-mail:"+this.email);
        System.out.println("Password:"+this.password);
        System.out.println("MailBox Capacity : "+this.mailCapacity+"mb");
        System.out.println("Alternate mail:"+this.alter_email);
    }

    //Storing data into the File

    public  void storeFile(){
        try{
            FileWriter in=new FileWriter("C:\\Users\\shubh\\OneDrive\\Desktop\\Info.txt",true);
//            FileWriter in1=new FileWriter("C:\\Users\\shubh\\OneDrive\\Desktop\\Info.txt");
            in.write("First Name: "+this.fname);
            in.append("\nLast Name: "+this.lname);
            in.append("\nEmail: "+this.email);
            in.append("\nPassword: "+this.password);
            in.append("\nMail Capacity: "+this.mailCapacity);
            in.append("\nAlternate Email: "+this.alter_email+"\n");
            in.append("\n");
//            System.out.println();
//            System.out.println();
            in.close();
            System.out.println();
            System.out.println("Data Stored");
        }catch(Exception e){
            System.out.println(e);
        }
    }

    //Reading File

    public void readFile(){
        try{
            FileReader f=new FileReader("C:\\Users\\shubh\\OneDrive\\Desktop\\Info.txt");
            int i;
            while((i=f.read())!=-1){
                System.out.print((char)i);
            }
            System.out.println();
            f.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }

}
