package com.openbravo.pos.util;

import java.awt.Component;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import com.openbravo.beans.JPasswordDialog;
import com.openbravo.pos.forms.AppLocal;

public class Hashcypher {


    public Hashcypher() {
    }

    public static boolean authenticate(String sPassword, String sHashPassword) {
        if (sHashPassword == null || sHashPassword.equals("") || sHashPassword.startsWith("empty:")) {
            return sPassword == null || sPassword.equals("");
        } else if (sHashPassword.startsWith("sha1:")) {
            return sHashPassword.equals(hashString(sPassword));
        } else if (sHashPassword.startsWith("plain:")) {
            return sHashPassword.equals("plain:" + sPassword);
        } else {
            return sHashPassword.equals(sPassword);
        }
    }

    public static String hashString(String sPassword) {

        if (sPassword == null || sPassword.equals("")) {
            return "empty:";
        } else {
            try {
                MessageDigest md = MessageDigest.getInstance("SHA-1");
                md.update(sPassword.getBytes("UTF-8"));
                byte[] res = md.digest();
                return "sha1:" + StringUtils.byte2hex(res);
            } catch (NoSuchAlgorithmException e) {
                return "plain:" + sPassword;
            } catch (UnsupportedEncodingException e) {
                return "plain:" + sPassword;
            }
        }
    }

    public static String changePassword(Component parent) {
        // Show the changePassword dialogs but do not check the old password

        String sPassword = JPasswordDialog.showEditPassword(parent,
                                                            AppLocal.getIntString("Label.Password"),
                                                            AppLocal.getIntString("label.passwordnew"),
                                                            new ImageIcon(Hashcypher.class.getResource("/images/password.png")));
        if (sPassword != null) {
            String sPassword2 = JPasswordDialog.showEditPassword(parent,
                                                                 AppLocal.getIntString("Label.Password"),
                                                                 AppLocal.getIntString("label.passwordrepeat"),
                                                                 new ImageIcon(Hashcypher.class.getResource("/images/password.png")));
            if (sPassword2 != null) {
                if (sPassword.equals(sPassword2)) {
                    return  Hashcypher.hashString(sPassword);
                } else {
                    JOptionPane.showMessageDialog(parent, AppLocal.getIntString("message.changepassworddistinct"),
                                                  AppLocal.getIntString("message.title"), JOptionPane.WARNING_MESSAGE);
                }
            }
        }

        return null;
    }

    public static String changePassword(Component parent, String sOldPassword) {

        String sPassword = JPasswordDialog.showEditPassword(parent,
                                                            AppLocal.getIntString("Label.Password"),
                                                            AppLocal.getIntString("label.passwordold"),
                                                            new ImageIcon(Hashcypher.class.getResource("/images/password.png")));
        if (sPassword != null) {
            if (Hashcypher.authenticate(sPassword, sOldPassword)) {
                return changePassword(parent);
            } else {
                JOptionPane.showMessageDialog(parent, AppLocal.getIntString("message.BadPassword"),
                                              AppLocal.getIntString("message.title"), JOptionPane.WARNING_MESSAGE);
            }
        }
        return null;
    }
}
