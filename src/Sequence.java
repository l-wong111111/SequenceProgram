public class Sequence {
    private int seqLength;
    private int seqPosition;
    private double multiplier;

    public Sequence (int seqLength_, int seqPosition_, double  multiplier_) {
        seqLength = seqLength_;
        seqPosition = seqPosition_;
        multiplier = multiplier_;
    }

    public int decrement() {
        seqPosition--;
        if (seqPosition == 0) seqPosition = seqLength;
        return seqPosition;
    }

    public int getSeqLength() {
        return seqLength;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public int getSeqPosition() {
        return seqPosition;
    }
}
