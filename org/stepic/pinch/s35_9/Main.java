package stepic.pinch.s35_9;

public class Main {
    public static void main(String[] args) {
        System.out.println(checkLabels(new TextAnalyzer[]{new TooLongTextAnalyzer(25), new SpamAnalyzer(new String[]{"buy","sell"}), new NegativeTextAnalyzer()}, args[0]));
    }

    public static Label checkLabels(TextAnalyzer[] analyzers, String text) {
        Label res;
        for(TextAnalyzer analyzer:analyzers){
            if((res = analyzer.processText(text)) != Label.OK)
                return res;
        }
        return Label.OK;
    }
}
