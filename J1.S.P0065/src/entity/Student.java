package entity;

public class Student {
    private String name;
    private String className;
    private double mathMark;
    private double physicalMark;
    private double chemistryMark;
    private double average;
    private char type;

    public Student(String name, String className, double mathMark, double physicalMark, double chemistryMark) {
        this.name = name;
        this.className = className;
        this.mathMark = mathMark;
        this.physicalMark = physicalMark;
        this.chemistryMark = chemistryMark;
        this.average = (mathMark + physicalMark + chemistryMark) / 3;
        if (this.average > 7.5) {
            this.type = 'A';
        } else if (average >= 6 && average <= 7.5) {
            this.type = 'B';
        } else if (average >= 4 && average < 6) {
            this.type = 'C';
        } else {
            this.type = 'D';
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public double getMathMark() {
        return mathMark;
    }

    public void setMathMark(double mathMark) {
        this.mathMark = mathMark;
    }

    public double getPhysicalMark() {
        return physicalMark;
    }

    public void setPhysicalMark(double physicalMark) {
        this.physicalMark = physicalMark;
    }

    public double getChemistryMark() {
        return chemistryMark;
    }

    public void setChemistryMark(double chemistryMark) {
        this.chemistryMark = chemistryMark;
    }

    public double getAverage() {
        return average;
    }

    public char getType() {
        return type;
    }
}

