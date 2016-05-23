package in.trillit;

import java.awt.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ListAllRecord extends JFrame {

    JPanel MainPanel = new JPanel();
    JPanel NorthPanel = new JPanel();
    JPanel SouthPanel = new JPanel();
    JPanel CenterPanel = new JPanel();
    JLabel Header = new JLabel("");
    JButton Next = new JButton("Next");
    JButton Prev = new JButton("Previous");

    public ListAllRecord(String title, String tablename, Statement st) {
        super(title);
        try {
            this.setLayout(new BorderLayout());
            ResultSet rs = st.executeQuery("select * from " + tablename);
            SetTable(rs);
            Header.setFont(new Font(Font.MONOSPACED, Font.BOLD, 13));
            Header.setText(title);
            NorthPanel.add(Header);
            this.add(BorderLayout.NORTH, NorthPanel);
            this.add(BorderLayout.CENTER, CenterPanel);
            setVisible(true);
            Toolkit kit = Toolkit.getDefaultToolkit();
            Image image = kit.getImage(ClassLoader.getSystemResource("images/images_025 (7) - Copy.jpg"));
            setIconImage(image);
            pack();
        } catch (SQLException ex) {
            System.err.println("Error in List All Record : " + ex.getMessage());
            ex.printStackTrace();
        }

    }

    private void SetTable(ResultSet rs) {
        try {

            final Vector columnNames = new Vector();
            final Vector data = new Vector();

            ResultSetMetaData md = (ResultSetMetaData) rs.getMetaData();
            int columns = md.getColumnCount();

            for (int i = 1; i <= columns; i++) {
                columnNames.add(md.getColumnName(i));
            }
            
            while (rs.next()) {
                Vector row = new Vector();
                for (int i = 1; i <= columns; i++) {
                    row.addElement(rs.getObject(i));
                }
                data.addElement(row);
            }
            DefaultTableModel model = new DefaultTableModel(data, columnNames);
            JTable table = new JTable(model);
            table.setRowHeight(26);

            table.setAutoResizeMode(5);
            JScrollPane scrollPane = new JScrollPane(table);
            CenterPanel.setLayout(new BorderLayout());
            CenterPanel.add(BorderLayout.CENTER, scrollPane);
        } catch (SQLException ex) {
            System.err.println("Error in SetTable method : " + ex.getMessage());
            ex.printStackTrace();
        }
    }

}
