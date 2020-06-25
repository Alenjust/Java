package Java;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
 
public class MyPaint {
	public static void main(String[] args) {
		new PaintFrame( "JavaPainter" );
	}
}
 
class MyCanvas extends JPanel implements MouseListener, MouseMotionListener {
	
	private Vector<Point> curve;
	private Vector<Vector<Point>> curves;
	
	private Point ptFrom = new Point();
	private Point ptTo = new Point();
	
	MyCanvas() {
		curve = new Vector<Point>();
		curves = new Vector<Vector<Point>>();
		this.setPreferredSize(new Dimension(300, 200));
		this.addMouseListener( this );
		this.addMouseMotionListener( this );
	}
	
	public void paintComponent( Graphics g ) {
		g.setColor( Color.RED );
		for( Vector<Point> points : curves ) {			
			Point pt0 = points.get( 0 );
			for( int i = 1; i < points.size(); ++i ) {
				Point pt = points.get( i );
				g.drawLine(pt0.x, pt0.y, pt.x, pt.y);
				pt0 = pt;
			}
		}
	}
 
	@Override
	public void mousePressed(MouseEvent e) {
		ptFrom.x = e.getX();
		ptFrom.y = e.getY();
		curve.add( (Point) ptFrom.clone() );
	}
 
	@Override
	public void mouseReleased(MouseEvent e) {
		ptTo.x = e.getX();
		ptTo.y = e.getY();
		curve.add( (Point) ptTo.clone() );
		curves.add( new Vector<Point>( curve ) );
		curve.clear();
	}
 
	@Override
	public void mouseDragged(MouseEvent e) {
		ptTo.x = e.getX();
		ptTo.y = e.getY();
		curve.add( ( Point )ptTo.clone() );
		Graphics g = getGraphics();
		g.setColor(Color.RED);
		g.drawLine( ptFrom.x, ptFrom.y, ptTo.x, ptTo.y );
		ptFrom.x = ptTo.x;
		ptFrom.y = ptTo.y;
	}
 
	@Override
	public void mouseEntered(MouseEvent e) {
		// do nothing
	}
 
	@Override
	public void mouseExited(MouseEvent e) {
		// do nothing
	}
 
	@Override
	public void mouseClicked(MouseEvent e) {
		// do nothing
	}
 
	@Override
	public void mouseMoved(MouseEvent e) {
		// do nothing
	}
 
}
 
class PaintFrame extends JFrame {
 
	private MyCanvas canvas = new MyCanvas();
 
	PaintFrame( String title ) {
		super( title );
		Container cp = getContentPane();
		cp.add(canvas);
		setSize(300, 200);
		setVisible(true);
	}
}
