import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;


public class Student{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int choice,n,srch;
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
       try{
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","");
        st = con.createStatement();
        rs = st.executeQuery("show tables;");
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
        System.out.println("3 Search Data.");
        System.out.println("4 Delete Data.");
        System.out.println("5 Exit Opertion.");
        System.out.println("What you want 1 to 5 :");
        choice =sc.nextInt();
        switch(choice)
        {
            case 1:
                System.out.println("Enter Roll no : ");
                int rn=sc.nextInt();
                System.out.println("Enter Name : ");
                String name=sc.next();
                System.out.println("Enter Marks : ");
                float mrks=sc.nextFloat();
                System.out.println("Enter grade : ");
                String grd=sc.next();
                try{
                    n=st.executeUpdate("insert into data values("+rn+",'"+name+"',"+mrks+",'"+grd+"')");
                    System.out.println(n+" record inserted");
                }
                catch(Exception e){
                    System.out.println(e);
                }
                break;
            case 2:
                try{
                    rs=st.executeQuery("select * from data");
                    while(rs.next()){
                        System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getFloat(3)+" "+rs.getString(4));
                    }
                    System.out.println("\n");
                }
                catch(Exception e){
                    System.out.println(e);
                }
                break;
            case 3:
                System.out.println("Enter roll no : ");
                srch=sc.nextInt();
                try{
                    rs=st.executeQuery("select * from data where rollno="+srch);
                    if(rs.next()){
                        System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getFloat(3)+" "+rs.getString(4));
                    }
                    else{
                        System.out.println("Record not found");
                    }
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
                break;
            case 4:
                System.out.println("Enter want you delete :");
                int dlt=sc.nextInt();
                try{
                    n=st.executeUpdate("delete from data where rollno="+dlt);
                    System.out.println(n+" deletion successfully!");
                }
                catch(Exception e){
                    System.out.println(e);
                }
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Operation Try Again");
        }
        }
    }
}