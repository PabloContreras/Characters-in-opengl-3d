package org.yourorghere;

import com.sun.opengl.util.texture.Texture;
import com.sun.opengl.util.texture.TextureIO;
import java.io.File;
import java.io.IOException;
import javax.media.opengl.GL;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

/**
 * @author Elizabeth
 * @version 2.0.0
 */
public class Hormiga {

    private GLUquadric q = null;
    int n = 1;
    float movimiento;
    int texture;

    public void set_blue_material(GL gl) {
        float mat_ambient[] = {
            0.2f, 0.2f, 0.6f, 1.0f
        };
        float mat_diffuse[] = {
            1.0f, 1.0f, 1.0f, 1.0f
        };
        float mat_specular[] = {
            0.0f, 0.0f, 0.0f, 0.0f
        };
        float shine = 125.2f;
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, mat_specular, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);
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

    public void set_black_material(GL gl) {
        float mat_ambient[] = {0.05f, 0.05f, 0.05f, 0f};
        float mat_diffuse[] = {0.05f, 0.05f, 0.05f, 0f};
        float mat_specular[] = {0.05f, 0.05f, 0.05f, 0f};
        float shine = 1f;

        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, mat_specular, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);

    }

    public void set_black_material2(GL gl) {
        float mat_ambient[] = {0.1f, 0.1f, 0.1f, 0f};
        float mat_diffuse[] = {0.1f, 0.1f, 0.1f, 0f};
        float mat_specular[] = {0.1f, 0.1f, 0.1f, 0f};
        float shine = 1f;

        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, mat_specular, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);

    }

    public void set_shirt_material(GL gl) {
        float mat_ambient[] = {0.5f, 0.45f, 0.3f, 1.0f};
        float mat_diffuse[] = {0.8f, 0.8f, 0.8f, 1.0f};
        float mat_specular[] = {0.4f, 0.3f, 0.2f, 1.0f};
        float shine = 128f;

        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, mat_specular, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);
    }

    public void set_red_material(GL gl) {
        float[] mat_ambient = {1f, 0f, 0f, 0.2f};
        float[] mat_diffuse = {0.1f, 0f, 0f, 1.0f};
        float[] mat_specular = {0.7f, 0.6f, 0.6f, 1.0f};
        float shine = 1.0f;
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, mat_specular, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);
    }

    public void set_traje_material(GL gl) {
        float mat_ambient[] = {0.7f, 0.7f, 0.7f, 0.0f};
        float mat_diffuse[] = {1.0f, 1.0f, 1.0f, 1.0f};
        float mat_specular[] = {0.5f, 0.5f, 0.5f, 1.0f};
        float shine = 64f;//125.2

        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, mat_specular, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);

    }

    public void draw_personaje(GL gl, boolean avanzaB, int m, boolean brinca) throws InterruptedException {
        GLU glu = new GLU();
        q = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(q, GLU.GLU_FILL);
        glu.gluQuadricOrientation(q, GLU.GLU_OUTSIDE);
        glu.gluQuadricNormals(q, GLU.GLU_SMOOTH);
        gl.glPushMatrix();
        gl.glTranslatef(0f, 0.8f, 1f);
        gl.glScalef(.5f, .5f, .5f);
        gl.glRotatef(180, 0f, 1f, 0f);
        if (brinca) {
            gl.glTranslatef(0, .3f, 0);
        } else {
            gl.glTranslatef(0, -.3f, 0);
        }
        personaje(avanzaB, brinca, gl, glu, m);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(0f, 0.1f, -2.2f);
        gl.glScalef(1.2f, 1.2f, 1.2f);
        dibujaFondo(gl);
        gl.glPopMatrix();
    }
    static boolean b = true;
    static float avanza = 0;

    public void personaje(boolean avanzaB, boolean brinca, GL gl, GLU glu, int m) throws InterruptedException {
        if (avanzaB) {
            gl.glTranslatef(3.5f, -1, 0);
            gl.glRotatef(95, 0, 1, 0);
            if (avanzaB) {
                avanza = avanza + (float) 0.1;
                System.out.println("ava" + avanza);
                gl.glTranslatef(0, avanza, -avanza);
            }
            if (avanza > 3) {
                avanzaB = false;
                avanza = 0;
            }
            if (b) {
                dibujaCabeza(gl, glu);
                dibujaCuerpo(gl, glu);
                dibujaManos(gl, glu, avanzaB, m, brinca);
                dibujaManosD(gl, glu, false, m, brinca);
                dibujaPiernas(gl, glu, avanzaB, 45, brinca);
                dibujaPiernasD(gl, glu, avanzaB, 0, brinca);
                Thread.sleep(200);
                b = false;
            } else {
                dibujaCabeza(gl, glu);
                dibujaCuerpo(gl, glu);
                dibujaManos(gl, glu, false, m, brinca);
                dibujaManosD(gl, glu, avanzaB, m, brinca);
                dibujaPiernasD(gl, glu, avanzaB, 30, brinca);
                dibujaPiernas(gl, glu, avanzaB, -25, brinca);
                Thread.sleep(200);
                b = true;

            }

        } else {
            dibujaCabeza(gl, glu);
            dibujaCuerpo(gl, glu);
            dibujaManos(gl, glu, avanzaB, m, brinca);
            dibujaManosD(gl, glu, avanzaB, m, brinca);
            dibujaPiernas(gl, glu, avanzaB, 0, brinca);
            dibujaPiernas(gl, glu, avanzaB, 1, brinca);
            dibujaPiernasD(gl, glu, avanzaB, m, brinca);
        }
    }

    public void dibujaCuerpo(GL gl, GLU glu) {
//Primer toro
        set_black_material2(gl);
        gl.glPushMatrix();
        gl.glTranslatef(0.0f, -.55f, 0.75f);
        gl.glRotatef(90f, 1f, 0f, 0f);
        dibujaToro(gl, 0.13f, 0.1f, 10, 10);
        gl.glPopMatrix();

//Primera Parte
        set_black_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(0.0f, -0.5f, 0.75f);
        gl.glRotatef(90, 1f, 0f, 0f);
        glu.gluCylinder(q, .05f, .35f, .4f, 20, 3);
        gl.glTranslatef(0.0f, 0.0f, 0.46f);
        glu.gluSphere(q, .35f, 10, 10);
        gl.glTranslatef(0f, 0f, .05f);
        glu.gluCylinder(q, .35f, .05f, .4f, 20, 3);
        gl.glPopMatrix();

//Segundo toro
        set_black_material2(gl);
        gl.glPushMatrix();
        gl.glTranslatef(0.0f, -1.35f, 0.75f);
        gl.glRotatef(90f, 1f, 0f, 0f);
        dibujaToro(gl, 0.13f, 0.1f, 10, 10);
        gl.glPopMatrix();

//Segunda Parte        
        set_black_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(0.0f, -1.35f, 0.75f);
        gl.glPushMatrix();
        gl.glRotatef(45, 1f, 0f, 0f);
        glu.gluCylinder(q, .05f, .43f, .5f, 20, 3);
        gl.glPopMatrix();
        gl.glTranslatef(0, -.473f, .475f);
        glu.gluSphere(q, .45f, 10, 10);
        gl.glTranslatef(0, 0f, .15f);
        glu.gluCylinder(q, .43f, .01f, .5f, 20, 3);
        gl.glPopMatrix();
    }

    public void dibujaCabeza(GL gl, GLU glu) {
//cabeza       
        gl.glPushMatrix();
        set_black_material(gl);
        gl.glTranslatef(0.0f, 0.1f, 0.75f);
        glu.gluSphere(q, 0.7f, 15, 5);
        gl.glPopMatrix();
//ojos
        set_eyes_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(.4f, 0.3f, .4f);
        glu.gluSphere(q, .25, 50, 50);
        gl.glTranslatef(-.8f, 0f, 0.0f);
        glu.gluSphere(q, .25, 50, 50);
        gl.glPopMatrix();
//pupilas
        set_black_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(.425f, 0.3f, 0.265f);
        glu.gluSphere(q, .15, 10, 10);
        gl.glTranslatef(-.85f, 0f, 0f);
        glu.gluSphere(q, .15, 10, 10);
        gl.glPopMatrix();
//antenas1
        set_black_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(0.4f, .5f, .85f);
        gl.glPushMatrix();
        gl.glRotatef(-90, 1f, 0f, 0f);
        gl.glRotatef(25, 0f, 1f, 0f);
        glu.gluCylinder(q, .05f, .03f, 1, 4, 4);
        gl.glPopMatrix();
        gl.glTranslatef(-0.8f, 0f, 0f);
        gl.glPushMatrix();
        gl.glRotatef(-90, 1f, 0f, 0f);
        gl.glRotatef(-25, 0f, 1f, 0f);
        glu.gluCylinder(q, .05f, .03f, 1, 4, 4);
        gl.glPopMatrix();
        gl.glPopMatrix();
//antenas2        
        set_black_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(0.8f, 1.4f, .85f);
        gl.glPushMatrix();
        gl.glRotatef(90, 0, 1, 0);
        gl.glRotatef(15, 0f, 1f, 0f);
        glu.gluCylinder(q, .03f, .05f, .5, 4, 4);
        gl.glPopMatrix();
        gl.glTranslatef(-1.6f, 0f, 0f);
        gl.glPushMatrix();
        gl.glRotatef(-90, 0, 1, 0);
        gl.glRotatef(-15, 0f, 1f, 0f);
        glu.gluCylinder(q, .03f, .05f, .5, 4, 4);
        gl.glPopMatrix();
        gl.glPopMatrix();
    }

    public void dibujaManos(GL gl, GLU glu, boolean avanzaB, int n, boolean brinca) {
//mano derecha
        set_black_material(gl);
        gl.glPushMatrix();//------5
        gl.glTranslatef(-0.25f, -0.8f, 0.75f);
        if (brinca) {
            gl.glRotatef(-60, 0f, 0f, 1f);
        }
        if (avanzaB) {
            gl.glRotated(45, 1f, 0, 0);
        }
        gl.glPushMatrix();//-----4
        gl.glPushMatrix();//---1
        gl.glRotatef(90, 1f, 0f, 0f);
        gl.glRotatef(-60, 0f, 1f, 0f);
        glu.gluCylinder(q, .04f, .05f, .55f, 4, 3);
        gl.glPopMatrix();//---1
        gl.glTranslatef(-.45f, -.25f, 0f);
        gl.glPushMatrix();//---2
        gl.glRotatef(90, 1f, 0f, 0f);
        gl.glRotatef(-10, 0f, 1f, 0f);
        glu.gluCylinder(q, .05f, .04f, .55f, 4, 3);
        gl.glPopMatrix();//---2
        gl.glPopMatrix();//-----4
        gl.glPopMatrix();//------5
    }

    public void dibujaManosD(GL gl, GLU glu, boolean avanzaB, int n, boolean brinca) {
//mano iz
        gl.glPushMatrix();//------5
        gl.glTranslatef(0.25f, -0.8f, 0.75f);
        if (brinca) {
            gl.glRotatef(60, 0f, 0f, 1f);
        }
        if (avanzaB) {
            gl.glRotated(45, 1f, 0, 0);
        }
        gl.glPushMatrix();//-----4
        gl.glPushMatrix();//---1
        gl.glRotatef(90, 1f, 0f, 0f);
        gl.glRotatef(60, 0f, 1f, 0f);
        glu.gluCylinder(q, .04f, .05f, .55f, 4, 3);
        gl.glPopMatrix();//---1
        gl.glTranslatef(.45f, -.25f, 0f);
        gl.glPushMatrix();//---2
        gl.glRotatef(90, 1f, 0f, 0f);
        gl.glRotatef(10, 0f, 1f, 0f);
        glu.gluCylinder(q, .05f, .04f, .55f, 4, 3);
        gl.glPopMatrix();//---2
        gl.glPopMatrix();//-----4
        gl.glPopMatrix();//------5
    }

    public void dibujaPiernas(GL gl, GLU glu, boolean avanzaB, int n, boolean brinca) {
//pierna 
        gl.glPushMatrix();//------5
        gl.glTranslatef(0.05f, -1.35f, 0.7f);
        if (brinca) {
            gl.glRotatef(45, 0f, 0f, 1f);
        }
        if (avanzaB) {
            gl.glRotated(n, 1f, 0, 0);
        }
        gl.glPushMatrix();//-----4
        gl.glPushMatrix();//---1
        gl.glRotatef(100, 1f, 0f, 0f);
        gl.glRotatef(15, 0f, 1f, 0f);
        glu.gluCylinder(q, .04f, .05f, .65f, 4, 3);
        gl.glPopMatrix();//---1
        gl.glTranslatef(0.16f, -.6f, -.1f);
        gl.glPushMatrix();//---2
        gl.glRotatef(90, 1f, 0f, 0f);
        glu.gluCylinder(q, .05f, .05f, .85f, 4, 3);
        gl.glPopMatrix();//---2
        gl.glTranslatef(0f, -.85f, .05f);
        gl.glPushMatrix();//---3
        gl.glRotatef(170, 0f, 1f, 0f);
        glu.gluCylinder(q, .05f, .05f, .35f, 5, 3);
        gl.glPopMatrix();//---3
        gl.glPopMatrix();//-----4
        gl.glPopMatrix();//------5

    }

    public void dibujaPiernasD(GL gl, GLU glu, boolean avanzaB, int n, boolean brinca) {
//pierna 
        gl.glPushMatrix();//------5
        gl.glTranslatef(-0.05f, -1.35f, 0.7f);
        if (brinca) {
            gl.glRotatef(-45, 0f, 0f, 1f);
        }
        if (avanzaB) {
            gl.glRotated(n, 1f, 0, 0);
        }
        gl.glPushMatrix();//-----4
        gl.glPushMatrix();//---1
        gl.glRotatef(100, 1f, 0f, 0f);
        gl.glRotatef(-15, 0f, 1f, 0f);
        glu.gluCylinder(q, .04f, .05f, .65f, 4, 3);
        gl.glPopMatrix();//---1
        gl.glTranslatef(-0.16f, -.6f, -.1f);
        gl.glPushMatrix();//---2
        gl.glRotatef(90, 1f, 0f, 0f);
        glu.gluCylinder(q, .04f, .05f, .85f, 4, 3);
        gl.glPopMatrix();//---2
        gl.glTranslatef(0f, -.85f, 0.05f);
        gl.glPushMatrix();//---3
        gl.glRotatef(-170, 0f, 1f, 0f);
        glu.gluCylinder(q, .05f, .05f, .35f, 5, 3);
        gl.glPopMatrix();//---3
        gl.glPopMatrix();//-----4
        gl.glPopMatrix();//------5
    }

    public void dibujaToro(GL gl, float R, float r, int N, int n) {
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

    public void cargaTextura(GL gl, String text) {
        gl.glClearDepth(1.0f);
        gl.glEnable(GL.GL_DEPTH_TEST);
        gl.glDepthFunc(GL.GL_LEQUAL);
        gl.glHint(GL.GL_PERSPECTIVE_CORRECTION_HINT, GL.GL_NICEST);

        gl.glEnable(GL.GL_TEXTURE_2D);
        try {

            File im = new File(text);
            Texture t = TextureIO.newTexture(im, true);
            texture = t.getTextureObject();

        } catch (IOException e) {
        }
    }

    public void dibujaFondo(GL gl) {
        cargaTextura(gl, "hormiguero.jpg");
        gl.glBindTexture(GL.GL_TEXTURE_2D, texture);
        gl.glBegin(GL.GL_QUADS);
        gl.glTexCoord2f(0f, 1f);
        gl.glVertex3f(-5f, -3.5f, 0f);
        gl.glTexCoord2f(1f, 1f);
        gl.glVertex3f(5f, -3.5f, 0f);
        gl.glTexCoord2f(1f, 0f);
        gl.glVertex3f(5f, 3.5f, 0f);
        gl.glTexCoord2f(0f, 0f);
        gl.glVertex3f(-5f, 3.5f, 0f);
        gl.glEnd();
    }

}
