/*
Universidad del Valle de Guatemala
cc2008 - POO
Seccion 10
Laboratorio #2
Eliazar Canastuj
carnet: 23384
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class main{
    public static void main(String[] args) {
        //Crear las variables nesesarias
        String archivoCSV = "salones.csv";
        List<List<salon>> salonesPorEdificio = new ArrayList<>();
        Scanner teclado = new Scanner(System.in);


        try {
            File archivo = new File(archivoCSV);
            Scanner scanner = new Scanner(archivo);

            // Inicializa la lista de salones para cada edificio
            for (int i = 0; i < 26; i++) { // Suponiendo que los edificios son letras del alfabeto de la 'A' a la 'Z'
                salonesPorEdificio.add(new ArrayList<>());
            }

            // Lee el archivo línea por línea
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] campos = linea.split(";");

                if (campos.length == 5) {
                    int idSede = Integer.parseInt(campos[0].trim());
                    char edificio = campos[1].trim().charAt(0);
                    int nivel = Integer.parseInt(campos[2].trim());
                    int idSalon = Integer.parseInt(campos[3].trim());
                    int capacidad = Integer.parseInt(campos[4].trim());

                    salon salon = new salon(idSede, edificio, nivel, idSalon, capacidad, false);

                    int indiceEdificio = edificio - 'A'; 
                    salonesPorEdificio.get(indiceEdificio).add(salon);

                    System.out.println("Se añadió el salón " + idSalon + " al edificio " + edificio);

                } else {
                    System.err.println("Error en el formato de la línea: " + linea);
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("El archivo CSV no se encontró: " + archivoCSV);
            e.printStackTrace();
        }



        //lectura del archivo de cursos
        String archivoCursos = "cursos.csv";
        List<curso> cursos = new ArrayList<>();


        try {
            File archivos = new File(archivoCursos);
            Scanner skaner = new Scanner(archivos);

            
            while (skaner.hasNextLine()) {
                    String linea = skaner.nextLine();
                    String[] campos = linea.split(";");

                    if (campos.length == 7) {
                        int idCurso = Integer.parseInt(campos[0].trim());
                        int idSede = Integer.parseInt(campos[1].trim());
                        String nombreCurso = campos[2].trim();
                        int horario = Integer.parseInt(campos[3].trim());
                        int duracion = Integer.parseInt(campos[4].trim());
                        String dias = campos[5].trim();
                        int cantidadEstudiantes = Integer.parseInt(campos[6].trim());

                        curso curso = new curso(idCurso, idSede, nombreCurso, horario, duracion, dias, cantidadEstudiantes);
                        cursos.add(curso);

                    } else {
                        System.err.println("Error en el formato de la línea: " + linea);
                    }
                }
                skaner.close();
        } catch (FileNotFoundException e) {
            System.err.println("El archivo CSV no se encontró: " + archivoCursos);
            e.printStackTrace();
        }


        //menu
        boolean hola = true;
        while(hola){
            System.out.println("========================");
            System.out.println("Elija una opcion: ");
            System.out.println("1. consultar un salón");
            System.out.println("2. mostrar los detalles del curso");
            System.out.println("3. signación de salón a los cursos");
            System.out.println("========================");
            int opcion = teclado.nextInt();
            teclado.nextLine();


            switch(opcion){
                case 1:
                    System.out.println("Ingrese el id de sede: ");
                    int idSedeBusqueda = teclado.nextInt();
                    teclado.nextLine();

                    System.out.println("El id del salón: ");
                    int idSalonBusqueda = teclado.nextInt();
                    teclado.nextLine();

                    System.out.println("El edificio: ");
                    String input = teclado.next();
                    char edificioBusqueda = input.charAt(0);

                    System.out.println("El nivel: ");
                    int nivelBusqueda = teclado.nextInt();
                    teclado.nextLine();


                    SalonManager salonManager = new SalonManager(salonesPorEdificio);
                    salonManager.buscarSalon(idSedeBusqueda, idSalonBusqueda, edificioBusqueda, nivelBusqueda);

                    break;

                case 2:
                    System.out.print("Introdusca el ID del curso: ");
                    int idBuscado = teclado.nextInt();
                    teclado.nextLine();

                    for (curso curso : cursos) {
                        if (curso.getIdCurso() == idBuscado) {
                            System.out.println("ID: " + curso.getIdCurso());
                            System.out.println("Sede: " + curso.getIdSede());
                            System.out.println("Nombre Curso: " + curso.getNombreCurso());
                            System.out.println("Horario: " + curso.getHorario() + "" +  curso.getDias());
                            System.out.println("Cantidad Estudiantes: " + curso.getCapacidad());
                            break;
                        }
                    }

                    break;


                case 3:
                    System.out.print("No pude hacer esta opcion :C");
                    break;
            }


        }



    


    
    }
}

