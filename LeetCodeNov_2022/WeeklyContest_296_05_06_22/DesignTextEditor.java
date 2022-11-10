package WeeklyContest_296_05_06_22;

public class DesignTextEditor {

    private StringBuilder sb;
    private int pos;
    public DesignTextEditor() {
        this.sb = new StringBuilder();
    }

    public void addText(String text) {
        sb.insert(pos, text);
        pos += text.length();
    }

    public int deleteText(int k) {
        int temp = pos;
        pos -= k;
        if (pos < 0) {
            pos = 0;
        }
        sb.delete(pos, temp);
        return temp - pos;
    }

    public String cursorLeft(int k) {

        pos -= k;
        if (pos < 0) {
            pos = 0;
        }
        if (pos < 10) {
            return sb.substring(0, pos);
        }
        return sb.substring(pos - 10, pos);
    }

    public String cursorRight(int k) {
        pos += k;
        if (pos > sb.length()) {
            pos = sb.length();
        }
        if (pos < 10) {
            return sb.substring(0, pos);
        }
        return sb.substring(pos - 10, pos);
    }
}
