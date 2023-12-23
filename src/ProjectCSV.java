import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

//Enoch Abiodun
//G00380316
//CSV Project to display Data in ascending and descending order which then you can export from java

public class ProjectCSV extends JPanel {
    ArrayList<Project> project_collection = new ArrayList<>(); //collection of weather objects
    JFrame frame = new JFrame("CSV PROJECT"); // Sets frame
    JPanel iconPanel = new JPanel();
    JPanel grid = new JPanel(new FlowLayout()); //sets grid
    /* Creates JButtons */
    JButton read_data = new JButton("Load CSV");
    JButton sort_temp = new JButton("Display Max Temp Ascending");
    JButton sort_rain = new JButton("Display Rain Descending");
    JButton sort_wdsp = new JButton("Display Mean Wind Speed Descending");
    JButton sort_sun = new JButton("Display Sun Ascending");
    JButton save_data = new JButton("Save CSV");
    JTextArea output = new JTextArea(40,40);
    JTextArea textbox = new JTextArea(1,100);
    int read_flag = 0;
    int count = 0;

    public ProjectCSV() throws IOException {
        /* Adds all JButtons */
        frame.add(iconPanel);
        iconPanel.add(read_data);
        iconPanel.add(sort_temp);
        iconPanel.add(sort_rain);
        iconPanel.add(sort_wdsp);
        iconPanel.add(sort_sun);
        iconPanel.add(save_data);

        /* Sets text areas */
        frame.add(textbox);
        textbox.setVisible(false);
        textbox.setEditable(true);
        output.setEditable(false);
        /* Sets Layouts */
        frame.setLayout(new GridLayout(1, 3, 2, 3));
        iconPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 1000, 7));
        frame.add(output);
        /* Creates Listener */
        ReadBtnListener listener = new ReadBtnListener();
        /* Adds listener to all that need it */
        read_data.addActionListener(listener);
        save_data.addActionListener(listener);

        sort_temp.addActionListener(listener);
        sort_rain.addActionListener(listener);
        sort_wdsp.addActionListener(listener);
        sort_sun.addActionListener(listener);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setSize(500, 500);
        frame.setVisible(true);

    }
    /* Creates the project */
    public static void main(String[] args) throws IOException {
        ProjectCSV t = new ProjectCSV();
    }
    /* Actionlistener */
    private class ReadBtnListener implements ActionListener {
        /* Gets file */
        String file = "src/project.csv";
        String curline;

        long lineNumber = 0;
        /* Buffer Reader */
        BufferedReader bufferedReader;
        {
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void actionPerformed(ActionEvent evt) {

            /* Gets data from file */
            if (evt.getSource() == read_data) {
                read_flag = 1; // set flag to 1
                //weather_collection.forEach(weather -> output.append(weather.toString()));
                while (true)  //while we haven't reached end of file
                {
                    try {
                        if ((curline = bufferedReader.readLine()) == null)
                            break;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println(curline);
                    curline += "\n";
                    output.append(curline);
                    lineNumber++;
                    String[] data = curline.split(",");
                    try {
                        Project weather = new Project(Float.parseFloat(data[0]), Float.parseFloat(data[1]), Float.parseFloat(data[2]), Float.parseFloat(data[3]), Float.parseFloat(data[4]), Float.parseFloat(data[5]), Float.parseFloat(data[6]), Float.parseFloat(data[7]), Float.parseFloat(data[8]), Float.parseFloat(data[9]), Float.parseFloat(data[10]), Float.parseFloat(data[11]));
                        project_collection.add(weather);

                    } catch (Exception e) {
                        System.out.println(" ERROR IN CSV FILE LINE # --- " + lineNumber);
                        e.printStackTrace();
                    }
                }
            }

            /* Saves Data to file */
            if (evt.getSource() == save_data) {
                String save;
                textbox.setVisible(true);
                save = textbox.getText();
                FileOutputStream output = null;
                try {
                    output = new FileOutputStream(new File(save + ".csv"), false);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                PrintWriter printWriter = new PrintWriter(output);
                for (Project weather : project_collection) {
                    printWriter.println(weather + "\n");
                }
                printWriter.flush();
                printWriter.close();

            }

            /* Sorts Temp */
            if (evt.getSource() == sort_temp) {
                if (read_flag == 1) {
                    output.setText("");
                    Collections.sort(project_collection, new maxTPComp());
                    for (Project weather : project_collection) {
                        output.append(weather + "\n");
                    }
                    read_flag = 0;
                    read_data.doClick();
                }
            }

            /* Sorts Rain */
            if (evt.getSource() == sort_rain) {
                new Project(1);
                if (read_flag == 1) {
                    output.setText("");
                    Collections.sort(project_collection, new getRainComp());
                    for (Project weather : project_collection) {
                        output.append(weather + "\n");
                    }
                    read_flag = 0;
                    read_data.doClick();
                }
            }

            /* Sorts Wind Speed */
            if (evt.getSource() == sort_wdsp) {
                new Project(1);
                if (read_flag == 1) {
                    output.setText("");
                    Collections.sort(project_collection, new getWDSPcomp());
                    for (Project weather : project_collection) {
                        output.append(weather + "\n");
                    }
                    read_flag = 0;
                    read_data.doClick();
                }
            }

            /* Sorts Sun */
            if (evt.getSource() == sort_sun) {
                new Project(1);
                if (read_flag == 1) {
                    output.setText("");
                    Collections.sort(project_collection, new getSunComp());
                    for (Project weather : project_collection) {
                        output.append(weather + "\n");
                    }
                    read_flag = 0;
                    read_data.doClick();
                }
            }
        }
    }
}
