/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.poli.pds.reservas.ReservaDeHabitaciones.DAO.impl;

import co.com.poli.pds.reservas.ReservaDeHabitaciones.DAO.IHabitacionDAO;
import co.com.poli.pds.reservas.ReservaDeHabitaciones.Data.HabitacionData;
import co.com.poli.pds.reservas.ReservaDeHabitaciones.Model.Habitacion;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Sebastian
 */
@Repository
public class HabitacionDAO implements IHabitacionDAO {

    public HabitacionDAO() {
    }

    @Override
    public List<Habitacion> getHabitaciones() {
        return HabitacionData.getListaHabitacions();
    }

    @Override
    public Habitacion getHabitacion(String idHabitacion) {
        List<Habitacion> habitaciones = HabitacionData.getListaHabitacions();
        for (Habitacion habitacion : habitaciones) {
            if (idHabitacion.equals(habitacion.getIdHabitacion())) {
                return habitacion;
            }
        }
        return null;
    }

    @Override
    public Habitacion insertHabitacion(Habitacion habitacion) {
        List<Habitacion> habitaciones = HabitacionData.getListaHabitacions();
        habitaciones.add(habitacion);
        HabitacionData.setListaHabitacions(habitaciones);
        return habitacion;
    }

}
