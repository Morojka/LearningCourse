package TextAnalyzers;

public class TooLongTextAnalyzer implements TextAnalyzer{
    private int maxLength;

    public TooLongTextAnalyzer(int commentMaxLength) {
        maxLength = commentMaxLength;
    }

    @Override
    public Label processText(String text) {
        if (text.length() > maxLength) {
            return Label.TOO_LONG;
        }

        return Label.OK;
    }
}