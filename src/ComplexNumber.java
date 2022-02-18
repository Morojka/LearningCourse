import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public final class ComplexNumber {
    private final double re;
    private final double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof ComplexNumber) {
            ComplexNumber other = (ComplexNumber) o;
            return other.getIm() == im && other.getRe() == re;
        } else {
            return false;
        }

    }

    @Override
    public int hashCode() {
        return Objects.hash(getRe(), getIm());
    }
}