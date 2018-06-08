/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.poli.pds.reservas.ReservaDeHabitaciones.DAO.impl;

import co.com.poli.pds.reservas.ReservaDeHabitaciones.DAO.IReservaDAO;
import co.com.poli.pds.reservas.ReservaDeHabitaciones.Data.ReservaData;
import co.com.poli.pds.reservas.ReservaDeHabitaciones.Model.Reserva;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Sebastian
 */
@Repository
public class ReservaDAO implements IReservaDAO {

    public ReservaDAO() {
    }

    @Override
    public List<Reserva> getReservas() {
        return ReservaData.getListaReservas();
    }

    @Override
    public Reserva getReserva(String idReserva) {
        List<Reserva> reservas = ReservaData.getListaReservas();
        for (Reserva reserva : reservas) {
            if (idReserva.equals(reserva.getIdReserva())) {
                return reserva;
            }
        }
        return null;
    }

    @Override
    public Reserva insertReserva(Reserva reserva) {
        List<Reserva> reservas = ReservaData.getListaReservas();
        reservas.add(reserva);
        ReservaData.setListaReservas(reservas);
        return reserva;
    }

}
