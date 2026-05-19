public class Problema3 {

    public static int mergeSortYContar(int[] arr, int izquierdo, int derecho) {
        int conteo = 0;

        if (izquierdo < derecho) {
            int medio = (izquierdo + derecho) / 2;
            conteo += mergeSortYContar(arr, izquierdo, medio);
            conteo += mergeSortYContar(arr, medio + 1, derecho);
            conteo += fusionarYContar(arr, izquierdo, medio, derecho);

        }

        return conteo;
    }

    private static int fusionarYContar(int[] arr, int izquierdo, int medio, int derecho) {
        int[] temp = new int[derecho - izquierdo + 1];
        int i = izquierdo;
        int j = medio + 1;
        int k = 0;
        int inversionesCruzadas = 0;

        while (i <= medio && j <= derecho) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                inversionesCruzadas += (medio - i + 1);

            }
        }

        while (i <= medio) {
            temp[k++] = arr[i++];

        }
        while (j <= derecho) {
            temp[k++] = arr[j++];

        }

        for (int x = 0; x < temp.length; x++) {
            arr[izquierdo + x] = temp[x];

        }

        return inversionesCruzadas;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2};
        int total = mergeSortYContar(arr, 0, arr.length - 1);
        System.out.println("Resultado: " + total);
    }
}
