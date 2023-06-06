package BasicExercises;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;


/**
 *
 * @author Romario - estradaflorezromario@artesyletras.edu.co
 */
public class Panel extends JPanel {

    private static final long serialVersionUID = 1L;

    private double x1 = 0;
    private double x2 = 0;
    private double y1 = 0;
    private double y2 = 0;

    private Point2D px = new Point2D.Double(x1, y1);
    private Point2D py = new Point2D.Double(x2, y2);

    private Point2D pxTempo = new Point2D.Double(x2, y2);
    private Point2D pyTempo = new Point2D.Double(x1, y1);

    private boolean init = true;

    static ArrayList<Polygon> polygons = new ArrayList<Polygon>();

    static ArrayList<Ellipse2D> elipse = new ArrayList<Ellipse2D>();
    static ArrayList<Arc2D> arc = new ArrayList<Arc2D>();

    static ArrayList<Color> borderColor = new ArrayList<Color>();
    static ArrayList<Color> fillColor = new ArrayList<Color>();
    static ArrayList<Color> elipseColors = new ArrayList<Color>();

    static ArrayList<double[]> propertyArc = new ArrayList<double[]>();
    static ArrayList<double[]> property = new ArrayList<double[]>();

    static ArrayList<Color> colors = new ArrayList<Color>();

    static ArrayList<double[]> arcProperty = new ArrayList<double[]>();

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        // Enable anti-aliasing for smoother rendering
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Create a scaling transformation
        double scaleX = 2.5;
        double scaleY = 2.5;
        AffineTransform scalingTransform = AffineTransform.getScaleInstance(scaleX, scaleY);

        // Apply the scaling transformation to the graphics object
        g2d.transform(scalingTransform);

        // uncomment to active every draw
        
