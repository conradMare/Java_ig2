public class Car {

    private String make = "Tesla";
    private String model = "X";
    private String color = "White";
    private int doors = 2;
    private boolean convertible = true;

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getDoors() {
        return doors;
    }

    public boolean isConvertible() {
        return convertible;
    }

    public void setMake(String make) {
        if (make == null) make = "Unknown";
        String lowercaseMake = make.toLowerCase();
        switch (lowercaseMake) {
            case "holden", "porsche", "tesla" -> this.make = make;
            default -> {
                this.make = "Unsupported";
            }
        }
    }

    public void setModel(String model) {
        if (model == null) model = "Unknown";
        String uppercaseModel = model.toUpperCase();
        switch (uppercaseModel) {
            case "CARRERA", "CAYENNE", "CAYMAN" -> this.model = model;
            default -> {
                this.model = "Unsupported";
            }
        }
    }

    public void setColor(String color) {
        if (color == null) color = "Unknown";
        String lowercaseColor = color.toLowerCase();
        switch (lowercaseColor) {
            case "black", "red", "white" -> this.color = color;
            default -> {
                this.color = "Unknown";
            }
        }
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public void setConvertible(boolean convertible) {
        this.convertible = convertible;
    }

    public void describeCar() {
        System.out.println(doors + " -Door " +
                color + "  " +
                make + "  " +
                model + "  " +
                (convertible ? " Convertible " : " "));
    }
}
