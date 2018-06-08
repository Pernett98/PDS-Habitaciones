/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.poli.pds.reservas.ReservaDeHabitaciones.Controller;

import co.com.poli.pds.reservas.ReservaDeHabitaciones.Business.IReservaBusiness;
import co.com.poli.pds.reservas.ReservaDeHabitaciones.Model.Habitacion;
import co.com.poli.pds.reservas.ReservaDeHabitaciones.Model.Reserva;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Sebastian
 */
@RestController
@RequestMapping(value = "/reserva")
public class ReservaController {

    @Autowired
    private IReservaBusiness iReservaBusiness;

    @GetMapping("/")
    public List<Reserva> getReservas() {
        return iReservaBusiness.getReservas();
    }

    @PostMapping("/")
    public Reserva crearReserva(@RequestBody Reserva reserva) {
        return iReservaBusiness.insertReserva(reserva);
    }

    @GetMapping("/{id}")
    public Reserva obtenerReserva(@PathVariable(value = "id") String idReserva) {
        return iReservaBusiness.getReserva(idReserva);
    }

    @GetMapping("/valorPrivadas")
    public Double getValorMasCostosa() {
        return iReservaBusiness.getValorDeHabitacionesPrivadasOcupadas();
    }

    @GetMapping("/HabitacionMasCostosa")
    public Habitacion getHabitacionMasCostosa() {
        return iReservaBusiness.getHabitacionMasCostosaOcupada();
    }

}
