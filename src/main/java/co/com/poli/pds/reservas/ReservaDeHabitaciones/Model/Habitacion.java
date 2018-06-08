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
public class Habitacion {

    private String idHabitacion;
    private String tipoHabitacion;
    private int numeroCamas;

    public static final String TIPO_PRIVADA = "Privada";
    public static final String TIPO_COMPARTIDA = "Compartida";

    public static final int MIN_COMPARTIDA = 2;
    public static final int MAX_COMPARTIDA = 4;

    public static final int MIN_PRIVADA = 4;
    public static final int MAX_PRIVADA = 10;

    public Habitacion() {
    }

    public Habitacion(String idHabitacion, String tipoHabitacion, int numeroCamas) {
        this.idHabitacion = idHabitacion;
        this.tipoHabitacion = tipoHabitacion;
        this.numeroCamas = numeroCamas;
    }

    public String getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(String idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public int getNumeroCamas() {
        return numeroCamas;
    }

    public void setNumeroCamas(int numeroCamas) {
        this.numeroCamas = numeroCamas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.idHabitacion);
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
        final Habitacion other = (Habitacion) obj;
        if (!Objects.equals(this.idHabitacion, other.idHabitacion)) {
            return false;
        }
        return true;
    }

}
