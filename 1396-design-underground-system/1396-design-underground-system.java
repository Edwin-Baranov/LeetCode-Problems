class UndergroundSystem {
    Map<Integer, Pair<String, Integer>> checkedIn;
    Map<String, Pair<Double, Integer>> travelTimes; 

    public UndergroundSystem() {
        checkedIn = new HashMap<>();
        travelTimes = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkedIn.put(id, new Pair<>(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> checkInData = checkedIn.get(id);
        String startStation = checkInData.getKey();
        Integer checkInTime = checkInData.getValue();
        
        String routeKey = stationKey(startStation, stationName);
        Pair<Double, Integer> routeData = travelTimes.getOrDefault(routeKey, new Pair<>(0.0, 0));
        Double totalTripTime = routeData.getKey();
        Integer totalTrips = routeData.getValue();
        
        double tripTime = t - checkInTime;
        travelTimes.put(routeKey, new Pair<>(totalTripTime + tripTime, totalTrips + 1));
    }
    
    public double getAverageTime(String startStation, String endStation) {
        Pair<Double, Integer> routeData = travelTimes.get(stationKey(startStation, endStation));
        return routeData.getKey() / routeData.getValue();
    }
    
    private String stationKey(String startStation, String endStation) {
        return startStation + "->" + endStation;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */