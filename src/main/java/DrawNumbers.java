import java.util.Random;
import java.util.concurrent.Callable;

/**
 * Created by Bartek on 2017-09-06.
 */
public class DrawNumbers implements Callable<Integer>{
    private Random random = new Random();

    public Integer call() throws Exception {
        Integer number = random.nextInt(50);
        return number;
    }

    @Override
    public String toString() {
        return "DrawNumbers{" +
                "random=" + random +
                '}';
    }
}
