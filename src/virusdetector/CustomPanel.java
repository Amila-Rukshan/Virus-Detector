/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virusdetector;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Arc2D;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author ARS
 */
public class CustomPanel extends JLabel{
    
    int progress = 0;
    
    public void setProgress(int x){
        progress = x;
    }
    
    public void paint(Graphics g){
        int start = 0;
        super.paint(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.translate(this.getWidth()/2, this.getHeight()/2);
        g2.rotate(Math.toRadians(270));
        Arc2D.Float arc = new Arc2D.Float(Arc2D.PIE);
        arc.setFrameFromCenter(new Point(0,0), new Point(22,22));
        arc.setAngleStart(1);
        arc.setAngleExtent(-progress*3.6);
        System.out.println(progress);
        g2.setColor(new Color(51,79,127));
        g2.draw(arc);
        g2.fill(arc);
             
        if(start==0){
            arc.setAngleStart(1);
            arc.setAngleExtent(360-progress*3.6);
            System.out.println(progress);
            g2.setColor(new Color(204,204,204));
            g2.draw(arc);
            g2.fill(arc);
            start=1;
        }
        
        arc.setFrameFromCenter(new Point(0,0), new Point(18,18));
        arc.setAngleStart(1);
        arc.setAngleExtent(360);
        System.out.println(progress);
        g2.setColor(new Color(204,204,204));
        g2.draw(arc);
        g2.fill(arc);
        
        this.setText("");
    }
}
