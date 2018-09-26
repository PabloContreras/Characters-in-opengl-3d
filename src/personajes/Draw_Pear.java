/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.media.opengl.GL;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author Elizabeth
 */
public class Draw_Pear {
    
    //Variables
    private static final int SLICES = 40;
    private static final int STACKS = 40;
    private GLUquadric q = null;
    private static final float WIDTH_TALLO = 0.1f;
    private static final float WIDTH_PUPILS = 0.03f;
    private static final float WIDTH_EYES = 0.1f;
    private static final float WIDTH_OPEN_MOUTH = 0.1f;    
    private static final float HEIGHT_LEGS = 0.2f;
    private static final float WIDTH_LEGS = 0.1f;
    private static final float WIDTH_ARMS = 0.09f;
    
    //Audio
    AudioStream audio=null;
    AudioStream audio1=null;
    InputStream sounds=null;
    int x=0;
    public Draw_Pear(){
        
    }
    
    public void draw_pear(GL gl,boolean walk,boolean jump){
    GLU glu = new GLU();
        q = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(q, GLU.GLU_FILL);
        glu.gluQuadricOrientation(q, GLU.GLU_OUTSIDE);
        glu.gluQuadricNormals(q, GLU.GLU_SMOOTH);  
        if(walk){
        
        gl.glTranslatef(0.0f, 0.2f, 0f);
        bodyOne(gl, glu,-0.6f,0.6f,0.2f);
        bodyOne(gl, glu,0.1f,0.3f,0.2f);
        draw_tallo(glu, gl);
        draw_eyes(glu, gl, jump);
        draw_manos(gl, glu);
            soundJump("jump.wav", x);
        }
        else{
        bodyOne(gl, glu,-0.6f,0.6f,0.2f);
        bodyOne(gl, glu,0.1f,0.3f,0.2f);
        draw_tallo(glu, gl);
        draw_eyes(glu, gl, jump);
            draw_manos(gl, glu);
        }
                
    }
    
    public void bodyOne(GL gl, GLU glu,float tras,float tam,float heigth) {

        //we create scarf
        set_green_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(0.0f, tras, 0.0f);
        gl.glRotatef(93f, 1f, 0f, 0f);
        draw_torus(gl, heigth, tam, SLICES, STACKS);
        gl.glPopMatrix();

    }
    
    public void draw_torus(GL gl, float R, float r, int N, int n) {

        int maxn = 1000;
        n = Math.min(n, maxn - 1);
        N = Math.min(N, maxn - 1);
        float rr = 1.5f * r;
        double dv = 2 * Math.PI / n;
        double dw = 2 * Math.PI / N;
        double v = 0.0f;
        double w = 0.0f;
        while (w < 2 * Math.PI + dw) {
            v = 0.0f;
            gl.glBegin(GL.GL_TRIANGLE_STRIP);
            while (v < 2 * Math.PI + dv) {
                gl.glNormal3d(
                        (R + rr * Math.cos(v)) * Math.cos(w)
                        - (R + r * Math.cos(v)) * Math.cos(w),
                        (R + rr * Math.cos(v)) * Math.sin(w)
                        - (R + r * Math.cos(v)) * Math.sin(w),
                        (rr * Math.sin(v) - r * Math.sin(v)));
                gl.glVertex3d((R + r * Math.cos(v)) * Math.cos(w),
                        (R + r * Math.cos(v)) * Math.sin(w),
                        r * Math.sin(v));
                gl.glNormal3d(
                        (R + rr * Math.cos(v + dv)) * Math.cos(w + dw)
                        - (R + r * Math.cos(v + dv)) * Math.cos(w + dw),
                        (R + rr * Math.cos(v + dv)) * Math.sin(w + dw)
                        - (R + r * Math.cos(v + dv)) * Math.sin(w + dw),
                        rr * Math.sin(v + dv) - r * Math.sin(v + dv));
                gl.glVertex3d((R + r * Math.cos(v + dv)) * Math.cos(w + dw),
                        (R + r * Math.cos(v + dv)) * Math.sin(w + dw),
                        r * Math.sin(v + dv));
                v += dv;
            }
            gl.glEnd();
            w += dw;
        }
    }
    
