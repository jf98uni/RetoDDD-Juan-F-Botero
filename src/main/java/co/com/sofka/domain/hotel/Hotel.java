package co.com.sofka.domain.hotel;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.hotel.event.*;
import co.com.sofka.domain.hotel.valor.*;

import java.util.List;

public class Hotel extends AggregateEvent<HotelID> {

    protected List<Cuarto> cuartos;
    protected List<Restaurante> restaurantes;
    protected DatosHotel datosHotel;

    public Hotel(HotelID hotelID , DatosHotel datosHotel) {
        super(hotelID);
        appendChange(new HotelCreado(datosHotel)).apply();
        subscribe(new HotelEventChange(this));
    }

    public void crearCuarto(CuartoID cuartoID,Personal personal){
        appendChange(new CuartoCreado(cuartoID,personal));

    }

    public void crearRestaurante(RestauranteID restauranteID,Location location){
        appendChange(new RestauranteCreado(restauranteID,location));
    }

    public void editarDatos(String nombre, String locacion){
        appendChange((new DatosEditados(nombre,locacion)));
    }

    public void editarPersonal(String nombre, String apellido, String cargo){
        appendChange((new PersonalEditado(nombre,apellido,cargo)));
    }

    public void editarLocacion(Location location){
        appendChange(new LocacionEditada(location));
    }
}
