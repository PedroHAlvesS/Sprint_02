package components;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPhraseEmotion {

    private Pattern funnyEmotion;
    private Pattern upsetEmotion;
    private String phrase;

    public RegexPhraseEmotion(String phrase) {
        this.funnyEmotion = Pattern.compile(":-)", Pattern.LITERAL);
        this.upsetEmotion = Pattern.compile(":-(", Pattern.LITERAL);
        this.phrase = phrase;
    }

    public String getPhraseEmotion() {
        long numberOfFunnyEmoticon = this.howMuchFunnyEmoticon();
        long numberOfUpsetEmoticon = this.howMuchUpsetEmoticon();

        if (numberOfFunnyEmoticon > numberOfUpsetEmoticon) {
            return "Divertido!";
        } else if (numberOfFunnyEmoticon < numberOfUpsetEmoticon) {
            return "Chateado!";
        } else {
            return "Neutro!";
        }
    }

    private long howMuchFunnyEmoticon() {
        Matcher funnyMatcher = this.funnyEmotion.matcher(this.phrase);
        return funnyMatcher.results().count();
    }

    private long howMuchUpsetEmoticon() {
        Matcher upsetMatcher = this.upsetEmotion.matcher(this.phrase);
        return upsetMatcher.results().count();
    }
}
