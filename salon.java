/*
Universidad del Valle de Guatemala
cc2008 - POO
Seccion 10
Laboratorio #2
Eliazar Canastuj
carnet: 23384
*/

import java.util.*;

public class salon{
    private int Id_sede;
    private char lugar;
    private int nivel;
    private int id_salon;
    private int capacidad;
    private boolean disponible;

    public salon(int Id_sede, char lugar, int nivel, int id_salon, int capacidad, boolean disponible){
        this.Id_sede = Id_sede;
        this.lugar = lugar;
        this.nivel = nivel;
        this.id_salon = id_salon;
        this.capacidad = capacidad;
        this.disponible = disponible;
    }

    //metodos
    public int getNumero(){
        return this.Id_sede;
    }

    public char getLugar(){
        return this.lugar;
    }

    public int getNivel(){
        return this.nivel;
    }
    
    public int getCapacidad(){
        return this.capacidad;
    }

    public boolean getDisponible(){
        return this.disponible;
    }

    public int getIdSalon(){
        return this.id_salon;
    }


    

}