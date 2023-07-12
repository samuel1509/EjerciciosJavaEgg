import java.util.Scanner;

public class JuegoAhorcado {
    private char[] palabra;
    private int letrasEncontradas;
    private int intentosMaximos;

    public JuegoAhorcado(char[] palabra, int intentosMaximos) {
        this.palabra = palabra;
        this.letrasEncontradas = 0;
        this.intentosMaximos = intentosMaximos;
    }

    public char[] getPalabra() {
        return palabra;
    }

    public void setPalabra(char[] palabra) {
        this.palabra = palabra;
    }

    public int getLetrasEncontradas() {
        return letrasEncontradas;
    }

    public void setLetrasEncontradas(int letrasEncontradas) {
        this.letrasEncontradas = letrasEncontradas;
    }

    public int getIntentosMaximos() {
        return intentosMaximos;
    }

    public void setIntentosMaximos(int intentosMaximos) {
        this.intentosMaximos = intentosMaximos;
    }
}

public class JuegoAhorcadoServicio {
    private JuegoAhorcado juego;

    public void inicializarJuego() {
        // Aquí puedes agregar más palabras al array de palabras disponibles
        String[] palabras = { "hola", "adios", "casa", "perro", "gato" };
        int indicePalabraAleatoria = (int) (Math.random() * palabras.length);
        String palabraAleatoria = palabras[indicePalabraAleatoria];
        char[] letrasPalabraAleatoria = palabraAleatoria.toCharArray();
        juego = new JuegoAhorcado(letrasPalabraAleatoria, 6);
    }

    public void ejecutarJuego() {
        Scanner scanner = new Scanner(System.in);
        char[] palabra = juego.getPalabra();
        int intentosMaximos = juego.getIntentosMaximos();
        int letrasEncontradas = juego.getLetrasEncontradas();
        int intentosRealizados = 0;
        boolean[] letrasDescubiertas = new boolean[palabra.length];

        while (letrasEncontradas < palabra.length && intentosRealizados < intentosMaximos) {
            System.out.print("Ingresa una letra: ");
            char letra = scanner.nextLine().charAt(0);

            boolean letraEncontrada = false;
            for (int i = 0; i < palabra.length; i++) {
                if (palabra[i] == letra && !letrasDescubiertas[i]) {
                    letrasDescubiertas[i] = true;
                    letrasEncontradas++;
                    letraEncontrada = true;
                }
            }

            if (letraEncontrada) {
                System.out.println("¡Letra encontrada!");
            } else {
                intentosRealizados++;
                System.out.println("Letra incorrecta. Intentos restantes: " + (intentosMaximos - intentosRealizados));
            }

            System.out.println("Estado actual: " + obtenerEstadoActual(palabra, letrasDescubiertas));
        }

        if (letrasEncontradas == palabra.length) {
            System.out.println("¡Felicidades, has ganado!");
        } else {
            System.out.println("Lo siento, has perdido. La palabra era: " + new String(palabra));
        }
    }

    private String obtenerEstadoActual(char[] palabra, boolean[] letrasDescubiertas) {
        StringBuilder estadoActual = new StringBuilder();
        for (int i = 0; i < palabra.length; i++) {
            if (letrasDescubiertas[i]) {
                estadoActual.append(palabra[i]);
            } else {
                estadoActual.append("_");
            }
            estadoActual.append(" ");
        }
        return estadoActual.toString();
    }
}

public class MenuClaseServicio {
    private JuegoAhorcadoServicio juegoAhorcadoServicio;

    public MenuClaseServicio() {
        juegoAhorcadoServicio = new JuegoAhorcadoServicio();
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("===== Menú =====");
            System.out.println("1. Comenzar a jugar");
            System.out.println("2. Salir");
            System.out.print("Ingrese una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    juegoAhorcadoServicio.inicializarJuego();
                    juegoAhorcadoServicio.ejecutarJuego();
                    break;
                case 2:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        MenuClaseServicio menuClaseServicio = new MenuClaseServicio();
        menuClaseServicio.mostrarMenu();
    }
}
