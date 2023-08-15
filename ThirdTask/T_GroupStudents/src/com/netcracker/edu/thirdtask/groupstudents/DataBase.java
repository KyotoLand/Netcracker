package com.netcracker.edu.thirdtask.groupstudents;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {

    public static void addStudents(String group, int number){
        String dbURL = "jdbc:oracle:thin:@localhost:1521:orcl";
        String username = "C##scott";
        String password = "tiger";

        try {
            Connection connection = DriverManager.getConnection(dbURL, username, password);
            System.out.println("Connected to oracle database");
            String sql = "INSERT ALL\n" +
                    " INTO T_GroupSelected (id_student, firstname, lastname, id_Group)\n" +
                    " SELECT id_student, firstname, lastname, id_Group\n" +
                    " FROM T_Student\n" +
                    " WHERE id_student NOT IN(SELECT T.id_student FROM T_GroupSelected T)" +
                    " AND id_Group = '" + group +
                    "' AND dolgCount > " + number;
            Statement statement =  connection.createStatement();
            int rows = statement.executeUpdate(sql);

            System.out.println(rows + " rows inserted");

            statement.close();

            connection.close();

        } catch (SQLException e) {
            System.out.println("Can't connect to database");
            e.printStackTrace();
        }
    }

}
