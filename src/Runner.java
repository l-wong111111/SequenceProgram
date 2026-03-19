import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        boolean storeAllTicks = true;
        ArrayList<Integer> seqPositions = new ArrayList<>();
        ArrayList<Tick> ticks = new ArrayList<>();
        ArrayList<Sequence> sequences = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            System.out.print("Enter: ");
            seqPositions.add(scan.nextInt() + 1);
        }

        sequences.add(new Sequence(6, seqPositions.get(0), 10));
        sequences.add(new Sequence(16, seqPositions.get(1), 50));
        sequences.add(new Sequence(51, seqPositions.get(2), 250));
        sequences.add(new Sequence(126, seqPositions.get(3), 5));

        int fullPeriod = 1;
        for (int i = 0; i < sequences.size(); i++) {
            fullPeriod *= sequences.get(i).getSeqLength(); //can be optimized if seqlengths have same factors, not needed for small values of seq length
        }

        if (storeAllTicks) {
            for (int timesDecremented = 1; timesDecremented <= fullPeriod; timesDecremented++) {
                ArrayList<Sequence> sequencesAt1 = new ArrayList<>();
                for (int i = 0; i < sequences.size(); i++) {
                    if (sequences.get(i).decrement() == 1) sequencesAt1.add(sequences.get(i));
                }
                ticks.add(new Tick(sequencesAt1, timesDecremented));
            }
        }
//        for (int i = 0; i < ticks.size(); i++) {
//            System.out.println(ticks.get(i).getMultiplier());
//        }
        printMultiplierTick(100000, ticks, 10);
    }

    private static void printMultiplierTick (int multiplier, ArrayList<Tick> ticks, int printAmount){
        int count = 0;
        for (Tick tick: ticks) {
            if (tick.getMultiplier() >= 100000) {
                System.out.println("Multi: " + tick.getMultiplier() + " Tick: " + tick.getTick());
                count++;
            }
            if (count == printAmount) break;
        }
    }
}
