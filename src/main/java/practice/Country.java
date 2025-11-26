package practice;

public class Country {
    private String name;
    private double area;
    private long population;
    private String capitalName;
    private long capitalPopulation;

    public Country(String name, double area, long population, String capitalName, long capitalPopulation) {
        setName(name);
        setArea(area);
        setPopulation(population);

        if (capitalName != null && capitalPopulation < 0) {
            throw new IllegalArgumentException("Население столицы не может быть отрицательным");
        }

        this.capitalName = capitalName;
        this.capitalPopulation = capitalPopulation;
    }

    public Country(String name, double area, long population) {
        setName(name);
        setArea(area);
        setPopulation(population);
        setCapital(null, 0);
    }

    public String getName() {
        return name;
    }

    public double getArea() {
        return area;
    }

    public long getPopulation() {
        return population;
    }

    public String getCapitalName() {
        return capitalName;
    }

    public long getCapitalPopulation() {
        return capitalPopulation;
    }

    public double getPopulationDensity() {

        if (area <= 0 || population <= 0) {
            throw new IllegalStateException("Невозможно вычислить плотность: некорректные данные");
        }

        return (double) population / area;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Название страны не может быть пустым");
        }

        this.name = name;
    }

    public void setArea(double area) {
        if (area <= 0) {
            throw new IllegalArgumentException("Площадь должна быть строго больше нуля");
        }

        this.area = area;
    }

    public void setPopulation(long population) {
        if (population < 0) {
            throw new IllegalArgumentException("Население не может быть отрицательным");
        }

        this.population = population;
    }

    public void setCapital(String capitalName, long capitalPopulation) {

        if (capitalName != null) {

            if (capitalPopulation < 0) {
                throw new IllegalArgumentException("Население столицы не может быть отрицательным");
            }

            this.capitalName = capitalName;
            this.capitalPopulation = capitalPopulation;

        } else {
            this.capitalName = null;
            this.capitalPopulation = 0;
        }
    }

    public String toString() {

        String result = name + ": " + area + " км²";

        if (population > 0) {
            result += ", население: " + population;
        }

        if (capitalName != null && capitalPopulation > 0) {
            result += "\nСтолица: " + capitalName + ", население: " + capitalPopulation;
        }

        return result;
    }

}
