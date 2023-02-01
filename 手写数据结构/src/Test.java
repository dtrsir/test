import com.zhong.KMP.KMP;

public class Test {
    public static void main(String[] args) {
        int[] array = {5, 3, 4, 6, 2};
        int tmp;
        int index = 0;

        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                tmp = array[i];
                for (int j = i - 1; j >= 0 && array[j] > tmp; j--) {
                    array[j + 1] = array[j];
                    index = j;
                }
                array[index] = tmp;
            }
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }


    public static void swap(int[] array, int a, int b) {
        int tmp = 0;
        tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }


}
