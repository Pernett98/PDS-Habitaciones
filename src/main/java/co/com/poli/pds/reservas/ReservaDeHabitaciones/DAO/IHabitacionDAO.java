/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.poli.pds.reservas.ReservaDeHabitaciones.DAO;

import co.com.poli.pds.reservas.ReservaDeHabitaciones.Model.Habitacion;
import java.util.List;

/**
 *
 * @author Sebastian
 */
public interface IHabitacionDAO {
    
    public List<Habitacion> getHabitaciones();
    public Habitacion getHabitacion(String idHabitacion);
    public Habitacion insertHabitacion(Habitacion habitacion);
    
}
