package tw.org.iii.myclass;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.JPanel;

public class SignView extends JPanel {
//	private LinkedList<Point> line;	// 儲存單一線條的資料
//	private LinkedList<LinkedList<Point>> lines; // 儲存多線條的資料
	private LinkedList<LinkedList<HashMap<String, Integer>>> lines, recycler;

	public SignView() {
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
		// 實例應用：在繪圖的paintComponent方法中，
		// 傳入的Graphics g參數實際上是一個Graphics2D實例，但它的靜態類型是Graphics。
		// 為了使用Graphics2D的進階功能，需要將它明確地轉型成Graphics2D類型，
		// 例如：Graphics2D g2d = (Graphics2D) g;。

		// 在這邊也可以使用 g instanceof Graphics 來檢查其關係。
		Graphics2D g2d = (Graphics2D) g;

		// 設定線條粗細為 4 像素
		float lineWidth = 4.0f;
		BasicStroke bs = new BasicStroke(lineWidth);
		g2d.setStroke(bs);

		g.setColor(Color.BLUE);

//		// 繪圖 - 更新存下來的線條(只有單一線條)
//		for (int i = 1; i < line.size(); i++) {
//			Point p0 = line.get(i - 1);
//			Point p1 = line.get(i);
//			g.drawLine(p0.x, p0.y, p1.x, p1.y);
//		}

//		// 繪圖 - 更新存下來的線條(多線條)
//		for (LinkedList<Point> line : lines) {
//			for (int i = 1; i < line.size(); i++) {
//				Point p0 = line.get(i - 1);
//				Point p1 = line.get(i);
//				g.drawLine(p0.x, p0.y, p1.x, p1.y);
//			}
//		}

		for (LinkedList<HashMap<String, Integer>> line : lines) {
			for (int i = 1; i < line.size(); i++) {
				HashMap<String, Integer> p0 = line.get(i - 1);
				HashMap<String, Integer> p1 = line.get(i);
				g.drawLine(p0.get("x"), p0.get("y"), p1.get("x"), p1.get("y"));
			}
		}

	}

	private class MyListener extends MouseAdapter {
//		// 監聽單一線條
//		@Override
//		public void mouseDragged(MouseEvent e) {
//			super.mouseDragged(e);
//			// 因Point 類別直接繼承 Object的無傳參數建構式
//			Point point = new Point();
//			point.x = e.getX();
//			point.y = e.getY();
//			line.add(point);
//
//			// 呼叫 JPanel父類別的方法 repaint() 來觸發重新繪製
//			// 注意：paintComponent 是生命週期的概念，不是用來呼叫的
//			repaint();
//		}

		@Override
		public void mousePressed(MouseEvent e) {
			super.mousePressed(e);
			// 當Pressed觸發後，產生新的線
//			LinkedList<Point> line = new LinkedList<>();
//
//			// 當Pressed觸發後，產生新的點
//			Point point = new Point();
//			point.x = e.getX();
//			point.y = e.getY();
//			line.add(point);
//
//			lines.add(line);

			// 當Pressed觸發後，產生新的線
			LinkedList<HashMap<String, Integer>> line = new LinkedList<>();

			// 當Pressed觸發後，產生新的點
			HashMap<String, Integer> point = new HashMap<>();
			point.put("x", e.getX());
			point.put("y", e.getY());
			line.add(point);
			lines.add(line);
			recycler.clear();

		}

		@Override
		public void mouseDragged(MouseEvent e) {
			super.mouseDragged(e);

//			Point point = new Point();
//			point.x = e.getX();
//			point.y = e.getY();
//			lines.getLast().add(point);

			HashMap<String, Integer> point = new HashMap<>();
			point.put("x", e.getX());
			point.put("y", e.getY());
			lines.getLast().add(point);

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
}

// 只有在Interface Collection下的才能用forEach尋訪
// 用HashMap來取代Point類別
