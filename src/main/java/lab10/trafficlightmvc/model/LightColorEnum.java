package lab10.trafficlightmvc.model;

import javafx.scene.paint.Color;

/**
 * an enumeration of the three varying light colors we will use
 * we are holding the values of color for the lights in their 'on' state
 */
public enum LightColorEnum {
    Red(Color.RED),
    Yellow(Color.YELLOW),
    Green(Color.LAWNGREEN);

    private Color color;

    private LightColorEnum(Color color) { this.color = color; }

    public Color getColor() {
        return color;
    }
}
