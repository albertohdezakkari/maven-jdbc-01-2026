package org.example.DAO;

import org.example.beans.Cliente;

import java.sql.*;
import java.util.ArrayList;

public class ClienteDAO
    implements DAO<Cliente> {
    private static final String URL = "jdbc:postgresql://database-2.cxhptkfuwfna.us-east-1.rds.amazonaws.com:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "12345678";
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String SQL_SELECT = "SELECT * FROM CLIENTES";

    private static Connection conn;
    private static Statement st;
    private static void initConexion(){
        System.out.println("Intentando conectar a la base de datos...");
        try{
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        }catch (Exception e){

        }
    }
    private static ResultSet ejecutarQuery(String SQL){
        ResultSet rs = null;
        try{
            st = conn.createStatement();
            rs = st.executeQuery(SQL);
        }catch(Exception e){
        }finally {
            return rs;
        }

    }
    @Override
    public void add(Cliente object) {
        initConexion();
        ResultSet rs = ejecutarQuery(SQL_SELECT);
    }

    @Override
    public void update(int id, Cliente object) {
        initConexion();
        ResultSet rs = ejecutarQuery(SQL_SELECT);
    }

    @Override
    public void delete(int id) {
        initConexion();
        ResultSet rs = ejecutarQuery(SQL_SELECT);
    }

    @Override
    public Cliente find(int id) {
        initConexion();
        ResultSet rs = ejecutarQuery(SQL_SELECT);
        return null;
    }

    @Override
    public ArrayList<Cliente> findAll() {
        ArrayList<Cliente> lstClientes =
                new ArrayList<>();
        initConexion();
        ResultSet rs = ejecutarQuery(SQL_SELECT);
        try {
            if(rs!=null){
                while(rs.next()){
                    Cliente cliente = new Cliente();
                    System.out.println("LECTURA DEL RS" + rs.getInt(1));
                    cliente.setId(rs.getInt(1));
                    cliente.setNombre(rs.getString(2));
                    cliente.setEmail(rs.getString(3));
                    cliente.setDia(rs.getString(4));
                    cliente.setMes(rs.getString(5));
                    cliente.setAnyo(rs.getString(6));
                    lstClientes.add(cliente);
                }


                }
        }catch (Exception e){

        }

        return null;
    }
    // PRUEBAS UNITARIAS
    public static void main (String[] args){
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.findAll();


    }
}
