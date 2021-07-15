public class CrawlerLogFolder {

    public int minOperations(String[] logs) {

        int step = 0;
        for (String log : logs) {

            if (log.equals("./"))
                continue;
            if (log.equals("../")) {
                step--;
                step = Math.max(step, 0);
            } else {
                step++;
            }
        }
        return step;
    }
}
