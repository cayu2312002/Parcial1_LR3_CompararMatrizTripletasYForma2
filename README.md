Parcial1_LR3_CompararMatrizTripletasYForma2

Miguel Angel Urueña Riobo – SEM 2021-2
miguel.uruena@udea.edu.co
Profesor: Alejandro Escobar


Enunciado:

La compañía VALIDADES mantiene una copia de las imágenes satelitales tomadas al planeta Marte. Las imágenes se toman cada 5 minutos y son procesadas por una super computadora, esta computadora convierte la imagen en una matriz de NxN, siempre n > 200, cada posición de la matriz tiene un número de contraste. Este número de contraste es un número del 0 al 9, donde 0 es que no hay contraste y 9 el mayor contraste. La empresa VALIDADES ya tiene todo el programa para la creación de cada matriz asociada a cada foto, es un super programa.  Tenga en cuenta que la matriz es cuadrada
VALIDADES tiene un problema, las fotos están desorganizadas y hay fotos iguales, por lo tanto, las matrices también son iguales. por esto la empresa lo ha contratado a usted para que realice un método llamado COMPARAR, que compare dos matrices (Matriz A y Matriz B), es decir, el programa compara dos fotos. La comparación al final debe decir si una foto es igual a otra. 
Tenga en cuenta que se entrega un objeto de la matriz A (representación en Tripletas) la matriz B está representada en un objeto de la matriz de lista ligada forma 1 para cedulas pares y un objeto en lista ligada forma 2 para las cedulas impares
NOTA IMPORTANTE: No puede usar el método getCelda. El método COMPARAR que va a realizar debe tener el recorrido de las matrices.
Recuerde:
•	Las dos matrices por comparar son dispersas, una está representada en tripletas y la otra está representada en ligada forma 1 y forma 2 según la cédula.
•	NO PUEDE utilizar el método getCelda, lo interesante de este ejercicio son los recorridos sobre la representación de las dos matrices.
•	IMPORTANTE el objeto de la matriz en tripleta le permite acceder al arreglo de Objetos del tipo Tripleta
•	IMPORTANTE el objeto de la matriz en lista ligada le permite acceder al Objeto Nodo super cabeza según sea forma 1 o forma 2.
•	Desde estos dos objetos se deben realizar los recorridos.

Planteamiento del Problema:

Se optó por implementar la solución del problema en código Java usando el IDE IntelliJ, estructurando el código mediante librerías y clases previamente realizadas organizadas de la siguiente manera:
1.	Lista:
  a.	Nodo doble
2.	matricesDispersas:
  a.	MatrizEnTripleta
  b.	MatrizForma2
  c.	Tripleta
3.	Main.

Librerías (Código):

Lista:

Nodo doble:

Se define la clase NodoDoble, con sus respectivos métodos: asignaLI, asignaLD, asignaDato, retornaLD, retornaLI. 
matricesDispersas:

MatrizEnTripleta:

Se define la clase MatrizEnTripleta, con sus respectivos métodos: numeroFilas, numeroColumnas, numeroTripletas, retornaTripleta, asignaNumeroTripletas, muestraMatriz, insertaTripleta, existe, buscarPosicion, bucarIndice, mostrarMatrizCuadricula y getDato. 

MatrizEnForma2:

Se define la clase MatrizForma2, con sus respectivos métodos: primero, cabezaPorFilas, cabezaPorColumnas, esVacia, finRecorrido, muestraMatriz, conectaPorFilas, conectaPorColumnas, conecta, numeroDeElementos, numeroFilas y numeroColumnas. 

Tripleta:

Se define la clase Tripleta, con sus respectivos métodos: Tripleta, retornaFila, retornaColumna, retornaValor, asignaFila, asignaColumna y asignaValor. 

Main:

Se define la clase “Main”, con las siguientes funciones:

main: 

Esta función llama a la ejecución de una de las dos funciones siguientes, GenerarMatrizEnTripletasYForma2Aleatoria(int dimension, int elementos) o GenerarMatrizEnTripletasYForma2Manualmente(), dependiendo de la que encuentre habilitada, es decir que dependiendo de lo que uno desee comenta la función que no usará. 

GenerarMatrizEnTripletasYForma2Aleatoria(int dimension, int elementos): 

Esta función recibe dos enteros que corresponden a la dimensión y número de elementos deseado para las matrices, posteriormente crea una MatrizEnTripleta y una MatrizForma2 con sus elementos iguales y genera y ubica los elementos de manera aleatoria con la restricción de que el dato debe estar entre 1 y 9. Finalmente muestra por consola las dos matrices iguales generadas e invoca la función “comparar”.
GenerarMatrizEnTripletasYForma2Manualmente(): 

Esta función crea una MatrizEnTripleta y una MatrizForma2 con los nodos y tripletas previamente definidos. Finalmente muestra por consola las dos matrices generadas e invoca la función “comparar”.

comparar(MatrizEnTripleta MatrizA, MatrizForma2 MatrizB2): 

Esta función recibe como parámetros dos matrices ordenadas que corresponden a una MatrizEnTripleta y una MatrizForma2. Posteriormente 	compara si las dos matrices tienen la misma cantidad de filas, columnas y elementos diferentes de cero. En caso de que no se cumpla la condición se indica que las matrices son diferentes; en caso de que se cumpla entonces se comienzan a recorrer simultáneamente las dos matrices comparando si todas las posiciones de la matrizA son iguales a las posiciones de la matrizB2, en caso de ser iguales se indica que las matrices son iguales, en caso de encontrar un elemento que sea diferente de inmediato se indica que las matrices son diferentes y se termina el programa.

Link Repositorio:

Para una mejor visualización, se recomienda dirigirse al repositorio del programa en GitHub, mediante el siguiente link: https://github.com/cayu2312002/Parcial1_LR3_CompararMatrizTripletasYForma2
Adicionalmente se garantiza una mejor experiencia descargando el repositorio y ejecutándolo con el IDE IntelliJ, en el cual podrá observar a detalle el código y correr el programa para analizarlo en funcionamiento.
