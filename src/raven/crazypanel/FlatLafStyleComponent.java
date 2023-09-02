package raven.crazypanel;

import java.io.Serializable;
import java.util.StringJoiner;
import javax.swing.JComponent;

/**
 *
 * @author Raven
 */
public class FlatLafStyleComponent implements Serializable {

    public String getOwnStyle() {
        return ownStyle;
    }

    public void setOwnStyle(String ownStyle) {
        this.ownStyle = ownStyle;
    }

    public String[] getStyles() {
        return styles;
    }

    public void setStyles(String[] styles) {
        this.styles = styles;
    }

    public FlatLafStyleComponent(String ownStyle, String[] styles) {
        this.ownStyle = ownStyle;
        this.styles = styles;
    }

    public FlatLafStyleComponent() {
    }

    private String ownStyle;
    private String styles[];

    public void installStyle(JComponent component, String style) {
        String arrs[] = style.split(";");
        StringJoiner st = new StringJoiner(";");
        for (String arr : arrs) {
            if (arr.contains("=")) {
                String a[] = arr.split("=");
                component.putClientProperty(a[0], a[1]);
            } else {
                st.add(arr);
            }
        }
        if (st.length() > 0) {
            component.putClientProperty("FlatLaf.style", st.toString());
        }
    }
}