        paintNeil(g);
    }

    // Graphic draws
    public void paintNeil(Graphics g) {
        cleanArc();
        cleanOval();
        cleanPolygon();
        reset();

        // colors
        Color CWhite = Color.decode("#ffffff");
        Color CGreen = Color.decode("#57cb98");
        Color CGreenSoft = Color.decode("#CAB8FF");
        Color CBlack = Color.decode("#152744");
        Color CRed = Color.decode("#F0C9C9");
        Color CPurple = Color.decode("#533E85");
        Color CPurpleSoft = Color.decode("#a279ff");
        Color CPurpleStrong = Color.decode("#2b2044");
        
        

        // EYES
        int spaceBetweenEyes = 10;
        int pLeftRightEye = 200+spaceBetweenEyes; 
        int pLeftLeftEye = 112-spaceBetweenEyes; 
        int pTop = 90;

        int eWidth = 38;
        int eHeight = 90;

        int[] rightEye = { pLeftRightEye+8, pTop-12, eWidth, eHeight };

        int[] leftEye = { pLeftLeftEye+8, pTop, eWidth, eHeight };

        int[] head = { 100, 10, 160, 220 };

        // Background ovals
        int[] bgOval4 = { -90, -120, 600, 600 };
        createOval(g, bgOval4,CPurpleSoft,0,0);

        int[] bgOval3 = { -20, -30, 400, 400 };
        createOval(g, bgOval3,CGreenSoft,0,0);

        int[] bgOval2 = { 30, 20, 300, 300 };
        createOval(g, bgOval2,CPurple,0,0);

        int[] bgOval1 = { 80, 70, 200, 200 };
        createOval(g, bgOval1,CPurpleStrong,0,0);

        // Legs

        // Left Leg
        int leftLegLeftPosition = 168;
        int leftLegTopPosition = 120+165;
        int leftLegWidth = 160-150;
        int leftLegHeight = 220-170; 

        int[] leftLeg = { leftLegLeftPosition, leftLegTopPosition, leftLegWidth, leftLegHeight };

        createOval(g, leftLeg,CGreen,12,6);

        // Right Leg
        int rightLegLeftPosition = 184;
        int rightLegTopPosition = 120+165;
        int rightLegWidth = 160-150;
        int rightLegHeight = 220-170; 

        int[] rightLeg = { rightLegLeftPosition, rightLegTopPosition, rightLegWidth, rightLegHeight };

        createOval(g, rightLeg,CGreen,(-12),6);

        // Trunk
        int bLeftPosition = 162;
        int bTopPosition = 120+80;
        int bWidth = 160-120;
        int bHeight = 220-120; 

        int[] trunk = { bLeftPosition, bTopPosition, bWidth, bHeight };

        createOval(g, trunk,CGreen,0,6);

        // Left Arm
        int leftArmLeftPosition = 162;
        int leftArmTopPosition = 120+100;
        int leftArmWidth = 160-150;
        int leftArmHeight = 220-170; 

        int[] leftArm = { leftArmLeftPosition, leftArmTopPosition, leftArmWidth, leftArmHeight };

        createOval(g, leftArm,CGreen,33,6);

        // Right Arm
        int rightArmLeftPosition = 192;
        int rightArmTopPosition = 120+104;
        int rightArmWidth = 160-150;
        int rightArmHeight = 220-170; 

        int[] rightArm = { rightArmLeftPosition, rightArmTopPosition, rightArmWidth, rightArmHeight };

        createOval(g, rightArm,CGreen,(-33),6);


        // Head paint

        createOval(g, head,CGreen,0,6);
        createOval(g, rightEye,CBlack,22,6);
        createOval(g, leftEye,CBlack,(-22),6);


        paintOval(g, CBlack);
        cleanOval();


        // Nose
        int nLeftPosition = 172;
        int nTopPosition = 170;
        int nWidth = 16;
        int nHeight = 8;

        // Mouth
        int mLeftPosition = 170;
        int mTopPosition = 200;
        int mWidth = 20;
        int mHeight = 10;

        // tongue
        int sizeTongue = 10;
        int tLeftPosition = 170 + (sizeTongue/2);
        int tTopPosition = 190;
        int tWidth = 20-sizeTongue;
        int tHeight = 30;

        double[] nose = { nLeftPosition, nTopPosition, nWidth, nHeight, 0, -180 };
        double[] mouth = { mLeftPosition, mTopPosition, mWidth, mHeight, 0, -180 };
        double[] tongueDown = { tLeftPosition, tTopPosition, tWidth, tHeight, 0, -180 };

        createArc(g, nose, Arc2D.OPEN, CBlack,1,CBlack,0, 2);
        createArc(g, mouth, Arc2D.CHORD, CBlack,1,CBlack,1, 2);
        createArc(g, tongueDown, Arc2D.CHORD, CRed,1,CRed,1, 2);

        paintArc(g);
        cleanArc();

        // Name
        g.setColor(CWhite);
        g.setFont(new Font("Montserrat", Font.BOLD, 30));

        String name = "NEIL";

        g.drawString(name, 272, 340);
    }

    // METHODS

    private void paintPolygon(Graphics g) {
        super.paint(g);
        for(int i = 0; i < colors.size(); i++){
            g.setColor(colors.get(i));
            g.fillPolygon(polygons.get(i));
        }
    }

    private void paintLine(double[][] coordinate, Graphics2D g2, boolean end, float top, Color trace) {
        // Graphics2D g2 = (Graphics2D)g2;

        Stroke pencil = new BasicStroke(top);
        g2.setStroke(pencil);

        g2.setColor(trace);

        reset();

        for (int e = 0; e < coordinate.length; e++) {
            boolean flight = false;

            if(Math.pow(-1, (e+1))> 0) flight = true;

            Line2D some = paintCoordinate(coordinate[e][0], coordinate[e][1], flight);
            init = false;

            if(init == false && e > 0) g2.draw(some);

            if(e == coordinate.length-1 && end == true) {
                some = new Line2D.Double(pyTempo, pxTempo);
                g2.draw(some);
            }
        }
    }

    // private void createPolygon(int[] coordinateX, int[] coordinateY, Graphics2D g2, Color color, int sides) {
    private void createPolygon(int[] coordinateX, int[] coordinateY, Graphics g, Color color) {
        super.paint(g);
        Polygon polygon = new Polygon(coordinateX, coordinateY, coordinateX.length);

        polygons.add(polygon);
        colors.add(color);
    }

    private Line2D paintCoordinate(double pMoon, double pMoon2, boolean flight) {
        
        if(flight == false && init == true) {
            x1 = pMoon;
            y1 = pMoon2;

            px = new Point2D.Double(x1, y1);
            pxTempo = px;
            pyTempo = px;
        }

        if(!init) {
            px = pxTempo;
            x2 = pMoon;
            y2 = pMoon2;
            py = new Point2D.Double(x2, y2);
            pxTempo = py;
        }
        
        Line2D lActual = new Line2D.Double(px, py);

        return lActual;
    }


    // Cleaners
    private void reset() {
        x1 = 0;
        x2 = 0;
        y1 = 0;
        y2 = 0;

        px = new Point2D.Double(x1, y1);
        py = new Point2D.Double(x2, y2);

        pxTempo = new Point2D.Double(x2, y2);
        pyTempo = new Point2D.Double(x1, y1);

        init = true;
    }
    
    private void cleanOval() {
        elipse.clear();
        elipseColors.clear();
        property.clear();
    }

    private void cleanArc() {
        arc.clear();
        borderColor.clear();
        fillColor.clear();
        propertyArc.clear();
    }

    private void cleanPolygon() {
        polygons.clear();
        colors.clear();
    }

    // METHODS circles
    private void createOval(Graphics g, int[] coordinate, Color color, double angle, int brush){
        int x = coordinate[0];
        int y = coordinate[1];

        double properties[] = { x, y, angle, brush };

        Ellipse2D elipseToUse = new Ellipse2D.Double( 0, 0, coordinate[2], coordinate[3] );

        elipse.add(elipseToUse);

        elipseColors.add(color);
        property.add(properties);
    }

    private void createArc(Graphics g2, double[] coordinate, int arcType, Color borderC, double withBorder, Color fillC, double withFillColor, float brush) {
        double x = coordinate[0];
        double y = coordinate[1];
        double width = coordinate[2];
        double height = coordinate[3];
        double start = coordinate[4];
        double extend = coordinate[5];

        double arcProperties[] = { withBorder, withFillColor, brush };

        Arc2D arc2d = new Arc2D.Double( x, y, width, height, start, extend, arcType );
        
        arc.add(arc2d);
        borderColor.add(borderC);
        
        fillColor.add(fillC);
        propertyArc.add(arcProperties);

    }

    private void paintArc(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;

        int size = arc.size();

        double withBorder;
        double withFillColor;
        double pencil;
        double propertyRecover[];

        for (int i = 0; i < size; i++) {
            propertyRecover = propertyArc.get(i);
            withBorder = propertyRecover[0];
            withFillColor = propertyRecover[1];
            pencil = propertyRecover[2];

            Stroke brush = new BasicStroke((float) pencil);
            g2d.setStroke(brush);

            Arc2D objArc = arc.get(i);

            if(withBorder == 1) {
                g2d.setColor(borderColor.get(i));
                g2d.draw(objArc);
            } 
            if(withFillColor == 1) {
                g2d.setColor(fillColor.get(i));
                g2d.fill(objArc);
            }
        }
    }

    private void paintOval(Graphics g, Color color) {
        Graphics2D g2d = (Graphics2D)g;

        int size = elipse.size();

        double x;
        double y;
        double angle;
        double pencil;
        double [] propertyRecover;
        
        for (int i = 0; i < size; i++) {

            AffineTransform old = g2d.getTransform();
            propertyRecover = property.get(i);

            x = propertyRecover[0];
            y = propertyRecover[1];
            angle = propertyRecover[2];
            pencil = propertyRecover[3];

            Stroke brush = new BasicStroke((float) pencil);
            g2d.setStroke(brush);

            g2d.translate(x, y);
            g2d.rotate(angle * Math.PI/180);

            g2d.setColor(color);
            g2d.draw(elipse.get(i));
            
            g2d.setColor(elipseColors.get(i));
            g2d.fill(elipse.get(i));

            g2d.setTransform(old);
        }
    }
}