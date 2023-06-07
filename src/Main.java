import java.util.Arrays;
import java.util.stream.Stream;


 /**
 * The class Main
 */ 
public class Main {


/** 
 *
 * Main
 *І
 * @param args  the args. 
 */
    public static void main(String[] args) { 

        int[][] matrix = {
            {5, 2, 3},
            {4, 1, 3},
            {9, 2, 8}
        };

        int[] flattened = Arrays.stream(matrix)
                                .flatMapToInt(Arrays::stream)
                                .toArray();

        int mostFrequentNumber = Arrays.stream(flattened)
                                       .distinct()
                                       .boxed()
                                       .max((a, b) -> 
                                           (int) Arrays.stream(flattened).filter(x -> x == a).count() -
                                           (int) Arrays.stream(flattened).filter(x -> x == b).count()
                                       )
                                       .orElse(0);

        System.out.println("Most frequent number: " + mostFrequentNumber);
    }
}