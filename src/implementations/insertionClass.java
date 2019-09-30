package implementations;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class insertionClass {
    int arr[]=new int[200];
    double time=0;
    int i=1,j=0,key = arr[i];
    Sound s=new Sound("Sounds/sound.wav");
    public int comp=0;

    public insertionClass() throws SlickException {
        rand();
    }

    public void rand(){
        for(int i=0;i<200;i++){
            arr[i]= (int)(500* Math.random());
        }
    }

    public void timeAdder(double num){
        time=time+((double)num)/1000;
    }

    public void renderer(Graphics g){
        for(int k=0;k<200;k++){
            if((k==i-1)&&i<199){g.setColor(Color.magenta);}
            else if((k==j)&&i<199){g.setColor(Color.orange);}
            else g.setColor(Color.white);
            g.fillRect(180+4*k+k-1,500-arr[k]+110,4,arr[k]);

            sort();

        }
    }

    void sort(){
        if(time>0.0005) {
            if (i < 200) {comp++;
                if (j >= 0 && arr[j] > key) {comp+=2;
                    arr[j + 1] = arr[j];
                    j = j - 1;

                } else {comp+=2;
                    s.play(1, (float) 0.01);
                    arr[j + 1] = key;
                    key = arr[i];
                    j = i -1;
                    i++;
                }
            }
            if(i==200){
                key=arr[199];
                j=198;
                while (j >= 0 && arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j = j - 1;
                }
            }
            time=0;
        }
    }

}
