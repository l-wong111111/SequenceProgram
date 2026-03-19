import java.util.ArrayList;

public class Tick {
    private ArrayList<Sequence> sequences;
    private int tick;

    public Tick(ArrayList<Sequence> sequences_, int tick_) {
        sequences = new ArrayList<Sequence>(sequences_);
        tick = tick_;
    }

    public double getMultiplier() {
        if (sequences.isEmpty()) return 0;
        double multiplier = 1;
        for (Sequence sequence : sequences) {
            multiplier *= sequence.getMultiplier();
        }
        return multiplier;
    }

    public ArrayList<Sequence> getSequences() {
        return sequences;
    }
}
