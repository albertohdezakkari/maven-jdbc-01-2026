package org.example.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class MotorSQL {
    private static final String URL = "jdbc:postgresql://database-2.cxhptkfuwfna.us-east-1.rds.amazonaws.com:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "12345678";
    private static final String DRIVER = "org.postgresql.Driver";
    private static Connection conn;
    private static Statement st;

    public static PreparedStatement getPst() {
        return pst;
    }

    private static PreparedStatement pst;
    private static ResultSet rs;

    public static void conectar(){}
    public static void ejecutarDDL(){}
    public static ResultSet ejecutarDML(String SQL){
        ResultSet rs = null;
        try{
            st = conn.createStatement();
            rs = st.executeQuery(SQL);
        }catch(Exception e){
        }finally {
            return rs;
        }
    }
    public static ResultSet ejecutarDMLPST(String SQL){
        ResultSet rs = null;
        try{
            pst = conn.prepareStatement(SQL);
            //rs = st.executeQuery(SQL);
        }catch(Exception e){
        }finally {
            return rs;
        }
    }
    public static void desconectar(){}
}
