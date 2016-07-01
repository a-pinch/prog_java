package org.stepic.pinch.s35_9;

class TooLongTextAnalyzer implements TextAnalyzer {

    private final int maxLength;

    TooLongTextAnalyzer(int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public Label processText(String text) {
        return text!= null && text.length()>maxLength ? Label.TOO_LONG : Label.OK;
    }
}
