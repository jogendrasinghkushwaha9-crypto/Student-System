import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;


public class Student{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int choice;
       try{
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","");
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("show tables;");
        System.out.println("Connection Established ");
        while(rs.next()){
            System.out.println(rs.getString(1));
        }
       }
       catch(Exception e){
        System.out.println(e);
       }
        while(true){
        System.out.println("Student Administration Panel :");
        System.out.println("1 Store Data.");
        System.out.println("2 Show Data.");
        System.out.println("3 Delete Data.");
        System.out.println("4 Exit Opertion.");
        System.out.println("What you want 1 to 4 :");
        choice =sc.nextInt();
        switch(choice)
        {
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Operation Try Again");
        }
        }
    }
}