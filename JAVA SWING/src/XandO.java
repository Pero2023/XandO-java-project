public class XandO {import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

    public class XandO {
        JFrame tictac = new JFrame("X and O");

        JButton btnOne = new JButton();
        JButton btnTwo = new JButton();
        JButton btnThree = new JButton();
        JButton btnFour = new JButton();
        JButton btnFive = new JButton();
        JButton btnSix = new JButton();
        JButton btnSeven = new JButton();
        JButton btnEight = new JButton();
        JButton btnNine = new JButton();

        JLabel scoreLabel = new JLabel();
        int xScore = 0;
        int oScore = 0;
        String currentPlayer = "X";

        public XandO() {
            try {
                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            } catch (Exception e) {
                e.printStackTrace();
            }

            tictac.setLayout(new BorderLayout());

            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(3, 3));

            panel.add(btnOne);
            panel.add(btnTwo);
            panel.add(btnThree);
            panel.add(btnFour);
            panel.add(btnFive);
            panel.add(btnSix);
            panel.add(btnSeven);
            panel.add(btnEight);
            panel.add(btnNine);

            JButton[] buttons = {btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine};
            for (JButton button : buttons) {
                button.setFont(new Font("San-Serif", Font.PLAIN, 100));
                button.setFocusPainted(false);
                button.setContentAreaFilled(false);
                button.setOpaque(true);
                button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 6));
                button.addActionListener(new ButtonClickListener(this));
            }
            tictac.add(panel, BorderLayout.CENTER);
            JPanel scorePanel = new JPanel();
            scorePanel.setLayout(new BorderLayout());

            scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
            scoreLabel.setFont(new Font("Serif", Font.ROMAN_BASELINE, 32));
            scoreLabel.setBorder(new EmptyBorder(14, 14, 14, 14));
            updateScoreLabel();
            scoreLabel.setOpaque(true);
            scoreLabel.setBackground(new Color(177, 204, 239));
            scorePanel.add(scoreLabel, BorderLayout.CENTER);

            tictac.add(scorePanel, BorderLayout.EAST);

            tictac.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            tictac.setSize(700, 600);
            tictac.setVisible(true);
        }

        void updateScoreLabel() {
            scoreLabel.setText("<html>X = " + xScore + "<br>O = " + oScore + "</html>");
        }

        boolean checkForWin() {
            int[][] winConditions = {
                    {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Rows
                    {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Columns
                    {0, 4, 8}, {2, 4, 6}             // Diagonals
            };

            JButton[] buttons = {btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine};

            for (int[] winCondition : winConditions) {
                if (buttons[winCondition[0]].getText().equals(currentPlayer) &&
                        buttons[winCondition[1]].getText().equals(currentPlayer) &&
                        buttons[winCondition[2]].getText().equals(currentPlayer)) {
                    return true;
                }
            }
            return false;
        }

        boolean checkForDraw() {
            JButton[] buttons = {btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine};
            for (JButton button : buttons) {
                if (button.getText().equals("")) {
                    return false;
                }
            }
            return true;
        }

        void resetBoard() {
            JButton[] buttons = {btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine};
            for (JButton button : buttons) {
                button.setText("");
                button.setBackground(null);
                button.setOpaque(false);
                button.setBorderPainted(true);
            }
            currentPlayer = "X";
        }
    }
}