     public void set_green_material(GL gl) {
        float[] mat_ambient = {0.4f, 1f, 0.0f, 0.0f};
        float[] mat_diffuse = {0.4f, 0.4f, 0.4f, 1.0f};
        float[] mat_specular = {0.7f, 0.6f, 0.6f, 1.0f};
        float shine = 15.0f;
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, mat_specular, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);
    }
     
     public void draw_tallo(GLU glu,GL gl){
        set_tallo_material(gl);
        gl.glPushMatrix();
        
        
        gl.glTranslatef(0.0f, 0.34f, 0.07f);
        
        glu.gluSphere(q, WIDTH_TALLO, SLICES, STACKS);
        
	//
        gl.glTranslatef(0.06f, 0.06f, 0.0f);
        glu.gluSphere(q, WIDTH_TALLO, SLICES, STACKS);
        
        //
        gl.glTranslatef(0.07f, 0.07f, 0.0f);
        glu.gluSphere(q, WIDTH_TALLO, SLICES, STACKS);
        
        //
        gl.glTranslatef(0.08f, 0.08f, 0.0f);
        glu.gluSphere(q, WIDTH_TALLO, SLICES, STACKS);
        
        //
        gl.glTranslatef(0.09f, 0.09f, 0.0f);
        glu.gluSphere(q, WIDTH_TALLO, SLICES, STACKS);
        
        //
         gl.glTranslatef(0.1f, 0.1f, 0.0f);
        glu.gluSphere(q, WIDTH_TALLO, SLICES, STACKS);
        gl.glPopMatrix();
    }
        public void set_tallo_material(GL gl) {
        float mat_ambient[] = {0.3f, 0.2f, 0.1f, 0.9f};
        float mat_diffuse[] = {1.0f, 1.0f, 1.0f, 1.0f};
        float mat_specular[] = {0.8f, 0.8f, 0.8f, 1.0f};
        float shine = 51.2f;
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, mat_specular, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);
    }
        
    public void draw_eyes(GLU glu,GL gl,boolean jump){
            set_eyes_material(gl);

        gl.glPushMatrix();
        
        gl.glTranslatef(-0.17f, 0.14f, 0.38f);
        glu.gluSphere(q, WIDTH_EYES, SLICES, STACKS);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(0.17f, 0.14f, 0.38f);
        glu.gluSphere(q, WIDTH_EYES, SLICES, STACKS);
        gl.glPopMatrix();
        
        if (jump == true) {
        set_grey_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(-0.2f, 0.2f, 0.45f);
        glu.gluSphere(q, WIDTH_PUPILS, SLICES, STACKS);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(0.2f, 0.2f, 0.45f);
        glu.gluSphere(q, WIDTH_PUPILS, SLICES, STACKS);
        gl.glPopMatrix();
        }
        else{
        set_grey_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(-0.2f, 0.1f, 0.45f);
        glu.gluSphere(q, WIDTH_PUPILS, SLICES, STACKS);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(0.2f, 0.1f, 0.45f);
        glu.gluSphere(q, WIDTH_PUPILS, SLICES, STACKS);
        gl.glPopMatrix();
        }
//Boca
gl.glPushMatrix();
         gl.glTranslatef(0.1f, 0.0f, 0.15f);
            gl.glRotatef(45f, 1f, 0f, 0f);
            gl.glScalef(-0.2f, 0.03f, 0.9f);
            box(gl);   
            gl.glPopMatrix();
        }
        
        public void set_eyes_material(GL gl) {
        float mat_ambient[] = {1.0f, 1.0f, 1.0f, 1.0f};
        float mat_diffuse[] = {1.0f, 1.0f, 1.0f, 1.0f};
        float mat_specular[] = {0.8f, 0.8f, 0.8f, 1.0f};
        float shine = 51.2f;
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, mat_specular, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);
    }
            public void set_grey_material(GL gl) {

        float mat_ambient[] = {0.07f, 0.07f, 0.07f, 0.0f};
        float mat_diffuse[] = {1.0f, 1.0f, 1.0f, 1.0f};
        float mat_specular[] = {0.8f, 0.8f, 0.8f, 1.0f};
        float shine = 125.2f;

        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, mat_specular, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);
        
        

    }
             public void set_new_material(GL gl) {

        float mat_ambient[] = {0.7f, 0.07f, 0.07f, 0.0f};
        float mat_diffuse[] = {1.0f, 1.0f, 1.0f, 1.0f};
        float mat_specular[] = {0.8f, 0.8f, 0.8f, 1.0f};
        float shine = 125.2f;

        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, mat_specular, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);
             }
     public void box(GL gl) {
        gl.glBegin(GL.GL_POLYGON);/* f1: front */
        gl.glNormal3f(-1.0f, 0.0f, 0.0f);
        gl.glVertex3f(0.0f, 0.0f, 0.0f);
        gl.glVertex3f(0.0f, 0.0f, 1.0f);
        gl.glVertex3f(1.0f, 0.0f, 1.0f);
        gl.glVertex3f(1.0f, 0.0f, 0.0f);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);/* f2: bottom */
        gl.glNormal3f(0.0f, 0.0f, -1.0f);
        gl.glVertex3f(0.0f, 0.0f, 0.0f);
        gl.glVertex3f(1.0f, 0.0f, 0.0f);
        gl.glVertex3f(1.0f, 1.0f, 0.0f);
        gl.glVertex3f(0.0f, 1.0f, 0.0f);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);/* f3:back */
        gl.glNormal3f(1.0f, 0.0f, 0.0f);
        gl.glVertex3f(1.0f, 1.0f, 0.0f);
        gl.glVertex3f(1.0f, 1.0f, 1.0f);
        gl.glVertex3f(0.0f, 1.0f, 1.0f);
        gl.glVertex3f(0.0f, 1.0f, 0.0f);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);/* f4: top */
        gl.glNormal3f(0.0f, 0.0f, 1.0f);
        gl.glVertex3f(1.0f, 1.0f, 1.0f);
        gl.glVertex3f(1.0f, 0.0f, 1.0f);
        gl.glVertex3f(0.0f, 0.0f, 1.0f);
        gl.glVertex3f(0.0f, 1.0f, 1.0f);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);/* f5: left */
        gl.glNormal3f(0.0f, 1.0f, 0.0f);
        gl.glVertex3f(0.0f, 0.0f, 0.0f);
        gl.glVertex3f(0.0f, 1.0f, 0.0f);
        gl.glVertex3f(0.0f, 1.0f, 1.0f);
        gl.glVertex3f(0.0f, 0.0f, 1.0f);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);/* f6: right */
        gl.glNormal3f(0.0f, -1.0f, 0.0f);
        gl.glVertex3f(1.0f, 0.0f, 0.0f);
        gl.glVertex3f(1.0f, 0.0f, 1.0f);
        gl.glVertex3f(1.0f, 1.0f, 1.0f);
        gl.glVertex3f(1.0f, 1.0f, 0.0f);
        gl.glEnd();
    }
             
