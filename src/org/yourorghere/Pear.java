/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

import com.sun.opengl.util.Animator;
import com.sun.opengl.util.texture.Texture;
import com.sun.opengl.util.texture.TextureCoords;
import com.sun.opengl.util.texture.TextureIO;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Jair
 */
public class Pear extends JFrame implements GLEventListener,MouseListener,MouseMotionListener,KeyListener{
    
    
    //Variables
        private float view_rotx = 0.01f;
    private float view_roty = 0.01f;
    private int oldMouseX;
    private int oldMouseY;
    boolean[] keys=new boolean[256]; //to know which key is pressed
    
    //position of stan in the window
    private static final float X_POSITION=0f;
    private static final float Y_POSITION=-0.08f;
    private static final float Z_POSITION=0f;
    
    //Texture
    private File file;
    private Texture texture;
    private boolean newTexture=true;
    
    public static void main(String[] args) {
        Frame frame = new Frame("Pear-Press J && W");
        GLCanvas canvas = new GLCanvas();
        canvas.addGLEventListener(new Pear());
        frame.add(canvas);
        frame.setSize(900, 700);
        final Animator animator = new Animator(canvas);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Run this on another thread than the AWT event queue to
                // make sure the call to Animator.stop() completes before
                // exiting
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
        file=new File("paisaje.jpg");
        GL gl = drawable.getGL();
        System.err.println("INIT GL IS: " + gl.getClass().getName());
        gl.setSwapInterval(1);        
        // set up lighting
        float light_ambient[]={0.9f, 0.9f, 0.9f, 1.0f};
        float light_diffuse[]={0.3f, 0.3f, 0.3f, 1.0f};
        float light_specular[]={1.0f, 1.0f, 1.0f, 1.0f};
        float light_position[] = {1.0f,1.5f,1.0f,0.0f };        
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_AMBIENT, light_ambient, 0);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_DIFFUSE, light_diffuse, 0);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_SPECULAR, light_specular, 0);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_POSITION, light_position, 0);        
        gl. glEnable(GL.GL_LIGHTING);
        gl.glEnable(GL.GL_LIGHT0);
        gl.glEnable(GL.GL_DEPTH_TEST);            
        // Setup the drawing area and shading mode
        gl.glClearColor(0.9f, 0.9f, 0.9f, 0.9f); 
        gl.glShadeModel(GL.GL_SMOOTH);        
        drawable.addMouseListener(this);
        drawable.addMouseMotionListener(this);
        drawable.addKeyListener(this);   
    }

    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();
        // Clear the drawing area
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        gl.glMatrixMode(GL.GL_MODELVIEW);        
        // Reset the current matrix to the "identity"
        gl.glLoadIdentity();
        glu.gluLookAt(0.1f,0.0f,4.0f,// eye
                      0.0f,0.0f,0.0f,  // looking at
                      0.0f,0.0f,1.0f   // is up
                    );        
        // Move the whole scene
        gl.glTranslatef(X_POSITION, Y_POSITION, Z_POSITION);
        gl.glRotatef(view_rotx,1.0f,0.0f,0.0f);
        gl.glRotatef(view_roty,0.0f,1.0f,0.0f);
        gl.glRotatef(90,0.0f,0.0f,1.0f);        
        //we draw Stan in the window
        Draw_Pear pear = new Draw_Pear(); 
        pear.draw_pear(gl, keys['W'], keys['J']);         
        
         if (newTexture) {
      newTexture = false;

      if (texture != null) {
        texture.dispose();
        texture = null;
      }

      try {
        System.err.println("Loading texture...");
        texture = TextureIO.newTexture(file, true);
        System.err.println("Texture estimated memory size = " + texture.getEstimatedMemorySize());
      } catch (IOException e) {
        e.printStackTrace();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        e.printStackTrace(new PrintStream(bos));
        JOptionPane.showMessageDialog(null,
                                      bos.toString(),
                                      "Error loading texture",
                                      JOptionPane.ERROR_MESSAGE);
        return;
      }
    }

    if (texture != null) {
      texture.enable();
      texture.bind();
      gl.glTexEnvi(GL.GL_TEXTURE_ENV, GL.GL_TEXTURE_ENV_MODE, GL.GL_REPLACE);
      TextureCoords coords = texture.getImageTexCoords();

      gl.glBegin(GL.GL_QUADS);
      gl.glTexCoord2f(coords.left(), coords.bottom());
      gl.glVertex3f(3.2f, -2.5f, -1f);
      gl.glTexCoord2f(coords.right(), coords.bottom());
      gl.glVertex3f(-3.2f, -2.5f, -1f);
      gl.glTexCoord2f(coords.right(), coords.top());
      gl.glVertex3f(-3.2f, 2.5f, -1f);
      gl.glTexCoord2f(coords.left(), coords.top());
      gl.glVertex3f(3.3f, 2.5f, -1f);
      gl.glEnd();
      texture.disable();
    }
        
        
        // Flush all drawing operations to the graphics card
        gl.glFlush();   
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
         GL gl = drawable.getGL();
        GLU glu = new GLU();
        if (height <= 0) { // avoid a divide by zero error!
            height = 1;
        }
        final float h = (float) width / (float) height;
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
       // glu.gluOrtho2D(0, 1, 0, 1);
        glu.gluPerspective(45.0f, h, 1.0, 20.0);
        gl.glMatrixMode(GL.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
        
    }

    public void mouseClicked(MouseEvent e) {
        
    }

    public void mousePressed(MouseEvent e) {
         oldMouseX = e.getX();
        oldMouseY = e.getY();  
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
        float thetaX = 360.0f * ( (float)(x-oldMouseX)/(float)size.width);
        float thetaY = 360.0f * ( (float)(oldMouseY-y)/(float)size.height);
        oldMouseX = x;
        oldMouseY = y;
        view_rotx += thetaX;
        view_roty += thetaY;
    }

    public void mouseMoved(MouseEvent e) {
        
    }

    public void keyTyped(KeyEvent e) {
        
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()<250 && keys[e.getKeyCode()]==false){
            keys['W']=false;
            keys['J']=false;
            keys[e.getKeyCode()]=true;    
        }
        else
            keys[e.getKeyCode()]=false;    
        System.out.println("key press " + e.getKeyChar());
    }

    public void keyReleased(KeyEvent e) {
        
    }
    
}
