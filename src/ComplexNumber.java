import java.util.Objects;

public final class ComplexNumber {
    /* ComplexNumber a = new ComplexNumber(1, 1);
        ComplexNumber b = new ComplexNumber(1, 1);
        System.out.println(a.equals(b));
        System.out.println(a.hashCode() == b.hashCode());
        вызов из мейна
        */

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