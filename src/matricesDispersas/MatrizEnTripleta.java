package matricesDispersas;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * MatrizEnTripleta dispersa representada en forma de tripletas.
 */
public class MatrizEnTripleta {

    public Tripleta[] v;

    public MatrizEnTripleta(Tripleta t) {
        int n;
        n = t.retornaValor();
        v = new Tripleta[n + 2];
        v[0] = t;
    }

    public boolean esVacia() {
        Tripleta t = retornaTripleta(0);
        return t.retornaValor() == 0;
    }

    public int numeroFilas() {
        return v[0].retornaFila();
    }

    public int numeroColumnas() {
        return v[0].retornaColumna();
    }

    public int numeroTripletas() {
        return v[0].retornaValor();
    }

    public Tripleta retornaTripleta(int i) {
        return v[i];
    }

    public void asignaNumeroTripletas(int datos) {
        numeroTripletas();
        Tripleta[] aux = v;
        Tripleta ti, tj;
        ti = aux[0];
        tj = new Tripleta(ti.retornaFila(), ti.retornaColumna(), datos);
        v = new Tripleta[datos + 2];
        v[0] = tj;
        if (datos - 1 >= 0) System.arraycopy(aux, 1, v, 1, datos - 1);
    }

    /**
     * Muestra todos los elementos de la matriz.
     */
    public void muestraMatriz() {
        int p, f, c, i;
        int val;
        p = numeroTripletas();
        f = v[0].retornaFila();
        c = v[0].retornaColumna();
        val = v[0].retornaValor();
        System.out.println("\n\nCabeza: " + f + ", " + c + ", " + val);
        for (i = 1; i <= p; i++) {
            if (v[i] == null) {
                System.err.println("Nulo en i: " + i);
                return;
            }
            f = v[i].retornaFila();
            c = v[i].retornaColumna();
            val = v[i].retornaValor();
            //Necesaria modificación para GUI.
            System.out.println(f + ", " + c + ", " + val);
        }
    }

    /**
     * Inserta la tripleta t en su lugar correspondiente. La matriz está
     * ordenada por filas y luego por columnas de menor a mayor.
     * <p>
     * Tripleta a insertar.
     */
    public void insertaTripleta(Tripleta ti) {
        int i, j, datos;
        Tripleta t, tx;
        tx = retornaTripleta(0);
        datos = tx.retornaValor();
        i = 1;
        t = retornaTripleta(i);
        while (i <= datos && t.retornaFila() < ti.retornaFila()) {
            i = i + 1;
            t = retornaTripleta(i);
        }
        while (i <= datos && t.retornaFila() == ti.retornaFila() && t.retornaColumna() < ti.retornaColumna()) {
            i = i + 1;
            t = retornaTripleta(i);
        }
        j = datos;
        datos = datos + 1;
        asignaNumeroTripletas(datos);
        while (j >= i) {
            v[j + 1] = v[j];
            j = j - 1;
        }
        v[i] = ti;
    }

    public boolean existe(int fila, int columna) {
        if (fila <= 0 || columna <= 0 || fila > this.numeroFilas() || columna > this.numeroColumnas()) {
            return false;
        }
        int i = 1;
        Tripleta ti = this.retornaTripleta(1);
        while (ti != null) {
            if (ti.retornaFila() == fila && ti.retornaColumna() == columna) {
                return true;
            }
            i++;
            ti = this.retornaTripleta(i);
        }
        return false;
    }

    //busca un elemento con las fila y columna enviadas, retorna cero si no existe
    public int buscarPosicion(int fila, int columna) {
        int indice = 1;
        Tripleta t = this.retornaTripleta(1);
        while (indice < this.numeroTripletas() && (t.retornaFila() != fila || t.retornaColumna() != columna)) {
            indice++;
            if(indice <= this.numeroTripletas()){
                t = this.retornaTripleta(indice);
            }
        }
        if(indice > this.numeroTripletas()){ //cuidado con el cero
            return 0;
        }
        else {
            return indice;
        }
    }

    //busca un elemento con las fila y columna enviadas, retorna -1 si no existe
    public int buscarIndice(int fila, int columna) {
        int indice = 1;
        Tripleta t = this.retornaTripleta(1);
        while (indice <= this.numeroTripletas() && (t.retornaFila() != fila || t.retornaColumna() != columna)) {
            indice++;
            if(indice <= this.numeroTripletas()){
                t = this.retornaTripleta(indice);
            }
        }
        if(indice > this.numeroTripletas()){
            return -1;
        }
        else {
            return indice;
        }
    }

    public void mostrarMatrizCuadricula(){
        int[][] x = new int[v[0].retornaFila()][v[0].retornaColumna()];
        for (int i = 1; i <= this.numeroTripletas() ; i++) {
            Tripleta t = this.retornaTripleta(i);
            int f = t.retornaFila();
            int c = t.retornaColumna();
            x[f-1][c-1] = t.retornaValor();
        }

        for (int[] ints : x) {
            for (int j = 0; j < x[0].length; j++) {
                if (ints[j] == -1) {
                    System.out.print(" x ");
                } else {
                    System.out.print(" " + ints[j] + " ");
                }
            }
            System.out.println();
        }
    }

    //obtiene el valor almacenado en i,j
    public int getDato(int f, int c){
        if(buscarIndice(f,c)==-1){
            return 0;
        }
        else{
            Tripleta t = v[buscarIndice(f,c)];
            return t.retornaValor();
        }
    }
}