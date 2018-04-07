/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virusdetector;

import com.sun.management.OperatingSystemMXBean;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import static virusdetector.FileSelector.RecursivePrint;

/**
 *
 * @author ARS
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    private static Thread scanThread;
    
    private static final JFileChooser fc = new JFileChooser();

    private static String filepath = "";
    
    private static String malware = "";
    
    private static Set<String> malwareHashes;

    public MainFrame() {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        button4.setVisible(false);
        lbl_delete.setVisible(false);
        panel_performance.setVisible(false);
        panel_sacn.setVisible(false);
        
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        malwareHashes = new HashSet<String>();
        
        try {
            
            File f = new File("VirusShare_00000.md5.txt");
            BufferedReader reader = new BufferedReader(new FileReader(f));
            //StringBuffer stringBuffer = new StringBuffer();
            
		String line;
		while ((line = reader.readLine()) != null) {
                    //line = line.replace("\n", "").replace("\r", "");
                    malwareHashes.add(line);
		}
		reader.close();
            System.out.println(malwareHashes);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        

        lbl_os.setText("OS name: " + System.getProperty("os.name") + " | version: " + System.getProperty("os.version") + " | architecture: " + System.getProperty("os.arch"));

        panel_performance.setVisible(false);
        new Thread() {
            public void run() {
                OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(
                        OperatingSystemMXBean.class);
                while (true) {

                    int x = (int) (osBean.getSystemCpuLoad() * 100);

                    customPanel1.setProgress(x);
                    customPanel1.repaint();
                    lbl_cpu_usage.setText(x + "%");
                    if (x > 85) {
                        //cpu_progress.setForeground(Color.red);
                    } else if (x > 50) {
                        //cpu_progress.setForeground(Color.orange);
                    } else {
                        //cpu_progress.setForeground(Color.green);   
                    }

                }
            }
        }.start();

    }

    void setColor(JPanel panel) {
        if (!panel.getBackground().equals(new Color(92, 71, 126))) {
            panel.setBackground(new Color(85, 65, 118));
        }
    }

    void resetColor(JPanel panel) {
        if (!panel.getBackground().equals(new Color(92, 71, 126))) {
            panel.setBackground(new Color(64, 43, 100));
        }
    }

    void setPressedColor(JPanel panel) {
        panel.setBackground(new Color(92, 71, 126));
    }

    void setReleasedColor(JPanel panel) {
        panel.setBackground(new Color(85, 65, 118));
    }

    void backToNomalColor(JPanel panel) {
        panel.setBackground(new Color(64, 43, 100));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btn_performance = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbl_performance = new javax.swing.JLabel();
        btn_virusScan = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbl_virus_scan1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbl_date = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbl_os = new javax.swing.JLabel();
        panel_sacn = new javax.swing.JPanel();
        button1 = new java.awt.Button();
        button2 = new java.awt.Button();
        lbl_path = new javax.swing.JLabel();
        button3 = new java.awt.Button();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        button4 = new java.awt.Button();
        lbl_delete = new javax.swing.JLabel();
        panel_performance = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        lbl_cpu_usage = new javax.swing.JLabel();
        customPanel1 = new virusdetector.CustomPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();

        setLocationByPlatform(true);
        setUndecorated(true);

        bg.setBackground(new java.awt.Color(204, 204, 204));
        bg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bgKeyPressed(evt);
            }
        });
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(54, 33, 89));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(85, 65, 118));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/virusdetector/logo.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 11, -1, 88));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Virus Analyzer");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 140, -1));

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 140));

        btn_performance.setBackground(new java.awt.Color(64, 43, 100));
        btn_performance.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        btn_performance.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 23, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/virusdetector/speed.png"))); // NOI18N
        btn_performance.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 50, 50));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Performance");
        btn_performance.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 100, 30));

        lbl_performance.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_performanceMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_performanceMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_performanceMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_performanceMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_performanceMouseReleased(evt);
            }
        });
        btn_performance.add(lbl_performance, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 70));

        jPanel3.add(btn_performance, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 190, 70));

        btn_virusScan.setBackground(new java.awt.Color(64, 43, 100));
        btn_virusScan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        btn_virusScan.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 23, -1, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/virusdetector/virusScan.png"))); // NOI18N
        btn_virusScan.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 50, 50));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Virus Scan");
        btn_virusScan.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 100, 30));

        lbl_virus_scan1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_virus_scan1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_virus_scan1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_virus_scan1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_virus_scan1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_virus_scan1MouseReleased(evt);
            }
        });
        lbl_virus_scan1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lbl_virus_scan1KeyPressed(evt);
            }
        });
        btn_virusScan.add(lbl_virus_scan1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 70));

        jPanel3.add(btn_virusScan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 190, 70));

        bg.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 490));

        jPanel1.setBackground(new java.awt.Color(122, 72, 221));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Last scan was on ");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Your computer is in good shape");

        lbl_date.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_date.setForeground(new java.awt.Color(0, 255, 102));
        lbl_date.setText("2018-04-05");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_date, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(312, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(55, 55, 55)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(319, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbl_date))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(31, Short.MAX_VALUE)))
        );

        bg.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 640, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/virusdetector/minimize.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        bg.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 0, 30, 30));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/virusdetector/close.png"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        bg.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 0, 30, 30));

        lbl_os.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_os.setText("OS: ");
        bg.add(lbl_os, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 500, 30));

        panel_sacn.setBackground(new java.awt.Color(204, 204, 204));
        panel_sacn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        button1.setActionCommand("Select");
        button1.setLabel("Select");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        panel_sacn.add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 80, -1));

        button2.setActionCommand("Select");
        button2.setLabel("Scan");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });
        panel_sacn.add(button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 80, -1));

        lbl_path.setBackground(new java.awt.Color(255, 255, 255));
        lbl_path.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_path.setText("Select a folder to scan ");
        panel_sacn.add(lbl_path, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 520, 20));

        button3.setActionCommand("Select");
        button3.setLabel("Stop");
        button3.setVisible(false);
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });
        panel_sacn.add(button3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 80, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "", "Potential Malware"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Boolean.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(20);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(20);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(600);
        }

        panel_sacn.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 550, 170));

        button4.setActionCommand("Select");
        button4.setLabel("Delete");
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });
        panel_sacn.add(button4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, 80, -1));

        lbl_delete.setBackground(new java.awt.Color(255, 255, 255));
        lbl_delete.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_delete.setText("Take action against those files");
        panel_sacn.add(lbl_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 190, 20));

        bg.add(panel_sacn, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 610, 300));

        panel_performance.setBackground(new java.awt.Color(204, 204, 204));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("CPU usage:");

        lbl_cpu_usage.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        javax.swing.GroupLayout panel_performanceLayout = new javax.swing.GroupLayout(panel_performance);
        panel_performance.setLayout(panel_performanceLayout);
        panel_performanceLayout.setHorizontalGroup(
            panel_performanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_performanceLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(panel_performanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_performanceLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(lbl_cpu_usage, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_performanceLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(customPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(437, Short.MAX_VALUE))
        );
        panel_performanceLayout.setVerticalGroup(
            panel_performanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_performanceLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panel_performanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_performanceLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel16))
                    .addGroup(panel_performanceLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lbl_cpu_usage, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(customPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(308, Short.MAX_VALUE))
        );

        bg.add(panel_performance, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 630, 390));

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/virusdetector/sheild.png"))); // NOI18N

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 0, 153));
        jLabel14.setText("You're protected");
        jLabel14.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel14.setAlignmentY(0.0F);

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("This program uses a MD5 Hash Registry to detect malware. It will only tell you if the MD5 matches");
        jLabel15.setToolTipText("");
        jLabel15.setAlignmentY(0.0F);

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("a previously submitted file that was determined to be malware.");
        jLabel17.setAlignmentY(0.0F);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(203, 203, 203))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addContainerGap(252, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(143, Short.MAX_VALUE)))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(20, 20, 20)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(199, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addGap(110, 110, 110))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(122, Short.MAX_VALUE)))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addContainerGap(245, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(83, 83, 83)))
        );

        jLabel15.getAccessibleContext().setAccessibleName("This program uses a MD5 Hash Registry to detect malware. It will only tell you if the MD5 matches");
        jLabel15.getAccessibleContext().setAccessibleDescription("");

        bg.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 620, 360));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code, here:
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void lbl_virus_scan1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_virus_scan1MouseEntered
        // TODO add your handling code here:
        setColor(btn_virusScan);

    }//GEN-LAST:event_lbl_virus_scan1MouseEntered

    private void lbl_performanceMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_performanceMouseEntered
        // TODO add your handling code here:btn_performance
        setColor(btn_performance);

    }//GEN-LAST:event_lbl_performanceMouseEntered

    private void lbl_virus_scan1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_virus_scan1MouseExited
        // TODO add your handling code here:
        resetColor(btn_virusScan);
    }//GEN-LAST:event_lbl_virus_scan1MouseExited

    private void lbl_performanceMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_performanceMouseExited
        // TODO add your handling code here:
        resetColor(btn_performance);
    }//GEN-LAST:event_lbl_performanceMouseExited

    private void lbl_virus_scan1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lbl_virus_scan1KeyPressed
        // TODO add your handling code here:
        //setClickedColor(btn_virusScan);
    }//GEN-LAST:event_lbl_virus_scan1KeyPressed

    private void lbl_virus_scan1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_virus_scan1MouseClicked
        // TODO add your handling code here:
        //setClickedColor(btn_virusScan);
        setPressedColor(btn_virusScan);
        backToNomalColor(btn_performance);
        panel_sacn.setVisible(true);
        panel_performance.setVisible(false);
    }//GEN-LAST:event_lbl_virus_scan1MouseClicked

    private void lbl_performanceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_performanceMouseClicked
        // TODO add your handling code here:
        //setClickedColor(btn_performance);

        setPressedColor(btn_performance);
        backToNomalColor(btn_virusScan);
        panel_performance.setVisible(true);
        panel_sacn.setVisible(false);
    }//GEN-LAST:event_lbl_performanceMouseClicked

    private void lbl_virus_scan1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_virus_scan1MousePressed
        // TODO add your handling code here:

    }//GEN-LAST:event_lbl_virus_scan1MousePressed

    private void lbl_virus_scan1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_virus_scan1MouseReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_lbl_virus_scan1MouseReleased

    private void lbl_performanceMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_performanceMousePressed
        // TODO add your handling code here:

    }//GEN-LAST:event_lbl_performanceMousePressed

    private void lbl_performanceMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_performanceMouseReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_lbl_performanceMouseReleased

    private void bgKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bgKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_bgKeyPressed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:

        int returnValue = fc.showOpenDialog(this);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            filepath = file.getAbsolutePath();
            System.out.println(filepath);
            lbl_path.setText(filepath);
        }
    }//GEN-LAST:event_button1ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        // TODO add your handling code here:
        button4.setVisible(false);
        lbl_delete.setVisible(false);
        malware = "";
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        model.setRowCount(0);
        scanThread = new Thread() {
            
           DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
            
           private int count  = 0;
            
            void RecursivePrint(File[] arr,int index,int level) {
                // terminate condition
                if(index == arr.length)
                    return;

                // tabs for internal levels
                for (int i = 0; i < level; i++)
                    System.out.print("\t");

                // for files
                if(arr[index].isFile()){
                    System.out.println(arr[index].getName());
                    String path = arr[index].getAbsolutePath();
                    
                    lbl_path.setText(path);
                    
                    String hash = MD5CheckSum.getMD5HashOfFile(path);
                    
                    if(malwareHashes.contains(hash)){
                        count++;
                        malware += path+"\n";
                        //System.out.println(hash);
                        model.addRow(new Object[]{count, false, path});
                    }
                        
                }

                // for sub-directories
                else if(arr[index].isDirectory())
                {
                    System.out.println("[" + arr[index].getName() + "]");

                    // recursion for sub-directories
                    RecursivePrint(arr[index].listFiles(), 0, level + 1);
                }

                // recursion for main directory
                RecursivePrint(arr,++index, level);
           }
            public void run() {
                File maindir = new File(filepath);

                if (maindir.exists() && maindir.isDirectory()) {
                    // array for files and sub-directories 
                    // of directory pointed by maindir
                    File arr[] = maindir.listFiles();

                    System.out.println("**********************************************");
                    System.out.println("Files from main directory : " + maindir);
                    System.out.println("**********************************************");

                    // Calling recursive method
                    RecursivePrint(arr, 0, 0);
                }
                    DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                    String requiredDate = df.format(new Date()).toString();
                    lbl_date.setText(requiredDate);
                    lbl_delete.setVisible(true);
                    button4.setVisible(true);
            }

        };
                
        scanThread.start(); 

    }//GEN-LAST:event_button2ActionPerformed

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        // TODO add your handling code here:
        scanThread.stop();
        malware = "";
        button3.disable();
    }//GEN-LAST:event_button3ActionPerformed

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        for (int row = 0; row < model.getRowCount(); row++) {
            if((boolean)model.getValueAt(row, 1) == true){
                System.out.println(model.getValueAt(row, 2));
                File f = new File((String)model.getValueAt(row, 2));
                f.delete();
                model.removeRow(row);
                for(int r = 0; r < model.getRowCount(); r++){
                    model.setValueAt(r+1, r, 0);
                }
            }
        }
        
    }//GEN-LAST:event_button4ActionPerformed

    /**
                 * @param args the command line arguments
                 */

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JPanel btn_performance;
    private javax.swing.JPanel btn_virusScan;
    private java.awt.Button button1;
    private java.awt.Button button2;
    private java.awt.Button button3;
    private java.awt.Button button4;
    private virusdetector.CustomPanel customPanel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbl_cpu_usage;
    private javax.swing.JLabel lbl_date;
    private javax.swing.JLabel lbl_delete;
    private javax.swing.JLabel lbl_os;
    private javax.swing.JLabel lbl_path;
    private javax.swing.JLabel lbl_performance;
    private javax.swing.JLabel lbl_virus_scan1;
    private javax.swing.JPanel panel_performance;
    private javax.swing.JPanel panel_sacn;
    // End of variables declaration//GEN-END:variables
}