import javax.swing.*;
import java.awt.*;
import java.util.Timer;


public class SpringApplet extends JApplet {
	private SimEngine obiekt;
    private SimTask obiekt11;
    private Timer timer;


    public void init()
    {
    	//Ustawienie rozmiar�w appletu
        setSize(600,540);

        //Utworzenie obiektu SimEngine
        obiekt=new SimEngine(10,0.5,0.1,300,1,10,100,10);

        //Utowrzenie obiektu SimTask
        obiekt11 =new SimTask(obiekt,this,0.5);
        // Utworzenie obiektu klsay Timer
        timer = new Timer();
        //Uruchomienie timera
        timer.scheduleAtFixedRate(obiekt11,0,150);
    }
    public void paint(Graphics g)
    {

    //Wyczyszczenie powierzchni appletu
        g.setColor(Color.WHITE);
        g.fillRect(0,0,600,540);
        g.setColor(Color.BLACK);
    //Utworzenie siatki wsp�rz�dnych
        for(int y=0;y<9;y++)
        {
        	for(int x =0;x<10;x++)
        	{
        		g.drawRect(x,y,x*60+60,y*60+60);
        	}
        }
        
        //USTAWIENIA LINII
        //Tworzenie obiektu graficznego typu Graphics2D ( rozszerza klas� Graphics)
        Graphics2D g2=(Graphics2D)g;
       
        //Ustawnienie szeroko�ci linii na 3 punkty
        BasicStroke grubaLinia= new BasicStroke(3.0f);
        g2.setStroke(grubaLinia);
        //Legenda
        g.drawString("LEGENDA:",400,280);

        //Ustawienie uwierdzenia(linia,kreskowanie)
        g.drawLine(150,50,475,50);
        for(int i=0;i<14;i++)
        {
            g.drawLine(150+25*i,50,160+25*i,40);
        }
        
        ////ZADANIE PODSTAWOWE 
        /////Utworzenie liny
         //g.drawLine(313, 50, 313,60+(int)obiekt.Polozenie_masy());
        ////Utworzenie masy
         //int szerokoscmasy=24;
        // int dlugoscmasy=20;
         //g.fillOval(313-szerokoscmasy/2,60+(int)obiekt.Polozenie_masy()-dlugoscmasy/2, szerokoscmasy,dlugoscmasy);
        
       //ZADANIE DODATKOWE
      //UTWORZENIE SPRʯYNY
        //Okre�lenie d�ugo�ci spr�zyny
        int k=(int)obiekt.Dlugosc_swobodna_sprezyny()/30;
        //G�rne mocowanie spr�yny
        g.drawLine(313,50,313,60);
        g.drawLine(313,60,328,60);
        //Wy�wietlenie zygzak�w przypominaj�cych spr�yn�
        for(int i =0;i<=k;i++) {
            g.drawLine(328,60+(int)obiekt.Polozenie_masy()*i/10,298,75+(int)obiekt.Polozenie_masy()*i/10);
            g.drawLine(298,75+(int)obiekt.Polozenie_masy()*i/10,328,60+(int)obiekt.Polozenie_masy()*(i+1)/10);
     	   }
        //Dolne mocowanie sp�yny
        g.drawLine(328,60+(int)obiekt.Polozenie_masy()*(k+1)/10,313,68+(int)obiekt.Polozenie_masy()*(k+1)/10);
        g.drawLine(313,68+(int)obiekt.Polozenie_masy()*(k+1)/10,313,90+(int)obiekt.Polozenie_masy()*(k+1)/10);
        //UTWORZENIE MASY
        int szerokoscmasy=35;
        int wysokoscmasy=25;
        g.setColor(Color.LIGHT_GRAY);
        g.fillOval(313-(szerokoscmasy/2),90-(wysokoscmasy/2)+(int)obiekt.Polozenie_masy()*(k+1)/10,szerokoscmasy,wysokoscmasy);

       //Nazwa czcionki,tekst pogrubiony,wielko��
       Font czcionka = new Font( "Arial", Font.BOLD, 12 );
       g.setFont ( czcionka );


       //Ustawienie si�y ci�ko�ci

       //Ustawienie koloru
       g.setColor(Color.red);
       //D�ugo�� wektora si�y
       g.drawLine(313,90+(int)obiekt.Polozenie_masy()*(k+1)/10,313,90+(int)obiekt.Polozenie_masy()*(k+1)/10+(int)obiekt.sila_ciezkosci());
       //Utorzenie grot�w si�y
       g.drawLine(313,90+(int)obiekt.Polozenie_masy()*(k+1)/10+(int)obiekt.sila_ciezkosci(),305,80+(int)obiekt.Polozenie_masy()*(k+1)/10+(int)obiekt.sila_ciezkosci());
       g.drawLine(313,90+(int)obiekt.Polozenie_masy()*(k+1)/10+(int)obiekt.sila_ciezkosci(),321,80+(int)obiekt.Polozenie_masy()*(k+1)/10+(int)obiekt.sila_ciezkosci());
       //Opis si�y
       g.drawString("Si�a ci�ko�ci - "+(int)obiekt.sila_ciezkosci()+"N",400,300);


       //Ustawienie si�y spr�ysto�ci
       g.setColor(Color.green);

       g.drawLine(313,90+(int)obiekt.Polozenie_masy()*(k+1)/10,313,90+(int)obiekt.Polozenie_masy()*(k+1)/10+(int)obiekt.sila_sprezystosci());
      if(obiekt.sila_sprezystosci()>0) {
       g.drawLine(313,90+(int)obiekt.Polozenie_masy()*(k+1)/10+(int)obiekt.sila_sprezystosci(),305,80+(int)obiekt.Polozenie_masy()*(k+1)/10+(int)obiekt.sila_sprezystosci());
       g.drawLine(313,90+(int)obiekt.Polozenie_masy()*(k+1)/10+(int)obiekt.sila_sprezystosci(),321,80+(int)obiekt.Polozenie_masy()*(k+1)/10+(int)obiekt.sila_sprezystosci());
       }
      if(obiekt.sila_sprezystosci()<=0)
      {
      g.drawLine(313,90+(int)obiekt.Polozenie_masy()*(k+1)/10+(int)obiekt.sila_sprezystosci(),305,100+(int)obiekt.Polozenie_masy()*(k+1)/10+(int)obiekt.sila_sprezystosci());
      g.drawLine(313,90+(int)obiekt.Polozenie_masy()*(k+1)/10+(int)obiekt.sila_sprezystosci(),321,100+(int)obiekt.Polozenie_masy()*(k+1)/10+(int)obiekt.sila_sprezystosci());
      }
      g.drawString("Si�a spr�ysto�ci - "+(int)obiekt.sila_sprezystosci()+"N",400,320);

      //Ustawienie si�y t�umienia
      g.setColor(Color.blue);

      g.drawLine(313,90+(int)obiekt.Polozenie_masy()*(k+1)/10,313,90+(int)obiekt.Polozenie_masy()*(k+1)/10+(int)obiekt.sila_tlumienia());
      if(obiekt.sila_tlumienia()<0) {
      g.drawLine(313,90+(int)obiekt.Polozenie_masy()*(k+1)/10+(int)obiekt.sila_tlumienia(),305,100+(int)obiekt.Polozenie_masy()*(k+1)/10+(int)obiekt.sila_tlumienia());
      g.drawLine(313,90+(int)obiekt.Polozenie_masy()*(k+1)/10+(int)obiekt.sila_tlumienia(),321,100+(int)obiekt.Polozenie_masy()*(k+1)/10+(int)obiekt.sila_tlumienia());
      }
      if(obiekt.sila_tlumienia()>=0) {
     	 g.drawLine(313,90+(int)obiekt.Polozenie_masy()*(k+1)/10+(int)obiekt.sila_tlumienia(),305,80+(int)obiekt.Polozenie_masy()*(k+1)/10+(int)obiekt.sila_tlumienia());
          g.drawLine(313,90+(int)obiekt.Polozenie_masy()*(k+1)/10+(int)obiekt.sila_tlumienia(),321,80+(int)obiekt.Polozenie_masy()*(k+1)/10+(int)obiekt.sila_tlumienia());

      }
      g.drawString("Si�a t�umienia - "+(int)obiekt.sila_tlumienia()+"N",400,340);

      //Ustawienie wektora predkosci

      g.setColor(Color.gray);

      g.drawLine(313,90+(int)obiekt.Polozenie_masy()*(k+1)/10,313,90+(int)obiekt.Polozenie_masy()*(k+1)/10+(int)obiekt.Predkosc_masy());
      if(obiekt.Predkosc_masy()>0) {
          g.drawLine(313,90+(int)obiekt.Polozenie_masy()*(k+1)/10+(int)obiekt.Predkosc_masy(),305,80+(int)obiekt.Polozenie_masy()*(k+1)/10+(int)obiekt.Predkosc_masy());
          g.drawLine(313,90+(int)obiekt.Polozenie_masy()*(k+1)/10+(int)obiekt.Predkosc_masy(),321,80+(int)obiekt.Polozenie_masy()*(k+1)/10+(int)obiekt.Predkosc_masy());
          g.drawString("Wektor predko�ci - "+(int)obiekt.Predkosc_masy()+"m/s",400,360);
          }

      if(obiekt.Predkosc_masy()<=0) {
      g.drawLine(313,90+(int)obiekt.Polozenie_masy()*(k+1)/10+(int)obiekt.Predkosc_masy(),305,100+(int)obiekt.Polozenie_masy()*(k+1)/10+(int)obiekt.Predkosc_masy());
      g.drawLine(313,90+(int)obiekt.Polozenie_masy()*(k+1)/10+(int)obiekt.Predkosc_masy(),321,100+(int)obiekt.Polozenie_masy()*(k+1)/10+(int)obiekt.Predkosc_masy());
      g.drawString("Wektor predko�ci - "+(int)obiekt.Predkosc_masy()+"m/s",400,360);
      }
   }
}


