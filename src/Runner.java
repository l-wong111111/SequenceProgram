import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        boolean storeAllTicks = true;
        ArrayList<Tick> ticks = new ArrayList<>();
        ArrayList<Sequence> sequences = new ArrayList<>();

        sequences.add(new Sequence(6, 1, 2));
        sequences.add(new Sequence(7, 1, 5));
        sequences.add(new Sequence(8, 1, 10));

        int fullPeriod = 1;
        for (int i = 0; i < sequences.size(); i++) {
            fullPeriod *= sequences.get(i).getSeqLength(); //can be optimized if seqlengths have same factors, not needed for small values of seq length
        }

        if (storeAllTicks) {
            for (int timesDecremented = 1; timesDecremented <= fullPeriod; timesDecremented++) {
                ArrayList<Sequence> sequencesAt1 = new ArrayList<>();
                for (int i = 0; i < sequences.size(); i++) {
                    if (sequences.get(i).decrement() == 1) sequencesAt1.add(sequences.get(i));
                    System.out.print(sequences.get(i).getSeqPosition());
                }
                ticks.add(new Tick(sequencesAt1, timesDecremented));
                System.out.println();
            }
        }

//        for (int i = 0; i < ticks.size(); i++) {
//            System.out.println(ticks.get(i).getMultiplier());
//        }



    }
}
