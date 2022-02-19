import org.jetbrains.annotations.NotNull;

public class AsciiCharSequence  implements CharSequence{
    public byte[] value;

    public AsciiCharSequence(byte[] arr) {
        value = arr;
    }

    @Override
    public int length() {
        return value.length;
    }

    @Override
    public char charAt(int index) {
        return (char) value[index];
    }

    @NotNull
    @Override
    public AsciiCharSequence subSequence(int start, int end) {
        byte[] result = new byte[end - start];
        int iterator = start;
        for (int i = 0; i < result.length; i++) {
            result[i] = value[iterator];
            iterator++;
        }
        return new AsciiCharSequence(result);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (byte val : value) {
            result.append((char) val);
        }
        return result.toString();
    }
}
