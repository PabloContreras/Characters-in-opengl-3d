/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

import com.sun.opengl.util.texture.Texture;
import com.sun.opengl.util.texture.TextureIO;
import java.io.File;
import java.io.IOException;
import javax.media.opengl.GL;
import javax.media.opengl.glu.GLUquadric;

/**
 *
 * @author Elizabeth
 */
public class Fondo {

    public GLUquadric q = null;
    int texture;

    public void cargaTextura(GL gl, String text) {
        gl.glClearDepth(1.0f);
        gl.glEnable(GL.GL_DEPTH_TEST);
        gl.glDepthFunc(GL.GL_LEQUAL);
        gl.glHint(GL.GL_PERSPECTIVE_CORRECTION_HINT, GL.GL_NICEST);

        gl.glEnable(GL.GL_TEXTURE_2D);
        try {

            File im = new File("images/" + text);
            Texture t = TextureIO.newTexture(im, true);
            texture = t.getTextureObject();

        } catch (IOException e) {
        }
    }

    public void draw_tablero(GL gl) {
        cargaTextura(gl, "hormiguero.jpg");
        gl.glBindTexture(GL.GL_TEXTURE_2D, texture);
        gl.glBegin(GL.GL_QUADS);
        gl.glTexCoord2f(0f, 1f);
        gl.glVertex3f(-2.5f, -1.5f, 0f);
        gl.glTexCoord2f(1f, 1f);
        gl.glVertex3f(2.5f, -1.5f, 0f);
        gl.glTexCoord2f(1f, 0f);
        gl.glVertex3f(2.5f, 1.5f, 0f);
        gl.glTexCoord2f(0f, 0f);
        gl.glVertex3f(-2.5f, 1.5f, 0f);
        gl.glEnd();
    }
}
