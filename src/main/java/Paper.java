class Paper {
    private String text;

    void setText(String text) {
        this.text = text;
    }

    String getText() {
        return text;
    }

    void writeText(Character textToWrite) {
        if (text == null) {
            text = String.valueOf(textToWrite);
        } else {
            text = String.valueOf(new StringBuilder(text).append(textToWrite));
        }
    }
}
