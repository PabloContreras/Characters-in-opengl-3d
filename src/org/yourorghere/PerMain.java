package org.yourorghere;

import com.sun.opengl.util.Animator;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import javax.swing.JOptionPane;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 * @author Sandra Daniela
 * @version 2.0.0
 */
public class PerMain implements GLEventListener, KeyListener, MouseListener, MouseMotionListener {

    AudioStream audio;
    InputStream sounds;
    static GLCanvas canvas = new GLCanvas();
    private float view_rotx = 0.01f;
    private float view_roty = 0.01f;
    int m = 0;
    private int oldMousex;
    private int oldMousey;
    boolean avanzaB = false;
    boolean brinca = false;
    private static final float X_POSITION = 0f;
    private static final float Y_POSITION = 0f;
    private static final float Z_POSITION = 0f;

    public static void main(String[] args) {
        Frame frame = new Frame("Coloonia de hormigas -'h' para saltar, 'w' para caminar");
        canvas.addGLEventListener(new PerMain());
        frame.add(canvas);
        frame.setSize(800, 600);
        final Animator animator = new Animator(canvas);
        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                new Thread(new Runnable() {

                    public void run() {
                        animator.stop();
                        System.exit(0);
                    }
                }).start();
            }
        });
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        animator.start();
    }

    public void init(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        System.err.println("INIT GL IS: " + gl.getClass().getName());
        gl.setSwapInterval(1);


        float light_ambient[] = {1.9f, 1.9f, 1.9f, 1.0f};
        float light_diffuse[] = {1.3f, 1.3f, 1.3f, 1.0f};
        float light_specular[] = {1.0f, 1.0f, 1.5f, 1.5f};
        float light_position[] = {1f, 5f, -2f, 1.0f};

        gl.glLightfv(GL.GL_LIGHT0, GL.GL_AMBIENT, light_ambient, 0);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_DIFFUSE, light_diffuse, 0);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_SPECULAR, light_specular, 0);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_POSITION, light_position, 0);
////
        gl.glEnable(GL.GL_LIGHTING);
        gl.glEnable(GL.GL_LIGHT0);
        gl.glEnable(GL.GL_DEPTH_TEST);

        gl.glClearColor(.9f, .9f, .9f, 1.0f);
        gl.glShadeModel(GL.GL_SMOOTH);

        drawable.addMouseListener(this);
        drawable.addMouseMotionListener(this);
        drawable.addKeyListener(this);
    }
    float avanza = 0;

    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();

        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        gl.glMatrixMode(GL.GL_MODELVIEW);

        gl.glLoadIdentity();
        glu.gluLookAt(0.1f, 0.0f, 4.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f);

        gl.glTranslatef(X_POSITION, Y_POSITION, Z_POSITION);
        gl.glRotatef(view_rotx, 1.0f, 0.0f, 0.0f);
        gl.glRotatef(view_roty, 0.0f, 1.0f, 0.0f);
        gl.glRotatef(90, 0.0f, 0.0f, 1.0f);
        gl.glScalef(.5f, .5f, .5f);

        Hormiga per = new Hormiga();

        try {
            per.draw_personaje(gl, avanzaB, m, brinca);
        } catch (InterruptedException ex) {
            Logger.getLogger(PerMain.class.getName()).log(Level.SEVERE, null, ex);
        }

        gl.glFlush();
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();
        if (height <= 0) {
            height = 1;
        }
        final float h = (float) width / (float) height;
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(45.0f, h, 1.0, 20.0);
        gl.glMatrixMode(GL.GL_MODELVIEW);
        gl.glOrtho(-10.0, 10.0, -10.0, 10.0, -10.0, 10.0);
        gl.glLoadIdentity();

    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {

    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 87 || e.getKeyCode() == 119) {
            if (avanzaB) {
                avanzaB = false;
            } else {
                avanzaB = true;
            }
            repAudio("prev");
        } else if (e.getKeyCode() == 72 || e.getKeyCode() == 104) {
            brinca = true;

            repAudio("prev");
        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == 87 || e.getKeyCode() == 119) {

            repAudio("prev");
        }
        if (e.getKeyCode() == 72 || e.getKeyCode() == 104) {
            brinca = false;
        }
    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {
        oldMousex = e.getX();
        oldMousey = e.getY();
    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void mouseDragged(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        Dimension size = e.getComponent().getSize();
        float thetaX = 360.0f * ((float) (x - oldMousex) / (float) size.width);
        float thetaY = 360.0f * ((float) (oldMousey - y) / (float) size.width);
        oldMousex = x;
        oldMousey = y;
        view_rotx += thetaX;
        view_roty += thetaY;
    }

    public void mouseMoved(MouseEvent e) {

    }

    public void repAudio(String sound) {
        try {
            if (audio != null) {
                AudioPlayer.player.stop(audio);
            }
            sounds = new FileInputStream(new File("sounds/" + sound + ".wav"));
            audio = new AudioStream(sounds);
            AudioPlayer.player.start(audio);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
    }

    public void detAudio() {
        if (audio != null) {
            AudioPlayer.player.stop(audio);
        }
    }

}
