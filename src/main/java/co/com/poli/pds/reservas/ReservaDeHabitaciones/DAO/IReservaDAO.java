/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.poli.pds.reservas.ReservaDeHabitaciones.DAO;

import co.com.poli.pds.reservas.ReservaDeHabitaciones.Model.Habitacion;
import co.com.poli.pds.reservas.ReservaDeHabitaciones.Model.Reserva;
import java.util.List;

/**
 *
 * @author Sebastian
 */
public interface IReservaDAO {

    public List<Reserva> getReservas();

    public Reserva getReserva(String idReserva);

    public Reserva insertReserva(Reserva reserva);

}
