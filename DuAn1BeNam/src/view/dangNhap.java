package view;

import javax.swing.JOptionPane;
import model.NhanVien;
import service.NhanVienService;

public class dangNhap extends javax.swing.JFrame {

    private NhanVienService nhanVienService;

    public dangNhap() {
        initComponents();
        setLocationRelativeTo(null);
        this.nhanVienService = new NhanVienService();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMaNhanVien = new javax.swing.JTextField();
        txtMatKhau = new javax.swing.JPasswordField();
        btnDangNhap = new javax.swing.JButton();
        lblMaNhanVien = new javax.swing.JLabel();
        lblMatKhau = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Đăng Nhập");

        jLabel2.setText("Mã Nhân Viên:");

        jLabel3.setText("Mật Khẩu:");

        btnDangNhap.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDangNhap.setText("Đăng Nhập");
        btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangNhapActionPerformed(evt);
            }
        });

        lblMaNhanVien.setForeground(new java.awt.Color(255, 0, 0));
        lblMaNhanVien.setText(" ");

        lblMatKhau.setForeground(new java.awt.Color(255, 0, 0));
        lblMatKhau.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMaNhanVien)
                            .addComponent(txtMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                            .addComponent(lblMaNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jLabel1))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(btnDangNhap)))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(lblMaNhanVien)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(lblMatKhau)
                .addGap(18, 18, 18)
                .addComponent(btnDangNhap)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangNhapActionPerformed
        String maNhanVien = this.txtMaNhanVien.getText().trim();
        String matKhau = this.txtMatKhau.getText().trim();

        if (maNhanVien.length() == 0 && matKhau.length() == 0) {
            this.lblMaNhanVien.setText("Chưa nhập mã nhân viên!");
            this.lblMatKhau.setText("Chưa nhập mật khẩu!");

        }

        if (maNhanVien.length() == 0) {
            this.lblMaNhanVien.setText("Chưa nhập mã nhân viên!");

        }
        if (matKhau.length() == 0) {
            this.lblMatKhau.setText("Chưa nhập mật khẩu!");
            return;
        }

        if (maNhanVien.length() == 0 && matKhau.length() != 0) {
            this.lblMaNhanVien.setText("Chưa nhập mã nhân viên!");
            this.lblMatKhau.setText(" ");
            return;
        }

        if (maNhanVien.length() != 0 && matKhau.length() != 0) {
            this.lblMaNhanVien.setText(" ");
            this.lblMatKhau.setText(" ");
        }
        NhanVien nvDatabase = nhanVienService.getNhanVienDangNhap(maNhanVien);
        System.out.println(maNhanVien + " | " + matKhau);
        if (nvDatabase != null) {
            if (nvDatabase.getMatKhau().equalsIgnoreCase(matKhau)) {
                maDangNhap.maDangNhap = maNhanVien;
                System.out.println(maDangNhap.maDangNhap);
                nullForm nf = new nullForm();
                nf.setVisible(true);
                this.dispose();
                JOptionPane.showMessageDialog(this, "Đăng nhập thành công!");
                return;
            } else {
                JOptionPane.showMessageDialog(this, "Sai mật khẩu!");
                return;
            }
        } else {
            JOptionPane.showMessageDialog(this, "Tài khoản không tồn tại");
            return;
        }
    }//GEN-LAST:event_btnDangNhapActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dangNhap().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangNhap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblMaNhanVien;
    private javax.swing.JLabel lblMatKhau;
    private javax.swing.JTextField txtMaNhanVien;
    private javax.swing.JPasswordField txtMatKhau;
    // End of variables declaration//GEN-END:variables
}
