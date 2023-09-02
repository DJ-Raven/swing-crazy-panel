package raven.crazypanel;

import javax.swing.JPanel;

/**
 *
 * @author Raven
 */
public class CrazyPanel extends JPanel {

    public FlatLafStyleComponent getFlatLafStyleComponent() {
        return flatLafStyleComponent;
    }

    public void setFlatLafStyleComponent(FlatLafStyleComponent flatLafStyleComponent) {
        this.flatLafStyleComponent = flatLafStyleComponent;
        installStyleComponents();
    }

    public MigLayoutConstraints getMigLayoutConstraints() {
        return migLayoutConstraints;
    }

    public void setMigLayoutConstraints(MigLayoutConstraints migLayoutConstraints) {
        this.migLayoutConstraints = migLayoutConstraints;
        installLayoutConstraints();
    }

    private FlatLafStyleComponent flatLafStyleComponent;
    private MigLayoutConstraints migLayoutConstraints;
    private MigLayoutCustom migLayout;

    public CrazyPanel() {
        init();
    }

    private void init() {
        migLayoutConstraints = new MigLayoutConstraints("", "", "", new String[]{});
        migLayout = new MigLayoutCustom();
        migLayout.setMigLayoutConstraints(migLayoutConstraints);
        setLayout(migLayout);
    }

    private void installLayoutConstraints() {
        migLayout.setMigLayoutConstraints(migLayoutConstraints);
    }

    public void installStyleComponents() {
        putClientProperty("FlatLaf.style", flatLafStyleComponent.getOwnStyle());
        migLayout.setFlatLafStyleComponent(flatLafStyleComponent);
    }
}
