/*Juego de "4 en línea" contra la computadora

El objetivo del juego de "4 en línea" es ser el primero en conectar cuatro 
fichas del mismo color en línea vertical, horizontal o diagonal en un tablero 
de seis filas por siete columnas. En nuestro caso, utilizaremos las letras "J" 
para representar al jugador y "C" para representar a la computadora.
Para desarrollar este juego, debes crear los métodos necesarios para generar la
 matriz y replicar la lógica del juego. 
Además, deberás imprimir el tablero en pantalla, incluyendo un borde superior
 con los números de las columnas. La primera ficha de la computadora deberá ser 
 colocada en la columna central.

1 2 3 4 5 6 7 
O O O O O O O
O O O O O O O
O O O O O O O
O O O O O O O
O O O O O O O
O O O C O O O

💡Recuerda que en el juego de "4 en línea", el tablero se coloca perpendicular al
 piso, y las fichas caen ocupando la fila más baja disponible hasta toparse con 
 otra ficha.
A continuación, se solicitará al jugador que elija en qué columna desea colocar 
su ficha, y se actualizará la matriz de juego en consecuencia.
Después de cada movimiento, se verificará si las fichas del jugador o de la 
computadora forman una línea de 4 en línea, ya sea en posición horizontal, 
vertical o diagonal:
Si se encuentra una línea de cuatro, se mostrará un mensaje de victoria para el 
jugador correspondiente. 
En caso contrario, el juego continuará hasta que uno de los dos jugadores gane o 
ya no haya más espacios disponibles en el tablero, en cuyo caso se imprimirá un 
mensaje de empate.
Durante el turno de la computadora, deberás implementar la siguiente lógica: 
primero, se debe detectar si en el próximo turno alguno de los dos jugadores 
tiene la oportunidad de hacer un cuatro en línea:
En caso afirmativo, la computadora deberá colocar su ficha en la columna 
correspondiente para ganar o evitar que el jugador gane. 
Si no se detecta una oportunidad de victoria inmediata, la computadora deberá 
analizar cuál es la línea propia más cercana a completarse y colocar su ficha en 
la columna correspondiente.
*/

public class CuatroEnLinea {
public static void main(String[] args) {
    


    private static final int ROWS = 6;

    private static final int COLUMNS = 7;

    private static final char EMPTY = 'O';

    private static final char PLAYER_SYMBOL = 'J';

    private static final char COMPUTER_SYMBOL = 'C';

    private char[][] board;

    private boolean isPlayerTurn;

public ConnectFour() {
        board = 
       
new char[ROWS][COLUMNS];
        isPlayerTurn = 
       
true;
    

}

    if(isPlayerTurn)

    {
                
               
// Turno del jugador
                System.out.print(
                System.out.print

                System.out

                System

               
"Ingrese el número de columna (1-7) para colocar su ficha: ");
                int column = scanner.nextInt() - 1;

                if (isValidMove(column)) {
                    makeMove(column, PLAYER_SYMBOL);

                    
                    makeMove(column, PLAYER_SYMBOL);

                   

                    makeMove(column, PLAYER_SYMBOL);


                    makeMove(column,
if (isWinningMove(PLAYER_SYMBOL)) {
                        printBoard();
                        System.out.println(
                        printBoard();
                        System.out

                        printBoard();
                       

                        printBoard();
"¡Felicidades! ¡Has ganado!");
                        
                       
break;
                    }

                    isPlayerTurn = 
                    }

                   

                    }

    false;}else{System.out.println(System.out.println

    System.out

    "Movimiento inválido. Intente nuevamente.");}}else{

    // Turno de la computadora

    int column = chooseComputerMove();

    makeMove(column, COMPUTER_SYMBOL);

                

                makeMove(column, COMPUTER


                makeMove(column,
break;
                }

    isPlayerTurn=

    }

    }

    true;}

    }

    }

    if(isBoardFull()){printBoard();System.out.println(printBoard();System"¡El juego ha terminado en empate!");break;}}

    scanner.close();}

    }}

    scanner.close();

    }}

    scanner

    }rivate

    void printBoard() {
        System.out.println(
        System.out.println
"1 2 3 4 5 6 7");
        
       
for (int row = 0; row < ROWS; row++) {
            
           
for (int col = 0; col < COLUMNS; col++) {
                System.out.print(board[row][col] + 
                System.out

                System

               
" ");
            }
            System.out.println();
        }
    }

    }System.out.println();}}

    }System.out.println();}}

    }System.out.println();}

    }

private boolean isValidMove(int column) {
        return column >= 0 && column < COLUMNS && board[0][column] == EMPTY;
    }

    }

    }

private void makeMove(int column, char symbol) {
        
       
for (int row = ROWS - 1; row >= 0; row--) {
            
           
if (board[row][column] == EMPTY) {
                board[row][column] = symbol;
                
                board
break;
            }
        }
    }

    }}}

    }}
}

private boolean isWinningMove(char symbol) {
        // Comprobar en posición horizontal
        
       
for (int row = 0; row < ROWS; row++) {
            
           
for (int col = 0; col <= COLUMNS - 4; col++) {
                
               
if (board[row][col] == symbol && board[row][col + 1] == symbol &&
                    board[row][col + 
                    board[row][col + 

                    board[row][col +

                   
2] == symbol && board[row][col + 3] == symbol) {
                    return
}