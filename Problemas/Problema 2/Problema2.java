public class Problema2 {

    public static int[] buscarDosMayores(int[] arr, int izq, int der) {

        if (izq + 1 == der) {
            if (arr[izq] > arr[der]) {
                return new int[]{arr[izq], arr[der]};
            } else {
                return new int[]{arr[der], arr[izq]};
            }
        }

        if (izq == der) {
            return new int[]{arr[izq], arr[izq]};
        }

        int medio = (izq + der) / 2;
        int[] resultadoIzq = buscarDosMayores(arr, izq, medio);
        int[] resultadoDer = buscarDosMayores(arr, medio + 1, der);
        int maxGlobal;
        int segGlobal;

        if (resultadoIzq[0] > resultadoDer[0]) {
            maxGlobal = resultadoIzq[0];

            if (resultadoIzq[1] > resultadoDer[0]) {
                segGlobal = resultadoIzq[1];

            } else {
                segGlobal = resultadoDer[0];

            }
        } else {
            maxGlobal = resultadoDer[0];

            if (resultadoIzq[0] > resultadoDer[1]) {
                segGlobal = resultadoIzq[0];

            } else {
                segGlobal = resultadoDer[1];

            }
        }

        return new int[]{maxGlobal, segGlobal};
    }

    public static int obtenerSegundo(int[] arr) {
        if (arr.length < 2) {
            return -1;
        }
        int[] resultado = buscarDosMayores(arr, 0, arr.length - 1);
        return resultado[1];
    }

    public static void main(String[] args) {
        int[] arreglo = {8, 3, 10, 5, 7};
        System.out.println("Segundo mas granded: " + obtenerSegundo(arreglo));
    }
}
