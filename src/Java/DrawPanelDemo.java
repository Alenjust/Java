package Java;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

//������
public class DrawPanelDemo extends JFrame{
     
     //����
     private int x1;
     private int x;
     private int x2;
     private int y1;
     private int y;
     private int y2;
     private Color color = Color. black;
     private  int taye;
     //������ť
     JButton b1 = new JButton( "ֱ��");
     JButton b2 = new JButton( "����");
     JButton b3 = new JButton( "Բ");
     JButton b4 = new JButton();        //��ɫ��ť
     JButton b5 = new JButton();        //��ɫ��ť
     JButton b6 = new JButton();        //��ɫ��ť
     JButton b7 = new JButton();        //��ɫ��ť
     //����Graphics����
     Graphics g;
     //��ȡͼ����Ϣ
     ArrayList<Line> line = new ArrayList<Line>();
     ArrayList<Rectangle> rect = new ArrayList<Rectangle>();
     ArrayList<Round> round = new ArrayList<Round>();
     //��дpaint������ͼ���ػ�
     @Override
     public void paint(Graphics g) {
           super.paint(g);
           for(Line l : line){
              g = DrawPanelDemo. this.getGraphics();
              g.setColor(l.getColor());
              g.drawLine(l.getX1(), l.getY1(), l.getX2(), l.getY2());
          }
           for(Rectangle r: rect){
              g = DrawPanelDemo. this.getGraphics();
              g.setColor(r.getColor());
              g.drawRect(r.getX(), r.getY(), Math.abs(r.getX2()-r.getX1()), Math.abs(r.getY2()-r.getY1()));
          }
           for(Round ro : round){
              g = DrawPanelDemo. this.getGraphics();
              g.setColor(ro.getColor());
              g.drawOval(ro.getX(), ro.getY(), Math.abs(ro.getX2()-ro.getX1()), Math.abs(ro.getY2()-ro.getY1()));
          }
     }
     
     public DrawPanelDemo(){
           //���ò���
           super( "��ͼ��");
           this.setSize(1000, 1000);
           this.setLayout( null);
           b1.setBounds(0, 0, 65, 65);
           b2.setBounds(0, 65, 65, 65);
           b3.setBounds(0, 130, 65, 65);
           b4.setBounds(0, 195, 65, 65);
           b5.setBounds(0, 260, 65, 65);
           b6.setBounds(0, 325, 65, 65);
           b7.setBounds(0, 390, 65, 65);
           b4.setBackground(Color. orange);
           b5.setBackground(Color. blue);
           b6.setBackground(Color. black);
           b7.setBackground(Color. red);
          add( b1);
          add( b2);
          add( b3);
          add( b4);
          add( b5);
          add( b6);
          add( b7);
           this.setVisible( true);
           this.setDefaultCloseOperation(JFrame. EXIT_ON_CLOSE);
     }
     
