import java.util.*;

public class ReconstructItinerary {

    Map<String, PriorityQueue<String>> map = new HashMap<>();
    List<String> route = new ArrayList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for(List<String> ticket: tickets) {
            if(!map.containsKey(ticket.get(0))) {
                PriorityQueue<String> pq = new PriorityQueue<>();
                pq.add(ticket.get(1));
                map.put(ticket.get(0),pq);
            }
            else {
                map.get(ticket.get(0)).add(ticket.get(1));
            }
        }
        visit("JFK");
        return route;
    }

    public void visit(String airport) {
        while(map.containsKey(airport) && !map.get(airport).isEmpty()) {
            PriorityQueue<String> dests = map.get(airport);
            String dest = dests.poll();
            visit(dest);
        }
        route.add(0,airport);
    }
}
