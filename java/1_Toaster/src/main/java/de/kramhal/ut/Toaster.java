package de.kramhal.ut;

public class Toaster {
    public enum ToastResult {
        RAW(3.0), MEDIUM(5.0), BURNED(5.5), COAL(7.0);

        private final double upperLimit;

        ToastResult(double upperLimit) {
            this.upperLimit = upperLimit;
        }

        static ToastResult getHumanReadable(double v) {
            for (ToastResult tr : ToastResult.values()) {
                if(v < tr.upperLimit)
                    return tr;
            }
            return COAL;
        }
    }
    public enum Bread {
        WHITE(3.0), BROWN(2.0), FULL_GRAIN(1.0);

        final double factor;

        Bread(double factor) {
            this.factor = factor;
        }
    }

    private double duration = 0.0;

    public ToastResult toast(Bread bread) {
        return ToastResult.getHumanReadable(duration*bread.factor);
    }

    public void setToastDuration(double duration) {
        if(Double.isNaN(duration))
            throw new IllegalArgumentException("Hä?");
        if(duration < 0.0)
            this.duration = 0.0;
        if(duration > 6.0)
            this.duration = 6.0;
        this.duration = duration;
    }

}
