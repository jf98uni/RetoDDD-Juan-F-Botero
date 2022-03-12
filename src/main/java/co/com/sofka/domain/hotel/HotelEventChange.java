package co.com.sofka.domain.hotel;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.domain.hotel.event.*;
import co.com.sofka.domain.reserva.event.ReservaCreada;

import java.util.ArrayList;

public class HotelEventChange extends EventChange {
    public HotelEventChange(Hotel hotel) {

        apply((HotelCreado event) ->{
            hotel.datosHotel = event.getDatosHotel();
            hotel.cuartos = new ArrayList<>();
            hotel.restaurantes = new ArrayList<>();
        }
        );
        apply((CuartoCreado event) ->{
                    hotel.crearCuarto(event.getCuartoID(),event.getPersonal());
                }
        );

        apply((DatosEditados event) ->{
                    hotel.editarDatos(event.getNombre(), event.getLocation());
                }
        );

        apply((LocacionEditada event) ->{
                    hotel.editarLocacion(event.getLocation());
                }
        );

        apply((PersonalEditado event) ->{
                    hotel.editarPersonal(event.getNombre(),event.getApellido(),event.getCargo());
                }
        );

        apply((RestauranteCreado event) ->{
                    hotel.crearRestaurante(event.getRestauranteID(),event.getLocation());
                }
        );



    }
}
