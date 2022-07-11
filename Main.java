
import java.awt.*;
import java.util.*;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
public class Main {



    public static void main(String[] args){
       System.out.println(circle());
    }



    public static ArrayList circle(){
        //setting up image start
        int width = 100;
        int height = 100;
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        File f = null;

        //setting up image end

        //taking input for radius & center
        int radius;
        int centerx;
        int centery;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter radius");
        radius = sc.nextInt();
        System.out.println("Enter Center x");
        centerx = sc.nextInt();
        System.out.println("Enter Center y");
        centery = sc.nextInt();


        //decision parameter(pk)
        int pk = 3-(2*radius);
        String plot;
        ArrayList<String> plottings = new ArrayList<String>();

        //calculation for 1st octate plottings
        int x = 0;
        int y = radius;
        while (x<=y){

            if(pk<0){
                pk= pk+(4*x) + 6;
            }else {
                pk = pk+(4*(x-y))+10;
                y = y-1;

            }
            plot = String.format("x:%s,y:%s",x,y);
            plottings.add(plot);
            x= x+1;
            img.setRGB(x+centerx,y+centery,new Color(255,255,255).getRGB());//octate 1
            img.setRGB(x+centerx,-y+centery,new Color(255,255,255).getRGB());//octate 2
            img.setRGB(y+centerx,-x+centery,new Color(255,255,255).getRGB());//octate 3
            img.setRGB(-y+centerx,-x+centery,new Color(255,255,255).getRGB());//octate 4
            img.setRGB(-x+centerx,-y+centery,new Color(255,255,255).getRGB());//octate 5
            img.setRGB(-x+centerx,y+centery,new Color(255,255,255).getRGB());//octate 6
            img.setRGB(-y+centerx,x+centery,new Color(255,255,255).getRGB());//octate 7
            img.setRGB(y+centerx,x+centery,new Color(255,255,255).getRGB());//octate 8

        }

        //save image
        try{
            f = new File("C:\\Users\\admin\\Desktop\\CodingProjects\\Bersenham\\java\\output\\circle.png");
            System.out.println("saved image");
            ImageIO.write(img, "png", f);
        }catch(IOException e){
            System.out.println(e);
        }
        //end saving image
        return plottings;


    }


}
