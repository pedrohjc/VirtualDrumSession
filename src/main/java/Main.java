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
        JButton PressedBtn = new JButton("Press The Keyboard");

        KeyStroke c = KeyStroke.getKeyStroke('c');
        KeyStroke x = KeyStroke.getKeyStroke('x');
        KeyStroke z = KeyStroke.getKeyStroke('z');
        KeyStroke v = KeyStroke.getKeyStroke('v');
        KeyStroke s = KeyStroke.getKeyStroke('s');
        KeyStroke d = KeyStroke.getKeyStroke('d');
        KeyStroke a1 = KeyStroke.getKeyStroke('a');
        KeyStroke w = KeyStroke.getKeyStroke('w');
        KeyStroke e = KeyStroke.getKeyStroke('e');
        InputMap inputMap = PressedBtn.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(c, ACTION_KEY);
        inputMap.put(z, ACTION_KEY);
        inputMap.put(w, ACTION_KEY);
        inputMap.put(x, ACTION_KEY);
        ActionMap actionMap = PressedBtn.getActionMap();


        //Listener
        final Action actionListener = new AbstractAction() {
            public void actionPerformed(ActionEvent actionEvent) {
//                JButton source = (JButton) actionEvent.getSource();
                System.out.println("\n" + actionEvent.getActionCommand());
                String key = actionEvent.getActionCommand();
                if (key.equalsIgnoreCase("c")){
                    MakeSound ms = new MakeSound();
                    ms.playSound("sounds\\Kick.wav");
                }
                if (key.equalsIgnoreCase("x")){
                    MakeSound ms = new MakeSound();
                    ms.playSound("sounds\\Snare.wav");
                }
                if (key.equalsIgnoreCase("z")){
                    MakeSound ms = new MakeSound();
                    ms.playSound("sounds\\DDrums_07.wav");
                }
                if (key.equalsIgnoreCase("w")){
                    MakeSound ms = new MakeSound();
                    ms.playSound("sounds\\Kick.wav");
                    ms.playSound("sounds\\DDrums_08.wav");
                }

            }
        };

        actionMap.put(ACTION_KEY, actionListener);

        PressedBtn.setActionMap(actionMap);
        frame.add(PressedBtn);
        frame.setSize(400, 200);
        frame.setVisible(true);
    }
}
