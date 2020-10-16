package com.shaunwassell;

public class CarRecord {
    public final Float mpg;
    public final Integer numberOfCylinders;
    public final Float displacement;
    // ....

    public static CarRecord parseCarRecord(String line) {
        String[] fields = line.split("\\s+");
        try {
            Float mpg = Float.parseFloat(fields[0].trim());
            Integer numberOfCylinders = Integer.parseInt(fields[1].trim());
            Float displacement = Float.parseFloat(fields[2].trim());

            return new CarRecord(mpg, numberOfCylinders, displacement);
        } catch (Exception e) {
            System.out.println("AHHHH! " + e.getMessage());
            return null;
        }
    }

    public CarRecord(Float mpg, Integer numberOfCylinders, Float displacement) {
        this.mpg = mpg;
        this.numberOfCylinders = numberOfCylinders;
        this.displacement = displacement;
    }

    @Override
    public String toString() {
        return "CarRecord{" +
                "mpg=" + mpg +
                ", numberOfCylinders=" + numberOfCylinders +
                ", displacement=" + displacement +
                '}';
    }
}
