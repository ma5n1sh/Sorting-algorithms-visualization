package implementations;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class bubbleClass {
    int arr[]=new int[200];
    double time=0;
    int i=0,j=0;
    Sound s=new Sound("Sounds/sound.wav");
    public int comp=0;

    public bubbleClass() throws SlickException {
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
            if((k==j||k==j+1)&&i<200){g.setColor(Color.magenta);}
            else g.setColor(Color.white);
            g.fillRect(180+4*k+k-1,500-arr[k]+110,4,arr[k]);

            bubbleSort(arr);

        }
    }

    void bubbleSort(int[] arr){
        int n = arr.length;
        if(time>0.0005) {
            if (i < 200) {comp++;
                if (j < 200 - i - 1) {comp++;
                    if (arr[j] > arr[j + 1]) {comp++;
                        s.play((float) 0.6, (float) 0.005*((float)(j+(i))/200));
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                    j++;
                }
                else{i++;j=0;comp++;}
            }
            time=0;
        }
    }

}
