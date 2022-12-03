
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Var_2 extends Component {
    JButton button;
    ButtonGroup buttonGroup;
    JLabel blankLabel, nameLabel, formatLabel, pageCountLabel, productCountLabel;
    JRadioButton soloRadioButton, courRadioButton, postRadioButton;
    JTextField nameInput, pageCountInput, productCountInput;
    JComboBox<String> formatBox;

    private void run() {
        JFrame window = createWindow();
        window.setVisible(true);
    }

    private JFrame createWindow() {
        JFrame frame = new JFrame("Lab 4-5");
        frame.getContentPane().add(createPanel());
        frame.pack();
        frame.setSize(700, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return frame;
    }

    private JPanel createPanel() {
        JPanel panel = new JPanel(new GridBagLayout());

        Color textColor = new Color(88,149,218,255);

        blankLabel = new JLabel("Бланк замовлення");
        blankLabel.setBounds(250, 20, 300, 40);
        blankLabel.setForeground(textColor);
        blankLabel.setFont(new Font("Serif", Font.BOLD, 20));
        panel.add(blankLabel);

        soloRadioButton = new JRadioButton("Хочу забрати замовлення самостійно");
        courRadioButton = new JRadioButton("Доставка замовлення кур'єром");
        postRadioButton = new JRadioButton("Доставка замовлення УкрПоштою");

        soloRadioButton.setBounds(50, 350, 300, 25);
        soloRadioButton.setFont(new Font("SansSerif", Font.PLAIN, 14));
        courRadioButton.setBounds(50, 390, 300, 25);
        courRadioButton.setFont(new Font("SansSerif", Font.PLAIN, 14));
        postRadioButton.setBounds(50, 430, 300, 25);
        postRadioButton.setFont(new Font("SansSerif", Font.PLAIN, 14));

        buttonGroup = new ButtonGroup();
        buttonGroup.add(soloRadioButton);
        buttonGroup.add(courRadioButton);
        buttonGroup.add(postRadioButton);

        panel.add(soloRadioButton);
        panel.add(courRadioButton);
        panel.add(postRadioButton);

        nameLabel = new JLabel("Назва продукціі");
        nameLabel.setBounds(50, 110, 300, 30);
        nameLabel.setFont(new Font("Serif", Font.BOLD, 16));
        panel.add(nameLabel);

        formatLabel = new JLabel("Формат паперу");
        formatLabel.setBounds(50, 150, 300, 30);
        formatLabel.setFont(new Font("Serif", Font.BOLD, 16));
        panel.add(formatLabel);

        pageCountLabel = new JLabel("Кількість сторінок");
        pageCountLabel.setBounds(50, 190, 300, 30);
        pageCountLabel.setFont(new Font("Serif", Font.BOLD, 16));
        panel.add(pageCountLabel);

        productCountLabel = new JLabel("Кількість екземплярів");
        productCountLabel.setBounds(50, 230, 300, 30);
        productCountLabel.setFont(new Font("Serif", Font.BOLD, 16));
        panel.add(productCountLabel);

        nameInput = new JTextField();
        nameInput.setBounds(300, 110, 200, 25);
        panel.add(nameInput);

        pageCountInput = new JTextField();
        pageCountInput.setBounds(300, 190, 100, 25);
        panel.add(pageCountInput);

        productCountInput = new JTextField();
        productCountInput.setBounds(300, 230, 100, 25);
        panel.add(productCountInput);

        String[] choices = { "А1","А2", "А3","А4","А5"};
        formatBox = new JComboBox<>(choices);
        formatBox.setBounds(300, 150, 180, 25);
        panel.add(formatBox);

        button = new JButton("Оформити замовлення");
        button.setBounds(380, 450, 250, 35);
        Color btnColor = new Color(0,128,0,255);
        button.setBackground(btnColor);
        button.setForeground(Color.black);
        button.setFont(new Font("Serif", Font.BOLD, 18));
        button.addActionListener(this::actionPerformed);
        panel.add(button);

        panel.setLayout(null);
        panel.setVisible(true);
        return panel;
    }

    public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }
    public void actionPerformed(ActionEvent e) {
        Pattern checkLetters = Pattern.compile("^[a-zA-Z]*$");
        Matcher matcher1 = checkLetters.matcher(nameInput.getText());

        Pattern checkNumbers = Pattern.compile("[0-9]+");
        Matcher matcher2 = checkNumbers.matcher(pageCountInput.getText());
        Matcher matcher3 = checkNumbers.matcher(productCountInput.getText());

        if (!soloRadioButton.isSelected() && !courRadioButton.isSelected() && !postRadioButton.isSelected()) {
            JOptionPane.showMessageDialog(this, "Оберіть спосіб доставки!", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (nameInput.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Введіть ім'я!", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (pageCountInput.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Введіть кількість сторінок!", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (productCountInput.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Введіть кількість одиниць!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (!matcher1.matches()) {
            JOptionPane.showMessageDialog(this, "Тільки літери A-Z a-z!", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!matcher2.matches()) {
            JOptionPane.showMessageDialog(this, "Тільки цифри 0-9!", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!matcher3.matches()) {
            JOptionPane.showMessageDialog(this, "Тільки цифри 0-9!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            new Exit_window().run(nameInput.getText(), pageCountInput.getText(), productCountInput.getText(), getSelectedButtonText(buttonGroup));
        }
    }


    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new Var_2().run());
    }
}