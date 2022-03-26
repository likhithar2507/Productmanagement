package com.harman.Projectmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Productmanagement {

    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int option;

        while(true) {
            System.out.println("1. Add the products :-");
            System.out.println("2. View all the products :-");
            System.out.println("3. Search a product by  using  its product code :-");
            System.out.println("4. Update product details using the  product's Code:-");
            System.out.println("5. Delete a product  by using it's Code :- ");
            System.out.println("6. Display all the details of  products  whose price  is greater than 50000:-");
            System.out.println("7. Display the count of total number of products  in the company:-");
            System.out.println("8. Display all the products details in the  Alphabetical order:-");
            System.out.println("9. exit :-");
            System.out.println("Enter Your choice :- ");
            option=in.nextInt();

            switch(option) {
                case 1:
                    try {
                        Connection c= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ABCDcompany?autoReconnect=true&useSSL=false","root","");
                        Scanner s=new Scanner(System.in);
                        String productcode,productname,brand,price,model,manufacturingyear,expirydate;
                        System.out.println("Product Code=");
                        productcode=s.nextLine();
                        System.out.println("Product Name =");
                        productname=s.nextLine();
                        System.out.println("Brand =");
                        brand=s.nextLine();
                        System.out.println("Price =");
                        price=s.nextLine();
                        System.out.println("Model =");
                        model=s.nextLine();
                        System.out.println("Year of Manufacturing =");
                        manufacturingyear=s.nextLine();
                        System.out.println("Exipry Date =");
                        expirydate=s.nextLine();

                        Statement stmt=c.createStatement();
                        stmt.executeUpdate("INSERT INTO `products`( `productcode`, `productname`, `brand`, `price`, `model`, `manufacturing_year`, `expirydate`) VALUES("+productcode+",'"+productname+"','"+brand+"',"+price+",'"+model+"',"+manufacturingyear+",'"+expirydate+"') ");
                        System.out.println("Product Details Inserted Successfully");

                    }
                    catch(Exception e) {
                        System.out.println(e);
                    }
                    break;

                case 2:
                    try {
                        Connection c= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ABCDcompany?autoReconnect=true&useSSL=false","root","");
                        Statement stmt=c.createStatement();
                        ResultSet rs=stmt.executeQuery("select * from products");
                        while(rs.next()) {
                            System.out.println("ID :"+rs.getInt("ID"));
                            System.out.println("Product Code :"+rs.getBigDecimal("productcode"));
                            System.out.println("Product Name :"+rs.getString("productname"));
                            System.out.println("Brand :"+rs.getString("brand"));
                            System.out.println("Price :"+rs.getInt("price"));
                            System.out.println("Model :"+rs.getString("model"));
                            System.out.println("Manufacturing Year :"+rs.getString("manufacturingyear"));
                            System.out.println("Expiry Date :"+rs.getString("expirydate"));
                        }
                    }
                    catch(Exception e) {
                        System.out.println(e);
                    }
                    break;

                case 3:
                    try {
                        Connection c= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ABCDcompany?autoReconnect=true&useSSL=false","root","");

                        Scanner s=new Scanner(System.in);
                        System.out.println("Enter the Product code :");
                        String productcode=s.nextLine();
                        java.sql.Statement stmt=c.createStatement();
                        ResultSet rs=stmt.executeQuery("select * from products where productcode="+productcode);
                        while(rs.next()) {
                            System.out.println("ID :"+rs.getInt("ID"));
                            System.out.println("Product Code :"+rs.getBigDecimal("productcode"));
                            System.out.println("Product Name :"+rs.getString("productname"));
                            System.out.println("Brand :"+rs.getString("brand"));
                            System.out.println("Price :"+rs.getInt("price"));
                            System.out.println("Model :"+rs.getString("model"));
                            System.out.println("Manufacturing Year :"+rs.getString("manufacturingyear"));
                            System.out.println("Expiry Date :"+rs.getString("expirydate"));
                        }
                    }
                    catch(Exception e) {
                        System.out.println(e);
                    }
                    break;

                case 4:
                    try {
                        Connection c= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ABCDcompany?autoReconnect=true&useSSL=false","root","");

                        Scanner s=new Scanner(System.in);
                        String productcode,productname,brand,price,model,manufacturingyear,expirydate;
                        System.out.println("Enter the Product code to get  it's Update :");
                        productcode=s.nextLine();

                        System.out.println("Product Name =");
                        productname=s.nextLine();
                        System.out.println("Brand =");
                        brand=s.nextLine();
                        System.out.println("Price =");
                        price=s.nextLine();
                        System.out.println("Model =");
                        model=s.nextLine();
                        System.out.println("Year of Manufacturing =");
                        manufacturingyear=s.nextLine();
                        System.out.println("Exipry Date =");
                        expirydate=s.nextLine();

                        Statement stmt=c.createStatement();
                        stmt.executeUpdate("update products set productname='"+productname+"',brand='"+brand+"',price="+price+",model='"+model+"',manufacturing_year="+manufacturingyear+",expirydate='"+expirydate+"' WHERE productcode="+productcode+"");
                        System.out.println("Updated Successfully");


                    }
                    catch(Exception e) {
                        System.out.println(e);
                    }
                    break;

                case 5:
                    try {
                        Connection c= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ABCDcompany?autoReconnect=true&useSSL=false","root","");

                        Scanner s=new Scanner(System.in);
                        String productcode;
                        System.out.println("Delete  the Product data using  it's Product code :");
                        productcode=s.nextLine();
                        Statement stmt=c.createStatement();
                        stmt.executeUpdate("delete from products where productcode="+productcode+"");

                        System.out.println("Product data  is Deleted Successfully");

                    }
                    catch(Exception e) {
                        System.out.println(e);
                    }
                    break;

                case 6:
                    try {
                        Connection c= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ABCDcompany?autoReconnect=true&useSSL=false","root","");

                        Statement stmt=c.createStatement();
                        ResultSet rs=stmt.executeQuery("select * from products where price > 50000");
                        while(rs.next()) {
                            System.out.println("ID :"+rs.getInt("ID"));
                            System.out.println("Product Code :"+rs.getBigDecimal("productcode"));
                            System.out.println("Product Name :"+rs.getString("productname"));
                            System.out.println("Brand :"+rs.getString("brand"));
                            System.out.println("Price :"+rs.getInt("price"));
                            System.out.println("Model :"+rs.getString("model"));
                            System.out.println("Manufacturing Year :"+rs.getString("manufacturingyear"));
                            System.out.println("Expiry Date :"+rs.getString("expirydate"));
                        }
                    }
                    catch(Exception e) {
                        System.out.println(e);
                    }
                    break;

                case 7:
                    try {
                        Connection c= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ABCDcompany?autoReconnect=true&useSSL=false","root","");
                        int count=0;
                        Statement stmt=c.createStatement();
                        ResultSet rs=stmt.executeQuery("select productname from products");
                        while(rs.next()) {
                            count++;
                        }
                        System.out.println("Total Products : "+count);
                    }
                    catch(Exception e) {
                        System.out.println(e);
                    }
                    break;

                case 8:
                    try {
                        Connection c= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ABCDcompany?autoReconnect=true&useSSL=false","root","");

                        Statement stmt=c.createStatement();
                        ResultSet rs=stmt.executeQuery("select * from products order by productname");
                        while(rs.next()) {
                            System.out.println("ID :"+rs.getInt("ID"));
                            System.out.println("Product Code :"+rs.getBigDecimal("productcode"));
                            System.out.println("Product Name :"+rs.getString("productname"));
                            System.out.println("Brand :"+rs.getString("brand"));
                            System.out.println("Price :"+rs.getInt("price"));
                            System.out.println("Model :"+rs.getString("model"));
                            System.out.println("Manufacturing Year :"+rs.getString("manufacturingyear"));
                            System.out.println("Expiry Date :"+rs.getString("expirydate"));
                        }
                    }
                    catch(Exception e) {
                        System.out.println(e);
                    }
                    break;

                case 9:
                    System.exit(0);

                default:
                    System.out.println(" OOPS! You have choosen an  INVALID option.. please try again ..");
            }
        }

    }
}