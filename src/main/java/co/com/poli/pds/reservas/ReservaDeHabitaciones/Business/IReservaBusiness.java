/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.poli.pds.reservas.ReservaDeHabitaciones.Business;

import co.com.poli.pds.reservas.ReservaDeHabitaciones.Model.Habitacion;
import co.com.poli.pds.reservas.ReservaDeHabitaciones.Model.Reserva;
import java.util.List;

/**
 *
 * @author Sebastian
 */
public interface IReservaBusiness {

    public List<Reserva> getReservas();

    public Reserva getReserva(String idReserva);

    public Reserva insertReserva(Reserva reserva);
    
    public Double getValorDeHabitacionesPrivadasOcupadas();
    
    public Habitacion getHabitacionMasCostosaOcupada();
    
}
