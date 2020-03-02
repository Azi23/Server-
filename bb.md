public class HelloWorld{

     public static void main(String []args){
        
        
     }
     
}

public class  Bands{
    private float[] o,h,l,c;
    private int yy;
    private int w=3;
    private float[] oH,hH,lH,cH;
    private float[] oL,hL,lL,cL;
    private float[] eH,eL;
    private float[] sma;
    
    
    Bands(float[] o, float[] h,float[] l,float[] c,int yy){
        this.o=o;
        this.h=h;
        this.l=l;
        this.c=c;
        this.yy=yy;
        this.s=c.length;
        this.sma=new float[s];
        start();
    }
    
    public float[] setDistance(float[] e){
        
        
        
        int k=yy;
        for(int i=yy-w;i<s;i++){
            k+=1;
            float templ=0,d=0;
            for(int h=yy-w;h<k;h++){    
                templ+=e[h];
                d+=1;
            }
            
            sma[i]=templ/d;
        }
        
        float[] bands = new float[this.s];
        
        for(int i=yy-w;i<s;i++){
            float templ1=0,d1=0;
            float[] sqr=new float[i+1];
            for(int g=i;g>yy-w;g--){
                templ1=sma[i]-e[g];
                sqr[g]=templ1*templ1;
            }
            templ1=0;
            for(int gg=yy-w+1;gg<sqr.length;gg++){
                templ1+=sqr[gg];
                d+=1;
            }
            bands[i]=templ1/d;
        }
        
        return bands;
    }
    
    public void setBands(float[] e){
        float[] dist=setDistance(e);
        for(int i=0;i<this.s;i++){
            eH[i]=sma[i]+dist[i];
            eL[i]=sma[i]-dist[i];
        }
    }
    public void setSet(float[] e,int o){
        setBands(e);
        if(o==0){
            oH=eH;
            oL=eL;
        }else if(o==1){
            hH=eH;
            hL=eL;
        }else if(o==2){
            lH=eH;
            lL=eL;
        }else{
            cH=eH;
            cL=eL;
        }
    }

    public void start(){
        setSet(this.o,0);
    
        setSet(this.h,1);
    
        setSet(this.l,0);
    
        setSet(this.c,1);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
