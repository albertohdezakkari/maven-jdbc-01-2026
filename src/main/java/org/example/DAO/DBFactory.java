package org.example.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBFactory {
    public static final String ORACLE = "ORACLE";
    public static final String POSTGRE = "POSTGRE";
    public static final String MARIADB = "MARIADB";
    public static final String SQLSERVER = "SQLSERVER";

    public static Connection getInstance(String conex){
        switch (conex){
            case POSTGRE:
                /*
                MotorSQL motorSQL =
                        new PostgreMotorSQL();
                */
                /*return motorSQL;
                System.out.println("Intentando conectar a la base de datos...");
                try{
                    Class.forName(DRIVER);
                    conn = DriverManager.getConnection(URL, USER, PASSWORD);
                    // DriverManager
                    conn = DBFactory.getInstance(DBFactory.ORACLE);

                }catch (Exception e){

                }*/
                break;
        }

        return null;
    }
}
