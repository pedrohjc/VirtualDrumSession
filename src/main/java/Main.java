import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
public class Main {
    public static void main(String[] a) {
        String ACTION_KEY = "theAction";
        JFrame frame = new JFrame("KeyStroke Sample");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton buttonA = new JButton("Press Space");
        Action actionListener = new AbstractAction() {
            public void actionPerformed(ActionEvent actionEvent) {
//                JButton source = (JButton) actionEvent.getSource();
                System.out.println("You pressed Space");
                MakeSound ms = new MakeSound();
                ms.playSound("sounds\\Snare.wav");
            }
        };
        KeyStroke space = KeyStroke.getKeyStroke(' ');
        InputMap inputMap = buttonA.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(space, ACTION_KEY);
        ActionMap actionMap = buttonA.getActionMap();
        actionMap.put(ACTION_KEY, actionListener);

        KeyStroke c = KeyStroke.getKeyStroke('c');
        InputMap inputMapc = buttonA.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(c, ACTION_KEY);
        ActionMap actionMapc = buttonA.getActionMap();
        actionMapc.put(ACTION_KEY, actionListener);

        buttonA.setActionMap(actionMap);
        frame.add(buttonA);
        frame.setSize(400, 200);
        frame.setVisible(true);
    }
}
