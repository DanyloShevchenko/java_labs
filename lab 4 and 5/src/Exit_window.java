import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Exit_window extends Component {

    JButton buttonClose, buttonConfirm;

    public void run(String name, String pageCount, String productCount, String ButtonText) {
        JFrame window = createWindow(name, pageCount, productCount, ButtonText);
        window.setVisible(true);
    }

    private JFrame createWindow(String name, String pageCount, String productCount, String ButtonText) {
        JFrame frame = new JFrame("Exit Window");
        frame.getContentPane().add(createPanel(name, pageCount, productCount, ButtonText));
        frame.pack();
        frame.setSize(400, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return frame;
    }

    private JPanel createPanel(String name, String pageCount, String productCount, String ButtonText) {
        JPanel panel = new JPanel(new GridBagLayout());

        JLabel nameLabel = new JLabel("Назва продукціі: " + name);
        nameLabel.setBounds(20, 50, 300, 30);
        nameLabel.setFont(new Font("Serif", Font.BOLD, 16));
        panel.add(nameLabel);

        JLabel pageCountLabel = new JLabel("Кількість сторінок: " + pageCount);
        pageCountLabel.setBounds(20, 80, 300, 30);
        pageCountLabel.setFont(new Font("Serif", Font.BOLD, 16));
        panel.add(pageCountLabel);

        JLabel productCountLabel = new JLabel("Кількість екземплярів: " + productCount);
        productCountLabel.setBounds(20, 110, 300, 30);
        productCountLabel.setFont(new Font("Serif", Font.BOLD, 16));
        panel.add(productCountLabel);

        JLabel deliveryMethod = new JLabel("Спосіб доставки: " + ButtonText);
        deliveryMethod.setBounds(20, 140, 400, 30);
        deliveryMethod.setFont(new Font("Serif", Font.BOLD, 16));
        panel.add(deliveryMethod);

        // JButton buttonClose, buttonConfirm;
        buttonConfirm = new JButton("Підтвердити");
        buttonConfirm.setBounds(20, 180, 150, 35);
        buttonConfirm.setBackground(Color.green);
        buttonConfirm.setForeground(Color.black);
        buttonConfirm.setFont(new Font("Serif", Font.BOLD, 18));
        buttonConfirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });
        panel.add(buttonConfirm);

        buttonClose = new JButton("Скасувати");
        buttonClose.setBounds(200, 180, 150, 35);
        buttonClose.setBackground(Color.red);
        buttonClose.setForeground(Color.black);
        buttonClose.setFont(new Font("Serif", Font.BOLD, 18));
        buttonClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });
        panel.add(buttonClose);

        panel.setLayout(null);
        panel.setVisible(true);
        return panel;
    }
}
