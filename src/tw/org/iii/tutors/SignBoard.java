package tw.org.iii.tutors;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import tw.org.iii.myclass.SignView;
import tw.org.iii.myclass.SignViewV2;

public class SignBoard extends JFrame {
//	private SignView signView;
	private SignViewV2 signView;
	JButton b1, b2, b3, b4, b6, b7,b8;

	public SignBoard() {
		super("簽名板");
		setSize(640, 480);

		setLayout(new BorderLayout());

		JPanel top = new JPanel();
		b1 = new JButton("Clear");
		b2 = new JButton("Undo");
		b3 = new JButton("Redo");
		b4 = new JButton("Color");
		b6 = new JButton("Save");
		b7 = new JButton("Load");
		b8 = new JButton("Save JPEG");
		top.add(b1);
		top.add(b2);
		top.add(b3);
		top.add(b4);
		top.add(b6);
		top.add(b7);
		top.add(b8);
		add(top, BorderLayout.NORTH);

//		signView = new SignView();
//		add(signView, BorderLayout.CENTER);

		signView = new SignViewV2();
		add(signView, BorderLayout.CENTER);

		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		initEvent();
	}

	private void initEvent() {
		// 使用閉包直接實作介面
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				clearSignView();
			}

		});
		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				undoSignView();
			}

		});
		b3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				redoSignView();
			}

		});
		b4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				changeColor();
			}

		});
		b6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				signView.saveLines("dir1/lines.vic");
			}
		});
		b7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				signView.loadLines("dir1/lines.vic");
			}
		});
		b8.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				saveJPEG();
				
			}
		});
	}
	
	private void saveJPEG() {
		signView.saveImage("dir1/vic", "jpeg");
	}

	private void clearSignView() {
		signView.clear();
	}

	private void undoSignView() {
		signView.undo();
	}

	private void redoSignView() {
		signView.redo();
	}

	public void changeColor() {
		Color color = JColorChooser.showDialog(null, "Color", signView.getColor());
		signView.setColor(color);
	}

	public static void main(String[] args) {
		new SignBoard();

	}

}

// Set：不可重複
// List：可重複、有順序性
// Map: key-value pair
