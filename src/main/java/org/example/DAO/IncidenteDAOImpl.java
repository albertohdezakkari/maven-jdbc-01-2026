package org.example.DAO;

import org.example.beans.Incidente;
import org.example.beans.Socs;

import java.util.ArrayList;

public class IncidenteDAOImpl
    extends AbstractDAO<Incidente> {

    public IncidenteDAOImpl(MotorSQL motorSQL) {
        super(motorSQL);
    }

    @Override
    public void add(Incidente object) {
            // 1º) CONECTAR
            // 2º) PREPARAR
            // 3º) EJECUTAR UPDATE
    }
    public static void main (String[] args ){
        // INSTANCI INCIDENTE
        IncidenteDAOImpl incidenteDAOImpl =
                new IncidenteDAOImpl(MotorFactory.
                        create(MotorFactory.POSTGRE));
        // TEST 1: AÑADIR
        Incidente incidente = new Incidente();
        incidente.setCodigoIncidente("");
        incidente.setTipoIncidente("");
        incidente.setFechaDeteccion("");
        incidente.setEstado("");
        incidente.setAutorExamen("ALBERTO AKKARI");
        incidente.setSoc(new Socs(1));
        incidenteDAOImpl.add(incidente);
        // FIN  TEST 1: AÑADIR
    }


    @Override
    public void update(int id, Incidente object) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Incidente find(int id) {
        return null;
    }

    @Override
    public ArrayList<Incidente> findAll() {
        return null;
    }
}
