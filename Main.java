import java.util.Scanner;

public class Main {

    public static void bubbleSort(int[] array) {
        int n = array.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
            System.out.println("After iteration " + (i + 1));
            printArray(array);
        }
    }

    public static void quickSort(String[] array, int low, int high) {
        if (low < high) {
            int pivot = partition(array, low, high);
            quickSort(array, low, pivot - 1);
            quickSort(array, pivot + 1, high);
        }
    }

    public static int partition(String[] array, int low, int high) {
        String pivot = array[high];
        int index = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j].compareToIgnoreCase(pivot) <= 0) {
                index++;
                String temp = array[index];
                array[index] = array[j];
                array[j] = temp;
            }
        }
        String temp = array[index + 1];
        array[index + 1] = array[high];
        array[high] = temp;
        return index + 1;
    }

    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void printArray(String[] array) {
        for (String word : array) {
            System.out.println(word);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose sorting method:");
        System.out.println("1 - Bubble Sort");
        System.out.println("2 - Quick Sort");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Enter the number of elements:");
                int n = scanner.nextInt();
                int[] intArray = new int[n];
                System.out.println("Enter the elements:");
                for (int i = 0; i < n; i++) {
                    intArray[i] = scanner.nextInt();
                }
                System.out.println("Unsorted array:");
                printArray(intArray);
                bubbleSort(intArray);
                System.out.println("Sorted array:");
                printArray(intArray);
                break;

            case 2:
                System.out.println("Enter the number of words:");
                int m = scanner.nextInt();
                scanner.nextLine();
                String[] strArray = new String[m];
                System.out.println("Enter the words:");
                for (int i = 0; i < m; i++) {
                    strArray[i] = scanner.nextLine();
                }
                quickSort(strArray, 0, m - 1);
                System.out.println("Sorted words:");
                printArray(strArray);
                break;

            default:
                System.out.println("Invalid choice!");
        }

        scanner.close();
    }
}
