//package Swing.report;
//
//import javax.swing.*;
//import javax.swing.table.DefaultTableModel;
//import javax.swing.table.JTableHeader;
//import javax.swing.table.TableColumn;
//import javax.swing.table.TableColumnModel;
//import javax.swing.table.TableCellRenderer;
//
//import java.awt.Component;
//import java.sql.*;
//
//public class resultDisplay extends JPanel {
//
//    private static final long serialVersionUID = 1L;
//    private JTable table;
//
//    public resultDisplay() {
//        setLayout(null);
//
//        // Getting the data
//        DefaultTableModel model = new DefaultTableModel();
//
//        try {
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS", "root", "");
//            Statement stmt = con.createStatement();
//            String query = "SELECT r.std_id, u.firstname, u.lastname, u.email,u.std_course,u.std_level, r.module_1, r.mark_1,r.module_2, r.mark_2,r.module_3, r.mark_3, r.percentage, r.result FROM users u JOIN results r ON u.user_id=r.std_id";
//            ResultSet rs = stmt.executeQuery(query);
//            ResultSetMetaData rsmd = rs.getMetaData();
//
//            int columnCount = rsmd.getColumnCount();
//
//            for (int i = 1; i <= columnCount; i++) {
//                model.addColumn(rsmd.getColumnName(i));
//            }
//
//            while (rs.next()) {
//                Object[] row = new Object[columnCount];
//                for (int i = 1; i <= columnCount; i++) {
//                    row[i - 1] = rs.getObject(i);
//                }
//                model.addRow(row);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        JScrollPane scrollPane = new JScrollPane();
//        scrollPane.setBounds(20, 20, 465, 311);
//        add(scrollPane);
//
//        table = new JTable(model);
//        scrollPane.setViewportView(table);
//        table.setRowSelectionAllowed(false);
//
//        TableColumnModel columnModel = table.getColumnModel();
//
//        // Adjust column widths based on content
//        for (int i = 0; i < columnModel.getColumnCount(); i++) {
//            TableColumn column = columnModel.getColumn(i);
//            int maxWidth = 0;
//
//            for (int row = 0; row < table.getRowCount(); row++) {
//                TableCellRenderer cellRenderer = table.getCellRenderer(row, i);
//                Component component = table.prepareRenderer(cellRenderer, row, i);
//                maxWidth = Math.max(component.getPreferredSize().width, maxWidth);
//            }
//
//            column.setPreferredWidth(maxWidth + 20); // Add some padding
//        }
//
//        table.setShowGrid(true);
//        table.setShowHorizontalLines(true);
//        table.setShowVerticalLines(true);
//
//        table.setRowHeight(30);
//
//        JTableHeader header = table.getTableHeader();
//        header.setVisible(true);
//        table.setIntercellSpacing(new java.awt.Dimension(7, 7));
//    }
//}



package Swing.report;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class resultDisplay extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTable table;

    public resultDisplay() {
        setLayout(new BorderLayout());

        // Getting the data
        DefaultTableModel model = new DefaultTableModel();

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS", "root", "");
            Statement stmt = con.createStatement();
            String query = "SELECT r.std_id, u.firstname, u.lastname, u.email, u.std_course, u.std_level, r.module_1, r.mark_1, r.module_2, r.mark_2, r.module_3, r.mark_3, r.percentage, r.result FROM users u JOIN results r ON u.user_id=r.std_id";
            ResultSet rs = stmt.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();

            int columnCount = rsmd.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                model.addColumn(rsmd.getColumnName(i));
            }

            while (rs.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = rs.getObject(i);
                }
                model.addRow(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        table = new JTable(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); // Prevent auto resizing
        table.setFillsViewportHeight(true); // Fill the viewport height

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        customizeTableAppearance();
    }

    private void customizeTableAppearance() {
        table.setGridColor(Color.BLACK);
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.setFont(new Font("Arial", Font.PLAIN, 12));
        table.setRowHeight(25);
        table.setRowMargin(5);
        table.setIntercellSpacing(new Dimension(10, 10));
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setShowGrid(true);
        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(true);
    }
}
