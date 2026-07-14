
package movierecommendationsystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MovieSystem extends javax.swing.JFrame {
    private ArrayList<UserVector> mainUsers;
    private ArrayList<UserVector> targetUsers;
    private HashMap<Integer, String> movies;
    
    public MovieSystem() {
        initComponents();
        setTitle("Movie Recommendation System");
        loadData(); // CSV dosyalarını yükle
    }
    
            // CSV dosyalarını okuyup verileri programa yükler
        private void loadData() {

            mainUsers = MovieDataLoader.loadUsers("main_data.csv");
            targetUsers = MovieDataLoader.loadUsers("target_user.csv");
            movies = MovieDataLoader.loadMovies("movies.csv");

            // Target user listesini combobox'a ekle
            cmbTargetUser.removeAllItems();

            for (UserVector user : targetUsers) {
                cmbTargetUser.addItem(user.getUserId());
            }

            // Movie Rating ekranındaki filmleri yükle
            loadRandomMoviesToComboBoxes();
        }

        // Movie Rating ekranı için rastgele 10 film seçer
        private void loadRandomMoviesToComboBoxes() {

            ArrayList<Integer> movieIds = new ArrayList<>(movies.keySet());
            ArrayList<String> selectedMovies = new ArrayList<>();

            Random random = new Random();

            // 10 farklı film seç
            while (selectedMovies.size() < 10
                    && selectedMovies.size() < movieIds.size()) {

                int randomIndex = random.nextInt(movieIds.size());

                int movieId = movieIds.get(randomIndex);

                String movieName = movies.get(movieId);

                String item = movieId + " - " + movieName;

                if (!selectedMovies.contains(item)) {
                    selectedMovies.add(item);
                }
            }

            // Combobox'ları temizle
            cmbMovie1.removeAllItems();
            cmbMovie2.removeAllItems();
            cmbMovie3.removeAllItems();
            cmbMovie4.removeAllItems();
            cmbMovie5.removeAllItems();

            // Aynı film listesini tüm combobox'lara ekle
            for (String item : selectedMovies) {

                cmbMovie1.addItem(item);
                cmbMovie2.addItem(item);
                cmbMovie3.addItem(item);
                cmbMovie4.addItem(item);
                cmbMovie5.addItem(item);
            }

            // İlk açılışta farklı filmler seçili gelsin
            if (selectedMovies.size() >= 5) {

                cmbMovie1.setSelectedIndex(0);
                cmbMovie2.setSelectedIndex(1);
                cmbMovie3.setSelectedIndex(2);
                cmbMovie4.setSelectedIndex(3);
                cmbMovie5.setSelectedIndex(4);
            }
        }

        // Kullanıcının seçtiği film ve puanı user vector içine ekler
        private void addSelectedMovieRating(
                UserVector user,
                String selectedItem,
                String ratingText) {

            String[] parts = selectedItem.split(" - ");

            int movieId = Integer.parseInt(parts[0]);

            int rating = Integer.parseInt(ratingText);

            if (rating >= 1 && rating <= 5) {

                user.addRating(movieId, rating);
            }
        }
        
        // Seçilen 5 filmin birbirinden farklı olup olmadığını kontrol eder
        private boolean areSelectedMoviesDifferent() {

            String m1 = cmbMovie1.getSelectedItem().toString();
            String m2 = cmbMovie2.getSelectedItem().toString();
            String m3 = cmbMovie3.getSelectedItem().toString();
            String m4 = cmbMovie4.getSelectedItem().toString();
            String m5 = cmbMovie5.getSelectedItem().toString();

            return !m1.equals(m2)
                    && !m1.equals(m3)
                    && !m1.equals(m4)
                    && !m1.equals(m5)
                    && !m2.equals(m3)
                    && !m2.equals(m4)
                    && !m2.equals(m5)
                    && !m3.equals(m4)
                    && !m3.equals(m5)
                    && !m4.equals(m5);
        }

        // Girilen rating değeri 1-5 arasında mı kontrol eder
        private boolean isValidRating(String text) {

            try {
                int rating = Integer.parseInt(text);
                return rating >= 1 && rating <= 5;
            } catch (Exception e) {
                return false;
            }
        }
        
        // X ve K değerlerinin pozitif sayı olup olmadığını kontrol eder
        private boolean isValidPositiveNumber(String text) {

            try {
                int number = Integer.parseInt(text);
                return number > 0;
            } catch (Exception e) {
                return false;
            }
        }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbTargetUser = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtTargetX = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTargetK = new javax.swing.JTextField();
        btnTargetRecommend = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtTargetResult = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cmbMovie1 = new javax.swing.JComboBox<>();
        cmbMovie2 = new javax.swing.JComboBox<>();
        cmbMovie3 = new javax.swing.JComboBox<>();
        cmbMovie4 = new javax.swing.JComboBox<>();
        cmbMovie5 = new javax.swing.JComboBox<>();
        txtRate1 = new javax.swing.JTextField();
        txtRate2 = new javax.swing.JTextField();
        txtRate3 = new javax.swing.JTextField();
        txtRate4 = new javax.swing.JTextField();
        txtRate5 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtMovieX = new javax.swing.JTextField();
        txtMovieK = new javax.swing.JTextField();
        btnMovieRecommend = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMovieResult = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText(" Target User:");

        cmbTargetUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTargetUserActionPerformed(evt);
            }
        });

        jLabel2.setText("X:");

        jLabel3.setText("K:");

        btnTargetRecommend.setText("Get Recommendations");
        btnTargetRecommend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTargetRecommendActionPerformed(evt);
            }
        });

        jLabel4.setText("Top  X * K Recommendations:");

        txtTargetResult.setColumns(20);
        txtTargetResult.setRows(5);
        jScrollPane1.setViewportView(txtTargetResult);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(178, 178, 178))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbTargetUser, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(85, 85, 85)))
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTargetX, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTargetK, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(btnTargetRecommend)
                        .addContainerGap(158, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTargetUser, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTargetX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTargetK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTargetRecommend))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Target User", jPanel1);

        jLabel5.setText("Movie 1:");

        jLabel6.setText("Movie 2:");

        jLabel7.setText("Movie 3:");

        jLabel8.setText("Movie 4:");

        jLabel9.setText("Movie 5:");

        cmbMovie1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMovie1ActionPerformed(evt);
            }
        });

        cmbMovie4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMovie4ActionPerformed(evt);
            }
        });

        cmbMovie5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMovie5ActionPerformed(evt);
            }
        });

        txtRate5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRate5ActionPerformed(evt);
            }
        });

        jLabel10.setText("X:");

        jLabel11.setText("K:");

        txtMovieK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMovieKActionPerformed(evt);
            }
        });

        btnMovieRecommend.setText("Get Recommendations");
        btnMovieRecommend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMovieRecommendActionPerformed(evt);
            }
        });

        jLabel12.setText("Recommendations:");

        txtMovieResult.setColumns(20);
        txtMovieResult.setRows(5);
        jScrollPane2.setViewportView(txtMovieResult);

        jLabel13.setText("Rating:");

        jLabel14.setText("Rating:");

        jLabel15.setText("Rating:");

        jLabel16.setText("Rating:");

        jLabel17.setText("Rating:");

        jLabel18.setText("K:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMovieRecommend)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 763, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cmbMovie4, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cmbMovie5, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cmbMovie3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(151, 151, 151)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtRate4, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtRate3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtRate5, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(cmbMovie2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtRate2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(cmbMovie1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(44, 44, 44)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtRate1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMovieX, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMovieK, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(86, 86, 86))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbMovie1)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMovieX, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtRate1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtRate2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cmbMovie2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRate3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtRate4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtMovieK, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(23, 23, 23)
                        .addComponent(txtRate5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cmbMovie3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbMovie4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbMovie5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(121, 121, 121)
                .addComponent(btnMovieRecommend)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Movie Rating", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbTargetUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTargetUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTargetUserActionPerformed

    private void cmbMovie4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMovie4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbMovie4ActionPerformed

    private void txtRate5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRate5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRate5ActionPerformed

    private void txtMovieKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMovieKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMovieKActionPerformed

    private void cmbMovie1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMovie1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbMovie1ActionPerformed

    private void cmbMovie5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMovie5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbMovie5ActionPerformed

    private void btnTargetRecommendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTargetRecommendActionPerformed
        // Seçilen target user için önerileri getir
        int selectedIndex = cmbTargetUser.getSelectedIndex();

            if (selectedIndex < 0) {
                return;
            }
            
            if (!isValidPositiveNumber(txtTargetX.getText()) || !isValidPositiveNumber(txtTargetK.getText())) {

                txtTargetResult.setText("X and K must be positive integer values.");
                return;
            }

            UserVector targetUser = targetUsers.get(selectedIndex);

            int x = Integer.parseInt(txtTargetX.getText());

            int k = Integer.parseInt(txtTargetK.getText());

            ArrayList<String> recommendations =
                    RecommendationEngine.recommendMovies(
                            targetUser,
                            mainUsers,
                            movies,
                            x,
                            k);

            txtTargetResult.setText("");

            for (String movie : recommendations) {

                txtTargetResult.append(movie + "\n");
            }
    }//GEN-LAST:event_btnTargetRecommendActionPerformed

    private void btnMovieRecommendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMovieRecommendActionPerformed
        // Kullanıcının girdiği film puanlarına göre önerileri getir
        if (!areSelectedMoviesDifferent()) {
            txtMovieResult.setText("Please select 5 different movies.");
            return;
        }

        if (!isValidRating(txtRate1.getText())
                || !isValidRating(txtRate2.getText())
                || !isValidRating(txtRate3.getText())
                || !isValidRating(txtRate4.getText())
                || !isValidRating(txtRate5.getText())) {

            txtMovieResult.setText("Ratings must be integer values between 1 and 5.");
            return;
        }
        
        if (!isValidPositiveNumber(txtMovieX.getText())
                || !isValidPositiveNumber(txtMovieK.getText())) {

            txtMovieResult.setText("X and K must be positive integer values.");
            return;
        }
        
        UserVector customUser = new UserVector("custom_user");

        addSelectedMovieRating(
                customUser,
                cmbMovie1.getSelectedItem().toString(),
                txtRate1.getText());

        addSelectedMovieRating(
                customUser,
                cmbMovie2.getSelectedItem().toString(),
                txtRate2.getText());

        addSelectedMovieRating(
                customUser,
                cmbMovie3.getSelectedItem().toString(),
                txtRate3.getText());

        addSelectedMovieRating(
                customUser,
                cmbMovie4.getSelectedItem().toString(),
                txtRate4.getText());

        addSelectedMovieRating(
                customUser,
                cmbMovie5.getSelectedItem().toString(),
                txtRate5.getText());

        int x = Integer.parseInt(txtMovieX.getText());

        int k = Integer.parseInt(txtMovieK.getText());

        ArrayList<String> recommendations =
                RecommendationEngine.recommendMovies(
                        customUser,
                        mainUsers,
                        movies,
                        x,
                        k);

        txtMovieResult.setText("");

        for (String movie : recommendations) {

            txtMovieResult.append(movie + "\n");
        }
    }//GEN-LAST:event_btnMovieRecommendActionPerformed

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
            java.util.logging.Logger.getLogger(MovieSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MovieSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MovieSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MovieSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MovieSystem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMovieRecommend;
    private javax.swing.JButton btnTargetRecommend;
    private javax.swing.JComboBox<String> cmbMovie1;
    private javax.swing.JComboBox<String> cmbMovie2;
    private javax.swing.JComboBox<String> cmbMovie3;
    private javax.swing.JComboBox<String> cmbMovie4;
    private javax.swing.JComboBox<String> cmbMovie5;
    private javax.swing.JComboBox<String> cmbTargetUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField txtMovieK;
    private javax.swing.JTextArea txtMovieResult;
    private javax.swing.JTextField txtMovieX;
    private javax.swing.JTextField txtRate1;
    private javax.swing.JTextField txtRate2;
    private javax.swing.JTextField txtRate3;
    private javax.swing.JTextField txtRate4;
    private javax.swing.JTextField txtRate5;
    private javax.swing.JTextField txtTargetK;
    private javax.swing.JTextArea txtTargetResult;
    private javax.swing.JTextField txtTargetX;
    // End of variables declaration//GEN-END:variables
}
