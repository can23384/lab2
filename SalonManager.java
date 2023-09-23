/*
Universidad del Valle de Guatemala
cc2008 - POO
Seccion 10
Laboratorio #2
Eliazar Canastuj
carnet: 23384
*/

import java.util.ArrayList;
import java.util.List;

public class SalonManager {
    private List<List<salon>> salonesPorEdificio;


    public SalonManager(List<List<salon>> salonesPorEdificio) {
        this.salonesPorEdificio = salonesPorEdificio;
    }


    public salon buscarSalon(int idSede, int idSalon, char edificio, int nivel) {
        int indiceEdificio = edificio - 'A'; // Convierte el carácter en un índice

        if (indiceEdificio >= 0 && indiceEdificio < salonesPorEdificio.size()) {
            List<salon> salonesDelEdificio = salonesPorEdificio.get(indiceEdificio);

            for (salon salon : salonesDelEdificio) {
                if (salon.getNumero() == idSede &&
                    salon.getIdSalon() == idSalon &&
                    salon.getNivel() == nivel) {
                    System.out.println("Sede: " + salon.getNumero());
                    System.out.println("Edificio: " + salon.getLugar());
                    System.out.println("Nivel: " + salon.getNivel());
                    System.out.println("id_salon: " + salon.getIdSalon());
                    return salon; 
                }
            }
        }

        return null; // Devuelve null si el salón no se encuentra
    }
    

}





