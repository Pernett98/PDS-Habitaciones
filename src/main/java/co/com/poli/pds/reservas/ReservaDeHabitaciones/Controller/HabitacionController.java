/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.poli.pds.reservas.ReservaDeHabitaciones.Controller;

import co.com.poli.pds.reservas.ReservaDeHabitaciones.Business.IHabitacionBusiness;
import co.com.poli.pds.reservas.ReservaDeHabitaciones.Model.Habitacion;
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
@RequestMapping(value = "/habitacion")
public class HabitacionController {
    
    @Autowired
    private IHabitacionBusiness iHabitacionBusiness;
    
    @GetMapping("/")
    public List<Habitacion> getHabitaciones() {
        return iHabitacionBusiness.getHabitaciones();
    }
    
    @PostMapping("/")
    public Habitacion crearHabitacion(@RequestBody Habitacion habitacion) {
        return iHabitacionBusiness.insertHabitacion(habitacion);
    }

    @GetMapping("/{id}")
    public Habitacion getHabitacion(@PathVariable(value = "id") String idHabitacion){
        return iHabitacionBusiness.getHabitacion(idHabitacion);
    }
       
}
