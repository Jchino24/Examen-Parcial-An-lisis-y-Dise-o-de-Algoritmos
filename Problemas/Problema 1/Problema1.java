public class Problema1 {

    public static boolean ordenado(int[] arr, int n) {
        if (n <= 1) {
            return true;
        }

        if (arr[n - 2] > arr[n - 1]) {
            return false;
        }

        return ordenado(arr, n - 1);
    }

    public static void main(String[] args) {
        int[] ejemplo1 = {1, 2, 3, 5, 8};
        int[] ejemplo2 = {1, 4, 2, 8};
        System.out.println("Resultado 1: " + ordenado(ejemplo1, ejemplo1.length));
        System.out.println("Resultado 2: " + ordenado(ejemplo2, ejemplo2.length));
    }
}
