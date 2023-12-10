package org.example;

import java.sql.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args)  throws SQLException { // this throws SQL exception
        String url = "jdbc:sqlite:hello.sqlite";
        Connection connection = DriverManager.getConnection(url); // connects
        Statement statement = connection.createStatement(); // this runs SQL queries

     //   String createTableSQL = "CREATE TABLE cats (name TEXT, age INTEGER)"; // Creat SQL table
     //   statement.execute(createTableSQL); //Execute SQL to creat table

      //  String insertDataSQL = "INSERT INTO cats VALUES ('Maru', 10)"; // inserts data in the table
     //   statement.execute(insertDataSQL); // Execute insert data in the table

        String insertDataSql = "INSERT INTO cats VALUES ('Hello Kitty', 40)";   // More SQL! Insert more data
        statement.execute(insertDataSql);    // Execute this to insert more data in databse

        String getAllCatsSql = "SELECT * FROM cats";   // Query to fetch data
        ResultSet allCats = statement.executeQuery(getAllCatsSql);   // ExecuteQuery this returns a ResultSet

        while (allCats.next()) { // Ths is a loop over the ResultSet it reads one row at a time
            String name = allCats.getString("name");     // this gets the data by column "Name"
            int age = allCats.getInt("age"); // this gets the other column "age"
            System.out.printf(name + " is " + age + " years old.\n");
        }

            allCats.close();      // Close result set when done using it


    }

}