package tb.soft.gui.swing;

import javax.swing.*;
import java.awt.*;

public class Content extends JPanel {
    private static final Insets GAPS = new Insets(10, 10, 10, 10);

    private final GridBagConstraints constraints;
    private final Window owner;

    public Content(Window owner) {
        super(new GridBagLayout());
        this.owner = owner;

        constraints = new GridBagConstraints();
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = GAPS;
    }

    public void addComponent(Component component, int gridx, int gridy, int gridwidth, int gridheight) {
        constraints.gridx = gridx;
        constraints.gridy = gridy;
        constraints.gridwidth = gridwidth;
        constraints.gridheight = gridheight;

        add(component, constraints);
        owner.pack();
    }
}
