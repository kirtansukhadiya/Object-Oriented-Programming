import javax.swing.JOptionPane;

public class Practice1 {
    public static void main(String[] args){
        String name = JOptionPane.showInputDialog("Enter your name");
        JOptionPane.showMessageDialog(null,"Hello "+name);
    }
}