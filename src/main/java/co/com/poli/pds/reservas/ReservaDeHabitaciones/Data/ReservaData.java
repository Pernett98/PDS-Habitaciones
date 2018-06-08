/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.poli.pds.reservas.ReservaDeHabitaciones.Data;

import co.com.poli.pds.reservas.ReservaDeHabitaciones.Model.Reserva;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sebastian
 */
public class ReservaData {
    
    private static List<Reserva> listaReservas;

    static {
        listaReservas = new ArrayList<Reserva>() {
            {
                add(new Reserva("1", "101", null, 10, 50000D));
                add(new Reserva("2", "102", null, 5, 50000D));
                add(new Reserva("3", "103", null, 8, 50000D));

            }
        };
    }

    public static List<Reserva> getListaReservas() {
        return listaReservas;
    }

    public static void setListaReservas(List<Reserva> listaReservas) {
        ReservaData.listaReservas = listaReservas;
    }
    
}
