class Paper {
    private String text;

    void setText(String text) {
        this.text = text;
    }

    String getText() {
        return text;
    }

    void writeText(String textToWrite) {
        if (this.text == null) {
            this.setText(textToWrite);
        } else {
            this.setText(String.valueOf(new StringBuilder(this.text).append(" ").append(textToWrite)));
        }
    }
}
