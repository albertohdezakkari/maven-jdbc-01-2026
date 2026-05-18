package org.example.DAO;

import org.example.beans.Cliente;

import java.sql.*;
import java.util.ArrayList;

public class ClienteDAO
    implements DAO<Cliente> {
    private static final String SQL_SELECT =
                "SELECT * FROM CLIENTES";
    @Override
    public void add(Cliente object) {

    }
    @Override
    public void update(int id, Cliente object) {}
    @Override
    public void delete(int id) {}
    @Override
    public Cliente find(int id) {
        String SQL_SELECT_ID_PARAM =
                "SELECT * FROM CLIENTES WHERE ID = ?" ;
        String SQL_SELECT_ID_PARAM_ST =
                "SELECT * FROM CLIENTES WHERE ID = " + id ;
        Cliente cliente = null;
        MotorSQL.conectar();
        try{
        ResultSet rs =
                MotorSQL.
                        ejecutarDML(SQL_SELECT_ID_PARAM_ST);
            ResultSet rs2 =
                    MotorSQL.
                            ejecutarDMLPST(SQL_SELECT_ID_PARAM);
                            MotorSQL.getPst().setInt(1, id);
            if(rs!= null) {
                if(rs.next()){
                    cliente = new Cliente();
                    cliente.setId(rs.getInt(1));
                    cliente.setNombre(rs.getString(2));
                    cliente.setEmail(rs.getString(3));
                    cliente.setDia(rs.getString(4));
                    cliente.setMes(rs.getString(5));
                    cliente.setAnyo(rs.getString(6));
                }
            }
        }catch (Exception e){}
        return cliente;
    }
    @Override
    public ArrayList<Cliente> findAll() {
        ArrayList<Cliente> lstClientes =
                new ArrayList<>();
        MotorSQL.conectar();
        ResultSet rs =
                MotorSQL.
                        ejecutarDML(SQL_SELECT);
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
        //clienteDAO.findAll();
        Cliente cliente = clienteDAO.find(1);
        System.out.println(cliente.toString());

    }
}
