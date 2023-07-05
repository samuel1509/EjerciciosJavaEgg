package src;

public class NombreyEdad {
    public static void main(String[] args) {
        int edad=45;
        String nombre="Cristian";

        mensaje(nombre,edad);
    }

    static void mensaje(String nombre,int edad){
        System.out.println("Me llamo "+nombre+" y tengo "+edad+" anios.");
    }
}
