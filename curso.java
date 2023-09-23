/*
Universidad del Valle de Guatemala
cc2008 - POO
Seccion 10
Laboratorio #2
Eliazar Canastuj
carnet: 23384
*/

import java.util.*;

public class curso{
    private int Id_curso;
    private int Id_sede;
    private String Nombre_curso;
    private int Horario;
    private int Duracion;
    private String dias;
    private int capacidad;

    public curso(int Id_curso, int Id_sede, String Nombre_curso, int Horario, int Duracion, String dias, int capacidad){
        this.Id_curso = Id_curso;
        this.Id_sede = Id_sede;
        this.Nombre_curso = Nombre_curso;
        this.Horario = Horario;
        this.Duracion = Duracion;
        this.dias = dias;
        this.capacidad = capacidad;

    }

    //metodos

    public int getIdCurso(){
        return this.Id_curso;
    }

    public int getIdSede(){
        return this.Id_sede;
    }

    public String getNombreCurso(){
        return this.Nombre_curso;
    }

    public int getHorario(){
        return this.Horario;
    }

    public String getDias(){
        return this.dias;
    }

    public int getCapacidad(){
        return this.capacidad;
    }

    

    


}