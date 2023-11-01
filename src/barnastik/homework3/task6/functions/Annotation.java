package barnastik.homework3.task6.functions;

import barnastik.homework3.task6.figure.Figure;

public class Annotation {
    private final String label;
    private final Figure figure;

    public Annotation(String label, Figure figure) {
        this.label = label;
        this.figure = figure;
    }

    public String getLabel() {
        return label;
    }

    public Figure getFigure() {
        return figure;
    }

    @Override
    public String toString() {
        return figure.toString() + ": " + label;
    }
}
