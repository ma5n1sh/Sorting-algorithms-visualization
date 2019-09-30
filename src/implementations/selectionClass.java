package implementations;

import org.newdawn.slick.*;

public class selectionClass {
    int arr[]=new int[200];
    double time=0;
    int i=0,j=0,min_idx;
    public int comp=0;
    Sound s=new Sound("Sounds/sound.wav");
    public selectionClass() throws SlickException {
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
            if((k==j)&&i<199){g.setColor(Color.magenta);}
            else if((k==i||k==min_idx)&&i<199){g.setColor(Color.orange);}
            else g.setColor(Color.white);
            g.fillRect(180+4*k+k-1,500-arr[k]+110,4,arr[k]);
            g.setColor(Color.white);

            sort();

        }
    }

    void sort()
    {
       if(time>0.00001) {


           if (i < 200 - 1) {comp++;



               if (j < 200) {comp++;
                   if (arr[j] < arr[min_idx]) {
                       min_idx = j;
                       s.play((float) 0.6, (float) 0.01*((float)((200-0.5*i))/200));
                   }
                   j++;
               }
               else {comp++;
                   int temp = arr[min_idx];
                   arr[min_idx] = arr[i];
                   arr[i] = temp;
                   i++;
                   j = i + 1;
                   min_idx=i;

               }

               time=0;
           }
       }

    }

}
