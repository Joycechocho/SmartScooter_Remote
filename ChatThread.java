import java.lang.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.awt.event.*;

import javax.imageio.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.event.*;
import java.net.*;
import java.net.Socket;
import java.net.ServerSocket;
import java.net.InetSocketAddress;
import java.io.BufferedOutputStream;
import java.io.BufferedInputStream;

import java.io.*;
import java.util.*;
import java.net.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Dimension;

class ChatThread extends Thread{

    //public Socket con = null;
    public int command_counter = 0;
    public int duration = 1000;  // moving for 1 sec per command
    public void run(){

    //get the next jpeg img from client
    while(true){
        byte[] rebyte = new byte[18];
        String message = "";
        InputStream in;
        try{
            in = ImageServer.con.getInputStream();
            in.read(rebyte);
            message = new String(new String(rebyte));
        } catch(IOException e){
            System.out.println("ERR!");
        }
        //System.out.println("receive");
        
        String tmp = message.trim();
        if (tmp.equals("Alarm")) {
            final Image img;
            System.out.println(message);
            try{
                img = ImageIO.read(getClass().getResource("image/warning.png"));
                ImageServer.frame.jb_alarm.setIcon(new ImageIcon(img));
            }catch(IOException e){

            }
        }
        //System.out.println(message);
    }
  }
}
