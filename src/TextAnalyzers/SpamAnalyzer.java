package TextAnalyzers;

public class SpamAnalyzer extends KeywordAnalyzer implements TextAnalyzer{
    private String[] keywords;

    public SpamAnalyzer(String[] spamKeywords) {
        keywords = spamKeywords;
    }

    @Override
    public String[] getKeywords() {
        return keywords;
    }

    @Override
    public Label getLabel() {
        return Label.SPAM;
    }
}