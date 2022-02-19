package TextAnalyzers;

public abstract class KeywordAnalyzer implements TextAnalyzer {
    protected abstract String[] getKeywords();

    protected abstract Label getLabel();

    @Override
    public Label processText(String text) {
        for (String token : getKeywords()) {
            if (text.contains(token)) {
                return getLabel();
            }
        }

        return Label.OK;
    }
}
