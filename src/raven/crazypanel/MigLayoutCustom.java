package raven.crazypanel;

import java.awt.Component;
import javax.swing.JComponent;
import net.miginfocom.swing.MigLayout;

public class MigLayoutCustom extends MigLayout {

    public FlatLafStyleComponent getFlatLafStyleComponent() {
        return flatLafStyleComponent;
    }

    public void setFlatLafStyleComponent(FlatLafStyleComponent flatLafStyleComponent) {
        this.flatLafStyleComponent = flatLafStyleComponent;
    }

    public MigLayoutConstraints getMigLayoutConstraints() {
        return migLayoutConstraints;
    }

    public void setMigLayoutConstraints(MigLayoutConstraints migLayoutConstraints) {
        this.migLayoutConstraints = migLayoutConstraints;
        setLayoutConstraints(migLayoutConstraints.getLayoutConstraints());
        setColumnConstraints(migLayoutConstraints.getColumnConstraints());
        setRowConstraints(migLayoutConstraints.getRowConstraints());
    }
    private FlatLafStyleComponent flatLafStyleComponent;
    private MigLayoutConstraints migLayoutConstraints;

    @Override
    public void addLayoutComponent(Component comp, Object constraints) {
        int index = comp.getParent().getComponentZOrder(comp);
        Object constraint = constraints;
        if (migLayoutConstraints.getComponentConstraint() != null && index < migLayoutConstraints.getComponentConstraint().length) {
            constraint = migLayoutConstraints.getComponentConstraint()[index];
        }
        if (flatLafStyleComponent != null && flatLafStyleComponent.getStyles() != null) {
            if (comp instanceof JComponent) {
                if (index < flatLafStyleComponent.getStyles().length) {
                    flatLafStyleComponent.installStyle((JComponent) comp, flatLafStyleComponent.getStyles()[index]);
                }
            }
        }
        try {
            super.addLayoutComponent(comp, constraint);
        } catch (Exception e) {
            System.err.println(e.getMessage() + " a Index " + index);
        }
    }
}
