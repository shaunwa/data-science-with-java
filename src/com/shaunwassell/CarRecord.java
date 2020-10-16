package com.shaunwassell;

public class CarRecord {
    public final Float mpg;
    public final Integer numberOfCylinders;
    public final Float displacement;
    public final Float weight;
    // ....

    public static CarRecord parseCarRecord(String line) {
        String[] fields = line.split("\\s+");
        try {
            Float mpg = Float.parseFloat(fields[0].trim());
            Integer numberOfCylinders = Integer.parseInt(fields[1].trim());
            Float displacement = Float.parseFloat(fields[2].trim());
            Float weight = Float.parseFloat(fields[4].trim());

            return new CarRecord(mpg, numberOfCylinders, displacement, weight);
        } catch (Exception e) {
            System.out.println("AHHHH! " + e.getMessage());
            return null;
        }
    }

    public CarRecord(Float mpg, Integer numberOfCylinders, Float displacement, Float weight) {
        this.mpg = mpg;
        this.numberOfCylinders = numberOfCylinders;
        this.displacement = displacement;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "CarRecord{" +
                "mpg=" + mpg +
                ", numberOfCylinders=" + numberOfCylinders +
                ", displacement=" + displacement +
                ", weight=" + weight +
                '}';
    }
}
