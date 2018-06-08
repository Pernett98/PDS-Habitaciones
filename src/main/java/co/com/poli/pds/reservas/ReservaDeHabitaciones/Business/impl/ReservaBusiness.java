/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.poli.pds.reservas.ReservaDeHabitaciones.Business.impl;

import co.com.poli.pds.reservas.ReservaDeHabitaciones.Business.IReservaBusiness;
import co.com.poli.pds.reservas.ReservaDeHabitaciones.DAO.IHabitacionDAO;
import co.com.poli.pds.reservas.ReservaDeHabitaciones.DAO.IReservaDAO;
import co.com.poli.pds.reservas.ReservaDeHabitaciones.Model.Habitacion;
import co.com.poli.pds.reservas.ReservaDeHabitaciones.Model.Reserva;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sebastian
 */
@Service
public class ReservaBusiness implements IReservaBusiness {

    @Autowired
    public IReservaDAO reservaDAO;

    @Autowired
    public IHabitacionDAO habitacionDAO;

    @Override
    public List<Reserva> getReservas() {
        return reservaDAO.getReservas();
    }

    @Override
    public Reserva getReserva(String idReserva) {
        return reservaDAO.getReserva(idReserva);
    }

    @Override
    public Reserva insertReserva(Reserva reserva) {
        Habitacion habitacion = habitacionDAO.getHabitacion(reserva.getIdHabitacion());
        if (habitacion != null) {
            if (Habitacion.TIPO_PRIVADA.equals(habitacion.getTipoHabitacion())) {
                reserva.setNumCamas(habitacion.getNumeroCamas());
                reserva.setPrecioXcama(Reserva.PRECIO_PRIVADA);
            }
            if (Habitacion.TIPO_COMPARTIDA.equals(habitacion.getTipoHabitacion())) {
                reserva.setPrecioXcama(Reserva.PRECIO_COMPARTIDA);
            }
            if (CheckDisponibilidadHabitacion(habitacion.getIdHabitacion(), reserva.getNumCamas())) {
                return reservaDAO.insertReserva(reserva);
            }
        }
        return null;
    }

    @Override
    public Double getValorDeHabitacionesPrivadasOcupadas() {
        Double valor = 0D;
        List<Reserva> reservas = reservaDAO.getReservas();

        for (Reserva reserva : reservas) {
            valor += reserva.getPrecioXcama() * reserva.getNumCamas();
        }

        return valor;
    }

    @Override
    public Habitacion getHabitacionMasCostosaOcupada() {
        Reserva reservaMasCara = null;
        List<Reserva> reservas = reservaDAO.getReservas();

        for (Reserva reserva : reservas) {
            if (reservaMasCara == null) {
                reservaMasCara = reserva;
            } else {
                Double value = reserva.getValorReserva();
                if (value > reservaMasCara.getValorReserva()) {
                    reservaMasCara = reserva;
                }
            }
        }
        
        if (reservaMasCara != null) {
            return habitacionDAO.getHabitacion(reservaMasCara.getIdHabitacion());
        }

        return null;
    }

    private boolean CheckDisponibilidadHabitacion(String idHabitacion, int numCamas) {
        List<Reserva> reservas = reservaDAO.getReservas();
        Habitacion habitacion = habitacionDAO.getHabitacion(idHabitacion);
        int camasReservadas = 0;
        for (Reserva reserva : reservas) {
            if (reserva.getIdHabitacion().equals(idHabitacion)) {
                camasReservadas += reserva.getNumCamas();
            }
        }
        return (camasReservadas + numCamas) <= habitacion.getNumeroCamas();
    }

}
