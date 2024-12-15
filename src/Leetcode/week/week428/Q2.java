package Leetcode.week.week428;

import java.util.*;

public class Q2 {
    /*
    两天自由外汇交易后的最大货币数
     */

    public double maxAmount(String initialCurrency, List<List<String>> pairs1,
                            double[] rates1, List<List<String>> pairs2, double[] rates2) {

        Map<String, Map<String, Double>> graph1 = buildGraph(pairs1, rates1);
        Map<String, Map<String, Double>> graph2 = buildGraph(pairs2, rates2);

        Map<String, Double> day1Result = maxCurrency(initialCurrency, graph1);

        double maxCurrency = 0.0;
        for (String currency : day1Result.keySet()){
            double amount = day1Result.get(currency);
            Map<String, Double> day2Result = maxCurrency(currency, graph2);
            maxCurrency = Math.max(maxCurrency, day2Result.getOrDefault(initialCurrency, 0.0) * amount);
        }

        return maxCurrency;
    }

    private Map<String, Double> maxCurrency(String initialCurrency, Map<String, Map<String, Double>> graph) {
        Map<String, Double> maxRates = new HashMap<>();
        Queue<String> queue = new LinkedList<>();

        maxRates.put(initialCurrency, 1.0);
        queue.offer(initialCurrency);

        while (!queue.isEmpty()){
            String current = queue.poll();
            double currentRate = maxRates.get(current);

            for (Map.Entry<String, Double> entry : graph.getOrDefault(current, new HashMap<>()).entrySet()){
                String neighbor = entry.getKey();
                double rate = entry.getValue();

                if (currentRate * rate > maxRates.getOrDefault(neighbor, 0.0)){
                    maxRates.put(neighbor, currentRate * rate);
                    queue.offer(neighbor);
                }
            }
        }

        return maxRates;
    }

    private Map<String, Map<String, Double>> buildGraph(List<List<String>> pairs, double[] rates) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0;i < pairs.size();i++){
            String start = pairs.get(i).get(0);
            String target = pairs.get(i).get(1);
            double rate = rates[i];

            graph.putIfAbsent(start, new HashMap<>());
            graph.putIfAbsent(target, new HashMap<>());

            graph.get(start).put(target, rate);
            graph.get(target).put(start, 1.0 / rate);
        }

        return graph;
    }
}
