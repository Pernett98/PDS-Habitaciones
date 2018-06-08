/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.poli.pds.reservas.ReservaDeHabitaciones.Data;

import co.com.poli.pds.reservas.ReservaDeHabitaciones.Model.Habitacion;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sebastian
 */
public class HabitacionData {

    private static List<Habitacion> listaHabitacions;

    static {
        listaHabitacions = new ArrayList<Habitacion>() {
            {
                add(new Habitacion("101", Habitacion.TIPO_PRIVADA, 10));
                add(new Habitacion("102", Habitacion.TIPO_PRIVADA, 5));
                add(new Habitacion("103", Habitacion.TIPO_PRIVADA, 8));

            }
        };
    }

    public static List<Habitacion> getListaHabitacions() {
        return listaHabitacions;
    }

    public static void setListaHabitacions(List<Habitacion> listaHabitacions) {
        HabitacionData.listaHabitacions = listaHabitacions;
    }

}
