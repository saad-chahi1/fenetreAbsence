package fenetreAbsence;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Fenetre extends JFrame{

  //MAIN METHOD
  public static void main(String[] args)
  {

       EventQueue.invokeLater(new Runnable()
       {
           public void run()
           {
               //INITIALIZE JFRAME FORM
               Fenetre form=new Fenetre();
               form.setVisible(true);;
           }
       });

  }

  //CONSTRUCTOR
  public Fenetre()
  {
    //the form
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(200,200,800,300);
    setTitle("La liste d'absence");
    getContentPane().setLayout(null);

    //ADD SCROLLPANE
    JScrollPane scroll=new JScrollPane();
    scroll.setBounds(70,80,600,200);
    getContentPane().add(scroll);

    //THE TABLE
    final JTable table=new JTable();
    scroll.setViewportView(table);

    //THE MODEL OF OUR TABLE
    DefaultTableModel model=new DefaultTableModel()
    {
      public Class<?> getColumnClass(int column)
      {
        switch(column)
        {
        case 0:
          return String.class;
        case 1:
          return String.class;
        case 2:
          return Boolean.class;
        case 3:
          return Boolean.class;
        case 4:
          return Boolean.class;

          default:
            return Boolean.class;
        }
      }
    };

    //ASSIGN THE MODEL TO TABLE
    table.setModel(model);

    model.addColumn("Nom");
    model.addColumn("Prenom");
    model.addColumn("Semaine1");
    model.addColumn("Semaine2");
    model.addColumn("Semaine3");
    
    String nom1="CHAHI";String nom2="BENHAR";String nom3="RZAL";String nom4="MAHDAR";String nom5="MOUGHAZI";
    String prenom1="SAAD";String prenom2="YASSINE";String prenom3="TAOUFIK";String prenom4="saad";String prenom5="YOUSSEF";
    String nom="",prenom="";
    //THE ROW
    for(int i=0;i<=4;i++)
    {
      if(i==0) {
    	  nom=nom1;prenom=prenom1;
      }else if(i==1) {
    	  nom=nom2;prenom=prenom2;
      }else if(i==2) {
    	  nom=nom3;prenom=prenom3;
      }else if(i==3) {
    	  nom=nom4;prenom=prenom4;
      }else if(i==4) {
    	  nom=nom5;prenom=prenom5;
      }
      model.addRow(new Object[0]);
      model.setValueAt(nom, i, 0);
      model.setValueAt(prenom, i, 1);
      model.setValueAt(false,i,2);
      model.setValueAt(false,i,3);
      model.setValueAt(false,i,4);
    }

    //OBTAIN SELECTED ROW
    JButton btn=new JButton("le nombre total de séances");
    btn.addActionListener(new ActionListener() {
    
      @Override
      public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
    	
        //GET SELECTED ROW
    	
        for(int i=0;i<table.getRowCount();i++)
        {
        int j=2;
        int  total = 0;
         while(j<5) {

          Boolean checked=Boolean.valueOf(table.getValueAt(i, j).toString());
          String col=table.getValueAt(i, j).toString();
          
          //DISPLAY
          j++;
          if(checked)
          {
            total=total+1;
          }
         }if(i==0)
             System.out.println("SAAD CHAHI été absent aux "+ total +" séance(s)");
         else if(i==1)
             System.out.println("YAASINE BENHAR été absent aux "+ total +" séance(s)");
         else if(i==2)
             System.out.println("TAOUFIK RZAL été absent aux "+ total +" séance(s)");
         else if(i==3)
             System.out.println("SAAD MEHDAR été absent aux "+ total +" séance(s)");
         else 
             System.out.println("YOUSSEF MOUGHAZI été absent aux "+ total +" séance(s)");
        }

      }
    });

    //ADD BUTTON TO FORM
    btn.setBounds(20,30,130,30);
    getContentPane().add(btn);
  }

}