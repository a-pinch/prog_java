package stepic.pinch.s35_9;

class NegativeTextAnalyzer extends KeywordAnalyzer {

    private final String[] keywords = new String[]{":(", "=(", ":|"};

    @Override
    protected String[] getKeywords() {
        return keywords;
    }

    @Override
    protected Label getLabel() {
        return Label.NEGATIVE_TEXT;
    }
}
