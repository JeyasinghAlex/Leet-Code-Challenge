package WeeklyContest_317_30_10_22;

import java.util.*;

public class MostPopularVideoCreator {

    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {

        int n = creators.length;

        Map<String, Creator> map = new HashMap<>();

        for (int i = 0; i < n; ++i) {

            String creator = creators[i];
            String id = ids[i];
            int view = views[i];

            map.putIfAbsent(creator, new Creator());
            Creator cr = map.get(creator);

            Video video = new Video(id, view);
            cr.videos.add(video);
            cr.totalViewCount += view;
        }

        int max = Integer.MIN_VALUE;
        for (Creator c : map.values()) {
            max = Math.max(max, c.totalViewCount);
        }

        List<List<String>> ans = new ArrayList<>();

        for (Map.Entry<String, Creator> entry : map.entrySet()) {

            String key = entry.getKey();
            Creator value = entry.getValue();

            if (value.totalViewCount != max) {
                continue;
            }

            Collections.sort(value.videos, new Comparator<Video>() {

                @Override
                public int compare(Video a, Video b) {
                    int diff = Integer.compare(b.view, a.view);
                    if (diff != 0) {
                        return diff;
                    }
                    return a.id.compareTo(b.id);
                }
            });

            ans.add(Arrays.asList(key, value.videos.get(0).id));
        }
        return ans;
    }

    class Creator {

        List<Video> videos = new ArrayList<>();
        int totalViewCount = 0;
    }

    class Video {

        String id;
        int view;

        Video(String id, int view) {
            this.id = id;
            this.view = view;
        }
    }
}
