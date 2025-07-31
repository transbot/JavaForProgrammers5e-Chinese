import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.IntStream;

public class RollDie {

   public static void main(String[] args) {
      int rolls = 600_000_000;
      LongAdder[] counts = new LongAdder[6];
      for (int i = 0; i < counts.length; i++) {
         counts[i] = new LongAdder();
      }

      IntStream.range(0, rolls).parallel().forEach(i -> {
         int roll = ThreadLocalRandom.current().nextInt(1, 7);
         counts[roll - 1].increment();
      });

      System.out.printf("%-6s%-10s%n", "点数", "次数");
      for (int i = 0; i < counts.length; i++) {
         System.out.printf("%-6d%-10d%n", i + 1, counts[i].longValue());
      }
   }
}