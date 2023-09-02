package raven.crazypanel;

import java.io.Serializable;

/**
 *
 * @author Raven
 */
public class MigLayoutConstraints implements Serializable {

    public String getLayoutConstraints() {
        return layoutConstraints;
    }

    public void setLayoutConstraints(String layoutConstraints) {
        this.layoutConstraints = layoutConstraints;
    }

    public String getColumnConstraints() {
        return columnConstraints;
    }

    public void setColumnConstraints(String columnConstraints) {
        this.columnConstraints = columnConstraints;
    }

    public String getRowConstraints() {
        return rowConstraints;
    }

    public void setRowConstraints(String rowConstraints) {
        this.rowConstraints = rowConstraints;
    }

    public String[] getComponentConstraint() {
        return componentConstraint;
    }

    public void setComponentConstraint(String[] componentConstraint) {
        this.componentConstraint = componentConstraint;
    }

    public MigLayoutConstraints(String layoutConstraints, String columnConstraints, String rowConstraints, String[] componentConstraint) {
        this.layoutConstraints = layoutConstraints;
        this.columnConstraints = columnConstraints;
        this.rowConstraints = rowConstraints;
        this.componentConstraint = componentConstraint;
    }

    private String layoutConstraints;
    private String columnConstraints;
    private String rowConstraints;
    private String componentConstraint[];
}