     //��ť����
     public void Listener(){
           b1.addActionListener( new ActionListener() {
              
               @Override
               public void actionPerformed(ActionEvent e) {
                    taye = 1;  //��ֱ��
              }
          });
           b2.addActionListener( new ActionListener() {
              
               @Override
               public void actionPerformed(ActionEvent e) {
                    taye = 2;  //������
              }
          });
           b3.addActionListener( new ActionListener() {
              
               @Override
               public void actionPerformed(ActionEvent e) {
                    taye = 3;  //��Բ
              }
          });
           b4.addActionListener( new ActionListener() {
              
               @Override
               public void actionPerformed(ActionEvent e) {
                    color = Color. orange;
              }
          });
           b5.addActionListener( new ActionListener() {
              
               @Override
               public void actionPerformed(ActionEvent e) {
                    color = Color. blue;
              }
          });
           b6.addActionListener( new ActionListener() {
              
               @Override
               public void actionPerformed(ActionEvent e) {
                    color = Color. black;
              }
          });
           b7.addActionListener( new ActionListener() {
              
               @Override
               public void actionPerformed(ActionEvent e) {
                    color = Color. red;
              }
          });
     }
     //ʵ�ֻ�ͼ����
     public void drawMetoh(){
          addMouseListener( new MouseListener() {
              
               @Override
               public void mouseReleased(MouseEvent e) {
                    x2 = e.getX();
                    y2 = e.getY();
                    //g.drawLine(x1, y1, x2, y2);
                    g = DrawPanelDemo. this.getGraphics();
                    if( taye == 1){
                         g.setColor( color);
                         g.drawLine( x1, y1, x2, y2);
                         line.add( new Line( x1, x2, y1, y2, color));
                   } else if( taye == 2){
                         if( x1< x2 && y1< y2){
                              x = x1;
                              y = y1;
                              g.setColor( color);
                              g.drawRect( x, y, Math. abs(x2 - x1), Math. abs(y2 - y1));
                              rect.add( new Rectangle(x,y ,x1 , x2 , y1 , y2 , color ));
                        } else if( x1> x2 && y1> y2){
                              x = x2;
                              y = y2;
                              g.setColor( color);
                              g.drawRect( x, y, Math. abs(x2 - x1), Math. abs(y2 - y1));
                              rect.add( new Rectangle(x,y ,x1 , x2 , y1 , y2 , color ));
                        } else if( x1< x2 && y1> y2){
                              x = x1;
                              y = y2;
                              g.setColor( color);
                              g.drawRect( x, y, Math. abs(x2 - x1), Math. abs(y2 - y1));
                              rect.add( new Rectangle(x,y ,x1 , x2 , y1 , y2 , color ));
                        } else if( x1> x2 && y2> y1){
                              x = x2;
                              y = y1;
                              g.setColor( color);
                              g.drawRect( x, y, Math. abs(x2 - x1), Math. abs(y2 - y1));
                              rect.add( new Rectangle(x,y ,x1 , x2 , y1 , y2 , color ));
                        }
                   } else if( taye == 3){
                         if( x1< x2 && y1< y2){
                              x = x1;
                              y = y1;
                              g.setColor( color);
                              g.drawOval( x, y, Math. abs(x2 - x1), Math. abs(y2 - y1));
                              round.add( new Round( x, y, x1, x2, y1, y2, color));
                        } else if( x1> x2 && y1> y2){
                              x = x2;
                              y = y2;
                              g.setColor( color);
                              g.drawOval( x, y, Math. abs(x2 - x1), Math. abs(y2 - y1));
                              round.add( new Round( x, y, x1, x2, y1, y2, color));
                        } else if( x1< x2 && y1> y2){
                              x = x1;
                              y = y2;
                              g.setColor( color);
                              g.drawOval( x, y, Math. abs(x2 - x1), Math. abs(y2 - y1));
                              round.add( new Round( x, y, x1, x2, y1, y2, color));
                        } else if( x1> x2 && y2> y1){
                              x = x2;
                              y = y1;
                              g.setColor( color);
                              g.drawOval( x, y, Math. abs(x2 - x1), Math. abs(y2 - y1));
                              round.add( new Round( x, y, x1, x2, y1, y2, color));
                        }
                   }
              }
              
               @Override
               public void mousePressed(MouseEvent e) {
                    x1 = e.getX();
                    y1 = e.getY();
              }
              
               @Override
               public void mouseExited(MouseEvent e) {}
              
               @Override
               public void mouseEntered(MouseEvent e) {}
              
               @Override
               public void mouseClicked(MouseEvent e) {}
          });
     }
     //�϶�Ч����������
     public void myMouseMotionListener(){
          addMouseMotionListener( new MouseMotionListener() {
              
               @Override
               public void mouseMoved(MouseEvent e) {
                    // TODO Auto-generated method stub
                   
              }
              
               @Override
               public void mouseDragged(MouseEvent e) {
                    x2 = e.getX();
                    y2 = e.getY();
                    g = DrawPanelDemo. this.getGraphics();
                    if( taye == 1){
                         g.setColor( color);
                         g.drawLine( x1, y1, x2, y2);
                        repaint();
                   } else if( taye == 2){
                         if( x1< x2 && y1< y2){
                              x = x1;
                              y = y1;
                              g.setColor( color);
                              g.drawRect( x, y, Math. abs(x2 - x1), Math. abs(y2 - y1));
                             repaint();
                        } else if( x1> x2 && y1> y2){
                              x = x2;
                              y = y2;
                              g.setColor( color);
                              g.drawRect( x, y, Math. abs(x2 - x1), Math. abs(y2 - y1));
                             repaint();
                        } else if( x1< x2 && y1> y2){
                              x = x1;
                              y = y2;
                              g.setColor( color);
                              g.drawRect( x, y, Math. abs(x2 - x1), Math. abs(y2 - y1));
                             repaint();
                        } else if( x1> x2 && y2> y1){
                              x = x2;
                              y = y1;
                              g.setColor( color);
                              g.drawRect( x, y, Math. abs(x2 - x1), Math. abs(y2 - y1));
                             repaint();
                        }
                   } else if( taye == 3){
                         if( x1< x2 && y1< y2){
                              x = x1;
                              y = y1;
                              g.setColor( color);
                              g.drawOval( x, y, Math. abs(x2 - x1), Math. abs(y2 - y1));
                             repaint();
                        } else if( x1> x2 && y1> y2){
                              x = x2;
                              y = y2;
                              g.setColor( color);
                              g.drawOval( x, y, Math. abs(x2 - x1), Math. abs(y2 - y1));
                             repaint();
                        } else if( x1< x2 && y1> y2){
                              x = x1;
                              y = y2;
                              g.setColor( color);
                              g.drawOval( x, y, Math. abs(x2 - x1), Math. abs(y2 - y1));
                             repaint();
                        } else if( x1> x2 && y2> y1){
                              x = x2;
                              y = y1;
                              g.setColor( color);
                              g.drawOval( x, y, Math. abs(x2 - x1), Math. abs(y2 - y1));
                             repaint();
                        }
                   }
              }
          });
     }

}
