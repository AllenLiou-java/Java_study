package tw.org.iii.myclass;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

// 可變換線條顏色
public class SignViewV2 extends JPanel {

	private LinkedList<Line> lines, recycler;
	private Color nowColor = Color.BLUE;

	public SignViewV2() {
		setBackground(Color.YELLOW);

		// 偵測滑鼠移動
		MyListener listener = new MyListener();
		addMouseListener(listener);
		addMouseMotionListener(listener);

//		line = new LinkedList<>();
		lines = new LinkedList<>();
		recycler = new LinkedList<>(); // 宣告recycler後記得建構式初始化時new 物件實體
	}

	// paintComponent 是由內部自動被呼叫，不需要主動去呼叫
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;

		// 設定線條粗細為 4 像素
		float lineWidth = 4.0f;
		BasicStroke bs = new BasicStroke(lineWidth);
		g2d.setStroke(bs);

		for (Line line : lines) {
			g.setColor(line.color);
			for (int i = 1; i < line.points.size(); i++) {
				HashMap<String, Integer> p0 = line.points.get(i - 1);
				HashMap<String, Integer> p1 = line.points.get(i);
				g.drawLine(p0.get("x"), p0.get("y"), p1.get("x"), p1.get("y"));
			}
		}

	}

	private class MyListener extends MouseAdapter {

		@Override
		public void mousePressed(MouseEvent e) {
			super.mousePressed(e);

			// 當Pressed觸發後，產生新的線
			Line line = new Line(nowColor);

			// 當Pressed觸發後，產生新的點
			HashMap<String, Integer> point = new HashMap<>();
			point.put("x", e.getX());
			point.put("y", e.getY());
			line.points.add(point);
			lines.add(line);
			recycler.clear();

		}

		@Override
		public void mouseDragged(MouseEvent e) {
			super.mouseDragged(e);

			HashMap<String, Integer> point = new HashMap<>();
			point.put("x", e.getX());
			point.put("y", e.getY());
			lines.getLast().points.add(point);

			repaint();
		}
	}

//	private class Point {
//		int x, y;
//	}

	public void clear() {
		lines.clear();
		repaint();
	}

	public void undo() {
		if (lines.size() > 0) {
			recycler.add(lines.removeLast());
			repaint();
		}

	}

	public void redo() {
		if (recycler.size() > 0) {
			lines.add(recycler.removeLast());
			repaint();
		}
	}

	public void setColor(Color newColor) {
		nowColor = newColor;
	}

	public Color getColor() {
		return nowColor;
	}

	// Line類別的屬性都是 Serializable，故Line 也可以是 Serializable
	public class Line implements Serializable {
		Color color;
		LinkedList<HashMap<String, Integer>> points;

		Line(Color color) {
			this.color = color;
			points = new LinkedList<>();
		}
	}

	// 因為lines 存取範圍為private，故saveLines 與 loadLines 只能寫在此類別中
	public void saveLines(String filename) {
		try {
			ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(filename));
			oout.writeObject(lines);
			oout.flush();
			oout.close();
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public void loadLines(String filename) {
		try {
			ObjectInputStream oin = new ObjectInputStream(new FileInputStream(filename));		
			lines = (LinkedList<Line>)oin.readObject();
			oin.close();
			
			repaint();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	// 輸出圖檔
	public void saveImage(String name,String type) {
		BufferedImage image = new BufferedImage(getWidth(),getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = image.createGraphics();
		// 在記憶體中繪製
		paint(g2);
		try{
			ImageIO.write(image, type, new File(name+"."+type));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

// 只有在Interface Collection下的才能用forEach尋訪
// 用HashMap來取代Point類別
