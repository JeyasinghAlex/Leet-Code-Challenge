package weekly_24_7_22;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class DesignFoodRatingSystem {

    class Food {
        String name;
        String cuisine;
        int rating;

        public Food(String name, String cuisine, int rating) {
            this.name = name;
            this.cuisine = cuisine;
            this.rating = rating;
        }
    }

    private Map<String, Food> menu;
    private Map<String, PriorityQueue<Food>> map;
    public DesignFoodRatingSystem(String[] foods, String[] cuisines, int[] ratings) {

        int n = foods.length;
        this.menu = new HashMap<>();
        this.map = new HashMap<>();

        for (int i = 0; i < n; ++i) {
            Food food = new Food(foods[i], cuisines[i], ratings[i]);
            map.putIfAbsent(cuisines[i], new PriorityQueue<>((a, b) -> a.rating != b.rating ? b.rating - a.rating : a.name.compareTo(b.name)));
            Queue<Food> pq = map.get(cuisines[i]);
            pq.offer(food);
            menu.put(foods[i], food);
        }
    }

    public void changeRating(String food, int newRating) {
        Food curr = menu.get(food);
        Queue<Food> pq = map.get(curr.cuisine);
        pq.remove(curr);
        curr.rating = newRating;
        pq.offer(curr);
    }

    public String highestRated(String cuisine) {
        return map.get(cuisine).peek().name;
    }
}
