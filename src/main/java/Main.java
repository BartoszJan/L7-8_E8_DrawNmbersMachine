import java.util.ArrayList;
import java.util.Comparator;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class Main {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(6);
        DrawNumbers number1 = new DrawNumbers();
        DrawNumbers number2 = new DrawNumbers();
        DrawNumbers number3 = new DrawNumbers();
        DrawNumbers number4 = new DrawNumbers();
        DrawNumbers number5 = new DrawNumbers();
        DrawNumbers number6 = new DrawNumbers();
        ArrayList<Integer> lottoNumbers = new ArrayList<Integer>();

        Future<Integer> futureNumber1 = executorService.submit(number1);
        Future<Integer> futureNumber2 = executorService.submit(number2);
        Future<Integer> futureNumber3 = executorService.submit(number3);
        Future<Integer> futureNumber4 = executorService.submit(number4);
        Future<Integer> futureNumber5 = executorService.submit(number5);
        Future<Integer> futureNumber6 = executorService.submit(number6);
        try {
            lottoNumbers.add(futureNumber1.get());
            lottoNumbers.add(futureNumber2.get());
            lottoNumbers.add(futureNumber3.get());
            lottoNumbers.add(futureNumber4.get());
            lottoNumbers.add(futureNumber5.get());
            lottoNumbers.add(futureNumber6.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();

        lottoNumbers.sort(Comparator.<Integer>naturalOrder());
        System.out.println(lottoNumbers);
    }
}
