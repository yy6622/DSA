
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class RecordMaintenance extends JPanel{
    public RecordMaintenance(JFrame frame){
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(100, 150, 50, 150));
        JPanel topPanel = searchPanel(); 
        add(topPanel, BorderLayout.NORTH);
        
        String[] columnNames = {"IC", "Name","Phone Number","Blood Type","Next Appointment"};

        String[][] data = {
            {"010215021133", "John Doe", "012-3456789", "A"},
            {"020425067724", "Jane Lee", "013-2345678", "B"},
            {"030526070242", "Ali Bin Ahmad", "014-3456789", "AB"}
        };
        
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);
        
         table.setRowHeight(28);
        table.setFont(new Font("Serif", Font.PLAIN, 16));
        table.getTableHeader().setFont(new Font("Serif", Font.BOLD, 16));

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
    }
     private JPanel searchPanel(){
        JPanel panel =new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JTextField search = new JTextField();
        search.setFont(new Font("Serif", Font.PLAIN, 18));
        search.setPreferredSize(new Dimension(500, 40));
        JButton btnSearch = new JButton("Search");
        btnSearch.setPreferredSize(new Dimension(150, 40));
        panel.add(search);
        panel.add(btnSearch);
        
        add(panel);
        return panel;
    }
    public static void main(String[] args){
        JFrame frame=new JFrame();
        JPanel recordMaintenance = new RecordMaintenance(frame);
        frame.add(recordMaintenance);
        frame.setVisible(true);
    }
    
   
}
