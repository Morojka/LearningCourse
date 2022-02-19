package TextAnalyzers;

public class NegativeTextAnalyzer extends KeywordAnalyzer implements TextAnalyzer{

    public String[] negativeTokens = new String[] {":(", "=(", ":|"};

    @Override
    public String[] getKeywords() {
        return negativeTokens;
    }

    @Override
    public Label getLabel() {
        return Label.NEGATIVE_TEXT;
    }
}