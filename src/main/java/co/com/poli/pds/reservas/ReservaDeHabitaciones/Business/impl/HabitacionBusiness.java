/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.poli.pds.reservas.ReservaDeHabitaciones.Business.impl;

import co.com.poli.pds.reservas.ReservaDeHabitaciones.Business.IHabitacionBusiness;
import co.com.poli.pds.reservas.ReservaDeHabitaciones.DAO.IHabitacionDAO;
import co.com.poli.pds.reservas.ReservaDeHabitaciones.Model.Habitacion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sebastian
 */
@Service
public class HabitacionBusiness implements IHabitacionBusiness {

    @Autowired
    private IHabitacionDAO dao;

    public HabitacionBusiness() {
    }

    @Override
    public List<Habitacion> getHabitaciones() {
        return dao.getHabitaciones();
    }

    @Override
    public Habitacion getHabitacion(String idHabitacion) {
        return dao.getHabitacion(idHabitacion);
    }

    @Override
    public Habitacion insertHabitacion(Habitacion habitacion) {
        if (!Habitacion.TIPO_COMPARTIDA.equals(habitacion.getIdHabitacion()) && Habitacion.TIPO_PRIVADA.equals(habitacion.getIdHabitacion())) {
            habitacion.setTipoHabitacion(Habitacion.TIPO_COMPARTIDA);
        }
        if (habitacion.getNumeroCamas() < 1) {
            return null;
        }
        if (Habitacion.TIPO_PRIVADA.equals(habitacion.getTipoHabitacion())) {
            if (habitacion.getNumeroCamas() > Habitacion.MAX_PRIVADA || habitacion.getNumeroCamas() < Habitacion.MIN_PRIVADA) {
                return null;
            }
        }
        if (Habitacion.TIPO_COMPARTIDA.equals(habitacion.getTipoHabitacion())) {
            if (habitacion.getNumeroCamas() > Habitacion.MAX_COMPARTIDA || habitacion.getNumeroCamas() < Habitacion.MIN_COMPARTIDA) {
                return null;
            }
        }

        return dao.insertHabitacion(habitacion);
    }

}
