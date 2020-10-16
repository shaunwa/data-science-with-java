package com.shaunwassell;

import java.util.*;
import java.util.stream.Collectors;

public class KNNClassifier {
    private List<DataPoint> dataPoints;

    static class Pair {
        public final String key;
        public final Float value;

        public Pair(String key, Float value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "key='" + key + '\'' +
                    ", value=" + value +
                    '}';
        }
    }

    public KNNClassifier() {
        this.dataPoints = new ArrayList<>();
    }

    public void addDataPoint(DataPoint dp) {
        this.dataPoints.add(dp);
    }

    /*
        High: 1
        Low: 2
     */

    private Map<String, Integer> countOccurrences(List<String> list) {
        Map<String, Integer> occurrences = new HashMap<>();
        for (String label : list) {
            Integer currentCount = occurrences.get(label);
            occurrences.put(label, (currentCount == null) ? 1 : currentCount + 1);
        }
        return occurrences;
    }

    public Map<String, Integer> classifyPoint(Float x, Float y, Integer numberOfNeighbors) {
        DataPoint unlabelledPoint = new DataPoint(x, y, "?");

        List<Pair> distances = this.dataPoints.stream()
                .map(dp -> new Pair(dp.label, DataPoint.getSquaredDistance(dp, unlabelledPoint)))
                .collect(Collectors.toList());

        Collections.sort(distances, new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                if (a.value > b.value) return -1;
                if (a.value < b.value) return 1;
                return 0;
            }
        });

        List<String> closestLabels = distances
                .subList(Math.max(distances.size() - numberOfNeighbors, 0), distances.size())
                .stream()
                .map(pair -> pair.key)
                .collect(Collectors.toList());

        return countOccurrences(closestLabels);
    }
}
