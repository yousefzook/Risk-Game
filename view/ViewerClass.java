package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSlider;

import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.ui.swingViewer.DefaultView;
import org.graphstream.ui.view.Viewer;
import org.graphstream.ui.view.ViewerListener;
import org.graphstream.ui.view.ViewerPipe;

import model.IBoard;
import model.ITerritory;

public class ViewerClass {

	private MultiGraph g;
	private String styleSheet;

	public ViewerClass(IBoard board) {
		g = new MultiGraph("Board Graph");
//		System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
		styleSheet = "node {" + "shape: rounded-box;" + "stroke-mode:plain;" + "stroke-width:10px;" + "size-mode:fit;" +
		// "fill-color:white;"+
				"fill-mode: dyn-plain;" + "text-alignment:center;" + "text-size:50px;" +
				// "stroke-color:black;"+
				"padding:10px;" + "text-style:bold-italic;" +

				"}" + "edge { 	" + "shape: line;" + "size:2;	" + " fill-color: blue;" + "text-size:15px;"
				+ "text-style:bold;" + "arrow-size:15px,7px;" + "text-background-mode:rounded-box;"
				+ "text-background-color:white;" + "text-padding:2px,2px;" + "}";
		g.addAttribute("ui.stylesheet", styleSheet);

		g.addAttribute("ui.antialias");
		g.addAttribute("ui.quality");

		initFrame(g, board);

	}

	private void drawGraph(MultiGraph graph, IBoard board) {
		// TODO Auto-generated method stub
		ArrayList<ITerritory> terrs = board.getTerritories();
		for (ITerritory terr : terrs) {

			graph.addNode(Integer.toString(terr.getNumber()));
			graph.getNode(Integer.toString(terr.getNumber())).setAttribute("ui.color", terr.getOwner().getColor());
			graph.getNode(Integer.toString(terr.getNumber())).setAttribute("ui.label", terr.getArmySize());
			String hexColor = "#" + Integer.toHexString(terr.getParentContinent().getColor().getRGB()).substring(2);
			graph.getNode(Integer.toString(terr.getNumber())).setAttribute("ui.style",
					"stroke-color:" + hexColor + ";");
			Set<ITerritory> neighbTerrs = terr.getNeighbors();
			for (ITerritory neigh : neighbTerrs) {
				if (!graph.getNode(Integer.toString(terr.getNumber()))
						.hasEdgeBetween(Integer.toString(neigh.getNumber())))
					graph.addEdge(Integer.toString(neigh.getNumber()) + Integer.toString(terr.getNumber()),
							Integer.toString(neigh.getNumber()), Integer.toString(terr.getNumber()));
			}
		}

	}

	private void initFrame(MultiGraph g2, IBoard board) {
		// TODO Auto-generated method stub
		g.setStrict(false);
		Viewer viewer = new Viewer(g, Viewer.ThreadingModel.GRAPH_IN_GUI_THREAD);

		JFrame myJFrame = new JFrame();
		myJFrame.setPreferredSize(new Dimension(600, 600));
		DefaultView view = (DefaultView) viewer.addDefaultView(false); // false indicates "no JFrame".
		view.setPreferredSize(new Dimension(1024, 720));

		myJFrame.setLayout(new FlowLayout());
		myJFrame.add(view);
		JButton myButton = new JButton("MyButton");
		myButton.addActionListener(e -> System.out.println("Somebody pushed my button."));
		myJFrame.add(myButton);
		JSlider slider = new JSlider();
		slider.addChangeListener(e -> view.getCamera().setViewPercent(slider.getValue() / 10.0));
		myJFrame.add(slider);
		myJFrame.pack();
		myJFrame.setVisible(true);
		myJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myJFrame.setSize(new Dimension(1280, 1024));
		viewer.enableAutoLayout();
		ViewerPipe vp = viewer.newViewerPipe();
		vp.addViewerListener(new ViewerListener() {
			@Override
			public void viewClosed(String viewName) {
				// dont care
			}

			@Override
			public void buttonPushed(String id) {
				Node n = g.getNode(id);
				String attributes[] = n.getAttributeKeySet().toArray(new String[n.getAttributeKeySet().size()]);

				String attributeToChange = (String) JOptionPane.showInputDialog(null, "Select attibute to modify",
						"Attribute for " + id, JOptionPane.QUESTION_MESSAGE, null, attributes, attributes[0]);
				String curValue = n.getAttribute(attributeToChange);
				String newValue = JOptionPane.showInputDialog("New Value", curValue);
				n.setAttribute(attributeToChange, newValue);
				// n.addAttribute("ui.class", "marked");
				n.addAttribute("ui.color", Color.cyan);
			}

			@Override
			public void buttonReleased(String id) {
				// don't care
			}
		});
		drawGraph(g, board);

		while (true) {
			(view).repaint();
			vp.pump();
		}
	}

}