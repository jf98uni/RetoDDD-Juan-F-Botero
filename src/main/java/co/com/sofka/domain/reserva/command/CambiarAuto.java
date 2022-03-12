package co.com.sofka.domain.reserva.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.reserva.valor.Auto;
import co.com.sofka.domain.reserva.valor.Costo;
import co.com.sofka.domain.reserva.valor.ReservaID;

public class CambiarAuto extends Command{

        private  final Auto auto;

        public CambiarAuto(ReservaID reservaID, Costo costo, Auto auto) {

            this.auto = auto;
        }

        public Auto getCosto() {
            return auto;
        }


    }

