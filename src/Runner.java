import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) throws InterruptedException {
        boolean storeAllTicks = true;
        ArrayList<Tick> ticks = new ArrayList<>();
        ArrayList<Sequence> sequences = new ArrayList<>();

        sequences.add(new Sequence(6, 6, 10));
        sequences.add(new Sequence(16, 16, 50));
        sequences.add(new Sequence(51, 21, 250));
        sequences.add(new Sequence(126, 48, 5));

        int fullPeriod = 1;
        for (int i = 0; i < sequences.size(); i++) {
            fullPeriod *= sequences.get(i).getSeqLength(); //can be optimized if seqlengths have same factors, not needed for small values of seq length
        }

        if (storeAllTicks) {
            for (int timesDecremented = 1; timesDecremented <= fullPeriod; timesDecremented++) {
                ArrayList<Sequence> sequencesAt1 = new ArrayList<>();
                for (int i = 0; i < sequences.size(); i++) {
                    if (sequences.get(i).decrement() == 1) sequencesAt1.add(sequences.get(i));
                    System.out.print(sequences.get(i).getSeqPosition() - 1 + "  ");
                }
                ticks.add(new Tick(sequencesAt1, timesDecremented));
                System.out.println();

            }
        }
//        for (int i = 0; i < ticks.size(); i++) {
//            System.out.println(ticks.get(i).getMultiplier());
//        }
        for (Tick tick: ticks) {
            if (tick.getMultiplier() >= 50000) {
                System.out.println("Multi: " + tick.getMultiplier() + " Tick: " + tick.getTick());
            }
        }
    }
}
