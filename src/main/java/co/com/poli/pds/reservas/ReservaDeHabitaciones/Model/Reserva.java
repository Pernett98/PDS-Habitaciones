/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.poli.pds.reservas.ReservaDeHabitaciones.Model;

import java.util.Objects;

/**
 *
 * @author Sebastian
 */
public class Reserva {

    private String idReserva;
    private String idHabitacion;
    private Habitacion habitacion;
    private int numCamas;
    private Double precioXcama;

    public static final Double PRECIO_PRIVADA = 50000D;
    public static final Double PRECIO_COMPARTIDA = 30000D;

    public Reserva() {
    }

    public Reserva(String idReserva, String idHabitacion, Habitacion habitacion, int numCamas, Double precioXcama) {
        this.idReserva = idReserva;
        this.idHabitacion = idHabitacion;
        this.habitacion = habitacion;
        this.numCamas = numCamas;
        this.precioXcama = precioXcama;
    }

    public String getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(String idReserva) {
        this.idReserva = idReserva;
    }

    public String getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(String idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public int getNumCamas() {
        return numCamas;
    }

    public void setNumCamas(int numCamas) {
        this.numCamas = numCamas;
    }

    public Double getPrecioXcama() {
        return precioXcama;
    }

    public void setPrecioXcama(Double precioXcama) {
        this.precioXcama = precioXcama;
    }
    
    public Double getValorReserva() {
        return this.precioXcama * this.numCamas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.idReserva);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reserva other = (Reserva) obj;
        if (!Objects.equals(this.idReserva, other.idReserva)) {
            return false;
        }
        return true;
    }

}
