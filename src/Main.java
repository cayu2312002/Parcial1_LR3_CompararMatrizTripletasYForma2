import lista.NodoDoble;
import matricesDispersas.MatrizEnTripleta;
import matricesDispersas.MatrizForma2;
import matricesDispersas.Tripleta;
import java.util.Random;

public class Main {
    public static void main (String [ ] args) {

        //GenerarMatrizEnTripletasYForma2Aleatoria(250, 70);
        GenerarMatrizEnTripletasYForma2Manualmente();

    }

    //Metodo que genera dos matrices iguales de manera aleatoria.
    public static void GenerarMatrizEnTripletasYForma2Aleatoria(int dimension, int elementos){
        MatrizEnTripleta m;
        MatrizForma2 a;
        //se define la tripleta principal para crear la matriz considerando la dimensión
        Tripleta t = new Tripleta(dimension, dimension, 0);
        m = new MatrizEnTripleta(t);
        a=new MatrizForma2(dimension,dimension);

        //se crea un generador de números aleatorios
        Random r = new Random();
        //un ciclo se repite tantas veces como tripletas hay que generar
        for (int i = 0; i < elementos; i++) {
            //se establece el rango para obtener las coordenadas según el número de filas y columnas ingresadas
            int f = r.nextInt(dimension) + 1;
            int c = r.nextInt(dimension) + 1;
            int d = r.nextInt(10);
            //se crea una tripleta con los valores de fila y columna obtenidos,
            //y un valor de -1 que corresponderá a las casillas con minas
            Tripleta tx = new Tripleta(f, c, d);
            //este ciclo verifica si ya hay un elemento con dichos valores de filas y columnas
            //en dicho caso vuelve a obtener los valores para no tener una posición repetida
            while (m.existe(f, c)) {
                f = r.nextInt(dimension) + 1;
                c = r.nextInt(dimension) + 1;
                tx = new Tripleta(f, c, d);
            }
            //se inserta la tripleta en la matriz
            m.insertaTripleta(tx);
            NodoDoble h=new NodoDoble(tx);
            a.conecta(h);
        }
        //se muestra la matriz creada en consola
        System.out.println("\n Matriz en tripletas:");
        m.muestraMatriz();
        System.out.println("\n \n");
        System.out.println("Matriz en forma 2:");
        a.muestraMatriz();
        comparar(m, a);
    }

    //Metodo que genera dos matrices ingresadas de manera manual.
    public static void GenerarMatrizEnTripletasYForma2Manualmente(){
        MatrizEnTripleta m;
        Tripleta tx;
        Tripleta t = new Tripleta(210, 210, 0);
        m = new MatrizEnTripleta(t);

        tx = new Tripleta(1, 2, 3);
        m.insertaTripleta(tx);
        tx = new Tripleta(2, 3, 8);
        m.insertaTripleta(tx);
        tx = new Tripleta(5, 1, 10);
        m.insertaTripleta(tx);
        tx = new Tripleta(4, 2, 7);
        m.insertaTripleta(tx);
        tx = new Tripleta(3, 5, 9);
        m.insertaTripleta(tx);
        //se muestra la matriz creada en consola
        System.out.println("\n Matriz en tripletas:");
        m.muestraMatriz();
        System.out.println("\n \n");


        MatrizForma2 a;
        a=new MatrizForma2(210, 210);
        Tripleta c=new Tripleta(1,2,3);
        NodoDoble h=new NodoDoble(c);
        a.conecta(h);
        c=new Tripleta(2,3,8);
        h=new NodoDoble(c);
        a.conecta(h);
        c=new Tripleta(5,1,10);
        h=new NodoDoble(c);
        a.conecta(h);
        c=new Tripleta(4,2,7);
        h=new NodoDoble(c);
        a.conecta(h);
        c=new Tripleta(3,5,9);
        h=new NodoDoble(c);
        a.conecta(h);
        System.out.println("Matriz en forma 2:");
        a.muestraMatriz();

        comparar(m, a);
    }

    //Metodo que compara si dos matrices son iguales o diferentes.
    public static void comparar(MatrizEnTripleta MatrizA, MatrizForma2 MatrizB2){
        //Primero comparamos si las dos matrices tienen la misma cantidad de filas, columnas y elementos diferentes de cero.
        int numeroFilasA=MatrizA.v[0].retornaFila();
        int numeroColumnasA=MatrizA.v[0].retornaFila();
        int numeroTripletasA=MatrizA.v[0].retornaValor();

        int numeroFilasB=MatrizB2.primero().retornaDato().retornaFila();
        int numeroColumnasB=MatrizB2.primero().retornaDato().retornaColumna();
        int numeroTripletasB=MatrizB2.primero().retornaDato().retornaValor();

        if (numeroFilasA==numeroFilasB && numeroColumnasA==numeroColumnasB && numeroTripletasA==numeroTripletasB){
            //System.out.println("\n Tienen la misma cantidad de filas, columnas y elementos diferentes de cero.");
            Tripleta tripletaActualEnA;
            int filaActualEnA, columnaActualEnA, valorActualEnA, filaActualEnB, columnaActualEnB, valorActualEnB;
            NodoDoble nodoSuperCabeza=MatrizB2.primero();
            NodoDoble nodoActualEnB=nodoSuperCabeza.retornaLD();
            for (int i=1; i<=numeroTripletasA; i++){
                tripletaActualEnA=MatrizA.v[i];
                filaActualEnA = tripletaActualEnA.retornaFila();
                columnaActualEnA = tripletaActualEnA.retornaColumna();
                valorActualEnA = tripletaActualEnA.retornaValor();
                nodoActualEnB=nodoActualEnB.retornaLD();
                filaActualEnB=nodoActualEnB.retornaDato().retornaFila();
                columnaActualEnB=nodoActualEnB.retornaDato().retornaColumna();
                valorActualEnB=nodoActualEnB.retornaDato().retornaValor();
                //Controladores para revisar en qué momento determina que son diferentes
                /*
                System.out.println("\n Comparamos las filas: "+filaActualEnA+" y "+filaActualEnB);
                System.out.println("Comparamos las columnas: "+columnaActualEnA+" y "+columnaActualEnB);
                System.out.println("Comparamos laos datos: "+valorActualEnA+" y "+valorActualEnB);
                 */
                if (!(filaActualEnA==filaActualEnB && columnaActualEnA==columnaActualEnB && valorActualEnA==valorActualEnB)){
                    System.out.println("\n Las matrices son diferentes.");
                    return;
                }
            }
            System.out.println("\n Las matrices son iguales.");
        }
        else {
            System.out.println("\n Las matrices son diferentes.");
        }
    }
}