public void draw_manos(GL gl,GLU glu){
 set_new_material(gl);
 gl.glPushMatrix();
 gl.glTranslatef(0.911f, -0.6f, 0f);
  gl.glRotatef(360, -1f, 2f, 0f);
 glu.gluCylinder(q, WIDTH_LEGS, WIDTH_LEGS, HEIGHT_LEGS, SLICES, STACKS);
 glu.gluDisk(q, 0f, WIDTH_LEGS, SLICES, STACKS);
 gl.glPopMatrix();
 gl.glPushMatrix();
 gl.glTranslatef(-0.9f, -0.6f, 0f);
  gl.glRotatef(-10, -1f, 2f, 0f);
 glu.gluCylinder(q, WIDTH_LEGS, WIDTH_LEGS, HEIGHT_LEGS, SLICES, STACKS);
 glu.gluDisk(q, 0f, WIDTH_LEGS, SLICES, STACKS);
 gl.glPopMatrix();
}

public void soundJump(String sound,int rep){
        try{
            if(rep==0){
         sounds = new FileInputStream(new File("sounds/" + sound));
                audio = new AudioStream(sounds);
                AudioPlayer.player.start(audio);
                AudioPlayer.player.stop();
            }
        }catch(Exception e){
            e.getMessage();
        }
    }

public void detAudio(int i) {
        if (i == 0) {
            AudioPlayer.player.stop(audio);
        } else {
            AudioPlayer.player.stop(audio1);
        }
    }
}
