package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Main {

    public static void main(String[] args) {

        BazaDeDate bd = BazaDeDate.getInstance();

        if (args == null) {
            System.out.println("Running Main");
        } else if (args.length >= 2) {
            String file1 = "src/project/" + args[0]; //exchangeRates.csv
            String file2 = "src/project/" + args[1]; //stockValues.csv
            try {
                FileReader f3;
                BufferedReader r3;
                f3 = new FileReader(file2);
                r3 = new BufferedReader(f3);
                String linie3 ;
                String[] numbers;
                linie3 = r3.readLine();
                while (linie3 != null) {
                    linie3 = r3.readLine();
                    if (linie3 != null) {
                        numbers = linie3.split(",");
                        Actiuni a = new Actiuni();
                        a.nume_companie = numbers[0];
                        a.nr = 0;
                        for (int h = 1; h < 11; h++)
                            a.getValori().add(Double.parseDouble(numbers[h]));
                        bd.getLista_actiuni().add(a);
                    }
                }
                f3.close();

                FileReader f2;
                BufferedReader r2;
                f2 = new FileReader(file1);
                r2 = new BufferedReader(f2);
                String linie2;
                String[] val_lin;
                int n = 0;
                do {
                    linie2 = r2.readLine();
                    if (linie2 != null && !linie2.substring(0, 4).equals("Base")) {
                        linie2 = linie2.substring(4);
                        val_lin = linie2.split(",");
                        for (int m = 0; m < 5; m++)
                            bd.matrice[n][m] = Double.parseDouble(val_lin[m]);
                        n++;
                    }
                } while (linie2 != null);
                f2.close();



            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        //////////////////////////////////////////////////////////////////////
        Frame frame = new JFrame("Aplicatie EBanking");
        JPanel panel = new JPanel(new BorderLayout()); // Folosim BorderLayout pentru a separa panelul în două părți

        // Panel pentru butoane
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0, 1));

        JButton createUserButton = new JButton("CREATE USER");
        JButton addFriendButton = new JButton("ADD FRIEND");
        JButton addAccountButton = new JButton("ADD ACCOUNT");
        JButton addMoneyButton = new JButton("ADD MONEY");
        JButton listUserButton = new JButton("LIST USER");
        JButton exchangeMoneyButton = new JButton("EXCHANGE MONEY");
        JButton listPortfolioButton = new JButton("LIST PORTFOLIO");
        JButton transferMoneyButton = new JButton("TRANSFER MONEY");
        JButton recommendStocksButton = new JButton("RECOMMEND STOCKS");
        JButton buyStocksButton = new JButton("BUY STOCKS");
        JButton buyPremiumButton = new JButton("BUY PREMIUM");
        JButton exitButton = new JButton("EXIT");



        buttonPanel.add(createUserButton);
        buttonPanel.add(addFriendButton);
        buttonPanel.add(addAccountButton);
        buttonPanel.add(addMoneyButton);
        buttonPanel.add(listUserButton);
        buttonPanel.add(exchangeMoneyButton);
        buttonPanel.add(listPortfolioButton);
        buttonPanel.add(transferMoneyButton);
        buttonPanel.add(recommendStocksButton);
        buttonPanel.add(buyStocksButton);
        buttonPanel.add(buyPremiumButton);
        buttonPanel.add(exitButton);

        // Panel pentru output
        JTextArea outputArea = new JTextArea();
        JScrollPane outputScrollPane = new JScrollPane(outputArea); // Adăugăm un JScrollPane pentru a permite scroll-ul în cazul output-ului lung

        panel.add(buttonPanel, BorderLayout.WEST); // Plasăm panelul cu butoane în partea stângă
        panel.add(outputScrollPane, BorderLayout.CENTER); // Plasăm output-ul în partea dreaptă

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);

        outputArea.setFont(new Font("Arial", Font.ITALIC, 14));
        // Setare culoare de fundal pentru JTextArea
        outputArea.setBackground(Color.lightGray);
        // Setare culoare de text pentru JTextArea
        outputArea.setForeground(Color.black);

        createUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = JOptionPane.showInputDialog("Introdu email:");
                String firstname = JOptionPane.showInputDialog("Introdu prenume:");
                String lastname = JOptionPane.showInputDialog("Introdu nume:");
                String address = JOptionPane.showInputDialog("Introdu adresa:");
                ComandaCreareUtilizator c = new ComandaCreareUtilizator(bd, email, firstname, lastname, address,outputArea);
                c.executa();
            }
        });

        addFriendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user1 = JOptionPane.showInputDialog("Introdu primul utilizator:");
                String user2 = JOptionPane.showInputDialog("Introdu al doilea utilizator:");
                ComandaAdaugarePrieten c = new ComandaAdaugarePrieten(bd, user1, user2,outputArea);
                c.executa();
            }
        });


        addAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = JOptionPane.showInputDialog("Introdu utilizatorul:");
                String accountType = JOptionPane.showInputDialog("Introdu tipul de cont:");
                ComandaAdaugareCont c = new ComandaAdaugareCont(bd, user, accountType,outputArea);
                c.executa();
            }
        });

        addMoneyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = JOptionPane.showInputDialog("Introdu utilizatorul:");
                String accountID = JOptionPane.showInputDialog("Introdu valuta contului:");
                double amount = Double.parseDouble(JOptionPane.showInputDialog("Introdu suma:"));
                ComandaAlimentareCont c = new ComandaAlimentareCont(bd, user, accountID, amount);
                c.executa();
            }
        });

        listUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = JOptionPane.showInputDialog("Introdu utilizatorul:");
                ComandaListareUtilizator c = new ComandaListareUtilizator(bd, user,outputArea);
                c.executa();
            }
        });

        exchangeMoneyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userFrom = JOptionPane.showInputDialog("Introdu utilizatorul care trimite:");
                String fromCurrency = JOptionPane.showInputDialog("Introdu valuta sursa:");
                String toCurrency = JOptionPane.showInputDialog("Introdu valuta destinație:");
                double amount = Double.parseDouble(JOptionPane.showInputDialog("Introdu suma:"));
                ComandaSchimbValutar c = new ComandaSchimbValutar(bd, userFrom, fromCurrency, toCurrency, amount,outputArea);
                c.executa();
            }
        });

        listPortfolioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = JOptionPane.showInputDialog("Introdu utilizatorul:");
                ComandaListarePortofoliuUtilizator c = new ComandaListarePortofoliuUtilizator(bd, user,outputArea);
                c.executa();
            }
        });

        transferMoneyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userFrom = JOptionPane.showInputDialog("Introdu utilizatorul care trimite:");
                String userTo = JOptionPane.showInputDialog("Introdu utilizatorul care primește:");
                String valuta = JOptionPane.showInputDialog("Introdu valuta:");
                double amount = Double.parseDouble(JOptionPane.showInputDialog("Introdu suma:"));
                ComandaTransfer c = new ComandaTransfer(bd, userFrom, userTo, valuta, amount,outputArea);
                c.executa();
            }
        });

        recommendStocksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ComandaRecomandareActiuni c = new ComandaRecomandareActiuni(bd,outputArea);
                c.executa();
            }
        });

        buyStocksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = JOptionPane.showInputDialog("Introdu utilizatorul:");
                String stockSymbol = JOptionPane.showInputDialog("Introdu numele companiei:");
                int quantity = Integer.parseInt(JOptionPane.showInputDialog("Introdu cantitatea:"));
                ComandaCumparareActiuni c = new ComandaCumparareActiuni(bd, user, stockSymbol, quantity,outputArea);
                c.executa();
            }
        });

        buyPremiumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = JOptionPane.showInputDialog("Introdu utilizatorul:");
                ComandaBuyPremium c = new ComandaBuyPremium(bd, user,outputArea);
                c.executa();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bd.reseteaza();
                System.exit(0);
            }
        });

    }
}
