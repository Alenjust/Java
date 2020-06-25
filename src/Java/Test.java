package Java;

public class Test {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 //创建一个画图板对象
        DrawPanelDemo d = new DrawPanelDemo();
         //调用DrawPanelDemo类中的监听器方法
        d.Listener();
         //调用DrawPanelDemo类中的画图方法
        d.drawMetoh();
         //调用DrawPanelDemo类中的鼠标拖动监听方法
        d.myMouseMotionListener();

	}

}
